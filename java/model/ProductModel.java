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
import dto.pc.PC_manageShopDTO;
import dto.product.*;
import dto.productAttribute.Product_AttributeDTO;
import dto.shop.Shop_DTO;
import repository.*;
import entity.ProductObject;
import entity.ShopObject;
import entity.UserObject;
import utility.Utilities;

public class ProductModel {
	private Product product;
	private PCModel pc;
	
	public ProductModel(ConnectionPool cp) {
		this.product = new ProductImpl(cp);
		this.pc = new PCModel(cp);
	}
	protected void finalize() throws Throwable {
		this.product = null;
		this.pc = null;
	}
	public ConnectionPool getCP() {
		return this.product.getCP();
	}
	public void releaseCP() {
		this.product.releaseCP();
		this.pc.releaseCP();
	}
	public boolean addProduct(ProductDTO<Product_AttributeDTO> item) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.addProduct(productObject);
	}
	public boolean editProduct(ProductDTO<Product_AttributeDTO> item, PRODUCT_EDIT_TYPE type) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.editProduct(productObject, type);
	}
	public boolean delProduct(ProductDTO<Product_AttributeDTO> item) {
		ProductObject productObject = new ProductObject();
		item.ApplyToEntity(productObject);
		return this.product.delProduct(productObject);
	}

	public Product_DTO getProduct_DTOById(int id) {
		Product_DTO item = new Product_DTO();
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
	
	public Pair<ArrayList<Product_DTO>, Integer> getProduct_DTOs(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> infors) {	
		short page = infors.getValue0();
		byte productPerPage = infors.getValue1();	
		Map<String,String> multiField = infors.getValue2();
		Map<String,String> multiCondition = infors.getValue3();
		Map<String,String> multiSort = infors.getValue4();		
		ArrayList<Product_DTO> items = new ArrayList<>();
		int at = (page - 1) * productPerPage;
		ArrayList<ResultSet> res = this.product.getProducts(at, productPerPage, multiField, multiCondition, multiSort);
		ResultSet rs = res.get(0);
		// Chuyen doi ban ghi thanh doi tuong
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_DTO item = new Product_DTO();
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
	
	public Pair<ArrayList<Product_DTO>, ArrayList<Product_DTO>> getProduct_DTOs() {		
		ArrayList<Product_DTO> items1 = new ArrayList<>();
		ArrayList<ResultSet> res = this.product.getProducts();
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {				
					Product_DTO item = new Product_DTO();
					setProductAttribute(item, rs);
					items1.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		ArrayList<Product_DTO> items2 = new ArrayList<>();
		rs = res.get(1);
		if (rs != null) {
			try {
				while (rs.next()) {	
					Product_DTO item = new Product_DTO();
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

	public Triplet<List<Product_manageShopDTO>,Integer, List<Pair<Product_manageShopDTO,Double>>> getProduct_manageShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, ShopObject shopObject) {
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
	
	public Pair<ArrayList<Product_viewShopDTO>,Integer> getProduct_viewShopDTO(Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, ShopObject shopObject) {
		Short pagePos = productInfors.getValue0();
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
	
	private void setProductAttribute(Product_DTO item, ResultSet rs) {
		try {	
//			Product_DTO item = new Product_DTO<Product_AttributeDTO>();
			item.setId(rs.getInt("product_id"));
			item.setPc(new PC_DTO(rs.getInt("product_pc_id"), rs.getString("pc_name")));
			switch (rs.getInt("product_pc_id")) {
			case 1:
				this.pc.getMonitorDTO(item);	
				break;						
			case 2:
				this.pc.getKeyboardDTO(item);	
				break;
			case 3:
				this.pc.getMiceDTO(item);	
				break;					
			case 4:
				this.pc.getHeadphoneSpeakerDTO(item);	
				break;						
			case 5:
				this.pc.getLaptopDTO(item);
				break;						
			case 6:
				this.pc.getDesktopDTO(item);		
				break;						
			case 7:	
				this.pc.getCPUDTO(item);
				break;						
			case 8:
				this.pc.getMotherboardDTO(item);
				break;						
			case 9:	
				this.pc.getRamDTO(item);					
				break;		
			case 10:
				this.pc.getStorageDTO(item);	
				break;				
			case 11:
				this.pc.getGraphicsCardDTO(item);
				break;						
			case 12:
				this.pc.getPowerSuppyDTO(item);		
				break;						
			case 13:
				this.pc.getCaseDTO(item);	
				break;				
			case 14:
				this.pc.getCoolingDTO(item);				
				break;	
			}
			item.setName(Utilities.decode(rs.getString("product_name")));
			item.setStatus(rs.getByte("product_status"));
			item.setPrice(rs.getDouble("product_price"));
			item.setImages(rs.getString("product_images"));
			item.setNotes(rs.getString("product_notes"));
			item.setLast_modified(rs.getString("product_last_modified"));
			item.setShop(new Shop_DTO(rs.getInt("product_shop_id")));
			item.setQuantity(rs.getInt("product_quantity"));		
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

		ArrayList<Product_DTO> rs1 = u.getProduct_DTOs(new Quintet<Short, Byte, Map<String, String> ,Map<String, String>, Map<String, String>>((short) 0,(byte) 0, new HashMap<String, String>(), new HashMap<String, String>(), new HashMap<String, String>())).getValue0();
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
				System.out.println(((Product_DTO) product).getAttribute());
			});	
		}
	}
}
