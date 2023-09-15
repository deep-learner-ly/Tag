package designpattern.chainofresponsibility;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LongyunBian
 * @version  2023/9/14 9:46
 */
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
