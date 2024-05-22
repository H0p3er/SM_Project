/**
* Template Name: NiceAdmin
* Updated: May 30 2023 with Bootstrap v5.3.0
* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/
(function () {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    if (all) {
      select(el, all).forEach(e => e.addEventListener(type, listener))
    } else {
      select(el, all).addEventListener(type, listener)
    }
  }

  /**
   * Easy on scroll event listener 
   */
  const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
  }

  /**
   * Sidebar toggle
   */
  if (select('.toggle-sidebar-btn')) {
    on('click', '.toggle-sidebar-btn', function (e) {
      select('body').classList.toggle('toggle-sidebar')
    })
  }

  /**
   * Search bar toggle
   */
  if (select('.search-bar-toggle')) {
    on('click', '.search-bar-toggle', function (e) {
      select('.search-bar').classList.toggle('search-bar-show')
    })
  }

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = select('#navbar .scrollto', true)
  const navbarlinksActive = () => {
    let position = window.scrollY + 200
    navbarlinks.forEach(navbarlink => {
      if (!navbarlink.hash) return
      let section = select(navbarlink.hash)
      if (!section) return
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        navbarlink.classList.add('active')
      } else {
        navbarlink.classList.remove('active')
      }
    })
  }
  window.addEventListener('load', navbarlinksActive)
  onscroll(document, navbarlinksActive)

  /**
   * Toggle .header-scrolled class to #header when page is scrolled
   */
  let selectHeader = select('#header')
  if (selectHeader) {
    const headerScrolled = () => {
      if (window.scrollY > 100) {
        selectHeader.classList.add('header-scrolled')
      } else {
        selectHeader.classList.remove('header-scrolled')
      }
    }
    window.addEventListener('load', headerScrolled)
    onscroll(document, headerScrolled)
  }

  /**
   * Back to top button
   */
  let backtotop = select('.back-to-top')
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add('active')
      } else {
        backtotop.classList.remove('active')
      }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
  }

  /**
   * Initiate tooltips
   */
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
  })

  /**
   * Initiate quill editors
   */
  if (select('.quill-editor-default')) {
    new Quill('.quill-editor-default', {
      theme: 'snow'
    });
  }

  if (select('.quill-editor-bubble')) {
    new Quill('.quill-editor-bubble', {
      theme: 'bubble'
    });
  }

  if (select('.quill-editor-full')) {
    new Quill(".quill-editor-full", {
      modules: {
        toolbar: [
          [{
            font: []
          }, {
            size: []
          }],
          ["bold", "italic", "underline", "strike"],
          [{
            color: []
          },
          {
            background: []
          }
          ],
          [{
            script: "super"
          },
          {
            script: "sub"
          }
          ],
          [{
            list: "ordered"
          },
          {
            list: "bullet"
          },
          {
            indent: "-1"
          },
          {
            indent: "+1"
          }
          ],
          ["direction", {
            align: []
          }],
          ["link", "image", "video"],
          ["clean"]
        ]
      },
      theme: "snow"
    });
  }

  /**
   * Initiate TinyMCE Editor
   */
  const useDarkMode = window.matchMedia('(prefers-color-scheme: dark)').matches;
  const isSmallScreen = window.matchMedia('(max-width: 1023.5px)').matches;

  tinymce.init({
    selector: 'textarea.tinymce-editor',
    plugins: 'preview importcss searchreplace autolink autosave save directionality code visualblocks visualchars fullscreen image link media template codesample table charmap pagebreak nonbreaking anchor insertdatetime advlist lists wordcount help charmap quickbars emoticons',
    editimage_cors_hosts: ['picsum.photos'],
    menubar: 'file edit view insert format tools table help',
    toolbar: 'undo redo | bold italic underline strikethrough | fontfamily fontsize blocks | alignleft aligncenter alignright alignjustify | outdent indent |  numlist bullist | forecolor backcolor removeformat | pagebreak | charmap emoticons | fullscreen  preview save print | insertfile image media template link anchor codesample | ltr rtl',
    toolbar_sticky: true,
    toolbar_sticky_offset: isSmallScreen ? 102 : 108,
    autosave_ask_before_unload: true,
    autosave_interval: '30s',
    autosave_prefix: '{path}{query}-{id}-',
    autosave_restore_when_empty: false,
    autosave_retention: '2m',
    image_advtab: true,
    link_list: [{
      title: 'My page 1',
      value: 'https://www.tiny.cloud'
    },
    {
      title: 'My page 2',
      value: 'http://www.moxiecode.com'
    }
    ],
    image_list: [{
      title: 'My page 1',
      value: 'https://www.tiny.cloud'
    },
    {
      title: 'My page 2',
      value: 'http://www.moxiecode.com'
    }
    ],
    image_class_list: [{
      title: 'None',
      value: ''
    },
    {
      title: 'Some class',
      value: 'class-name'
    }
    ],
    importcss_append: true,
    file_picker_callback: (callback, value, meta) => {
      /* Provide file and text for the link dialog */
      if (meta.filetype === 'file') {
        callback('https://www.google.com/logos/google.jpg', {
          text: 'My text'
        });
      }

      /* Provide image and alt text for the image dialog */
      if (meta.filetype === 'image') {
        callback('https://www.google.com/logos/google.jpg', {
          alt: 'My alt text'
        });
      }

      /* Provide alternative source and posted for the media dialog */
      if (meta.filetype === 'media') {
        callback('movie.mp4', {
          source2: 'alt.ogg',
          poster: 'https://www.google.com/logos/google.jpg'
        });
      }
    },
    templates: [{
      title: 'New Table',
      description: 'creates a new table',
      content: '<div class="mceTmpl"><table width="98%%"  border="0" cellspacing="0" cellpadding="0"><tr><th scope="col"> </th><th scope="col"> </th></tr><tr><td> </td><td> </td></tr></table></div>'
    },
    {
      title: 'Starting my story',
      description: 'A cure for writers block',
      content: 'Once upon a time...'
    },
    {
      title: 'New list with dates',
      description: 'New List with dates',
      content: '<div class="mceTmpl"><span class="cdate">cdate</span><br><span class="mdate">mdate</span><h2>My List</h2><ul><li></li><li></li></ul></div>'
    }
    ],
    template_cdate_format: '[Date Created (CDATE): %m/%d/%Y : %H:%M:%S]',
    template_mdate_format: '[Date Modified (MDATE): %m/%d/%Y : %H:%M:%S]',
    height: 600,
    image_caption: true,
    quickbars_selection_toolbar: 'bold italic | quicklink h2 h3 blockquote quickimage quicktable',
    noneditable_class: 'mceNonEditable',
    toolbar_mode: 'sliding',
    contextmenu: 'link image table',
    skin: useDarkMode ? 'oxide-dark' : 'oxide',
    content_css: useDarkMode ? 'dark' : 'default',
    content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
  });

  /**
   * Initiate Bootstrap validation check
   */
  var needsValidation = document.querySelectorAll('.needs-validation')

  Array.prototype.slice.call(needsValidation)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })

  /**
   * Initiate Datatables
   */
  const datatables = select('.datatable', true)
  datatables.forEach(datatable => {
    new simpleDatatables.DataTable(datatable);

  })

  /**
   * Autoresize echart charts
   */
  const mainContainer = select('#main');
  if (mainContainer) {
    setTimeout(() => {
      new ResizeObserver(function () {
        select('.echart', true).forEach(getEchart => {
          echarts.getInstanceByDom(getEchart).resize();
        })
      }).observe(mainContainer);
    }, 200);
  }

})();



