package part2.Servlets;

import part2.Service.ShopService;

import java.io.IOException;

public class AddProductToDbServlet extends javax.servlet.http.HttpServlet {
    ShopService shopService = new ShopService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String productName=request.getParameter("productNameToDb");
        String productPrice=request.getParameter("productPriceToDb");

        shopService.addProductToProductList(productName, Double.parseDouble(productPrice));
        response.sendRedirect("/");
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
