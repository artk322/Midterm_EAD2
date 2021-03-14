package org.example.midterm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    HttpServletResponse httpResponse = (HttpServletResponse) resp;
    
    Cookie ck = new Cookie("userId", "");
    ck.setMaxAge(0);
    httpResponse.addCookie(ck);

    chain.doFilter(req, resp);
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
