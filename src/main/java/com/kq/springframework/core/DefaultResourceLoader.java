package com.kq.springframework.core;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author kq
 * 2024-08-27 20:55
 **/
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // 默认加载类路径下的资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // 尝试 URL 网络资源
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 尝试系统文件资源
                return new FileSystemResource(location);
            }
        }
    }

}
