package entity;

import java.util.Objects;

public class WpsdObject {
	private int wpsd_id;
	private int wpsd_workplace_id;
	private int wpsd_product_id;
	private int wpsd_product_quantity;
	private String wpsd_created_date;
	private boolean wpsd_deleted;
	public WpsdObject(int wpsd_id, int wpsd_workplace_id, int wpsd_product_id, int wpsd_product_quantity,
			String wpsd_created_date, boolean wpsd_deleted) {
		super();
		this.wpsd_id = wpsd_id;
		this.wpsd_workplace_id = wpsd_workplace_id;
		this.wpsd_product_id = wpsd_product_id;
		this.wpsd_product_quantity = wpsd_product_quantity;
		this.wpsd_created_date = wpsd_created_date;
		this.wpsd_deleted = wpsd_deleted;
	}
	
	public WpsdObject() {
		super();
	}

	public int getWpsd_id() {
		return wpsd_id;
	}
	public void setWpsd_id(int wpsd_id) {
		this.wpsd_id = wpsd_id;
	}
	public int getWpsd_workplace_id() {
		return wpsd_workplace_id;
	}
	public void setWpsd_workplace_id(int wpsd_workplace_id) {
		this.wpsd_workplace_id = wpsd_workplace_id;
	}
	public int getWpsd_product_id() {
		return wpsd_product_id;
	}
	public void setWpsd_product_id(int wpsd_product_id) {
		this.wpsd_product_id = wpsd_product_id;
	}
	public int getWpsd_product_quantity() {
		return wpsd_product_quantity;
	}
	public void setWpsd_product_quantity(int wpsd_product_quantity) {
		this.wpsd_product_quantity = wpsd_product_quantity;
	}
	public String getWpsd_created_date() {
		return wpsd_created_date;
	}
	public void setWpsd_created_date(String wpsd_created_date) {
		this.wpsd_created_date = wpsd_created_date;
	}
	public boolean isWpsd_deleted() {
		return wpsd_deleted;
	}
	public void setWpsd_deleted(boolean wpsd_deleted) {
		this.wpsd_deleted = wpsd_deleted;
	}
	@Override
	public int hashCode() {
		return Objects.hash(wpsd_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WpsdObject other = (WpsdObject) obj;
		return wpsd_id == other.wpsd_id;
	}
	
	
}
