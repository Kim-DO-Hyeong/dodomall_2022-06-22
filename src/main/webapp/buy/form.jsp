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
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row g-5">
                    <div class="col-md-5 col-lg-4 order-md-last">
                      <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">Your cart</span>
                        <span class="badge bg-primary rounded-pill">3</span>
                      </h4>
                      <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Product name</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$12</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Second product</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$8</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Third item</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between bg-light">
                          <div class="text-success">
                            <h6 class="my-0">Promo code</h6>
                            <small>EXAMPLECODE</small>
                          </div>
                          <span class="text-success">−$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                          <span>Total (USD)</span>
                          <strong>$20</strong>
                        </li>
                      </ul>
              
                      <form class="card p-2">
                        <div class="input-group">
                          <input type="text" class="form-control" placeholder="Promo code">
                          <button type="submit" class="btn btn-secondary">Redeem</button>
                        </div>
                      </form>
                    </div>
                    <div class="col-md-7 col-lg-8">
                      <h4 class="mb-3">구매자 정보</h4>
                      <form class="needs-validation" novalidate="">
                        <div class="row g-3">
                          <div class="col-12">
                            <label for="firstName" class="form-label">이름</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
              
                          <div class="col-12">
                            <label for="firstName" class="form-label">연락처</label>
                            <input type="tel" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>

                          <div class="col-12">
                            <label for="firstName" class="form-label">주소</label>
                            <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
              
                          <div class="col-12">
                            <label for="firstName" class="form-label">이메일</label>
                            <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
              
                        <hr class="my-4">
              
                        <div class="form-check">
                          <input type="checkbox" class="form-check-input" id="same-address">
                          <label class="form-check-label" for="same-address">구매자 정보와 주문자 정보가 동일합니다.</label>
                        </div>

                        <hr class="my-4">

                        <h4 class="mb-3">주문자 정보</h4>
                          <div class="row g-3">
                            <div class="col-12">
                              <label for="firstName" class="form-label">이름</label>
                              <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
                
                            <div class="col-12">
                              <label for="firstName" class="form-label">연락처</label>
                              <input type="tel" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
  
                            <div class="col-12">
                              <label for="firstName" class="form-label">주소</label>
                              <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
                
                            <div class="col-12">
                              <label for="firstName" class="form-label">이메일</label>
                              <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
              
                        <hr class="my-4">
              
                        <h4 class="mb-3">결제 방법</h4>
              
                        <div class="my-3">
                          <div class="form-check">
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked="" required="">
                            <label class="form-check-label" for="credit">무통장입금</label>
                          </div>
                          <div class="form-check">
                            <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="debit">현금</label>
                          </div>
                        </div>
              
                        <hr class="my-4">
              
                        <button class="w-100 btn btn-primary btn-lg" type="submit">구매</button>
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
        <script src="../js/scripts.js"></script>
    </body>
</html>
