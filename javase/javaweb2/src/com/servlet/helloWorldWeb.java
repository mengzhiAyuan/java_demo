package com.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/2/20 11:24
 */
public class helloWorldWeb implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //service方法是专门处理请求和相应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
