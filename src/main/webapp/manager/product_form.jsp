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
        <link href="/dodomall/css/styles.css" rel="stylesheet" />
        <link href="/dodomall/css/logo.css" rel="stylesheet" />
        <link href="/dodomall/css/product_form.css" rel="stylesheet" />
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
                  <div class="col-lg">
                  
                  	<c:set var="action" value="http://localhost/dodomall//mng/product/add"/>
                  	<c:set var="enctype" value="enctype='multipart/form-data'"/>
                  	<c:if test="${param.page eq 'product_update'}">
             			<c:set var="action" value="http://localhost/dodomall//mng/product/update"/>
             			<c:set var="enctype" value="enctype='application/x-www-form-urlencoded'"/>
             		</c:if>
                    
                    <form action="${action}" method="POST" ${enctype }>
                    	<c:if test="${param.page eq 'product_update'}">
                    		<input type="hidden" value="${productInfo.productIdx }" name="productIdx">
                    	</c:if>
                        <div class="input-group input-group-lg" id="product_name_wrapper">
                            <span class="input-group-text" id="inputGroup-sizing-lg">상품명</span>
                            <input type="text" class="form-control" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" value="${productInfo.name }">
                        </div>

						<c:choose>
							<c:when test="${productInfo.category eq '노트북' }">
								<c:set var="selected1" value="selected='selected'"/>
							</c:when>
							<c:when test="${productInfo.category eq '스마트폰' }">
								<c:set var="selected2" value="selected='selected'"/>
							</c:when>
							<c:when test="${productInfo.category eq '테블릿' }">
								<c:set var="selected3" value="selected='selected'"/>
							</c:when>
						</c:choose>

                        <div class="input-group" id="product_category_wrapper">
                            <label class="input-group-text" for="inputGroupSelect01">카테고리</label>
                            <select class="form-select" id="inputGroupSelect01" name="category">
                              <option value="노트북" ${selected1 }>노트북</option>
                              <option value="스마트폰" ${selected2 }>스마트폰</option>
                              <option value="테블릿" ${selected3 }>테블릿</option>
                            </select>
                        </div>
                        
                        <div class="input-group" id="product_stock_wrapper">
                            <span class="input-group-text">재고</span>
                            <input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="stock"value="${productInfo.stock }">
                        </div>

                        <div class="input-group" id="product_price_wrapper">
                            <span class="input-group-text">가격</span>
                            <input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="price" value="${productInfo.price }" >
                        </div>

                        <div class="input-group" id="product_file_wrapper">
                            <label class="input-group-text" for="inputGroupFile01">상품 이미지</label>
                            
                            	<c:if test="${not empty productInfo.img}">
                            		<c:set var="style" value="style='display:none'"></c:set>
                            		<c:set var="imgFileName" value="${productInfo.img }"></c:set>
                            	</c:if >
                            	<c:if test="${empty productInfo.img}">
                            		<c:set var="filePathStyle" value="style='display:none'"></c:set>
                            	</c:if>
                            
                            <input type="file" class="form-control" id="inputGroupFile01" name="img" ${style}>
                            <span class="product_file_path" ${filePathStyle } >${imgFileName }</span>
                        	<c:if test="${not empty productInfo.img }">
                        		<button type="button" class="btn btn-danger btn-lg px-4 me-md-2">이미지 삭제</button>
                        	</c:if>
                        </div>
                    
                    	<div class="d-grid gap-2 d-md-flex justify-content-md-start">
                      		<c:set var="btnTitle" value="상품 등록"/>
                      		<c:set var="idTitle" value="add_btn"/>
                      		<c:if test="${param.page eq 'product_update'}">
                      			<c:set var="btnTitle" value="상품 수정"/>
                      		</c:if>
                      		<button type="submit" class="btn btn-primary btn-lg px-4 me-md-2">${btnTitle}</button>
                    	</div>
                    </form>
                  </div>
                </div>
              </div>
        </section>
        <!-- Footer-->
        <%@ include file="../includes/footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/dodomall/js/scripts.js"></script>
        <script src="/dodomall/js/jquery-3.6.0.min.js"></script>
        <script>
        	// 이미지 삭제 버튼 구현 
        </script>
    </body>
</html>
