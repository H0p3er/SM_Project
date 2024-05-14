<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/seller_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/seller_navigation-bar.jsp" flush="true"></jsp:include>


  <main id="main" class="main">


    <div class="pagetitle">
      <h1>Đơn hàng</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/home/main/seller/shopmanage.jsp">Shop</a></li>
          <li class="breadcrumb-item active">Đơn hàng</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <!-- Sales -->
    <div class="col-12">
      <div class="card recent-sales overflow-auto">
        <div class="card-body">
          <h5 class="card-title">Đơn Hàng Chờ Xử Lý</h5>

          <table class="table table-borderless datatable">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Khách hàng</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Sản phẩm</th>
                <th scope="col">Giá trị</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"><a href="#">#2457</a></th>
                <td>Brandon Jacob</td>
                <td>Địa chỉ</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$64</td>
                <td><a href="" type="button" class="btn btn-success"><i class="ri-check-fill"></i></a><a href="" type="button" class="btn btn-danger"><i class="ri-close-fill"></i></a></td>
              </tr>
              <tr>
                <th scope="row"><a href="#">#2147</a></th>
                <td>Bridie Kessler</td>
                <td>Địa chỉ</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li><a href="" class="text-black">Logitech Wireless Headphones</a></li>
                    <li><a href="" class="text-black">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$47</td>
                <td><a href="" type="button" class="btn btn-success"><i class="ri-check-fill"></i></a><a href="" type="button" class="btn btn-danger"><i class="ri-close-fill"></i></a></td>
              </tr>

            </tbody>
          </table>
        </div>
      </div>
    </div><!-- End Sales -->
    <!-- Sales -->
    <div class="col-12">
      <div class="card recent-sales overflow-auto">
        <div class="card-body">
          <h5 class="card-title">Danh Sách Đơn Hàng</h5>

          <table class="table table-borderless datatable">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Khách hàng</th>
                <th scope="col">Sản phẩm</th>
                <th scope="col">Giá trị</th>
                <th scope="col">Tình trạng</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"><a href="#">#2457</a></th>
                <td>Brandon Jacob</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$64</td>
                <td><span class="badge bg-success">Đã xác nhận</span></td>
              </tr>
              <tr>
                <th scope="row"><a href="#">#2147</a></th>
                <td>Bridie Kessler</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$47</td>
                <td><span class="badge bg-warning">Chờ duyệt</span></td>
              </tr>
              <tr>
                <th scope="row"><a href="#">#2049</a></th>
                <td>Ashleigh Langosh</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$147</td>
                <td><span class="badge bg-success">Đã xác nhận</span></td>
              </tr>
              <tr>
                <th scope="row"><a href="#">#2644</a></th>
                <td>Angus Grady</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$67</td>
                <td><span class="badge bg-danger">Đã hủy</span></td>
              </tr>
              <tr>
                <th scope="row"><a href="#">#2644</a></th>
                <td>Raheem Lehner</td>
                <td>
                  <ul class="ps-0" style="list-style-type: none;">
                    <li>2x <a href="">Logitech Wireless Headphones</a></li>
                    <li>3x <a href="">Mechanical_2 USB Tenkeyless Keyboard RGB</a></li>
                    <li><a href="">Asus 27 inch Gaming Monitor 2560x1440 TN 240Hz</a></li>
                    <li><a href="">MSI B460 ATX Motherboard</a></li>
                  </ul>
                </td>
                <td>$165</td>
                <td><span class="badge bg-success">Đã xác nhận</span></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div><!-- End Sales -->


  </main><!-- End #main -->

  <jsp:include page="../component/seller_footer.jsp" flush="true"></jsp:include>