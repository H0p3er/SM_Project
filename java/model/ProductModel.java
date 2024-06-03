package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import connection.ConnectionPool;
import connection.ConnectionPoolImpl;
import constant.PRODUCT_EDIT_TYPE;
import dto.pc.PC_DTO;
import dto.pc.PC_manageProductDTO;
import dto.pc.PC_manageBillDTO;
import dto.pc.PC_manageShopDTO;
import dto.pc.PC_viewBillDTO;
import dto.pc.PC_viewProductDTO;
import dto.pc.PC_viewShopDTO;
import dto.product.*;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_DTO;
import dto.shop.Shop_manageShopDTO;
import dto.shop.Shop_viewProductDTO;
import dto.shop.Shop_viewShopDTO;
import repository.*;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;
import utility.Utilities;

public class ProductModel {
	private Product product;
//	private PCModel pc;
	
	public ProductModel(ConnectionPool cp) {
		this.product = new ProductImpl(cp);
//		this.pc = new PCModel(cp);
	}
	protected void finalize() throws Throwable {
		this.product = null;
//		this.pc = null;
	}
	public ConnectionPool getCP() {
		return this.product.getCP();
	}
	public void releaseCP() {
		this.product.releaseCP();
//		this.pc.releaseCP();
	}
	public boolean addProduct(Product_DTO<Product_AttributeDTO> item) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.addProduct(productObject);
	}
	
	public boolean editProduct(Product_DTO<Product_AttributeDTO> item, PRODUCT_EDIT_TYPE type) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.editProduct(productObject, type);
	}
	public boolean delProduct(Product_DTO<Product_AttributeDTO> item) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.delProduct(productObject);
	}

	public Product_viewProductDTO getProduct_viewProductDTOById(int id) {
		Product_viewProductDTO item = new Product_viewProductDTO();
		ResultSet rs = this.product.getProductById(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					setProductAttribute(item,rs);;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<Product_viewProductDTO>, Integer> getProduct_viewProductDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {	
		short page = infors.getValue0();
		byte productPerPage = infors.getValue1();	
		Map<String,String> multiField = infors.getValue2();
		Map<String,String> multiCondition = infors.getValue3();
		Map<String,String> multiSort = infors.getValue4();		
		ArrayList<Product_viewProductDTO> items = new ArrayList<>();
		int at = (page - 1) * productPerPage;
		ArrayList<ResultSet> res = this.product.getProducts(at, productPerPage, multiField, multiCondition, multiSort);
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_viewProductDTO item = new Product_viewProductDTO();
					setProductAttribute(item, rs);
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		int product_count = getProductSize(rs);
		return new Pair<>(items, product_count);
	}
	
	public Pair<ArrayList<Product_viewProductDTO>, ArrayList<Product_viewProductDTO>> getProduct_viewProductDTO() {		
		ArrayList<Product_viewProductDTO> items1 = new ArrayList<>();
		ArrayList<ResultSet> res = this.product.getProducts();
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_viewProductDTO item = new Product_viewProductDTO();
					setProductAttribute(item, rs);
					items1.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		ArrayList<Product_viewProductDTO> items2 = new ArrayList<>();
		rs = res.get(1);
		if (rs != null) {
			try {
				while (rs.next()) {	
					Product_viewProductDTO item = new Product_viewProductDTO();
					setProductAttribute(item, rs);	
					items2.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(items1, items2);
	}	

	public Triplet<List<Product_manageShopDTO>, Integer, List<Pair<Product_manageShopDTO,Double>>> getProductStatistic(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, Shop_manageShopDTO shop_manageShopDTO) {
		ShopObject shopObject = new ShopObject();
		shop_manageShopDTO.applyToEntity(shopObject);
		
		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();	
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;	
		List<Product_manageShopDTO> product_manageShopDTOs = new ArrayList<Product_manageShopDTO>();	
		ArrayList<ResultSet> resultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);	
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_manageShopDTO product_ShopManagerDTO = new Product_manageShopDTO();
					product_ShopManagerDTO.setId(rs.getInt("product_id"));
					product_ShopManagerDTO.setName(rs.getString("product_name"));
					product_ShopManagerDTO.setQuantity(rs.getInt("product_quantity"));
					product_ShopManagerDTO.setImages(rs.getString("product_images"));
					product_ShopManagerDTO.setPrice(rs.getDouble("product_price"));
					product_ShopManagerDTO.setNotes(rs.getString("product_notes"));
					product_ShopManagerDTO.setPc(new PC_manageShopDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
					product_manageShopDTOs.add(product_ShopManagerDTO);
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = resultSets.get(1);
		int count_product = getProductSize(rs);
		rs = resultSets.get(2);
		List<Pair<Product_manageShopDTO,Double>> most_sold_product_current_month = getMostSoldProductCurrentMonth(rs);
		return new Triplet<>(product_manageShopDTOs,count_product,most_sold_product_current_month);
	}	

	
	public Pair<List<Product_manageShopDTO>,Integer> getProduct_manageShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, Shop_manageShopDTO shop_manageShopDTO) {
		ShopObject shopObject = new ShopObject();
		shop_manageShopDTO.applyToEntity(shopObject);
		
		short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();	
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;	
		ArrayList<Product_manageShopDTO> product_manageShopDTOs = new ArrayList<Product_manageShopDTO>();	
		ArrayList<ResultSet> resultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);	
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_manageShopDTO product_manageShopDTO = new Product_manageShopDTO();
					product_manageShopDTO.setId(rs.getInt("product_id"));
					product_manageShopDTO.setName(rs.getString("product_name"));
					product_manageShopDTO.setQuantity(rs.getInt("product_quantity"));
					product_manageShopDTO.setPrice(rs.getDouble("product_price"));
					setProductAttribute(product_manageShopDTO, rs);
					product_manageShopDTOs.add(product_manageShopDTO);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = resultSets.get(1);
		int count_product = getProductSize(rs);
		return new Pair<>(product_manageShopDTOs,count_product);
	}	
	
	
	public Product_manageShopDTO getProduct_manageShopDTO(int id) {
		Product_manageShopDTO item = new Product_manageShopDTO();
		ResultSet rs = this.product.getProductById(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					setProductAttribute(item,rs);;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public Pair<ArrayList<Product_viewShopDTO>,Integer> getProduct_viewShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, Shop_viewShopDTO shop_viewShopDTO) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		
		short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();	
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;	
		ArrayList<Product_viewShopDTO> product_viewShopDTOs = new ArrayList<Product_viewShopDTO>();	
		ArrayList<ResultSet> resultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);	
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_viewShopDTO product_viewShopDTO = new Product_viewShopDTO();
					product_viewShopDTO.setId(rs.getInt("product_id"));
					product_viewShopDTO.setName(rs.getString("product_name"));
					product_viewShopDTO.setQuantity(rs.getInt("product_quantity"));
					product_viewShopDTO.setPrice(rs.getDouble("product_price"));
					setProductAttribute(product_viewShopDTO, rs);
					product_viewShopDTOs.add(product_viewShopDTO);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = resultSets.get(1);
		int count_product = getProductSize(rs);
		return new Pair<>(product_viewShopDTOs,count_product);
	}	
	

	private List<Pair<Product_manageShopDTO,Double>> getMostSoldProductCurrentMonth(ResultSet rs) {	
		List<Pair<Product_manageShopDTO,Double>> most_sold_product_current_month =  new ArrayList<Pair<Product_manageShopDTO,Double>>();
		if (rs!=null) {
			try {			
				while (rs.next()) {	
					Product_manageShopDTO product_ShopManagerDTO = new Product_manageShopDTO();
					product_ShopManagerDTO.setId(rs.getInt("product_id"));
					product_ShopManagerDTO.setName(rs.getString("product_name"));
					product_ShopManagerDTO.setQuantity(rs.getInt("product_quantity"));
					product_ShopManagerDTO.setPrice(rs.getDouble("product_price"));
					most_sold_product_current_month.add(new Pair<Product_manageShopDTO,Double>(product_ShopManagerDTO, rs.getDouble("most_sold_product_by_month")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return most_sold_product_current_month;
	}

	private void setProductAttribute(Product_DTO<Product_AttributeDTO> product_DTO, ResultSet rs) {	
		try {			
			if (product_DTO instanceof Product_viewProductDTO) {		
				((Product_viewProductDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_viewProductDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_viewProductDTO) product_DTO).setPc(new PC_viewProductDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_viewProductDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_viewProductDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_viewProductDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_viewProductDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_viewProductDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_viewProductDTO) product_DTO).setShop(new Shop_viewProductDTO(rs.getInt("product_shop_id")));
				((Product_viewProductDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));	
			}
		
			if (product_DTO instanceof Product_manageShopDTO) {
				((Product_manageShopDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_manageShopDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_manageShopDTO) product_DTO).setPc(new PC_manageShopDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_manageShopDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_manageShopDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_manageShopDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_manageShopDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_manageShopDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_manageShopDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));
			}
			
			if (product_DTO instanceof Product_manageProductDTO) {
				((Product_manageProductDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_manageProductDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_manageProductDTO) product_DTO).setPc(new PC_manageProductDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_manageProductDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_manageProductDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_manageProductDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_manageProductDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_manageProductDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_manageProductDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));
			}
			
			if (product_DTO instanceof Product_viewShopDTO) {
				((Product_viewShopDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_viewShopDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_viewShopDTO) product_DTO).setPc(new PC_viewShopDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_viewShopDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_viewShopDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_viewShopDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_viewShopDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_viewShopDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_viewShopDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));
			}
			
			if (product_DTO instanceof Product_manageBillDTO) {
				((Product_manageBillDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_manageBillDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_manageBillDTO) product_DTO).setPc(new PC_manageBillDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_manageBillDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_manageBillDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_manageBillDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_manageBillDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_manageBillDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_manageBillDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));
			}
			
			if (product_DTO instanceof Product_viewBillDTO) {
				((Product_viewBillDTO) product_DTO).setName(Utilities.decode(rs.getString("product_name")));
				((Product_viewBillDTO) product_DTO).setId(rs.getInt("product_id"));
				((Product_viewBillDTO) product_DTO).setPc(new PC_viewBillDTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
				((Product_viewBillDTO) product_DTO).setStatus(rs.getByte("product_status"));
				((Product_viewBillDTO) product_DTO).setPrice(rs.getDouble("product_price"));
				((Product_viewBillDTO) product_DTO).setImages(rs.getString("product_images"));
				((Product_viewBillDTO) product_DTO).setNotes(rs.getString("product_notes"));
				((Product_viewBillDTO) product_DTO).setLast_modified(rs.getString("product_last_modified"));
				((Product_viewBillDTO) product_DTO).setQuantity(rs.getInt("product_quantity"));
			}	
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private int getProductSize(ResultSet rs) {
		int count_product = 0;
		if (rs!=null) {
			try {
				if (rs.next()) {
					count_product = rs.getInt("product_count");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return count_product;
	}
	
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		ProductModel u= new ProductModel(cp);
		
		//Them mot nguoi su dung
		ShopObject new_Shop = new ShopObject();
		new_Shop.setShop_name("Kho hàng Nguyên");
		new_Shop.setShop_user_id(19);
		new_Shop.setShop_address("Lâm Đồng");
		new_Shop.setShop_created_date("29/12/2003");
		UserObject currentUser = new UserObject();
		currentUser.setUser_name("Tran The Hưởng");
		currentUser.setUser_id((byte)2);

		//Lay tap ban ghi nguoi su dung

		ArrayList<Product_viewProductDTO> rs1 = u.getProduct_viewProductDTO(new Quintet<Short, Byte, Map<String, String> ,Map<String, String>, Map<String, String>>((short) 0,(byte) 0, new HashMap<String, String>(), new HashMap<String, String>(), new HashMap<String, String>())).getValue0();
		String row = null;

		if (rs1!=null) {
			rs1.forEach(product->{
//				if (product instanceof Product_CaseDTO) {
//					System.out.println("object:"+((Product_CaseDTO) product).getName());
//				}
//				
//				if (product instanceof Product_LaptopDTO) {
//					System.out.println("object:"+((Product_LaptopDTO) product).getLaptop_ram());
//				}
//				
//				if (product instanceof Product_CoolingDTO) {
//					System.out.println("object:"+((Product_CoolingDTO) product).getName());
//				}	
				System.out.println(((Product_viewProductDTO) product).getAttribute());
			});	
		}
	}
}
