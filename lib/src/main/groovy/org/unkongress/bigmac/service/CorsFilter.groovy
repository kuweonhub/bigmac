package org.unkongress.bigmac.service

import groovy.util.logging.Slf4j
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter implements Filter {
    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.debug("CorsFilter adding Access-Control-Allow-Origin to response.")
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, User-Agent, Host");

        //if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        //    response.setStatus(HttpServletResponse.SC_OK);
        //} else {
        //    chain.doFilter(req, res);
        //}
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
        // not needed
    }

    public void destroy() {
        //not needed
    }

}