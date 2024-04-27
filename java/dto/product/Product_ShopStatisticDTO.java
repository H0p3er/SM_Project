package dto.product;

import java.util.List;
import java.util.Map;



public class Product_ShopStatisticDTO {
	
	private Map<String,Integer> count_bill_last_month;
	private Map<String,Integer> count_bill_current_month;
	
	private Map<String,Double> sold_price_last_month;
	private Map<String,Double> sold_price_current_month;	
	
	private List<Product_manageShopDTO> most_sold_price_product;

	public Map<String, Integer> getCount_bill_last_month() {
		return count_bill_last_month;
	}

	public void setCount_bill_last_month(Map<String, Integer> count_bill_last_month) {
		this.count_bill_last_month = count_bill_last_month;
	}

	public Map<String, Integer> getCount_bill_current_month() {
		return count_bill_current_month;
	}

	public void setCount_bill_current_month(Map<String, Integer> count_bill_current_month) {
		this.count_bill_current_month = count_bill_current_month;
	}

	public Map<String, Double> getSold_price_last_month() {
		return sold_price_last_month;
	}

	public void setSold_price_last_month(Map<String, Double> sold_price_last_month) {
		this.sold_price_last_month = sold_price_last_month;
	}

	public Map<String, Double> getSold_price_current_month() {
		return sold_price_current_month;
	}

	public void setSold_price_current_month(Map<String, Double> sold_price_current_month) {
		this.sold_price_current_month = sold_price_current_month;
	}

	public List<Product_manageShopDTO> getMost_sold_price_product() {
		return most_sold_price_product;
	}

	public void setMost_sold_price_product(List<Product_manageShopDTO> most_sold_price_product) {
		this.most_sold_price_product = most_sold_price_product;
	}
	
	

}
