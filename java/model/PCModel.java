package model;

import repository.PC;
import repository.PCImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import dto.product.Product_DTO;
import dto.productAttribute.Product_CPUDTO;
import dto.productAttribute.Product_CaseDTO;
import dto.productAttribute.Product_CoolingDTO;
import dto.productAttribute.Product_DesktopDTO;
import dto.productAttribute.Product_GraphicsCardDTO;
import dto.productAttribute.Product_HeadphoneSpeakerDTO;
import dto.productAttribute.Product_KeyboardDTO;
import dto.productAttribute.Product_LaptopDTO;
import dto.productAttribute.Product_MiceDTO;
import dto.productAttribute.Product_MonitorDTO;
import dto.productAttribute.Product_MotherboardDTO;
import dto.productAttribute.Product_PowerSuppyDTO;
import dto.productAttribute.Product_RamDTO;
import dto.productAttribute.Product_StorageDTO;
import entity.PCObject;
import entity.ProductObject;

public class PCModel {
	private PC pc; 
	
	public PCModel(ConnectionPool cp) {
		this.pc = new PCImpl(cp);
		
	}
	
	public ConnectionPool getCP() {
		return this.pc.getCP();
	}
	
	public void releaseCP() {
		this.pc.releaseCP();
	}
	
	public PCObject getPCByID(int id) {
		ResultSet rs = this.pc.getPCById(id);
		
		PCObject pcObject = null;
		
		if (rs!=null) {
			try {
				if (rs.next()) {
					pcObject = new PCObject();
					pcObject.setPc_id(rs.getInt("pc_id"));
					pcObject.setPc_created_date("created_date");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pcObject;
	}
	
	
	
	public Product_CaseDTO getProduct_CaseDTO(Product_DTO product_DTO) throws SQLException {
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		Product_CaseDTO product_CaseDTO = new Product_CaseDTO();
		if (attribute.next()) {
			product_CaseDTO.setCase_size(attribute.getString("case_size"));
			product_CaseDTO.setCase_manufacturer(attribute.getString("case_manufacturer"));
			product_CaseDTO.setCase_color(attribute.getString("case_color"));
		}	
		
		return product_CaseDTO;
	}
	
	public Product_CoolingDTO getProduct_CoolingDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_CoolingDTO product_CoolingDTO = new Product_CoolingDTO();
		if (attribute.next()) {
			product_CoolingDTO.setCooling_color(attribute.getString("cooling_color"));
			product_CoolingDTO.setCooling_fan_size(attribute.getString("cooling_fan_size"));
			product_CoolingDTO.setCooling_manufacturer(attribute.getString("cooling_manufacturer"));
		}
	
		return product_CoolingDTO;
	}
	
	public Product_CPUDTO getProduct_CPUDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);			

		Product_CPUDTO product_CPUDTO = new Product_CPUDTO();
		return product_CPUDTO;
	}
	
	public Product_DesktopDTO getProduct_DesktopDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		
		Product_DesktopDTO product_DesktopDTO = new Product_DesktopDTO();
		return product_DesktopDTO;
	}
	
	public Product_GraphicsCardDTO getProduct_GraphicsCardDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		
		Product_GraphicsCardDTO product_GraphicsCardDTO = new Product_GraphicsCardDTO();
		return product_GraphicsCardDTO ;
	}
	
	public Product_HeadphoneSpeakerDTO getProduct_HeadphoneSpeakerDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		
		Product_HeadphoneSpeakerDTO product_HeadphoneSpeakerDTO = new Product_HeadphoneSpeakerDTO();
		return product_HeadphoneSpeakerDTO;
	}
	
	public Product_KeyboardDTO getProduct_KeyboardDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_KeyboardDTO product_KeyboardDTO = new Product_KeyboardDTO();
		if (attribute.next()) {

		}
		return product_KeyboardDTO;
	}
	
	public Product_LaptopDTO getProduct_LaptopDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_LaptopDTO product_LaptopDTO = new Product_LaptopDTO();
		if (attribute.next()) {
			product_LaptopDTO.setLaptop_manufacturer(attribute.getString("laptop_manufacturer"));
			product_LaptopDTO.setLaptop_cpu(attribute.getString("laptop_cpu"));
			product_LaptopDTO.setLaptop_ram(attribute.getString("laptop_ram"));
			product_LaptopDTO.setLaptop_storage(attribute.getString("laptop_storage"));
			product_LaptopDTO.setLaptop_screen_size(attribute.getString("laptop_screen_size"));
			product_LaptopDTO.setLaptop_resolution(attribute.getString("laptop_resolution"));
			product_LaptopDTO.setLaptop_type(attribute.getString("laptop_type"));
		}
		return product_LaptopDTO;
	}

	public Product_StorageDTO getProduct_StorageDTO(Product_DTO product_DTO) throws SQLException {
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		
		Product_StorageDTO product_StorageDTO = new Product_StorageDTO();
		return product_StorageDTO;
	}

	public Product_RamDTO getProduct_RamDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		Product_RamDTO product_RamDTO = new Product_RamDTO();
		return product_RamDTO;
	}

	public Product_PowerSuppyDTO getProduct_PowerSuppyDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_PowerSuppyDTO product_PowerSuppyDTO = new Product_PowerSuppyDTO();
		return product_PowerSuppyDTO;
	}

	public Product_MotherboardDTO getProduct_MotherboardDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		
		Product_MotherboardDTO product_MotherboardDTO = new Product_MotherboardDTO();
		return product_MotherboardDTO;
	}

	public Product_MonitorDTO getProduct_MonitorDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		
		Product_MonitorDTO product_MonitorDTO = new Product_MonitorDTO();
		return product_MonitorDTO;
	}

	public Product_MiceDTO getProduct_MiceDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		
		Product_MiceDTO product_MiceDTO = new Product_MiceDTO();
		return product_MiceDTO;
	}
}
