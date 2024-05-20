package service.productService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import connection.ConnectionPool;
import constant.PRODUCT_EDIT_TYPE;
import controller.ProductControl;
import dto.product.Product_DTO;
import service.StorageService;

/**
 * Servlet implementation class ProductEdit
 */
@WebServlet("/product/add")
@MultipartConfig(
		fileSizeThreshold   = 1024 * 2,
        maxFileSize         = 1024 * 1024 * 200,
        maxRequestSize      = 1024 * 1024 * 215
)
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	private StorageService storeService;
    private final String UPLOAD_DIR = "/home/assets/images/product"; 
    private final String seperator = utility.Utilities_const.SEPERATOR.label;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAdd() {
        super();
        storeService = new StorageService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//Thiết lập tập kí tự
		
		String name = request.getParameter("txtProductName");
		if(name != null && !name.isBlank()) {
			short pc = utility.Utilities.getShortParam(request, "pc");
			String note = request.getParameter("txtProductNote");
			String oldPath = request.getParameter("from-db");
			
			// chức năng lưu file
			// gets absolute path of the web application
	        String applicationPath = request.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file
	        String uploadFolderPath = applicationPath + UPLOAD_DIR;
	         
	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFolderPath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
	        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	        String partname = "";
	        String updatePath = "";
	        StringBuilder imagePath = new StringBuilder();
			for(Part part : request.getParts()) {
				System.out.println(part.getName());
				String partName = part.getName();
				if(partName.startsWith("uploadImg")) {
					String fileName = part.getSubmittedFileName();
					if(fileName != null && !fileName.isBlank()) {
						Date date = new Date();
						long time = date.getTime();
						String fileType = fileName.substring(fileName.lastIndexOf("."));
						String newName = fileName.substring(0, fileName.lastIndexOf(".")) + time + fileType;
						String uploadFilePath = Path.of(uploadFolderPath + File.separator + newName).toString();
						System.out.println(uploadFilePath);
						boolean success = storeService.uploadFileToSystem(part, uploadFilePath);
						if(success) {
							imagePath.append("/home/"+ UPLOAD_DIR + "/" + newName + seperator);
						}
					}
				} else if(partName.startsWith("oldImg")) {
					// xóa ảnh đã xóa trên giao diện
					updatePath += request.getParameter(partName) + seperator;
				}
			}
			
			storeService.delFiles(oldPath, updatePath, applicationPath);
			
			System.out.println(updatePath + seperator+ imagePath.toString());
			Product_DTO editProduct = new Product_DTO();
			editProduct.setName(name);
			editProduct.setImages(updatePath + seperator+ imagePath.toString());
			editProduct.setNotes(utility.Utilities.encode(note));
			
			// Lưu thay đổi vào csdl
			ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
			ProductControl productControl = new ProductControl(cp);
			if(cp == null) {
				cp = productControl.getCP();
				getServletContext().setAttribute("CPool", cp);
			}
			boolean editSuccess = productControl.editProduct(editProduct, PRODUCT_EDIT_TYPE.GENERAL);
			if(editSuccess) {
				response.sendRedirect("/home/seller/product/add?status=succ&type=edit");
				
			} else {
				response.sendRedirect("/home/seller/product/add?status=err&type=edit");
			}
		}
	}

}
