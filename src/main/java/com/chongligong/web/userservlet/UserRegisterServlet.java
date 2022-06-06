package com.chongligong.web.userservlet;

import com.chongligong.pojo.User;
import com.chongligong.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String attribute = (String)session.getAttribute("checkCode");
        if(!checkCode.equals(attribute))
           {
               request.setAttribute("register_msg","验证码错误");
               request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
               return;
           }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        User select = userService.selectByName(username);
        if (Objects.isNull(select)) {
            userService.addUser(username, password);
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);

        } else {
            request.setAttribute("register_msg","用户名已经存在");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);

        }
    }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            this.doGet(request, response);
        }
    }
