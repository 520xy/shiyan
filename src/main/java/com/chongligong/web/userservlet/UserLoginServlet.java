package com.chongligong.web.userservlet;

import com.chongligong.pojo.User;
import com.chongligong.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
         String userName=request.getParameter("username");
         String password=request.getParameter("password");
        UserService userService = new UserService();
        User user = userService.select(userName, password);
        if (Objects.isNull(user)){
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        }else {
            String remember = request.getParameter("remember");
            if(Objects.equals(remember,"1"))
            {
                Cookie userName1 = new Cookie("userName", userName);
                userName1.setMaxAge(3600*24*7);
                Cookie password1 = new Cookie("password", password);
                password1.setMaxAge(3600*24*7);
                response.addCookie(userName1);
                response.addCookie(password1);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/brandSelectAllServlet");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
