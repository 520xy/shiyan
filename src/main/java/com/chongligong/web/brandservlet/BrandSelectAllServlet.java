package com.chongligong.web.brandservlet;

import com.chongligong.pojo.Brand;
import com.chongligong.service.BrandService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandSelectAllServlet")
public class BrandSelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("/jsp/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
