<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../component/seller_header.jsp" flush="true"></jsp:include>
<jsp:include page="../component/seller_navigation-bar.jsp" flush="true"></jsp:include>

<%@ page import="java.util.*" %>
<% 
Map<String, String> map = new HashMap<String,String>();
if (request.getAttribute("shop-product-profile")!=null){
	map = (HashMap<String,String>) request.getAttribute("shop-product-profile"); 
}
%>
  <main id="main" class="main">
    <div class="pagetitle">
      <h1>Sản phẩm</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/home/main/seller/shopmanage.jsp">Shop</a></li>
          <li class="breadcrumb-item active">Sản phẩm</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <section class="section profile">
      <div class="row">

        <div class="col-12">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab"
                    data-bs-target="#profile-overview">Thông tin chi tiết</button>
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
                  <h5 class="card-title">Thông tin chi tiết</h5>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Hình ảnh</div>
                    <div class="col-lg-9 col-md-8"><img src="/home/assets/images/product/vga/vga.png" height="400" alt=""></div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Tên sản phẩm</div>
                    <div class="col-lg-9 col-md-8">MacBook Air 13 inch M1 2020 7-core GPU</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Giá tiền</div>
                    <div class="col-lg-9 col-md-8">3200000</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Loại sản phẩm</div>
                    <div class="col-lg-9 col-md-8">$product_pc_name</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Hãng sản xuất</div>
                    <div class="col-lg-9 col-md-8">Apple</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">CPU</div>
                    <div class="col-lg-9 col-md-8">Apple M1</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Ram</div>
                    <div class="col-lg-9 col-md-8">8GB LPDDR4X</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Card</div>
                    <div class="col-lg-9 col-md-8">Integrated Apple GPU</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Ổ cứng</div>
                    <div class="col-lg-9 col-md-8">512GB SSD</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Màn hình</div>
                    <div class="col-lg-9 col-md-8">Integrated Apple GPU</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Tần số quét</div>
                    <div class="col-lg-9 col-md-8">Integrated Apple GPU</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Độ phân giải</div>
                    <div class="col-lg-9 col-md-8">Integrated Apple GPU</div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phân loại máy</div>
                    <div class="col-lg-9 col-md-8">Integrated Apple GPU</div>
                  </div>
                  <h5 class="card-title">Mô tả</h5>
                  <p class="small fst-italic">Sunt est soluta temporibus accusantium neque nam maiores cumque
                    temporibus. Tempora libero non est unde veniam est qui dolor. Ut sunt iure rerum quae quisquam autem
                    eveniet perspiciatis odit. Fuga sequi sed ea saepe at unde.</p>
                </div>

                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form>
                    <div class="row mb-3">
                      <label for="productImg" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
                        <img src="/home/assets/images/product/vga/vga.png" alt="Profile">
                        <div class="pt-2">
                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i
                              class="bi bi-upload"></i></a>
                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i
                              class="bi bi-trash"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="productName" class="col-md-4 col-lg-3 col-form-label">Tên sản phẩm</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="productName" type="text" class="form-control" id="productName" value="MacBook Air 13 inch M1 2020 7-core GPU"
                          maxlength="120">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="price" class="col-md-4 col-lg-3 col-form-label">Giá tiền</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="price" type="number" class="form-control" id="price"
                          value="32000000">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="productPC" class="col-md-4 col-lg-3 col-form-label">Loại sản phẩm</label>
                      <div class="col-md-8 col-lg-9">
                        <select name="" id="" class="form-control">
                          <option value="2">Bàn phím</option>
                          <option value="3">Chuột</option>
                          <option value="7">CPU</option>
                          <option value="6">Desktop</option>
                          <option value="5" selected>Laptop</option>
                          <option value="8">Mainboard</option>
                          <option value="1">Màn hình</option>
                          <option value="10">Ổ cứng</option>
                          <option value="12">PSU</option>
                          <option value="9">Ram</option>
                          <option value="4">Tai nghe - Loa</option>
                          <option value="14">Tản nhiệt</option>
                          <option value="16">Thiết bị khác</option>
                          <option value="15">USB</option>
                          <option value="11">VGA</option>
                          <option value="13">Vỏ Case</option>
                        </select>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="manufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="manufacturer" type="text" class="form-control" id="manufacturer" value="Apple" maxlength="30">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="cpu" class="col-md-4 col-lg-3 col-form-label">CPU</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="cpu" type="text" class="form-control" id="cpu" value="Apple M1">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="ram" class="col-md-4 col-lg-3 col-form-label">RAM</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="ram" type="text" class="form-control" id="ram" value="8GB LPDDR4X">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="graphics" class="col-md-4 col-lg-3 col-form-label">Card</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="graphics" type="text" class="form-control" id="graphics" value="Integrated Apple GPU">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="storage" class="col-md-4 col-lg-3 col-form-label">Ổ cứng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="storage" type="text" class="form-control" id="storage" value="512GB SSD" maxlength="30">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="monitor" class="col-md-4 col-lg-3 col-form-label">Màn hình</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="monitor" type="text" class="form-control" id="monitor" value="Integrated Apple GPU">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="freq" class="col-md-4 col-lg-3 col-form-label">Tần số quét</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="freq" type="text" class="form-control" id="freq" value="Integrated Apple GPU">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="resolution" class="col-md-4 col-lg-3 col-form-label">Độ phân giải</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="resolution" type="text" class="form-control" id="resolution" value="Integrated Apple GPU" maxlength="30">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="type" class="col-md-4 col-lg-3 col-form-label">Phân loại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="type" type="text" class="form-control" id="type" value="Integrated Apple GPU">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="about" class="col-md-4 col-lg-3 col-form-label">Mô tả</label>
                      <div class="col-md-8 col-lg-9">
                        <textarea name="about" class="form-control" id="about"
                          style="height: 100px">Sunt est soluta temporibus accusantium neque nam maiores cumque temporibus. Tempora libero non est unde veniam est qui dolor. Ut sunt iure rerum quae quisquam autem eveniet perspiciatis odit. Fuga sequi sed ea saepe at unde.</textarea>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">

                  <!-- Settings Form -->
                  <form>
                    <div class="row">
                      <div class="col-lg-3 col-md-4 label">Trạng thái:</div>
                      <div class="col-lg-9 col-md-8 text-success"><h4>Đang bán</h4></div>
                    </div>
                    <div class="row">
                      <div class="col-lg-3 col-md-4 label">Số lượng:</div>
                      <div class="col-lg-9 col-md-8">30</div>
                    </div>
                    
                    <div class="row mb-3 mt-2">
                      <label for="quantity" class="col-md-4 col-lg-3 col-form-label">Cập nhật số lượng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="quantity" type="number" class="form-control" id="quantity" value="30" max="9999" min="0">
                      </div>
                    </div>
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Thay đổi</button>
                      <button type="submit" class="btn btn-danger"> Dừng bán</button>
                      <button type="submit" class="btn btn-secondary">Tiếp tục bán</button>
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