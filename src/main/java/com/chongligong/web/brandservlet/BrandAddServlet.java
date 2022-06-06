package com.chongligong.web.brandservlet;

import com.chongligong.pojo.Brand;
import com.chongligong.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/brandAddServlet")
public class BrandAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand= new Brand(new String(request.getParameter("brandName").getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8), new String(request.getParameter("companyName").getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8), Integer.valueOf(request.getParameter("ordered")), new String(request.getParameter("description").getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8), Integer.valueOf(request.getParameter("status")));
        BrandService brandService = new BrandService();
        brandService.add(brand);
        request.getRequestDispatcher("/brandSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
