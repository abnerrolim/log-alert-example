package br.org.test.controller.filter;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
@Slf4j
public class MDCFilter implements Filter {

    public static final String X_GLOBAL_ID = "x-global-id";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String globalId = request.getHeader(X_GLOBAL_ID);
        if (Objects.isNull(globalId))
            globalId = UUID.randomUUID().toString();
        response.setHeader(X_GLOBAL_ID, globalId);
        MDC.put(X_GLOBAL_ID, globalId);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
