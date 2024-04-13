package dto.seller;

import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;

public class SellerShopStatisticDTO {
	private HashMap<Integer,Pair<SellerShopProductDTO,Integer>> TotalSellingQuantityPerProduct;
	private HashMap<Integer,Pair<SellerShopProductDTO,Double>> TotalSellingPricePerProduct;
	private int TotalSellingQuantityAllProduct;
	private double TotalSellingPriceAllProduct;
	
	private HashMap<Integer,Pair<SellerShopProductDTO,Integer>> TotalQuantityPerProduct;
	private HashMap<Integer,Pair<SellerShopProductDTO,Double>> TotalPricePerProduct;
	private int TotalQuantityAllProduct;
	private double TotalPriceAllProduct;
	
	private int TotalProduct;

	public HashMap<Integer, Pair<SellerShopProductDTO, Integer>> getTotalSellingQuantityPerProduct() {
		return this.TotalSellingQuantityPerProduct;
	}

	public void setTotalSellingQuantityPerProduct(
			HashMap<Integer, Pair<SellerShopProductDTO, Integer>> totalSellingQuantityPerProduct) {
		this.TotalSellingQuantityPerProduct = totalSellingQuantityPerProduct;
	}

	public HashMap<Integer, Pair<SellerShopProductDTO, Double>> getTotalSellingPricePerProduct() {
		return this.TotalSellingPricePerProduct;
	}

	public void setTotalSellingPricePerProduct(
			HashMap<Integer, Pair<SellerShopProductDTO, Double>> totalSellingPricePerProduct) {
		this.TotalSellingPricePerProduct = totalSellingPricePerProduct;
	}

	public int getTotalSellingQuantityAllProduct() {
		return this.TotalSellingQuantityAllProduct;
	}

	public void setTotalSellingQuantityAllProduct(int totalSellingQuantityAllProduct) {
		this.TotalSellingQuantityAllProduct = totalSellingQuantityAllProduct;
	}

	public double getTotalSellingPriceAllProduct() {
		return this.TotalSellingPriceAllProduct;
	}

	public void setTotalSellingPriceAllProduct(double totalSellingPriceAllProduct) {
		this.TotalSellingPriceAllProduct = totalSellingPriceAllProduct;
	}

	public HashMap<Integer, Pair<SellerShopProductDTO, Integer>> getTotalQuantityPerProduct() {
		return this.TotalQuantityPerProduct;
	}

	public void setTotalQuantityPerProduct(HashMap<Integer, Pair<SellerShopProductDTO, Integer>> totalQuantityPerProduct) {
		this.TotalQuantityPerProduct = totalQuantityPerProduct;
	}

	public HashMap<Integer, Pair<SellerShopProductDTO, Double>> getTotalPricePerProduct() {
		return this.TotalPricePerProduct;
	}

	public void setTotalPricePerProduct(HashMap<Integer, Pair<SellerShopProductDTO, Double>> totalPricePerProduct) {
		this.TotalPricePerProduct = totalPricePerProduct;
	}

	public int getTotalQuantityAllProduct() {
		return this.TotalQuantityAllProduct;
	}

	public void setTotalQuantityAllProduct(int totalQuantityAllProduct) {
		this.TotalQuantityAllProduct = totalQuantityAllProduct;
	}

	public double getTotalPriceAllProduct() {
		return this.TotalPriceAllProduct;
	}

	public void setTotalPriceAllProduct(double totalPriceAllProduct) {
		this.TotalPriceAllProduct = totalPriceAllProduct;
	}

	public int getTotalProduct() {
		return this.TotalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.TotalProduct = totalProduct;
	}

	
}
