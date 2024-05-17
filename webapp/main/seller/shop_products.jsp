<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/seller_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/seller_navigation-bar.jsp" flush="true"></jsp:include>


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
    <!-- Recent Sales -->
    <div class="col-12">
      <div class="card recent-sales overflow-auto">
        <div class="card-body">
          <h5 class="card-title">Danh Sách Sản Phẩm</h5>
          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addproductModal">
            Thêm sản phẩm
          </button>
          <table class="table table-borderless datatable">
            <thead>
              <tr>
                <th scope="col">Hình ảnh</th>
                <th scope="col">Tên</th>
                <th scope="col">Giá trị</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Loại sản phẩm</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">
                  <img width="120px" src="/home/assets/images/sm.png" alt="">
                </th>
                <td><a href="/home/main/seller/shop_products_profile.jsp">MacBook Air 13 inch M1 2020 7-core GPU</a>
                </td>
                <td>32000000VND</td>
                <td>null</td>
                <td>1</td>
                <td>$product_pc_name</td>
              </tr>

            </tbody>
          </table>
        </div>
      </div>
    </div><!-- End Recent Sales -->
    <!-- Button trigger modal -->
    

    <!-- Modal -->
    <div class="modal fade" id="addproductModal" tabindex="-1" aria-labelledby="addproductModal" aria-hidden="true">
      <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm sản phẩm</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form>
              <div class="row mb-3">
                <label for="productImg" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                <div class="col-md-8 col-lg-9">
                  <img height="250px" src="/home/assets/images/product/vga/vga.png" alt="Profile">
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
                <label for="quantity" class="col-md-4 col-lg-3 col-form-label">Số lượng</label>
                <div class="col-md-8 col-lg-9">
                  <input name="quantity" type="number" class="form-control" id="quantity"
                    value="11" max="9999" min="1">
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
          <div class="modal-footer">
            <button type="button" class="btn btn-primary">Lưu</button>
          </div>
        </div>
      </div>
    </div>
  </main><!-- End #main -->

  <jsp:include page="../component/seller_footer.jsp" flush="true"></jsp:include>