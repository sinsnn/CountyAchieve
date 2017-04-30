/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sinsnn
 */
@WebFilter(filterName = "EscapeFilter", urlPatterns = {"/*"})
public class EscapeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) 
                            throws IOException, ServletException {

        HttpServletRequest requestWrapper
                = new EscapeWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);

    }

    @Override
    public void destroy() {
    }

}
