package com.chongligong.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/brand.jsp","/updata.jsp"})
public class FilterUnlogin implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String[] urls = {"css", "imgs", "login.jsp", "register.jsp", "/userLoginServlet", "/userRegisterServlet"};
        String string = req.getContextPath().toString();
        for (String url : urls) {
            if (string.contains(url)) {
                chain.doFilter(request, response);
                return;
            }
            HttpSession session = req.getSession();
            Object user = session.getAttribute("user");
            if(user!=null)
            {
                chain.doFilter(req,response);
            }
            else {
                req.setAttribute("login_msg","您还未登录");
                  req.getRequestDispatcher("/jsp/login.jsp").forward(req,response);
            }




        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }


}
