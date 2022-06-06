package com.chongligong.web.brandservlet;

import com.chongligong.pojo.Brand;
import com.chongligong.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/brandUpdataServlet")
public class BrandUpdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String brandName=request.getParameter("brandName");
        String companyName=request.getParameter("companyName");
        Integer ordered= Integer.valueOf(request.getParameter("ordered"));
        String description=request.getParameter("description");
        Integer status= Integer.valueOf(request.getParameter("status"));
        Brand brand = new Brand(id, brandName, companyName, ordered, description, status);
        BrandService brandService = new BrandService();
        brandService.updata(brand);
        request.getRequestDispatcher("/brandSelectAllServlet").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
