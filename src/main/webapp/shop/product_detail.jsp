<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </head>
    <body>
        <!-- Navigation-->
        <%@ include file ="../includes/navigation.jsp" %>
        <!-- Header-->
        <%@ include file="../includes/header.jsp" %>
        <!-- Section-->
        <section class="py-5">
            <div class="container col-xxl-8 px-4 py-5">
                <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
                  <div class="col-10 col-sm-8 col-lg-6">
                  
                    <c:set var="imgFileName" value="${productInfo.img }"/>
                  	<c:if test="${empty productInfo.img }">
                  		<c:set var="imgFileName" value="no-image.png"/>
                  	</c:if>
                  	
                    <img src="http://localhost/dodomall/images/product/${imgFileName }" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
                  </div>
	                  <form action="http://localhost/dodomall/product/buy">
		                  <div class="col-lg-6">
		                    <h1 class="display-5 fw-bold lh-1 mb-3">상품명 / ${productInfo.name }</h1>
		                    <p class="lead">상품 소개 / Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
		                    <p class="lead">카테고리 / ${productInfo.category }</p>
		                    <p class="lead">가격 / ${productInfo.price }원</p>
		                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
		                      <button type="button" class="btn btn-primary btn-lg px-4 me-md-2" id="buy_btn">구매 하기</button>
		                    </div>
		                  </div>
					</form>	                                  
                </div>
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
