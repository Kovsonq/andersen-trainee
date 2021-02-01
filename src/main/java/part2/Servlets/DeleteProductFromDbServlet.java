package part2.Servlets;

import part2.Service.ShopService;

import java.io.IOException;

public class DeleteProductFromDbServlet extends javax.servlet.http.HttpServlet {
    ShopService shopService = new ShopService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String productId=request.getParameter("productId");

        shopService.deleteProductFromProductList(Integer.parseInt(productId));
        response.sendRedirect("/");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
