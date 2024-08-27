package com.kq.springframework.core;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kq
 * 2024-08-27 20:48
 * 资源接口
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;

}
