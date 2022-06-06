package com.chongligong.web.brandservlet;

import com.chongligong.pojo.Brand;
import com.chongligong.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/brandSelectServlet")
public class BrandSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        BrandService brandService = new BrandService();
        Brand brand = brandService.select(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/jsp/updata.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
