package entity;

public class SaleObject {
	  public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public int getSale_product_id() {
		return sale_product_id;
	}
	public void setSale_product_id(int sale_product_id) {
		this.sale_product_id = sale_product_id;
	}
	public float getSale_off_price() {
		return sale_off_price;
	}
	public void setSale_off_price(float sale_off_price) {
		this.sale_off_price = sale_off_price;
	}
	public float getSale_off_price_percent() {
		return sale_off_price_percent;
	}
	public void setSale_off_price_percent(float sale_off_price_percent) {
		this.sale_off_price_percent = sale_off_price_percent;
	}
	public String getSale_start_date() {
		return sale_start_date;
	}
	public void setSale_start_date(String sale_start_date) {
		this.sale_start_date = sale_start_date;
	}
	public String getSale_end_date() {
		return sale_end_date;
	}
	public void setSale_end_date(String sale_end_date) {
		this.sale_end_date = sale_end_date;
	}
	private int sale_id;
      private String sale_name;
      private int sale_product_id;
      private float sale_off_price;
      private float sale_off_price_percent;
      private String sale_start_date;
      private String sale_end_date;
}
