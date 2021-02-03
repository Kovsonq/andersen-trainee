package part2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import part2.Product.Product;
import part2.Service.ProductWebService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class GoodListController {

    private final ProductWebService productWebService;

    @Autowired
    public GoodListController(ProductWebService productWebService) {
        this.productWebService = productWebService;
    }

    @GetMapping(value = "/")
    public String goodList(HttpServletRequest request) {
        HashMap<Integer, Product> productList = productWebService.getAllProductFromDB();
        HashMap<Integer, Product> bucketList = productWebService.getAllProductFromBucketDB();

        request.setAttribute("productList", productList);
        request.setAttribute("bucketList", bucketList);
        return "good-list";
    }

    @PostMapping(value = "/add-product")
    public String addProductToGoodList(HttpServletRequest request) {

        String productName=request.getParameter("productNameToDb");
        String productPrice=request.getParameter("productPriceToDb");

        productWebService.addProductToProductList(productName, Double.parseDouble(productPrice));

        return "redirect:/";
    }

    @PostMapping(value ="/delete-product")
    public String deleteProductFromGoodList(HttpServletRequest request) {

        String productId=request.getParameter("productId");

        productWebService.deleteProductFromProductList(Integer.parseInt(productId));
        return "redirect:/";
    }

    @PostMapping(value = "/add-product-to-bucket")
    public String addProductToBucketDb(HttpServletRequest request) {

        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");

        productWebService.addProductToBucketList(Integer.parseInt(productId));
        request.setAttribute("productName", productName);
        return "redirect:/";
    }

    @PostMapping(value ="/delete-product-from-bucket")
    public String deleteProductFromBucketDb(HttpServletRequest request) {

        String productId=request.getParameter("productId");

        productWebService.deleteProductFromBucketDbList(Integer.parseInt(productId));
        return "redirect:/";
    }

}