$(document).ready(function updateContent(selectedOption) {
  var divContent = '';
  switch (selectedOption) {
    case '1':
      divContent = `
      <div class="row mb-3">
      <label for="manufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
          <select name="productManufacturer" class="form-select">
              <option value="" selected></option>
              <option value="Acer">Acer</option>
              <option value="AOC">AOC</option>
              <option value="ASRock">ASRock</option>
              <option value="Asus">Asus</option>
              <option value="BenQ">BenQ</option>
              <option value="Dell">Dell</option>
              <option value="Gigabyte">Gigabyte</option>
              <option value="HP">HP</option>
              <option value="Huawei">Huawei</option>
              <option value="Lenovo">Lenovo</option>
              <option value="LG">LG</option>
              <option value="MSI">MSI</option>
              <option value="Philips">Philips</option>
              <option value="Samsung">Samsung</option>
              <option value="ViewSonic">ViewSonic</option>
              <option value="other">Khác</option>
          </select>
        </div>
      </div>
      <div class="row mb-3">
      <label for="size" class="col-md-4 col-lg-3 col-form-label">Kích thước</label>
        <div class="col-md-8 col-lg-9">
          <select name="productSize" class="form-select">
              <option value="" selected></option>
              <option value="-13inch">&lt;13 inch</option>
              <option value="13-17inch">13-17 inch</option>
              <option value="18-22inch">18-22 inch</option>
              <option value="24inch">24 inch</option>
              <option value="27inch">27 inch</option>
              <option value="28-34inch">28-34 inch</option>
              <option value="34+">34+</option>
          </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="use" class="col-md-4 col-lg-3 col-form-label">Mục đích sử dụng</label>
        <div class="col-md-8 col-lg-9">
          <select name="productUse" class="form-select">
              <option value="" selected></option>
              <option value="Gaming">Gaming</option>
              <option value="văn phòng">Văn phòng</option>
              <option value="đồ họa">Đồ họa</option>
              <option value="other">Khác</option>
          </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="resolution" class="col-md-4 col-lg-3 col-form-label">Độ phân giải</label>
        <div class="col-md-8 col-lg-9">
            <select name="productResolution" class="form-select">
                <option value="" selected></option>
                <option value="HD 1280x720">HD 1280x720</option>
                <option value="1366x768">1366x768</option>
                <option value="1600x900">1600x900</option>
                <option value="FHD 1080">FHD 1080</option>
                <option value="2k 2560x1440">2k 2560x1440</option>
                <option value="4k 3840x2160">4k 3840x2160</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="panel" class="col-md-4 col-lg-3 col-form-label">Tấm nền</label>
        <div class="col-md-8 col-lg-9">
            <select name="productPanel" class="form-select">
                <option value="" selected></option>
                <option value="IPS">IPS</option>
                <option value="VA">VA</option>
                <option value="TN">TN</option>
                <option value="OLED">OLED</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="frequency" class="col-md-4 col-lg-3 col-form-label">Tần số quét</label>
        <div class="col-md-8 col-lg-9">
            <select name="productFreq" class="form-select">
                <option value="" selected></option>
                <option value="60/75hz">60/75Hz</option>
                <option value="100/120hz">100/120Hz</option>
                <option value="144hz/165/180hz">144Hz/165/180Hz</option>
                <option value="240hz">240Hz</option>
                <option value="360hz">360Hz</option>
                <option value="540hz">540Hz</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="response" class="col-md-4 col-lg-3 col-form-label">Tốc độ phản hồi</label>
        <div class="col-md-8 col-lg-9">
            <select name="productResponse" class="form-select">
                <option value="" selected></option>
                <option value="0.1ms">0.1ms</option>
                <option value="0.3ms">0.3ms</option>
                <option value="0.5ms">0.5ms</option>
                <option value="1ms">1ms</option>
                <option value="4ms">4ms</option>
                <option value="6ms">6ms</option>
                <option value="8ms">8ms</option>
                <option value="12ms">12ms</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="type" class="col-md-4 col-lg-3 col-form-label">Loại màn hình</label>
        <div class="col-md-8 col-lg-9">
            <select name="productType" class="form-select">
                <option value="" selected></option>
                <option value="Cong">Cong</option>
                <option value="Phẳng">Phẳng</option>
                <option value="16:10">16:10</option>
                <option value="21:9">21:9</option>
                <option value="4:3">4:3</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '2':
      divContent = `
      <div class="row mb-3">
        <label for="productType" class="col-md-4 col-lg-3 col-form-label">Loại sản phẩm</label>
        <div class="col-md-8 col-lg-9">
            <select name="productType" class="form-select">
                <option value="" selected></option>
                <option value="Văn Phòng">Văn Phòng</option>
                <option value="Cơ">Cơ</option>
                <option value="Giả Cơ">Giả Cơ</option>
                <option value="Gaming">Gaming</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productConnection" class="col-md-4 col-lg-3 col-form-label">Kết nối</label>
        <div class="col-md-8 col-lg-9">
            <select name="productConnection" class="form-select">
                <option value="" selected></option>
                <option value="Dây">Dây</option>
                <option value="Bluetooth">Bluetooth</option>
                <option value="2.4">2.4 GHz</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSizeLayout" class="col-md-4 col-lg-3 col-form-label">Kích cỡ Layout phím</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSizeLayout" class="form-select">
                <option value="" selected></option>
                <option value="Mini">Mini</option>
                <option value="75%">75%</option>
                <option value="TKL">TKL</option>
                <option value="Fullsize">Fullsize</option>
                <option value="Low profile">Low profile</option>
                <option value="Công thái học">Công thái học</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productLed" class="col-md-4 col-lg-3 col-form-label">Led</label>
        <div class="col-md-8 col-lg-9">
            <select name="productLed" class="form-select">
                <option value="" selected></option>
                <option value="Không">Không</option>
                <option value="Có">Có</option>
                <option value="RGB">RGB</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '3':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asus">Asus</option>
                <option value="Akko">Akko</option>
                <option value="Apple">Apple</option>
                <option value="BenQ">BenQ</option>
                <option value="Consair">Consair</option>
                <option value="Dell">Dell</option>
                <option value="Dareu">Dareu</option>
                <option value="E-Dra">E-Dra</option>
                <option value="Fuhlen">Fuhlen</option>
                <option value="Genius">Genius</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="Logitech">Logitech</option>
                <option value="Microsoft">Microsoft</option>
                <option value="MSI">MSI</option>
                <option value="Pulsar">Pulsar</option>
                <option value="Rappo">Rappo</option>
                <option value="Razer">Razer</option>
                <option value="Steelseries">Steelseries</option>
                <option value="UGreen">UGreen</option>
                <option value="Zowie">Zowie</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productType" class="col-md-4 col-lg-3 col-form-label">Loại sản phẩm</label>
        <div class="col-md-8 col-lg-9">
            <select name="productType" class="form-select">
                <option value="" selected></option>
                <option value="Gaming">Gaming</option>
                <option value="Văn phòng">Văn phòng</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productConnection" class="col-md-4 col-lg-3 col-form-label">Kết nối</label>
        <div class="col-md-8 col-lg-9">
            <select name="productConnection" class="form-select">
                <option value="" selected></option>
                <option value="Dây">Dây</option>
                <option value="Bluetooth">Bluetooth</option>
                <option value="2.4">2.4 GHz</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productDesign" class="col-md-4 col-lg-3 col-form-label">Thiết kế</label>
        <div class="col-md-8 col-lg-9">
            <select name="productDesign" class="form-select">
                <option value="" selected></option>
                <option value="đối xứng">Đối xứng</option>
                <option value="công thái học">Công thái học</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productBattery" class="col-md-4 col-lg-3 col-form-label">Loại pin</label>
        <div class="col-md-8 col-lg-9">
            <select name="productBattery" class="form-select">
                <option value="" selected></option>
                <option value="pin rời">Pin rời</option>
                <option value="pin sạc">Pin sạc</option>
                <option value="không pin">Không pin</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '4':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asus">Asus</option>
                <option value="Cooler Master">Cooler Master</option>
                <option value="Corsair">Corsair</option>
                <option value="Dareu">Dareu</option>
                <option value="Edifier">Edifier</option>
                <option value="E-Dra">E-Dra</option>
                <option value="Fuhlen">Fuhlen</option>
                <option value="Genius">Genius</option>
                <option value="HP">HP</option>
                <option value="Jabra">Jabra</option>
                <option value="JBL">JBL</option>
                <option value="Lenovo">Lenovo</option>
                <option value="Logitech">Logitech</option>
                <option value="MicroLab">MicroLab</option>
                <option value="Microsoft">Microsoft</option>
                <option value="MSI">MSI</option>
                <option value="Pioneer">Pioneer</option>
                <option value="Rapoo">Rapoo</option>
                <option value="Razer">Razer</option>
                <option value="Sennheiser">Sennheiser</option>
                <option value="Sony">Sony</option>
                <option value="Steelseries">Steelseries</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
          <label for="productType" class="col-md-4 col-lg-3 col-form-label">Loại tai nghe</label>
          <div class="col-md-8 col-lg-9">
              <select name="productType" class="form-select">
                  <option value="" selected></option>
                  <option value="Overear">Over-ear</option>
                  <option value="in ear">In-ear</option>
                  <option value="loa">Loa</option>
                  <option value="phụ kiện">Phụ kiện</option>
                  <option value="other">Khác</option>
              </select>
          </div>
      </div>
      <div class="row mb-3">
        <label for="productConnection" class="col-md-4 col-lg-3 col-form-label">Loại kết nối</label>
        <div class="col-md-8 col-lg-9">
            <select name="productConnection" class="form-select">
                <option value="" selected></option>
                <option value="Dây">Dây</option>
                <option value="Bluetooth">Bluetooth</option>
                <option value="2.4">2.4 GHz</option>
                <option value="2.4 + Bluetooth">2.4 GHz + Bluetooth</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productPort" class="col-md-4 col-lg-3 col-form-label">Cổng kết nối</label>
        <div class="col-md-8 col-lg-9">
            <select name="productPort" class="form-select">
                <option value="" selected></option>
                <option value="Usb">USB</option>
                <option value="Usb C">USB-C</option>
                <option value="3.5">3.5mm</option>
            </select>
        </div>
      </div>
  
      `;
      break;

    case '5':
      divContent = `
      <div class="row mb-3">
        <label for="manufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
          <select name="productManufacturer" class="form-select">
            <option value="" selected></option>
            <option value="Acer">Acer</option>
            <option value="Apple">Apple</option>
            <option value="Asus">Asus</option>
            <option value="Dell">Dell</option>
            <option value="Gigabyte">Gigabyte</option>
            <option value="HP">HP</option>
            <option value="Huawei">Huawei</option>
            <option value="Lenovo">Lenovo</option>
            <option value="LG">LG</option>
            <option value="Microsoft">Microsoft</option>
            <option value="MSI">MSI</option>
            <option value="Viao">Viao</option>
            <option value="Xiaomi">Xiaomi</option>
            <option value="other">Hãng khác</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="cpu" class="col-md-4 col-lg-3 col-form-label">CPU</label>
        <div class="col-md-8 col-lg-9">
          <select name="productCPU" class="form-select">
            <option value="" selected></option>
            <option value="Intel Core i3">Intel Core i3</option>
            <option value="Intel Core i5">Intel Core i5</option>
            <option value="Intel Core i7">Intel Core i7</option>
            <option value="Intel Core i9">Intel Core i9</option>
            <option value="AMD Ryzen 3">AMD Ryzen 3</option>
            <option value="AMD Ryzen 5">AMD Ryzen 5</option>
            <option value="AMD Ryzen 7">AMD Ryzen 7</option>
            <option value="AMD Ryzen 9">AMD Ryzen 9</option>
            <option value="other">Khác</option>
          </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="ram" class="col-md-4 col-lg-3 col-form-label">RAM</label>
        <div class="col-md-8 col-lg-9">
          <select name="productRam" class="form-select">
            <option value="" selected></option>
            <option value="4gb">4GB</option>
            <option value="8gb">8GB</option>
            <option value="16gb">16GB</option>
            <option value="32gb">32GB</option>
            <option value="64gb">64GB</option>
            <option value="other">Khác</option>
        </select>                      
        </div>
      </div>
      <div class="row mb-3">
        <label for="graphics" class="col-md-4 col-lg-3 col-form-label">Card</label>
        <div class="col-md-8 col-lg-9">
          <select name="productGraphics" class="form-select">
            <option value="" selected></option>
            <option value="Intel UHD">Intel UHD</option>
            <option value="AMD Radeon">AMD Radeon</option>
            <option value="Intel Iris XE">Intel Iris XE</option>
            <option value="GTX 9">GTX 9</option>
            <option value="GTX 10">GTX 10</option>
            <option value="GTX 16">GTX 16</option>
            <option value="RTX 30">RTX 30</option>
            <option value="RTX 40">RTX 40</option>
            <option value="other">Khác</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="storage" class="col-md-4 col-lg-3 col-form-label">Ổ cứng</label>
        <div class="col-md-8 col-lg-9">
          <select name="productStorage" class="form-select">
            <option value="" selected></option>
            <option value="128gb">128GB</option>
            <option value="256gb">256GB</option>
            <option value="512gb">512GB</option>
            <option value="1tb">1TB</option>
            <option value="2tb">2TB</option>
            <option value="other">Khác</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="monitor" class="col-md-4 col-lg-3 col-form-label">Màn hình</label>
        <div class="col-md-8 col-lg-9">
          <!-- <input name="monitor" type="text" class="form-control" id="monitor" value="Integrated Apple GPU"> -->
          <select name="productScreen" class="form-select">
            <option value="" selected></option>
            <option value="-13inch">&lt;13 inch</option>
            <option value="13inch">13 inch</option>
            <option value="14inch">14 inch</option>
            <option value="15.6inch">15.6 inch</option>
            <option value="16inch">16 inch</option>
            <option value="17inch">17 inch</option>
            <option value="18inch">18 inch</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="freq" class="col-md-4 col-lg-3 col-form-label">Tần số quét</label>
        <div class="col-md-8 col-lg-9">
          <!-- <input name="freq" type="text" class="form-control" id="freq" value="Integrated Apple GPU"> -->
          <select name="productFreq" class="form-select">
            <option value="" selected></option>
            <option value="60hz">60Hz</option>
            <option value="90hz">90Hz</option>
            <option value="120hz">120Hz</option>
            <option value="144hz/165hz">144Hz/165Hz</option>
            <option value="240hz">240Hz</option>
            <option value="360hz">360Hz</option>
            <option value="other">Khác</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="resolution" class="col-md-4 col-lg-3 col-form-label">Độ phân giải</label>
        <div class="col-md-8 col-lg-9">
          <!-- <input name="resolution" type="text" class="form-control" id="resolution" value="Integrated Apple GPU" maxlength="30"> -->
          <select name="productResolution" class="form-select">
            <option value="" selected></option>
            <option value="HD 1280x720">HD 1280x720</option>
            <option value="FHD 1920x1080">FHD 1920x1080</option>
            <option value="2K 2560x1440">2K 2560x1440</option>
            <option value="4K 3840x2160">4K 3840x2160</option>
            <option value="other">Khác</option>
        </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="type" class="col-md-4 col-lg-3 col-form-label">Phân loại</label>
        <div class="col-md-8 col-lg-9">
          <select name="productType" class="form-select">
            <option value="" selected></option>
            <option value="Mỏng nhẹ">Mỏng nhẹ</option>
            <option value="Gaming">Gaming</option>
            <option value="Đồ Họa">Đồ Họa</option>
            <option value="Doanh nhân">Doanh nhân</option>
            <option value="Cảm ứng">Cảm ứng</option>
          </select>
        </div>
      </div>`;
      break;
    case '6':
      divContent = `
      <div class="row mb-3">
        <label for="productStatus" class="col-md-4 col-lg-3 col-form-label">Tình trạng máy</label>
        <div class="col-md-8 col-lg-9">
            <select name="productStatus" class="form-select">
                <option value="" selected></option>
                <option value="Cũ">Cũ</option>
                <option value="Mới">Mới</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Dell">Dell</option>
                <option value="HP">HP</option>
                <option value="Microsoft">Microsoft</option>
                <option value="Apple">Apple</option>
                <option value="Asus">Asus</option>
                <option value="Acer">Acer</option>
                <option value="Lenovo">Lenovo</option>
                <option value="MSI">MSI</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCPU" class="col-md-4 col-lg-3 col-form-label">CPU</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCPU" class="form-select">
                <option value="" selected></option>
                <option value="Intel Celeron">Intel Celeron</option>
                <option value="Intel Pentium">Intel Pentium</option>
                <option value="Intel Core i3">Intel Core i3</option>
                <option value="Intel Core i5">Intel Core i5</option>
                <option value="Intel Core i7">Intel Core i7</option>
                <option value="Intel Core i9">Intel Core i9</option>
                <option value="Intel Xeon">Intel Xeon</option>
                <option value="AMD Ryzen 3">AMD Ryzen 3</option>
                <option value="AMD Ryzen 5">AMD Ryzen 5</option>
                <option value="AMD Ryzen 7">AMD Ryzen 7</option>
                <option value="AMD Ryzen 9">AMD Ryzen 9</option>
                <option value="AMD Threadripper">AMD Threadripper</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productVGA" class="col-md-4 col-lg-3 col-form-label">VGA</label>
        <div class="col-md-8 col-lg-9">
            <select name="productVGA" class="form-select">
                <option value="" selected></option>
                <option value="Intel">Intel</option>
                <option value="AMD">AMD</option>
                <option value="NVIDIA">NVIDIA</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productRam" class="col-md-4 col-lg-3 col-form-label">RAM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productRam" class="form-select">
                <option value="" selected></option>
                <option value="DDR3">DDR3</option>
                <option value="DDR4">DDR4</option>
                <option value="DDR5">DDR5</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productRamCapacity" class="col-md-4 col-lg-3 col-form-label">Dung lượng RAM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productRamCapacity" class="form-select">
                <option value="" selected></option>
                <option value="4gb">4GB</option>
                <option value="8gb">8GB</option>
                <option value="16gb">16GB</option>
                <option value="32gb">32GB</option>
                <option value="64gb">64GB</option>
                <option value="128gb">128GB</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productStorage" class="col-md-4 col-lg-3 col-form-label">Ổ cứng</label>
        <div class="col-md-8 col-lg-9">
            <select name="productStorage" class="form-select">
                <option value="" selected></option>
                <option value="SSD">SSD</option>
                <option value="HDD">HDD</option>
                <option value="SSD + HDD">SSD + HDD</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productPSU" class="col-md-4 col-lg-3 col-form-label">Nguồn</label>
        <div class="col-md-8 col-lg-9">
            <select name="productPSU" class="form-select">
                <option value="" selected></option>
                <option value="Dưới 300w">Dưới 300W</option>
                <option value="400w">400W</option>
                <option value="500w">500W</option>
                <option value="600w">600W</option>
                <option value="800w">800W</option>
                <option value="1000w">1000W</option>
                <option value="Trên 1000w">Trên 1000W</option>
            </select>
        </div>
      </div>
  
      `;
      break;
    case '7':
      divContent = `
      <div class="row mb-3">
        <label for="productCPU" class="col-md-4 col-lg-3 col-form-label">CPU</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCPU" class="form-select">
                <option value="" selected></option>
                <option value="Intel Celeron">Intel Celeron</option>
                <option value="Intel Pentium">Intel Pentium</option>
                <option value="Intel Core i3">Intel Core i3</option>
                <option value="Intel Core i5">Intel Core i5</option>
                <option value="Intel Core i7">Intel Core i7</option>
                <option value="Intel Core i9">Intel Core i9</option>
                <option value="Intel Xeon">Intel Xeon</option>
                <option value="AMD Ryzen 3">AMD Ryzen 3</option>
                <option value="AMD Ryzen 5">AMD Ryzen 5</option>
                <option value="AMD Ryzen 7">AMD Ryzen 7</option>
                <option value="AMD Ryzen 9">AMD Ryzen 9</option>
                <option value="AMD Threadripper">AMD Threadripper</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSocket" class="col-md-4 col-lg-3 col-form-label">Socket</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSocket" class="form-select">
                <option value="" selected></option>
                <option value="AMD AM1">AMD AM1</option>
                <option value="AMD AM3+">AMD AM3+</option>
                <option value="AMD AM4">AMD AM4</option>
                <option value="AMD AM5">AMD AM5</option>
                <option value="AMD FM1">AMD FM1</option>
                <option value="AMD FM2">AMD FM2</option>
                <option value="AMD FM2+">AMD FM2+</option>
                <option value="AMD SP3">AMD SP3</option>
                <option value="AMD SP5">AMD SP5</option>
                <option value="AMD SP6">AMD SP6</option>
                <option value="AMD TR4">AMD TR4</option>
                <option value="AMD sTRX4">AMD sTRX4</option>
                <option value="AMD sTR5">AMD sTR5</option>
                <option value="Intel LGA 775">Intel LGA 775</option>
                <option value="Intel LGA 771">Intel LGA 771</option>
                <option value="Intel LGA 1366">Intel LGA 1366</option>
                <option value="Intel LGA 1156">Intel LGA 1156</option>
                <option value="Intel LGA 1567">Intel LGA 1567</option>
                <option value="Intel LGa 1155">Intel LGA 1155</option>
                <option value="Intel LGA 2011">Intel LGA 2011</option>
                <option value="Intel LGA 1356">Intel LGA 1356</option>
                <option value="Intel LGA 1150">Intel LGA 1150</option>
                <option value="Intel LGA 1151">Intel LGA 1151</option>
                <option value="Intel LGA 2066">Intel LGA 2066</option>
                <option value="Intel LGA 1200">Intel LGA 1200</option>
                <option value="Intel LGA 1700">Intel LGA 1700</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCT" class="col-md-4 col-lg-3 col-form-label">Core/Threats</label>
        <div class="col-md-8 col-lg-9">
          <input name="productCT" type="text" class="form-control"  value="" maxlength="20">
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSpeed" class="col-md-4 col-lg-3 col-form-label">Tốc độ</label>
        <div class="col-md-8 col-lg-9">
          <input name="productSpeed" type="number" class="form-control"  value="" min="0" placeholder="GHz" maxlength="4">
        </div>
      </div>
      `;
      break;
    case '8':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asrock">Asrock</option>
                <option value="Asus">Asus</option>
                <option value="Colorful">Colorful</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="MSI">MSI</option>
                <option value="NZXT">NZXT</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productChipset" class="col-md-4 col-lg-3 col-form-label">Chipset</label>
        <div class="col-md-8 col-lg-9">
            <select name="productChipset" class="form-select">
                <option value="" selected></option>
                <option value="Intel">Intel</option>
                <option value="AMD">AMD</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSocket" class="col-md-4 col-lg-3 col-form-label">Socket</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSocket" class="form-select">
                <option value="" selected></option>
                <option value="AMD AM1">AMD AM1</option>
                <option value="AMD AM3+">AMD AM3+</option>
                <option value="AMD AM4">AMD AM4</option>
                <option value="AMD AM5">AMD AM5</option>
                <option value="AMD FM1">AMD FM1</option>
                <option value="AMD FM2">AMD FM2</option>
                <option value="AMD FM2+">AMD FM2+</option>
                <option value="AMD SP3">AMD SP3</option>
                <option value="AMD SP5">AMD SP5</option>
                <option value="AMD SP6">AMD SP6</option>
                <option value="AMD TR4">AMD TR4</option>
                <option value="AMD sTRX4">AMD sTRX4</option>
                <option value="AMD sTR5">AMD sTR5</option>
                <option value="Intel LGA 775">Intel LGA 775</option>
                <option value="Intel LGA 771">Intel LGA 771</option>
                <option value="Intel LGA 1366">Intel LGA 1366</option>
                <option value="Intel LGA 1156">Intel LGA 1156</option>
                <option value="Intel LGA 1567">Intel LGA 1567</option>
                <option value="Intel LGa 1155">Intel LGA 1155</option>
                <option value="Intel LGA 2011">Intel LGA 2011</option>
                <option value="Intel LGA 1356">Intel LGA 1356</option>
                <option value="Intel LGA 1150">Intel LGA 1150</option>
                <option value="Intel LGA 1151">Intel LGA 1151</option>
                <option value="Intel LGA 2066">Intel LGA 2066</option>
                <option value="Intel LGA 1200">Intel LGA 1200</option>
                <option value="Intel LGA 1700">Intel LGA 1700</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSize" class="col-md-4 col-lg-3 col-form-label">Kích thước</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSize" class="form-select">
                <option value="" selected></option>
                <option value="ITX">ITX</option>
                <option value="mATX">mATX</option>
                <option value="ATX">ATX</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productRam" class="col-md-4 col-lg-3 col-form-label">Ram hỗ trợ</label>
        <div class="col-md-8 col-lg-9">
            <select name="productRam" class="form-select">
                <option value="" selected></option>
                <option value="DDR4">DDR4</option>
                <option value="DDR5">DDR5</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productRamSlot" class="col-md-4 col-lg-3 col-form-label">Số khe Ram</label>
        <div class="col-md-8 col-lg-9">
            <select name="productRamSlot" class="form-select">
                <option value="" selected></option>
                <option value="2 Khe Ram">2 Khe Ram</option>
                <option value="4 Khe Ram">4 Khe Ram</option>
                <option value="8 Khe Ram">8 Khe Ram</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '9':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Adata">Adata</option>
                <option value="Apacer">Apacer</option>
                <option value="AXpro">AXpro</option>
                <option value="Corsair">Corsair</option>
                <option value="Gskill">Gskill</option>
                <option value="Kingmax">Kingmax</option>
                <option value="Kingston">Kingston</option>
                <option value="Klevv">Klevv</option>
                <option value="Lexar">Lexar</option>
                <option value="PNY">PNY</option>
                <option value="Silicon">Silicon</option>
                <option value="Teamgroup">Teamgroup</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productUse" class="col-md-4 col-lg-3 col-form-label">Loại RAM cho</label>
        <div class="col-md-8 col-lg-9">
            <select name="productUse" class="form-select">
                <option value="" selected></option>
                <option value="Ram laptop">RAM Laptop</option>
                <option value="Ram desktop">RAM Desktop</option>
                <option value="Ram Server">RAM Server</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCapacity" class="col-md-4 col-lg-3 col-form-label">Dung lượng</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCapacity" class="form-select">
                <option value="" selected></option>
                <option value="4GB">4GB</option>
                <option value="8GB">8GB</option>
                <option value="16GB">16GB</option>
                <option value="32GB">32GB</option>
                <option value="64GB">64GB</option>
                <option value="128GB">128GB</option>
                <option value="256GB">256GB</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productBus" class="col-md-4 col-lg-3 col-form-label">Bus RAM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productBus" class="form-select">
                <option value="" selected></option>
                <option value="1066">1066</option>
                <option value="1333">1333</option>
                <option value="1600">1600</option>
                <option value="2133">2133</option>
                <option value="2400">2400</option>
                <option value="2666">2666</option>
                <option value="3000">3000</option>
                <option value="3200">3200</option>
                <option value="3600">3600</option>
                <option value="4000">4000</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSpec" class="col-md-4 col-lg-3 col-form-label">Chuẩn RAM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSpec" class="form-select">
                <option value="" selected></option>
                <option value="DDR3">DDR3</option>
                <option value="DDR4">DDR4</option>
                <option value="DDR5">DDR5</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '10':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Acer">Acer</option>
                <option value="Corsair">Corsair</option>
                <option value="Crucial">Crucial</option>
                <option value="Kingston">Kingston</option>
                <option value="Kioxia">Kioxia</option>
                <option value="Lexar">Lexar</option>
                <option value="Micron">Micron</option>
                <option value="MSI">MSI</option>
                <option value="PNY">PNY</option>
                <option value="Samsung">Samsung</option>
                <option value="Transcend">Transcend</option>
                <option value="Western Digital">Western Digital</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productPort" class="col-md-4 col-lg-3 col-form-label">Chuẩn ổ cứng</label>
        <div class="col-md-8 col-lg-9">
            <select name="productPort" class="form-select">
                <option value="" selected></option>
                <option value="2.5 inch">2.5 inch</option>
                <option value="3.5 inch">3.5 inch</option>
                <option value="mSata">mSata</option>
                <option value="M2 Sata">M.2 Sata</option>
                <option value="M2 PCIe">M.2 PCIe</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCapacity" class="col-md-4 col-lg-3 col-form-label">Dung lượng</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCapacity" class="form-select">
                <option value="" selected></option>
                <option value="120-128 GB">120-128 GB</option>
                <option value="240-256GB">240-256GB</option>
                <option value="480-512GB">480-512GB</option>
                <option value="960-1TB">960-1TB</option>
                <option value="2-4TB">2-4TB</option>
                <option value="8TB">8TB</option>
                <option value="10-12TB">10-12TB</option>
                <option value="14-20TB">14-20TB</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productM2" class="col-md-4 col-lg-3 col-form-label">Chuẩn M.2</label>
        <div class="col-md-8 col-lg-9">
            <select name="productM2" class="form-select">
                <option value="" selected></option>
                <option value="Gen 3.0">Gen 3.0</option>
                <option value="Gen 4.0">Gen 4.0</option>
                <option value="Gen 5.0">Gen 5.0</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productRPM" class="col-md-4 col-lg-3 col-form-label">RPM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productRPM" class="form-select">
                <option value="" selected></option>
                <option value="5400">5400</option>
                <option value="7200">7200</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '11':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asrock">Asrock</option>
                <option value="Asus">Asus</option>
                <option value="Colorful">Colorful</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="INNO3D">INNO3D</option>
                <option value="intel">Intel</option>
                <option value="Leadtek">Leadtek</option>
                <option value="MSI">MSI</option>
                <option value="Palit">Palit</option>
                <option value="Powercolor">Powercolor</option>
                <option value="Sapphire">Sapphire</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCore" class="col-md-4 col-lg-3 col-form-label">Số nhân</label>
        <div class="col-md-8 col-lg-9">
          <input name="productCore" type="number" class="form-control"  value="" min="0" maxlength="6">
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSpeed" class="col-md-4 col-lg-3 col-form-label">Số nhân</label>
        <div class="col-md-8 col-lg-9">
          <input name="productSpeed" type="number" class="form-control"  value="MHz" min="0" maxlength="6">
        </div>
      </div>
      <div class="row mb-3">
        <label for="productVersion" class="col-md-4 col-lg-3 col-form-label">Phiên bản</label>
        <div class="col-md-8 col-lg-9">
            <select name="productVersion" class="form-select">
                <option value="" selected></option>
                <option value="Intel ARC">Intel ARC</option>
                <option value="NVDIA Geforce GT">NVDIA Geforce GT</option>
                <option value="NVDIA Geforce GTX">NVDIA Geforce GTX</option>
                <option value="NVDIA Geforce RTX">NVDIA Geforce RTX</option>
                <option value="NVIDIA Quadro">NVIDIA Quadro</option>
                <option value="AMD Radeon">AMD Radeon</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productVram" class="col-md-4 col-lg-3 col-form-label">Dung lượng VRAM</label>
        <div class="col-md-8 col-lg-9">
            <select name="productVram" class="form-select">
                <option value="" selected></option>
                <option value="2gb">2GB</option>
                <option value="4gb">4GB</option>
                <option value="6gb">6GB</option>
                <option value="8gb">8GB</option>
                <option value="12gb">12GB</option>
                <option value="16gb">16GB</option>
                <option value="24gb">24GB</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
    <label for="productPower" class="col-md-4 col-lg-3 col-form-label">Yêu cầu nguồn</label>
      <div class="col-md-8 col-lg-9">
          <select name="productPower" class="form-select">
              <option value="" selected></option>
              <option value="Dưới 300w">Dưới 300W</option>
              <option value="400w">400W</option>
              <option value="500w">500W</option>
              <option value="600w">600W</option>
              <option value="800w">800W</option>
              <option value="1000w">1000W</option>
              <option value="Trên 1000w">Trên 1000W</option>
              <option value="other">Khác</option>
          </select>
      </div>
    </div>
      `;
      break;
    case '12':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asus">Asus</option>
                <option value="Acer">Acer</option>
                <option value="Aigo">Aigo</option>
                <option value="Antec">Antec</option>
                <option value="Cooler master">Cooler master</option>
                <option value="Corsair">Corsair</option>
                <option value="Deep cool">Deep cool</option>
                <option value="FSP">FSP</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="Kenoo">Kenoo</option>
                <option value="Lian-li">Lian-li</option>
                <option value="Mik">Mik</option>
                <option value="MSI">MSI</option>
                <option value="NZXT">NZXT</option>
                <option value="Segotep">Segotep</option>
                <option value="Thermalright">Thermalright</option>
                <option value="Thermaltake">Thermaltake</option>
                <option value="VSP">VSP</option>
                <option value="Xigmatek">Xigmatek</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCertification" class="col-md-4 col-lg-3 col-form-label">Chuẩn 80 Plus</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCertification" class="form-select">
                <option value="" selected></option>
                <option value="Non plus">Non Plus</option>
                <option value="White 80 plus">White 80 Plus</option>
                <option value="Bronze 80 plus">Bronze 80 Plus</option>
                <option value="Gold 80 plus">Gold 80 Plus</option>
                <option value="Platinum 80 plus">Platinum 80 Plus</option>
                <option value="Titanium 80 plus">Titanium 80 Plus</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCable" class="col-md-4 col-lg-3 col-form-label">Kiểu dây</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCable" class="form-select">
                <option value="" selected></option>
                <option value="Non-modular">Non-modular (Dây liền)</option>
                <option value="Semi-modular">Semi-modular</option>
                <option value="Full-modular">Full-modular (Dây rời)</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productSize" class="col-md-4 col-lg-3 col-form-label">Kích thước</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSize" class="form-select">
                <option value="" selected></option>
                <option value="SFX/ITX">SFX/ITX</option>
                <option value="ATX">ATX</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productCapacity" class="col-md-4 col-lg-3 col-form-label">Công suất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productCapacity" class="form-select">
                <option value="" selected></option>
                <option value="450W">450W</option>
                <option value="550W">550W</option>
                <option value="650W">650W</option>
                <option value="750W">750W</option>
                <option value="850W">850W</option>
                <option value="1000W">1000W</option>
                <option value="1200W">1200W</option>
                <option value="1300W">1300W</option>
                <option value="1500W">1500W</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '13':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
                <option value="" selected></option>
                <option value="Asus">Asus</option>
                <option value="Aigo">Aigo</option>
                <option value="Antec">Antec</option>
                <option value="Cooler master">Cooler master</option>
                <option value="Corsair">Corsair</option>
                <option value="Cougar">Cougar</option>
                <option value="Deep cool">Deep cool</option>
                <option value="Fractal design">Fractal design</option>
                <option value="Gigabyte">Gigabyte</option>
                <option value="Golden Field">Golden Field</option>
                <option value="Jonsbo">Jonsbo</option>
                <option value="Lian-li">Lian-li</option>
                <option value="Mik">Mik</option>
                <option value="Montech">Montech</option>
                <option value="MSI">MSI</option>
                <option value="NZXT">NZXT</option>
                <option value="Phanteks">Phanteks</option>
                <option value="Sama">Sama</option>
                <option value="Segotep">Segotep</option>
                <option value="Thermaltake">Thermaltake</option>
                <option value="VSP">VSP</option>
                <option value="Xigmatek">Xigmatek</option>
                <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
          <label for="productColor" class="col-md-4 col-lg-3 col-form-label">Màu sắc</label>
          <div class="col-md-8 col-lg-9">
              <select name="productColor" class="form-select">
                <option value="" selected></option>
                <option value="Trắng">Trắng</option>
                <option value="Đen">Đen</option>
                <option value="other">Khác</option>
              </select>
          </div>
      </div>
      <div class="row mb-3">
        <label for="productSize" class="col-md-4 col-lg-3 col-form-label">Kích thước</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSize" class="form-select">
              <option value="" selected></option>
              <option value="ATX">ATX</option>
              <option value="m-ATX">m-ATX</option>
              <option value="ITX">ITX</option>
              <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '14':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
              <option value="" selected></option>
              <option value="Antech">Antech</option>
              <option value="Arctic">Arctic</option>
              <option value="Cooler master">Cooler master</option>
              <option value="Deep cool">Deep cool</option>
              <option value="EKWB">EKWB</option>
              <option value="ID cooling">ID cooling</option>
              <option value="Intel">Intel</option>
              <option value="Jonsbo">Jonsbo</option>
              <option value="Noctua">Noctua</option>
              <option value="Thermalright">Thermalright</option>
              <option value="VSP">VSP</option>
              <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
        <label for="productType" class="col-md-4 col-lg-3 col-form-label">Loại tản nhiệt</label>
        <div class="col-md-8 col-lg-9">
            <select name="productType" class="form-select">
              <option value="" selected></option>
              <option value="Tản nhiệt nước">Tản nhiệt nước</option>
              <option value="Tản nhiệt tháp">Tản nhiệt tháp</option>
              <option value="Quạt tản nhiệt">Quạt tản nhiệt</option>
              <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
          <label for="productColor" class="col-md-4 col-lg-3 col-form-label">Màu sắc</label>
          <div class="col-md-8 col-lg-9">
              <select name="productColor" class="form-select">
                <option value="Trắng">Trắng</option>
                <option value="Đen">Đen</option>
                <option value="other">Khác</option>
              </select>
          </div>
      </div>
      <div class="row mb-3">
        <label for="productSize" class="col-md-4 col-lg-3 col-form-label">Kích thước</label>
        <div class="col-md-8 col-lg-9">
            <select name="productSize" class="form-select">
              <option value="" selected></option>
              <option value="120mm">120mm</option>
              <option value="140mm">140mm</option>
              <option value="other">Khác</option>
            </select>
        </div>
      </div>
      `;
      break;
    case '15':
      divContent = `
      <div class="row mb-3">
        <label for="productManufacturer" class="col-md-4 col-lg-3 col-form-label">Hãng sản xuất</label>
        <div class="col-md-8 col-lg-9">
            <select name="productManufacturer" class="form-select">
              <option value="" selected></option>
              <option value="Corsair">Corsair</option>
              <option value="Kingston">Kingston</option>
              <option value="Kioxia">Kioxia</option>
              <option value="Lexar">Lexar</option>
              <option value="Moment Semiconductor">Moment Semiconductor</option>
              <option value="Orico">Orico</option>
              <option value="Samsung">Samsung</option>
              <option value="Sandisk">Sandisk</option>
              <option value="Toshiba">Toshiba</option>
              <option value="TP-Link">TP-Link</option>
              <option value="Transcend">Transcend</option>
              <option value="other">Khác</option>
            </select>
        </div>
      </div>
      <div class="row mb-3">
          <label for="productCapacity" class="col-md-4 col-lg-3 col-form-label">Dung lượng</label>
          <div class="col-md-8 col-lg-9">
              <select name="productCapacity" class="form-select">
                <option value="" selected></option>
                <option value="4GB">4GB</option>
                <option value="8GB">8GB</option>
                <option value="16GB">16GB</option>
                <option value="32GB">32GB</option>
                <option value="64GB">64GB</option>
                <option value="128GB">128GB</option>
                <option value="256GB">256GB</option>
                <option value="512GB">512GB</option>
                <option value="other">Khác</option>
              </select>
          </div>
      </div>
      `;
      break;
    case '16':
      divContent = '';
      break;
    default:
      divContent = ''; // default action if none of the above cases match
  }
  $('#categorySpecs').html(divContent);
  $('#productSelect').change(function () {
    updateContent($(this).val());
  });
});