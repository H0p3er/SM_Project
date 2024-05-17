package dto.shop;

import java.util.List;
import java.util.Map;

import org.javatuples.Pair;

import dto.product.Product_DTO;



public class Shop_statisticDTO {
	
	private int count_order_last_month;
	private int count_order_current_month;
	private Map<String,Integer> order_current_month;
	
	private double sum_income_last_month;
	private double sum_income_current_month;
	private Map<String,Double> income_current_month;
	
	private int count_customer_last_month;
	private int count_customer_current_month;	
	private Map<String,Integer> customer_current_month;	
	
	private List<Pair<Product_DTO,Double>> most_sold_product_current_month;
	private List<Product_DTO> new_product_current_month;
	public int getCount_order_last_month() {
		return count_order_last_month;
	}
	public void setCount_order_last_month(int count_order_last_month) {
		this.count_order_last_month = count_order_last_month;
	}
	public int getCount_order_current_month() {
		return count_order_current_month;
	}
	public void setCount_order_current_month(int count_order_current_month) {
		this.count_order_current_month = count_order_current_month;
	}
	public Map<String, Integer> getOrder_current_month() {
		return order_current_month;
	}
	public void setOrder_current_month(Map<String, Integer> order_current_month) {
		this.order_current_month = order_current_month;
	}
	public double getSum_income_last_month() {
		return sum_income_last_month;
	}
	public void setSum_income_last_month(double sum_income_last_month) {
		this.sum_income_last_month = sum_income_last_month;
	}
	public double getSum_income_current_month() {
		return sum_income_current_month;
	}
	public void setSum_income_current_month(double sum_income_current_month) {
		this.sum_income_current_month = sum_income_current_month;
	}
	public Map<String, Double> getIncome_current_month() {
		return income_current_month;
	}
	public void setIncome_current_month(Map<String, Double> income_current_month) {
		this.income_current_month = income_current_month;
	}
	public int getCount_customer_last_month() {
		return count_customer_last_month;
	}
	public void setCount_customer_last_month(int count_customer_last_month) {
		this.count_customer_last_month = count_customer_last_month;
	}
	public int getCount_customer_current_month() {
		return count_customer_current_month;
	}
	public void setCount_customer_current_month(int count_customer_current_month) {
		this.count_customer_current_month = count_customer_current_month;
	}
	public Map<String, Integer> getCustomer_current_month() {
		return customer_current_month;
	}
	public void setCustomer_current_month(Map<String, Integer> customer_current_month) {
		this.customer_current_month = customer_current_month;
	}
	public List<Pair<Product_DTO, Double>> getMost_sold_product_current_month() {
		return most_sold_product_current_month;
	}
	public void setMost_sold_product_current_month(
			List<Pair<Product_DTO, Double>> most_sold_product_current_month) {
		this.most_sold_product_current_month = most_sold_product_current_month;
	}
	public List<Product_DTO> getNew_product_current_month() {
		return new_product_current_month;
	}
	public void setNew_product_current_month(List<Product_DTO> new_product_current_month) {
		this.new_product_current_month = new_product_current_month;
	}
	
	
}
