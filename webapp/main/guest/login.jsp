<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="../component/header.jsp" flush="true"></jsp:include>
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
 <header class="header-area header-sticky">
   <div class="container">
       <div class="row">
           <div class="col-12">
               <nav class="main-nav">
                   <!-- ***** Logo Start ***** -->
                   <a href="/home/main/home.jsp" class="logo">
                       <img height="120px" width="200" src="/home/assets/images/sm.png" alt="">
                   </a>

               </nav>
           </div>
       </div>
   </div>
 </header>
  <div class="contact-content mt-5">
    <div class="container mt-5">
      <div class="row">
        <div class="d-flex justify-content-center">
          <div class="col-lg-6">
          <form id="contact-form"  action="" method="post">
            <h1 class="my-5">Login</h1>
            <div class="row">
              <div class="col-lg-12">
                <fieldset>
                  <label for="name">Username</label>
                  <input type="name" name="name" id="name" placeholder="Username" autocomplete="on" required>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="email">Password</label>
                  <input type="password" name="email" id="email" pattern="[^ @]*@[^ @]*" placeholder="Password"
                    required="">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Login</button>
                </fieldset>
              </div>
            </div>
          </form>
        </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="../component/footer.jsp" flush="true"></jsp:include> 