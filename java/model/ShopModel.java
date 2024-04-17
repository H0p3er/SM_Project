package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import repository.*;
import connection.*;
import entity.*;
import constant.*;
import dto.*;
import dto.seller.SellerShopDTO;
import dto.seller.SellerShopProductDTO;
import dto.seller.SellerShopStatisticDTO;
import dto.user.ShopPCDTO;
import dto.user.ShopProductDTO;
import dto.user.ShopSellerDTO;

public class ShopModel {
	
	private Shop shop;
	
	public ShopModel(ConnectionPool cp) {
		this.shop= new ShopImpl(cp);
	}
	
	protected void finalize() throws Throwable{
		this.shop=null;
	}
	
	public ConnectionPool getCP() {
		return this.shop.getCP();
	}
	
	public void releaseCP() {
		this.shop.releaseCP();
	}

	//***********************Chuyen huong dieu khien tu Shop Impl*****************************************
	public boolean addShop(ShopDTO shopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.addShop(shopObject, currentUser);
	}
	
	public boolean editShop(ShopDTO shopDTO, SHOP_EDIT_TYPE et, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.editShop(shopObject, et, currentUser);
	}
	
	public boolean delShop(ShopDTO shopDTO, UserObject currentUser) {
		ShopObject shopObject = new ShopObject();
		shopDTO.applyToEntity(shopObject);
		return this.shop.delShop(shopObject, currentUser);
	}
	
	
	//****************************************************************
	
