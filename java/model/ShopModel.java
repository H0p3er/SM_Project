package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import repository.*;
import connection.*;
import entity.*;
import constant.*;
import dto.*;
import dto.pc.PC_ShopManagerDTO;
import dto.product.Product_ShopManagerDTO;
import dto.product.Product_ShopStatisticDTO;
import dto.shop.Shop_ShopManagerDTO;
import dto.shop.Shop_viewShopDTO;
import dto.user.User_viewShopDTO;

public class ShopModel {
	
	private Shop shop;
	private Product product;
	
	public ShopModel(ConnectionPool cp) {
		this.shop = new ShopImpl(cp);
		this.product = new ProductImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop=null;
		this.product=null;
	}
	
	public ConnectionPool getCP() {
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
		this.product.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu Shop Impl*****************************************
	public boolean addShop(Shop_viewShopDTO shop_viewShopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.addShop(shopObject, currentUser);
	}
	
	public boolean editShop(Shop_viewShopDTO shop_viewShopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.editShop(shopObject, et, currentUser);
	}
	
	public boolean delShop(Shop_viewShopDTO shop_viewShopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shop_viewShopDTO.applyToEntity(shopObject);
		return this.shop.delShop(shopObject, currentUser);
	}
	
	
	//****************************************************************
	
	public Shop_viewShopDTO getShopDTOById(Triplet<String, Short, Byte> infors, int id) {
		//Khoi tao cac gia tri cua DTO
		Shop_viewShopDTO shop_viewShopDTO = null ;
		User_viewShopDTO shopUserDTO = null;
		
		String filter = infors.getValue0();
		Short pagePos = infors.getValue1();
		byte pageLength = infors.getValue2();
		int recordPos = (pagePos-1)*pageLength;
		ArrayList<ResultSet> resultSets = this.shop.getShopById(filter,recordPos,pageLength,id);
		
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shop_viewShopDTO = new Shop_viewShopDTO();
					shop_viewShopDTO.setId(rs.getInt("shop_id"));
					shop_viewShopDTO.setName(rs.getString("shop_name"));
					shop_viewShopDTO.setAddress(rs.getString("shop_address"));
					shop_viewShopDTO.setImages(rs.getString("shop_images"));
					shop_viewShopDTO.setNotes(rs.getString("shop_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shop_viewShopDTO;	
	}
	

	public Product_ShopStatisticDTO getShopStatisticDTO(ArrayList<ResultSet> productResultSets, Shop_ShopManagerDTO shop_ShopManagerDTO) {	
		Product_ShopStatisticDTO product_ShopStatisticDTO = new Product_ShopStatisticDTO();
		
		ResultSet rs = productResultSets.get(1);
		
		int TotalProduct = 0;
		if (rs!=null) {
			try {
				if (rs.next()) {
					TotalProduct = rs.getInt("TotalProduct");
					product_ShopStatisticDTO.setTotalProduct(TotalProduct);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = productResultSets.get(0);
		PC_ShopManagerDTO pc_ShopManagerDTO = null;
		int QuantityAllProduct = 0;
		double PriceAllProduct = 0;
		if (rs!=null) {
			try {
				while (rs.next()) {
					Product_ShopManagerDTO product_ShopManagerDTO = new Product_ShopManagerDTO();
					product_ShopManagerDTO.setId(rs.getInt("product_id"));
					product_ShopManagerDTO.setName(rs.getString("product_name"));
					product_ShopManagerDTO.setQuantity(rs.getInt("product_quantity"));
					product_ShopManagerDTO.setPrice(rs.getDouble("product_price"));
					
					QuantityAllProduct += rs.getInt("product_quantity");
					PriceAllProduct += rs.getDouble("product_price");
					
					pc_ShopManagerDTO = new PC_ShopManagerDTO();
					pc_ShopManagerDTO.setName(rs.getString("pc_name"));
					product_ShopManagerDTO.setPc(pc_ShopManagerDTO);
					shop_ShopManagerDTO.getStorage().add(product_ShopManagerDTO);	
				}
				
				product_ShopStatisticDTO.setTotalPriceAllProduct(PriceAllProduct);
				product_ShopStatisticDTO.setTotalQuantityAllProduct(QuantityAllProduct);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Map<Integer,Pair<Product_ShopManagerDTO, Double>> hashMap1 = new HashMap<Integer, Pair<Product_ShopManagerDTO,Double>>();
		product_ShopStatisticDTO.setTotalSellingPricePerProduct(hashMap1);
		Map<Integer,Pair<Product_ShopManagerDTO, Integer>> hashMap2 = new HashMap<Integer, Pair<Product_ShopManagerDTO,Integer>>();
		product_ShopStatisticDTO.setTotalSellingQuantityPerProduct(hashMap2);
		
		/*
		 * System.out.println(shop_ShopManagerDTO.getStatistic().getTotalSellingPerProduct());
		 * System.out.println(shop_ShopManagerDTO.getStatistic().
		 * getTotalSellingQuantityPerProduct());
		 */


		rs = productResultSets.get(2);
		if (rs!=null) {
			try {			
				QuantityAllProduct = 0;
				PriceAllProduct = 0;
				while (rs.next()) {
					int product_id =rs.getInt("product_id");
					int TotalSellingQuantityPerProduct = rs.getInt("TotalSellingQuantityPerProduct");
					double TotalSellingPricePerProduct = rs.getInt("TotalSellingPricePerProduct");
					
					QuantityAllProduct+=TotalSellingQuantityPerProduct;
					PriceAllProduct+=TotalSellingPricePerProduct;
					
					Product_ShopManagerDTO product_ShopManagerDTO = new Product_ShopManagerDTO();
					product_ShopManagerDTO.setId(rs.getInt("product_id"));
					product_ShopManagerDTO.setName(rs.getString("product_name"));
					
					product_ShopStatisticDTO.getTotalSellingQuantityPerProduct().put(product_id, new Pair<Product_ShopManagerDTO, Integer>(product_ShopManagerDTO, TotalSellingQuantityPerProduct));
					
					product_ShopStatisticDTO.getTotalSellingPricePerProduct().put(product_id,
							new Pair<Product_ShopManagerDTO, Double>(product_ShopManagerDTO, TotalSellingPricePerProduct));
					
					product_ShopStatisticDTO.setTotalSellingPriceAllProduct(PriceAllProduct);
					product_ShopStatisticDTO.setTotalSellingQuantityAllProduct(QuantityAllProduct);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return product_ShopStatisticDTO;
	}

	
	public Pair<Shop_ShopManagerDTO, Product_ShopStatisticDTO> getShopDTOByUser(
			Quintet<Short, Byte, Map<String,String>, Map<String,String>, Map<String,String>> productInfors, 
			UserObject currentUser) {
		//Lay ban ghi 

		Short pagePos = productInfors.getValue0();
		byte pageLength = productInfors.getValue1();
		
		Map<String,String> multiField = productInfors.getValue2();
		Map<String,String> multiCondition = productInfors.getValue3();
		Map<String,String> multiSort = productInfors.getValue4();
		int recordPos = (pagePos-1)*pageLength;
		
		ArrayList<ResultSet> shopResultSets = this.shop.getShopByUser(currentUser);		
		
		ResultSet rs = shopResultSets.get(0);
		//Chuyen doi ban ghi thanh doi tuong
		//Gan gia tri khoi tao cho doi tuong ShopObject
		
		ShopObject shopObject = new ShopObject();
		Shop_ShopManagerDTO shop_ShopManagerDTO = new Shop_ShopManagerDTO() ;

		if (rs!=null) {
			try {
				if (rs.next()) {
					shopObject.setShop_id(rs.getInt("shop_id"));
					shopObject.setShop_name(rs.getString("shop_name"));
					shopObject.setShop_address(rs.getString("shop_address"));
					shopObject.setShop_images(rs.getString("shop_images"));
					shopObject.setShop_notes(rs.getString("shop_notes"));			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		shop_ShopManagerDTO.applyToEntity(shopObject);
		shop_ShopManagerDTO.setStorage(new ArrayList<Product_ShopManagerDTO>());
		
		
		ArrayList<ResultSet> productResultSets = this.product.getProductsByShop(recordPos,pageLength,multiField,multiCondition,multiSort,shopObject);
		Product_ShopStatisticDTO product_ShopStatisticDTO = getShopStatisticDTO(productResultSets,shop_ShopManagerDTO);
		
		return new Pair<Shop_ShopManagerDTO, Product_ShopStatisticDTO>(shop_ShopManagerDTO,product_ShopStatisticDTO);	
	}
	
	public static void main(String[] args) {
		//Khoi tao bo quan li ket noi
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tao doi tuong thuc thi chuc nang muc Shop
		ShopModel u=new ShopModel(cp);
		
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
		Product_ShopStatisticDTO rs = u.getShopDTOByUser(new Quintet<Short, Byte, String ,String, String>((short) 0,(byte) 0, "", "", ""),currentUser).getValue1();
		
		String row = null;
		//Duyen va hien thi danh sach nguoi su dung
		if (rs!=null) {
			System.out.println("object:"+rs);
			System.out.println("price:"+rs.getTotalPriceAllProduct());
			System.out.println("quantity:"+rs.getTotalQuantityAllProduct());
	
		}

	}
		
}
