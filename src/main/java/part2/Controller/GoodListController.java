package part2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import part2.Model.Bucket;
import part2.Model.Product.Product;
import part2.Model.ProductJpa;
import part2.Service.BucketService;
import part2.Service.ProductJpaService;
import part2.Service.ProductWebService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@Controller
public class GoodListController {

    private final ProductWebService productWebService;
    private final ProductJpaService productJpaService;
    private final BucketService bucketService;

    @Autowired
    public GoodListController(ProductWebService productWebService, ProductJpaService productJpaService, BucketService bucketService) {
        this.productWebService = productWebService;
        this.productJpaService = productJpaService;
        this.bucketService = bucketService;
    }

    @GetMapping(value = "/")
    public String goodList(HttpServletRequest request, Principal principal) {
        HashMap<Integer, Product> productList = productWebService.getAllProductFromDB();

        // jpa
        List<Bucket> productInBucket = bucketService.findAllProductInBucket(principal.getName());
        // jdbc
//        HashMap<Integer, Product> bucketList = productWebService.getAllProductFromBucketDB();


        request.setAttribute("productInBucket", productInBucket);
        request.setAttribute("productList", productList);
        // jdbc
//        request.setAttribute("bucketList", bucketList);
        return "good-list";
    }

    @PostMapping(value = "/add-product")
    public String addProductToGoodList(HttpServletRequest request) {

        String productName=request.getParameter("productNameToDb");
        String productPrice=request.getParameter("productPriceToDb");

        ProductJpa productJpa = new ProductJpa();
        productJpa.setProductName(productName);
        productJpa.setProductPrice(Double.parseDouble(productPrice));

        // jpa
        productJpaService.saveProductJpa(productJpa);
        // jdbc
        productWebService.addProductToProductList(productName, Double.parseDouble(productPrice));

        return "redirect:/";
    }

    @PostMapping(value ="/delete-product")
    public String deleteProductFromGoodList(HttpServletRequest request) {

        String productId=request.getParameter("productId");

        // jpa
        productJpaService.deleteProductJpa(Long.valueOf(productId));
        // jdbc
        productWebService.deleteProductFromProductList(Integer.parseInt(productId));

        return "redirect:/";
    }

    @PostMapping(value = "/add-product-to-bucket")
    public String addProductToBucketDb(HttpServletRequest request, Principal principal) {

        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");

        Bucket bucket = new Bucket();
        bucket.setUserName(principal.getName());
        ProductJpa productJpaBefore = productJpaService.findProductJpaById(Long.valueOf(productId));

        List<ProductJpa> list = bucket.getBucketProduct();
        list.add(productJpaBefore);

        // jpa
        bucketService.saveProductJpaToBucket(bucket);
        // jdbc
        productWebService.addProductToBucketList(Integer.parseInt(productId));

        request.setAttribute("productName", productName);
        return "redirect:/";
    }

    @PostMapping(value ="/delete-product-from-bucket")
    public String deleteProductFromBucketDb(HttpServletRequest request) {

        String productId=request.getParameter("productId");

        // jpa
        bucketService.deleteProductJpa(Long.valueOf(productId));
        // jdbc
        productWebService.deleteProductFromBucketDbList(Integer.parseInt(productId));
        return "redirect:/";
    }

}
