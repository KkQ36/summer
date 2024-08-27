package com.kq.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.PropertyValue;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.config.BeanReference;
import com.kq.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.kq.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.kq.springframework.core.Resource;
import com.kq.springframework.core.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kq
 * 2024-08-27 21:04
 * XML Bean 定义阅读器
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()){
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 执行 XML 文件的读取，示例 XML 文件：
     * <?xml version="1.0" encoding="UTF-8"?>
     * <beans>
     *     <bean id="userDao" class="com.kq.service.UserDao"/>
     *     <bean id="userService" class="com.kq.service.UserService">
     *         <property name="uId" value="10001"/>
     *         <property name="userDao" ref="userDao"/>
     *     </bean>
     * </beans>
     * @param inputStream 输入流
     * @throws ClassNotFoundException 类路径中未找到匹配的类
     * @exception BeansException 不能含有重复的 Bean Name
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // 如果是非元素节点，忽略掉
            if (!(childNodes.item(i) instanceof Element)) continue;
            // 判断节点是定义的对象节点，如果不是，忽略掉
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // 解析 bean 标签中的内容
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                // 如果没有配置 id，使用默认的类名首字母小写
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                // 只解析 property 标签
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值：根据配置的是 ref 还是 value 来判断这个属性是 Bean 对象引用还是普通属性
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                // 不能含有重复的 Bean Name
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

}
