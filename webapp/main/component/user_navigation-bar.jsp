<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page import="connection.*, entity.*" %>
    <div class="sub-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-8">
            <ul class="info">
              <li><i class="fa fa-envelope"></i> info@sm.vn</li>
            </ul>
          </div>
          <div class="col-lg-4 col-md-4">
            <ul class="social-links">
              <li><a href="#"><i class="fab fa-facebook"></i></a></li>
              <li><a href="https://x.com/minthu" target="_blank"><i class="fab fa-twitter"></i></a></li>
              <li><a href="#"><i class="fab fa-linkedin"></i></a></li>
              <li><a href="#"><i class="fab fa-instagram"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky shadow-sm">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <nav class="main-nav">
              <!-- ***** Logo Start ***** -->
              <a href="/home/homepage" class="logo d-flex align-items-center">
                <img height="80px" width="120px" src="/home/assets/images/sm.png" alt="">
              </a>
              <!-- ***** Logo End ***** -->
              <!-- ***** Menu Start ***** -->
              <ul class="nav justify-content-between px-3 px-md-0">
                <li class="ms-lg-5 col-8">
                  <form action="/home/product/search" method="get">
                    <div class="input-group">
                      <input type="text" name="search" class="form-control" placeholder="Tìm kiếm..."
                        aria-labbel="Timkiem" aria-describedby="button-addon2">
                      <button class="btn btn-dark" type="submit" id="button-addon2">
                        <i class="fa fa-search" aria-hidden="true"></i>
                      </button>
                    </div>
                  </form>
                </li>

                <% session=request.getSession(true); if (session.getAttribute("userLogined")!=null) { %>
                  <li><a class="bg-dark " data-bs-toggle="dropdown" aria-expanded="false"><i
                        class="fa fa-user text-light"></i>
                      <% UserObject user=(UserObject) session.getAttribute("userLogined");
                        out.append(user.getUser_fullname());%>
                    </a>
                    <ul class="dropdown-menu" id="dropdown">
                      <li>
                        <a class="dropdown-item p-0 bg-white text-black"
                          href="/home/main/user/cart.jsp"><i class="fa-solid fa-cart-shopping"></i> Giỏ hàng</a>
                      </li>
                      <li> <!-- /home/main/user/shop_create.jsp -->
                        <a class="dropdown-item p-0 bg-white text-black"  href="/home/main/shop/shop_profile.jsp"><i class="fa-solid fa-store"></i> Gian hàng của bạn</a>
                      </li>
                      <li>
                        <a class="dropdown-item p-0 bg-white text-black" href="/home/main/user/user_profile.jsp"><i class="fa-regular fa-id-card"></i> Thông
                          tin cá nhân</a>
                      </li>
                      <li>
                        <hr class="dropdown-divider">
                      </li>
                      <li><a class="dropdown-item p-0 bg-white text-black" href="/home/user/logout"><i class="fa-solid fa-right-from-bracket"></i> Đăng
                          xuất</a></li>
                    </ul>

                  </li>
                  <%} else {%>
                    <li>
                      <a href="/home/guest/login" class="bg-dark"><i class="fa fa-user text-light"></i>Login</a>
                    </li>
                    <% }%>
              </ul>
              <a class='menu-trigger'>
                <span>Menu</span>
              </a>
              <!-- ***** Menu End ***** -->
            </nav>
          </div>
        </div>
      </div>
    </header>
    <!-- ***** Header Area End ***** -->