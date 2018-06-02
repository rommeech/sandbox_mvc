package org.rp.sandboxmvc.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UrlParserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        List<String> pathSegments = null;
        String path = ((HttpServletRequest) request).getPathInfo();
        if (path != null) {
            pathSegments = Arrays.stream(path.split("/"))
                    .filter(entity -> ! entity.isEmpty())
                    .collect(Collectors.toList());
        }

        request.setAttribute("pathSegments", pathSegments);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
