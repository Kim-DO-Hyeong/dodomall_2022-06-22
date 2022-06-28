<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>두두몰</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="../css/join.css" />
    <link rel="stylesheet" href="../css/logo.css" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form>
      <h1 class="h3 mb-3 fw-normal">
    	<i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" placeholder="아이디">
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingOldPassword" placeholder="Password">
        <label for="floatingOldPassword">현재 비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingNewPassword" placeholder="Password">
        <label for="floatingNewPassword">새 비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingNewPasswordCheck" placeholder="Password">
        <label for="floatingNewPasswordCheck">새 비밀번호 확인</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingName" placeholder="Name">
        <label for="floatingName">이름</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingTel" placeholder="Tel">
        <label for="floatingTel">연락처</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingAddr" placeholder="Address">
        <label for="floatingAddr">주소</label>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingEmail" placeholder="Email" name="email">
        <label for="floatingEmail">이메일</label>
      </div>
      
      <button class="w-100 btn btn-lg btn-primary" type="button">정보수정</button>
      <button class="w-100 btn btn-lg btn-secondary" type="button">회원 탈퇴</button>
    </form>
  </main>
  
  </body>
</html>


