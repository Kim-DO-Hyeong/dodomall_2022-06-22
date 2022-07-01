<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/pageURLs.jsp" %>
<% 
	int amount = (int)request.getAttribute("amount");
	
	int end= (int) Math.ceil(amount/8.0);
	
	request.setAttribute("end", end);
%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>두두몰</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        <link href="../css/logo.css" rel="stylesheet" />
        <link href="../css/product_list.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
       <%@ include file ="../includes/navigation.jsp" %>
        <!-- Header-->
        <%@ include file="../includes/header.jsp" %>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach items="${productInfoList }" var="productInfo">
	                    <div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Product image-->
								<c:set var="imgFileName" value="${productInfo.img }"/>
	                            
	                            <c:if test="${empty imgFileName }">
	                            	<c:set var="imgFileName" value="no-image.png"/>
	                            </c:if>
	                            
	                            <img class="card-img-top" src="http://localhost/dodomall/images/product/${imgFileName }" />
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder">${productInfo.name }</h5>
	                                    <!-- Product price-->
	                                    ${productInfo.price }
	                                </div>
	                            </div>
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center">
	                                	<a class="btn btn-outline-dark mt-auto" href="${productDetailPage}&productIdx=${productInfo.productIdx }">상세 정보</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                  </c:forEach>  
                </div>
                
                <nav id="pagination_wrapper" aria-label="Page navigation example">
				  <ul class="pagination pagination-lg">
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    
				   
				    <c:forEach begin="1" end="${end }" var="pageNumber"> 
				    	<li class="page-item"><a class="page-link" href="${allProductListPage}&pageNumber=${pageNumber} ">${pageNumber }</a></li>
				    </c:forEach>
				    
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
            </div>
        </section>
        <!-- Footer-->
        <%@ include file="../includes/footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
    