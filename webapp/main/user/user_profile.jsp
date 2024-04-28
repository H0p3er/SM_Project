<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <jsp:include page="../component/user_header.jsp" flush="true"></jsp:include>
  <jsp:include page="../component/user_navigation-bar.jsp" flush="true"></jsp:include>

  <div class="best-deal mt-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 mb-5">
          <div class="section-heading">
            <h6>| Thông tin người dùng</h6>
            <h2><i class="fa-solid fa-circle-user"></i> username</h2>
          </div>
        </div>
        <div class="col-lg-12">
          <div class="tabs-content">
            <div class="row">
              <div class="nav-wrapper ">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="userprofile-tab" data-bs-toggle="tab"
                      data-bs-target="#userprofile" type="button" role="tab" aria-controls="userprofile"
                      aria-selected="true">Thông tin chung</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="editprofileform-tab" data-bs-toggle="tab"
                      data-bs-target="#editprofileform" type="button" role="tab" aria-controls="editprofileform"
                      aria-selected="false">Sửa thông tin</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="changepasswordform-tab" data-bs-toggle="tab"
                      data-bs-target="#changepasswordform" type="button" role="tab" aria-controls="changepasswordform"
                      aria-selected="false">Đổi mật khẩu</button>
                  </li>
                </ul>

              </div>
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="userprofile" role="tabpanel"
                  aria-labelledby="userprofile-tab">
                  <div class="row">
                    <div class="contact py-3">
                      <div class="container">
                        <div class="row">
                          <div class="col-lg-6 offset-lg-3">
                            <div class="section-heading text-center">
                              <h1>Thông tin cá nhân</h1>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-8 offset-lg-2 mt-1">
                      <div class="info-table">
                        <ul>
                          <li>Họ và tên <span>185</span></li>
                          <li>Nickname <span>25/4/2024</span></li>
                          <li>Ngày sinh <span>25/4/2024</span></li>
                          <li>Giới tính <span>Nam</span></li>
                          <li>Điện thoại <span>00001111</span></li>
                          <li>Email <span>Hanoi</span></li>
                          <li>Địa chỉ <span>Yes</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-12 mt-md-5">
                      <h4 class="mt-1">Note</h4>
                      <p> [note] Lorem ipsum dolor sit amet, consectetur adipiscing elit, do eiusmod tempor pack
                        incididunt ut
                        labore et dolore magna aliqua quised ipsum suspendisse.
                      </p>

                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="editprofileform" role="tabpanel" aria-labelledby="editprofileform-tab">
                  <div class="contact py-3">
                    <div class="container">
                      <div class="row">
                        <div class="col-lg-6 offset-lg-3">
                          <div class="section-heading text-center">
                            <h1>Cập nhật thông tin</h1>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="contact-content mt-1">
                    <div class="container">
                      <div class="row justify-content-center">
                        <div class="col-lg-9">
                          <form id="contact-form" action="" method="post">
                            <div class="row">
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="name">Họ và tên</label>
                                  <input type="text" name="name" id="full" placeholder="Họ và tên" value="$fullname"
                                    maxlength="70">
                                </fieldset>
                              </div>
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="nickname">Nickname</label>
                                  <input type="text" name="nickname" id="address" placeholder="Nickname"
                                    value="$nickname" maxlength="35">
                                </fieldset>
                              </div>
                              <div class="col-lg-8">
                                <fieldset>
                                  <label for="birtday">Ngày sinh</label>
                                  <input type="date" name="birthday" id="birtday" placeholder="Ngày sinh"
                                    value="$birthday">
                                </fieldset>
                              </div>
                              <div class="col-lg-4">
                                <fieldset>
                                  <label for="gender">Giới tính</label>
                                  <select name="gender" id="gender">
                                    <option value="Nam" selected>Nam</option> //selected dựa trên database ?
                                    <option value="Nữ">Nữ</option>
                                  </select>

                                </fieldset>
                              </div>
                              <div class="col-lg-5">
                                <fieldset>
                                  <label for="phone">Điện thoại</label>
                                  <input type="tel" name="phone" id="phone" placeholder="Điện thoại"
                                    value="$phonenumber" inputmode="numeric" minlength="10" maxlength="12">
                                </fieldset>
                              </div>
                              <div class="col-lg-7">
                                <fieldset>
                                  <label for="email">Email</label>
                                  <input type="email" name="email" id="email" placeholder="Email" value="$email"
                                    maxlength="50">
                                </fieldset>
                              </div>
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="address">Địa chỉ</label>
                                  <input type="text" name="address" id="address" placeholder="Địa chỉ" value="$address">
                                </fieldset>
                              </div>
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="note">Note</label>
                                  <textarea name="note" id="note" placeholder="Note" rows="3">$note</textarea>
                                </fieldset>
                              </div>
                              <div class="col-lg-12">
                                <fieldset>
                                  <button type="submit" id="form-submit" class="orange-button">Cập nhập thông
                                    tin</button>
                                </fieldset>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="changepasswordform" role="tabpanel"
                  aria-labelledby="changepasswordform-tab">
                  <div class="contact py-3">
                    <div class="container">
                      <div class="row">
                        <div class="col-lg-6 offset-lg-3">
                          <div class="section-heading text-center">
                            <h1>Đổi mật khẩu</h1>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="contact-content mt-1">
                    <div class="container">
                      <div class="row justify-content-center">
                        <div class="col-lg-9">
                          <form id="contact-form" action="" method="post">
                            <div class="row">
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="currentpassword">Nhập mật khẩu cũ</label>
                                  <input type="password" name="password" id="password" pattern="[^ @]*@[^ @]*"
                                    placeholder="Your current password" required maxlength="20">
                                </fieldset>
                              </div>
                              <div class="col-lg-12">
                                <fieldset>
                                  <label for="newpassword">Nhập mật khẩu mới</label>
                                  <input type="password" name="newpassword" id="newpassword" pattern="[^ @]*@[^ @]*"
                                    placeholder="Your new password" required autocomplete="off" maxlength="20">
                                </fieldset>
                              </div>

                              <div class="col-lg-12">
                                <fieldset>
                                  <button type="submit" id="form-submit" class="orange-button">Đổi mật khẩu</button>
                                </fieldset>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>






  <jsp:include page="../component/user_footer.jsp" flush="true"></jsp:include>