<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="pageURLs.jsp" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="${homePage }">
               		<i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
               		<i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
                	두두몰
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${homePage }">홈</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">브랜드 소개</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">쇼핑</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="${allProductListPage }">모든 상품</a></li>
                                
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="${noteBookProductListPage }">노트북</a></li>
                                <li><a class="dropdown-item" href="${smartPhoneProductListPage }">스마트폰</a></li>
                                <li><a class="dropdown-item" href="${tabletProductListPage }">테블릿</a></li>
                            </ul>
                        </li>
                        <li>
                            <div class="dropdown text-end">
                                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="bi bi-person-circle" style="font-size: 25px;"></i>
                                </a>
                                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                                  <c:choose>
	                                  <c:when test="${empty loginMemberInfo }">
	                                  	<li><a class="dropdown-item" href="${loginPage }">로그인</a></li>
	                                  	<li><a class="dropdown-item" href="${joinPage }">회원가입</a></li>
	                                  </c:when>
                                  	  <c:otherwise>
		                                  <li><a class="dropdown-item" href="#">정보 수정</a></li>
		                                  <li><a class="dropdown-item" href="${logoutPage }">로그아웃</a></li>
                                  	  </c:otherwise>
                                  </c:choose>
                                </ul>
                              </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>