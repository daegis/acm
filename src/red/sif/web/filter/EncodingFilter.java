package red.sif.web.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by XIAN. Yingda on 2017/6/25 21:47.
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        httpServletRequest.setCharacterEncoding("utf-8");
        chain.doFilter(httpServletRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
