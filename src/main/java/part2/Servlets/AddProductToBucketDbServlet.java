package part2.Servlets;

import part2.Service.ShopService;

import java.io.IOException;

public class AddProductToBucketDbServlet extends javax.servlet.http.HttpServlet {
    ShopService shopService = new ShopService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");

        shopService.addProductToBucketList(Integer.parseInt(productId));
        request.setAttribute("productName", productName);

        request.getRequestDispatcher("/WEB-INF/view/good-list.jsp").forward(request,response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
