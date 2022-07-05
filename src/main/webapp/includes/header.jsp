<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- page 파라미터를 활용해서 header_title 이 적절히 설정되도록 하세요 --%>
<%-- page 파라미터가 all_product 라면 header_title은 모든 상품으로  --%>
<%-- page 파라미터가 smartPhone 라면 header_title은 모든 상품으로  --%>
<%-- page 파라미터가 noteBook 라면 header_title은 모든 상품으로  --%>
<%-- page 파라미터가 tablet 라면 header_title은 모든 상품으로  --%>


<c:set var="header_title" value="홈"/>

<c:choose>
  	<c:when test="${param.page eq 'all_product'}">
		<c:set var="header_title" value="모든 상품"/>
	</c:when>
  	<c:when test="${param.page eq 'smartPhone'}">
		<c:set var="header_title" value="스마트폰"/>
	</c:when>
  	<c:when test="${param.page eq 'product_detail'}">
		<c:set var="header_title" value="상세 정보"/>
	</c:when>
  	<c:when test="${param.page eq 'noteBook'}">
		<c:set var="header_title" value="노트북"/>  	
  	</c:when>
  	
  	<c:when test="${param.page eq 'tablet'}">
  	 	<c:set var="header_title" value="테블릿"/>
  	</c:when>
  	
  	<c:when test="${param.page eq 'buy'}">
  	 	<c:set var="header_title" value="구매"/>
  	</c:when>
  	
  	<c:when test="${param.page eq 'manager_product_form'}">
  	 	<c:set var="header_title" value="상품 등록 / 수정"/>
  	</c:when>
  	
  	<c:when test="${param.page eq 'product_update'}">
  	 	<c:set var="header_title" value="상품 정보 수정"/>
  	</c:when>
  	
</c:choose>

<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">${header_title }</h1>
            <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
        </div>
    </div>
</header>