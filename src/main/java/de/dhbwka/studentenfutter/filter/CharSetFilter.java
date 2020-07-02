package de.dhbwka.studentenfutter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CharSetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    //tomcat7-maven-plugin can't handle default methods..
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //tomcat7-maven-plugin can't handle default methods..
    @Override
    public void destroy() {

    }
}
