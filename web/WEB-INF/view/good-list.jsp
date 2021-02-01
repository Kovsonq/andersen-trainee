<%@ page import="java.util.HashMap" %>
<%@ page import="part2.Product.Product" %>
<%@ page import="part2.Service.ShopService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kovso
  Date: 30.01.2021
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <title>Good list</title>
</head>
<body>


<div class="container">
    <div class="container">
        <div class="row row-cols-3">
            <div class="col text-left">
                <button type="button" class="btn btn-primary"
                        data-toggle="modal" data-target="#productListModal">
                    Manage LIST of GOODS
                </button>
            </div>
            <div class="col text-center">
                <h1>List of Goods</h1>
            </div>
            <div class="col text-right ">
                <button type="button" class="btn btn-warning"
                        data-toggle="modal" data-target="#bucketModal">
                    Show Bucket
                </button>
            </div>
        </div>
    </div>


    <table class="table table-sm table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col"># Index</th>
            <th scope="col">Product name</th>
            <th scope="col">Price</th>
            <th scope="col">Add to Bucket</th>
        </tr>
        </thead>
        <tbody>

        <% ShopService shopService = new ShopService();
            HashMap<Integer, Product> products = shopService.getAllProductFromDB();
        %>
        <% for (HashMap.Entry<Integer, Product> entry : products.entrySet()) {
            out.println("<tr>");
            out.println("<th>" + entry.getKey() + "</th>\n" +
                    "<td>" + entry.getValue().getName() + "</td>\n" +
                    "<td>" + entry.getValue().getPrice() + "</td>\n" +
                    "<td>"
                    +
                    "<form action='/add-product-to-bucket' method='post' style='margin:0px'>" +
                    "<input type='text' style='display:none' name='productId' value='" + entry.getKey() + "'/>" +
                    "<input type='text' style='display:none' name='productName' value='" + entry.getValue().getName() + "'/>" +
                    "<button type='submit' class='btn btn-warning'>Add item</button>" +
                    "</form>"
                    +
                    "</td>\n");
            out.println("</tr>");
        }
        %>
        </tbody>
    </table>

    <% if (request.getAttribute("productName") != null) {
        out.println("<h6>" + request.getAttribute("productName") + " was added to your bucket</h1>");
    } %>


    <!-- bucket Modal -->
    <div class="modal fade" id="bucketModal" tabindex="-1" aria-labelledby="bucketModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bucketModal1">Bucket</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <table class="table table-sm table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col"># Index</th>
                            <th scope="col">Product name</th>
                            <th scope="col">Price</th>
                            <th scope="col">DELETE From Bucket</th>
                        </tr>
                        </thead>
                        <tbody>

                        <% HashMap<Integer, Product> userBucket = shopService.getAllProductFromBucketDB();
                        %>
                        <% for (HashMap.Entry<Integer, Product> entry : userBucket.entrySet()) {
                            out.println("<tr>");
                            out.println("<th>" + entry.getKey() + "</th>\n" +
                                    "<td>" + entry.getValue().getName() + "</td>\n" +
                                    "<td>" + entry.getValue().getPrice() + "</td>\n" +
                                    "<td>"+
                                    "<form action='/delete-product-from-bucket' method='post' style='margin:0px'>" +
                                    "<input type='text' style='display:none' name='productId' value='" +
                                    entry.getKey() +
                                    "'/>" +
                                    "<button type='submit' class='btn btn-danger'>DELETE ITEM</button>" +
                                    "</form>"
                                    +
                                    "</td>\n"
                            );
                            out.println("</tr>");
                        }
                        %>

                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Confirm Order</button>
                </div>
            </div>
        </div>
    </div>

    <!-- product list Modal -->
    <div class="modal fade" id="productListModal" tabindex="-1" aria-labelledby="productListModal" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="productListModal1">Product list managing</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <table class="table table-sm table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col"># Index</th>
                            <th scope="col">Product name</th>
                            <th scope="col">Price</th>
                            <th scope="col">delete from product list</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% for (HashMap.Entry<Integer, Product> entry : products.entrySet()) {
                            out.println("<tr>");
                            out.println("<th>" + entry.getKey() + "</th>\n" +
                                    "<td>" + entry.getValue().getName() + "</td>\n" +
                                    "<td>" + entry.getValue().getPrice() + "</td>\n" +
                                    "<td>"
                                    +
                                    "<form action='/delete-product' method='post' style='margin:0px'>" +
                                    "<input type='text' style='display:none' name='productId' value='" + entry.getKey() + "'/>" +
                                    "<button type='submit' class='btn btn-warning'>DELETE</button>" +
                                    "</form>"
                                    +
                                    "</td>\n");
                            out.println("</tr>");
                        }
                        %>
                        </tbody>
                    </table>

                    <form class="form-inline" action="/add-product" method="post" style="margin:0px">

                        <input type="text" name="productNameToDb" placeholder="product name" required/>
                        <input type="text" name="productPriceToDb" placeholder="product price" required/>

                        <button type="submit" class="btn btn-success">Add product</button>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