	public ShopDTO getShopDTOById(Triplet<String, Short, Byte> infors, int id) {
		//Khoi tao cac gia tri cua DTO
		ShopDTO shopDTO = null ;
		ShopSellerDTO shopUserDTO = null;
		
		String filter = infors.getValue0();
		Short pagePos = infors.getValue1();
		byte pageLength = infors.getValue2();
		int recordPos = (pagePos-1)*pageLength;
		ArrayList<ResultSet> resultSets = this.shop.getShopById(filter,recordPos,pageLength,id);
		
		ResultSet rs = resultSets.get(0);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shopDTO = new ShopDTO();
					shopDTO.setId(rs.getInt("shop_id"));
					shopDTO.setName(rs.getString("shop_name"));
					shopDTO.setAddress(rs.getString("shop_address"));
					shopDTO.setImages(rs.getString("shop_images"));
					shopDTO.setNotes(rs.getString("shop_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ShopProductDTO shopProductDTO = null;
		ArrayList<ShopProductDTO> shopProductDTOs = new ArrayList<ShopProductDTO>();
		ShopPCDTO shopPCDTO = null;
		rs = resultSets.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					shopDTO = new ShopDTO();
					shopDTO.setId(rs.getInt("shop_id"));
					shopDTO.setName(rs.getString("shop_name"));
					shopDTO.setAddress(rs.getString("shop_address"));
					shopDTO.setImages(rs.getString("shop_images"));
					shopDTO.setNotes(rs.getString("shop_notes"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shopDTO;
		
		
	}
	
	public Pair<SellerShopDTO, SellerShopStatisticDTO> getShopDTOByUser(Triplet<String, Short, Byte> infors, UserObject currentUser) {
		//Lay ban ghi 
		String filter = infors.getValue0();
		Short pagePos = infors.getValue1();
		byte pageLength = infors.getValue2();
		int recordPos = (pagePos-1)*pageLength;
		
		ArrayList<ResultSet> resultSets = this.shop.getShopByUser(filter,recordPos,pageLength,currentUser);
		
		ResultSet rs = resultSets.get(0);
		//Chuyen doi ban ghi thanh doi tuong
		//Gan gia tri khoi tao cho doi tuong ShopObject
		SellerShopDTO sellerShopDTO = new SellerShopDTO() ;
		ArrayList<SellerShopProductDTO> sellerShopProductDTOs = new ArrayList<SellerShopProductDTO>();
		sellerShopDTO.setStorage(sellerShopProductDTOs);
		if (rs!=null) {
			try {
				if (rs.next()) {
					sellerShopDTO.setId(rs.getInt("shop_id"));
					sellerShopDTO.setName(rs.getString("shop_name"));
					sellerShopDTO.setAddress(rs.getString("shop_address"));
					sellerShopDTO.setImages(rs.getString("shop_images"));
					sellerShopDTO.setNotes(rs.getString("shop_notes"));				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		SellerShopStatisticDTO sellerShopStatisticDTO = new SellerShopStatisticDTO();
		int TotalProduct = 0;
		rs = resultSets.get(1);
		if (rs!=null) {
			try {
				if (rs.next()) {
					TotalProduct = rs.getInt("TotalProduct");
					sellerShopStatisticDTO.setTotalProduct(TotalProduct);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		rs = resultSets.get(2);
		ShopPCDTO shopPCDTO = null;
		int QuantityAllProduct = 0;
		double PriceAllProduct = 0;
		if (rs!=null) {
			try {
				while (rs.next()) {
					SellerShopProductDTO sellerShopProductDTO = new SellerShopProductDTO();
					sellerShopProductDTO.setId(rs.getInt("product_id"));
					sellerShopProductDTO.setName(rs.getString("product_name"));
					sellerShopProductDTO.setQuantity(rs.getInt("product_quantity"));
					sellerShopProductDTO.setPrice(rs.getDouble("product_price"));
					
					QuantityAllProduct += rs.getInt("product_quantity");
					PriceAllProduct += rs.getDouble("product_price");
					
					shopPCDTO = new ShopPCDTO();
					shopPCDTO.setName(rs.getString("pc_name"));
					sellerShopProductDTO.setPc(shopPCDTO);
					sellerShopDTO.getStorage().add(sellerShopProductDTO);	
				}
				
				sellerShopStatisticDTO.setTotalPriceAllProduct(PriceAllProduct);
				sellerShopStatisticDTO.setTotalQuantityAllProduct(QuantityAllProduct);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		HashMap<Integer,Pair<SellerShopProductDTO, Double>> hashMap1 = new HashMap<Integer, Pair<SellerShopProductDTO,Double>>();
		sellerShopStatisticDTO.setTotalSellingPricePerProduct(hashMap1);
		HashMap<Integer,Pair<SellerShopProductDTO, Integer>> hashMap2 = new HashMap<Integer, Pair<SellerShopProductDTO,Integer>>();
		sellerShopStatisticDTO.setTotalSellingQuantityPerProduct(hashMap2);
		
		/*
		 * System.out.println(sellerShopDTO.getStatistic().getTotalSellingPerProduct());
		 * System.out.println(sellerShopDTO.getStatistic().
		 * getTotalSellingQuantityPerProduct());
		 */


		rs = resultSets.get(3);
		if (rs!=null) {
			try {			
				QuantityAllProduct = 0;
				PriceAllProduct = 0;
				int TotalSellingQuantityPerProduct = 0;
				double TotalSellingPricePerProduct = 0;
				while (rs.next()) {
					int product_id =rs.getInt("product_id");
					TotalSellingQuantityPerProduct = rs.getInt("TotalSellingQuantityPerProduct");
					TotalSellingPricePerProduct = rs.getInt("TotalSellingPricePerProduct");
					
					QuantityAllProduct+=TotalSellingQuantityPerProduct;
					PriceAllProduct+=TotalSellingPricePerProduct;
					
					SellerShopProductDTO sellerShopProductDTO = new SellerShopProductDTO();
					sellerShopProductDTO.setId(rs.getInt("product_id"));
					sellerShopProductDTO.setName(rs.getString("product_name"));
					
					Pair<SellerShopProductDTO, Integer> pair1 = new Pair<SellerShopProductDTO, Integer>(sellerShopProductDTO, TotalSellingQuantityPerProduct);
					sellerShopStatisticDTO.getTotalSellingQuantityPerProduct().put(product_id,pair1);
					
					Pair<SellerShopProductDTO, Double> pair2 = new Pair<SellerShopProductDTO, Double>(sellerShopProductDTO, TotalSellingPricePerProduct);
					sellerShopStatisticDTO.getTotalSellingPricePerProduct().put(product_id,pair2);
					
					sellerShopStatisticDTO.setTotalSellingPriceAllProduct(PriceAllProduct);
					sellerShopStatisticDTO.setTotalSellingQuantityAllProduct(QuantityAllProduct);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return new Pair<SellerShopDTO, SellerShopStatisticDTO>(sellerShopDTO,sellerShopStatisticDTO);	
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
		SellerShopStatisticDTO rs = u.getShopDTOByUser(new Triplet<String, Short, Byte>("",(short) 0,(byte) 0),currentUser).getValue1();
		
		String row = null;
		//Duyen va hien thi danh sach nguoi su dung
		if (rs!=null) {
			System.out.println("object:"+rs);
			System.out.println("price:"+rs.getTotalPriceAllProduct());
			System.out.println("quantity:"+rs.getTotalQuantityAllProduct());
	
		}

	}
		
}
