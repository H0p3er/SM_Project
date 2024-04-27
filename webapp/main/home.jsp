<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.gson.*" %>
<jsp:include page="component/user_header.jsp" flush="true"></jsp:include>
<jsp:include page="component/user_navigation-bar.jsp" flush="true"></jsp:include>

<% Map<String, String> map = (Map<String,String>) request.getAttribute("home-page"); %>

        <div class="contact bg-black">
    <div class="container">
      <div class="row">
        <div class="section-heading text-center">
          <h2>Welcome to SM Marketplace</h2>
          <br>
          <h6>Nous n'avons pas ce dont vous avez besoin ici !</h6>
          <h6>这里什么都没有</h6>
        </div>
      </div>
    </div>
  </div>
  <div class="properties section">
    <div id="bestsaler">
      <div class="container">
        <div class="row">
          <div class="section-heading">
            <h6 class="fs-2">| Sản phẩm bán chạy</h6>
          </div>
        </div>
      </div>
      <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-interval="false">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
            aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
            aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
            aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <div class="item">
                    <a href="property-details.html"><img src="/home/assets/images/product/monitor/manhinh.png" alt=""></a>
                    <span class="category">Màn hình</span>
                    <h6>35,990,000đ</h6>
                    <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Màn Hình Samsung
                        Odyssey
                        OLED G9 G95SC
                        LS49CG954SEXXV LS49CG954SEXXV LS49CG954SEXXV</a></h4>
                    <ul class="item-list">
                      <li>Hãng: <span>Samsung</span></li>
                      <li>Kích thước: <span>49 inch</span></li>
                      <li>Độ phân giải: <span>5120x1440</span></li>
                      <li>Tấm nền: <span>OLED</span></li>
                      <li>Tần số quét: <span>3</span></li>
                      <li>Tốc độ phản hồi: <span>0.03 ms</span></li>
                    </ul>
                    <div class="main-button">
                      <a href="property-details.html">Xem chi tiết</a>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6">
                  <div class="item">
                    <a href="property-details.html"><img src="/home/assets/images/product/keyboard/banphim.png" alt=""></a>
                    <span class="category">Bàn phím</span>
                    <h6>2,090,000đ</h6>
                    <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Bàn Phím Cơ Không
                        Dây
                        FL-Esports CMK75 SAM Lake
                        Placid Blue 3 Mode</a></h4>
                    <ul class="item-list">
                      <li>Hãng: <span>FL-Esports</span></li>
                      <li>Loại bàn phím: <span>Cơ</span></li>
                      <li>Kết nối: <span>3 Mode</span></li>
                      <li>Layout: <span>75%</span></li>
                      <li>Led: <span>RGB</span></li>
                    </ul>
                    <div class="main-button">
                      <a href="property-details.html">Xem chi tiết</a>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-6">
                  <div class="item">
                    <a href="property-details.html"><img src="/home/assets/images/product/mouse/chuot.png" alt=""></a>
                    <span class="category">Chuột</span>
                    <h6>990,000đ</h6>
                    <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Chuột Razer
                        Basilisk V3
                        (RZ01-04000100-R3M1)</a></h4>
                    <ul class="item-list">
                      <li>Hãng: <span>Razer</span></li>
                      <li>Loại chuột: <span>Gaming</span></li>
                      <li>Kết nối: <span>USB</span></li>
                      <li>Thiết kế: <span>Công thái học</span></li>
                      <li>Pin: <span>Không</span></li>
                    </ul>
                    <div class="main-button">
                      <a href="property-details.html">Xem chi tiết</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container">
            <div class="row">
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/headphones/tainghe.png" alt=""></a>
                  <span class="category">Tai nghe/Loa</span>
                  <h6>3,390,000đ</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Tai Nghe HyperX
                      Cloud
                      II
                      Wireless (4P5K4AA)</a></h4>
                  <ul class="item-list">
                    <li>Hãng: <span>HyperX</span></li>
                    <li>Loại tai nghe: <span>Over ear</span></li>
                    <li>Kết nối: <span>2.4</span></li>
                    <li>Cổng kết nối: <span>USB</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/laptop/laptop.png" alt=""></a>
                  <span class="category">Laptop</span>
                  <h6>93,990,000₫</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Laptop Gaming
                      ASUS ROG
                      Zephyrus Duo 16 GX650PZ NM031W</a></h4>
                  <ul class="item-list">
                    <li>Hãng: <span>Asus</span></li>
                    <li>CPU: <span>R9 7945HX</span></li>
                    <li>VGA: <span>RTX 4080</span></li>
                    <li>Ram: <span>32GB DDR5</span></li>
                    <li>Màn hình: <span>16' MiniLED 240Hz</span></li>
                    <li>Ổ cứng: <span>1 TB</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/pc.png" alt=""></a>
                  <span class="category">Desktop</span>
                  <h6>6,990,000₫</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Mini PC INTEL
                      Tiger
                      Canyon Core I3</a></h4>
                  <ul class="item-list">
                    <li>CPU: <span>Intel I3-1115G4</span></li>
                    <li>VGA: <span>Intel UHD Graphics</span></li>
                    <li>Ram: <span>2x DDR4</span></li>
                    <li>Ổ cứng: <span>M2 PCIe</span></li>
                    <li>Nguồn: <span>DC 120W</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
            </div></div>
          </div>
          <div class="carousel-item">
            <div class="container">
            <div class="row">
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/cpu/cpu.png" alt=""></a>
                  <span class="category">CPU</span>
                  <h6>17,990,000₫</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">CPU AMD Ryzen 9
                      7950X3D</a></h4>
                  <ul class="item-list">
                    <li>Loại CPU: <span>AMD Ryzen 9</span></li>
                    <li>Socket: <span>AMD AM5</span></li>
                    <li>Cores/Threats: <span>16c/32t</span></li>
                    <li>Tốc độ: <span>4.2 - 5.7 GHz</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/mainboard/mainboard.png" alt=""></a>
                  <span class="category">Mainboard</span>
                  <h6>5,550,000đ</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Mainboard Asus
                      ROG
                      Strix
                      B760-A Gaming Wifi D4</a></h4>
                  <ul class="item-list">
                    <li>Hãng: <span>Asus</span></li>
                    <li>Chipset: <span>B760</span></li>
                    <li>Socket: <span>LGA 1720</span></li>
                    <li>Kích thước: <span>ATX</span></li>
                    <li>Ram: <span>DDR4</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 col-md-6">
                <div class="item">
                  <a href="property-details.html"><img src="/home/assets/images/product/ram/ram.png" alt=""></a>
                  <span class="category">Ram</span>
                  <h6>7,190,000₫</h6>
                  <h4 style="height: 72px" class="text-truncateline"><a href="property-details.html">Ram PC Corsair
                      Dominator
                      Platinum RGB DDR5 64GB 5600Mhz Black(2x
                      32GB)</a></h4>
                  <ul class="item-list">
                    <li>Hãng: <span>Corsair</span></li>
                    <li>Dành cho: <span>PC</span></li>
                    <li>Dung lượng: <span>2 x 32 GB</span></li>
                    <li>Bus: <span>5600 MHz</span></li>
                    <li>Chuẩn: <span>DDR5</span></li>
                  </ul>
                  <div class="main-button">
                    <a href="property-details.html">Xem chi tiết</a>
                  </div>
                </div>
              </div>
            </div></div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
          data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>

      </div>
    </div>

    <div class="container mt-5">
      <div class="row">
        <div class="section-heading">
          <h6 class="fs-2">| Sản phẩm mới</h6>
        </div>
      </div>
      <div class="row">


			<%=map.get("home_newest_product") %>	
      </div>
    </div>
  </div>
      

      <jsp:include page="component/user_footer.jsp" flush="true"></jsp:include>