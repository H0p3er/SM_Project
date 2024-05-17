<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:include page="../component/seller_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/seller_navigation-bar.jsp" flush="true"></jsp:include> 
     
     
    <main id="main" class="main">
    
    
    <div class="pagetitle">
      <h1>Thông tin</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/home/main/seller/shopmanage.jsp">Shop</a></li>
          <li class="breadcrumb-item active">Thông tin</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
      <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="assets/img/profile-img.jpg" alt="Profile">
              <h2>@shopname</h2>
              
              
              <div class="social-links mt-4">
                <a href="#" class="website-link"><i class="bi bi-globe2"></i></a>
                <a href="#" class="map-link"><i class="bi bi-map"></i></a>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Thông tin cửa hàng</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Thay đổi thông tin</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">Trạng thái</button>
                </li>

              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                  <h5 class="card-title">Profile Details</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Tên cửa hàng</div>
                    <div class="col-lg-9 col-md-8">@shopname</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Địa chỉ cửa hàng</div>
                    <div class="col-lg-9 col-md-8">A108 Adam Street, New York, NY 535022</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Số điện thoại cửa hàng</div>
                    <div class="col-lg-9 col-md-8">(436) 486-3538 x29071</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email cửa hàng</div>
                    <div class="col-lg-9 col-md-8">shop@example.com</div>
                  </div>

                  <h5 class="card-title">Chi tiết cửa hàng</h5>
                  <p class="small fst-italic">Sunt est soluta temporibus accusantium neque nam maiores cumque temporibus. Tempora libero non est unde veniam est qui dolor. Ut sunt iure rerum quae quisquam autem eveniet perspiciatis odit. Fuga sequi sed ea saepe at unde.</p>
                </div>

                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form>
                    <div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
                        <img src="assets/img/profile-img.jpg" alt="Profile">
                        <div class="pt-2">
                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></a>
                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="shopName" class="col-md-4 col-lg-3 col-form-label">Tên cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="shopName" type="text" class="form-control" id="shopName" value="@shopname" maxlength="120">
                      </div>
                    </div>

                   

                    <div class="row mb-3">
                      <label for="address" class="col-md-4 col-lg-3 col-form-label">Địa chỉ cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" id="address" value="A108 Adam Street, New York, NY 535022">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="phone" class="col-md-4 col-lg-3 col-form-label">Số điện thoại cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="tel" class="form-control" id="phone" value="(436) 486-3538 x29071" inputmode="numeric" minlength="10" maxlength="12">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="email" class="form-control" id="email" value="shop@example.com">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="websitelink" class="col-md-4 col-lg-3 col-form-label">Link website cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="websitelink" type="text" class="form-control" id="websitelink" value="link">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="maplink" class="col-md-4 col-lg-3 col-form-label">Link map cửa hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="maplink" type="text" class="form-control" id="maplink" value="link">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="about" class="col-md-4 col-lg-3 col-form-label">About</label>
                      <div class="col-md-8 col-lg-9">
                        <textarea name="about" class="form-control" id="about" style="height: 100px">Sunt est soluta temporibus accusantium neque nam maiores cumque temporibus. Tempora libero non est unde veniam est qui dolor. Ut sunt iure rerum quae quisquam autem eveniet perspiciatis odit. Fuga sequi sed ea saepe at unde.</textarea>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">

                  <!-- Settings Form -->
                  <form>

                    <div class="row mb-3">
                      <label for="status">Trạng thái:</label>
                      <h4 class="text-success">Đang hoạt động</h4>
                      <h4 class="text-danger">Dừng hoạt động</h4>
                      
                    </div>
                    
                    <div class="text-center">
                      <button type="submit" class="btn btn-danger">Dừng hoạt động</button>
                      <button type="submit" class="btn btn-secondary">Tái hoạt động</button>
                    </div>
                  </form><!-- End settings Form -->

                </div>

             

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>
    
    
    </main><!-- End #main -->
    
<jsp:include page="../component/seller_footer.jsp" flush="true"></jsp:include>