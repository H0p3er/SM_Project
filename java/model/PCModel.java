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
import dto.productAttribute.Product_UsbDTO;
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
			product_CoolingDTO.setCooling_type(attribute.getString("cooling_color"));
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
		if (attribute.next()) {
			product_CPUDTO.setCpu_collection(attribute.getString("cpu_collection"));
			product_CPUDTO.setCpu_socket(attribute.getString("cpu_socket"));
			product_CPUDTO.setCpu_cores(attribute.getInt("cpu_cores"));
			product_CPUDTO.setCpu_threads(attribute.getInt("cpu_threads"));
			product_CPUDTO.setCpu_speed_ghz(attribute.getString("cpu_speed_ghz"));
		}
		return product_CPUDTO;
	}
	
	public Product_DesktopDTO getProduct_DesktopDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		Product_DesktopDTO product_DesktopDTO = new Product_DesktopDTO();
		if (attribute.next()) {
			product_DesktopDTO.setDesktop_manufacturer(attribute.getString("desktop_manufacturer"));
			product_DesktopDTO.setDesktop_ram_type(attribute.getString("desktop_type"));
			product_DesktopDTO.setDesktop_cpu(attribute.getString("desktop_cpu"));
			product_DesktopDTO.setDesktop_gpu(attribute.getString("desktop_gpu"));
			product_DesktopDTO.setDesktop_ram_capacity(attribute.getString("desktop_ram_capacity"));
			product_DesktopDTO.setDesktop_ram_type(attribute.getString("desktop_ram_type"));
			product_DesktopDTO.setDesktop_storage(attribute.getString("desktop_storage"));
			product_DesktopDTO.setDesktop_power_supply(attribute.getString("desktop_power_supply"));
		}
		return product_DesktopDTO;
	}
	
	public Product_GraphicsCardDTO getProduct_GraphicsCardDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_GraphicsCardDTO product_GraphicsCardDTO = new Product_GraphicsCardDTO();
		if (attribute.next()) {
			product_GraphicsCardDTO.setGraphics_card_manufacturer(attribute.getString("graphics_card_manufacturer"));
			product_GraphicsCardDTO.setGraphics_card_speed(attribute.getString("graphics_card_speed"));
			product_GraphicsCardDTO.setGraphics_card_cores(attribute.getString("graphics_card_cores"));
			product_GraphicsCardDTO.setGraphics_card_version(attribute.getString("graphics_card_version"));
			product_GraphicsCardDTO.setGraphics_card_vram_capacity(attribute.getString("graphics_card_vram_capacity"));
			product_GraphicsCardDTO.setGraphics_card_require_psu(attribute.getString("graphics_card_require_psu"));
		}
		return product_GraphicsCardDTO ;
	}
	
	public Product_HeadphoneSpeakerDTO getProduct_HeadphoneSpeakerDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		Product_HeadphoneSpeakerDTO product_HeadphoneSpeakerDTO = new Product_HeadphoneSpeakerDTO();
		if (attribute.next()) {
			product_HeadphoneSpeakerDTO.setHeadphones_manufacturer(attribute.getString("headphones_manufacturer"));
			product_HeadphoneSpeakerDTO.setHeadphone_type(attribute.getString("headphone_type"));
			product_HeadphoneSpeakerDTO.setHeadphones_connection(attribute.getString("headphones_connection"));
			product_HeadphoneSpeakerDTO.setHeadphones_connection_ports(attribute.getString("headphones_connection_ports"));
		}
		return product_HeadphoneSpeakerDTO;
	}
	
	public Product_KeyboardDTO getProduct_KeyboardDTO(Product_DTO product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_KeyboardDTO product_KeyboardDTO = new Product_KeyboardDTO();
		if (attribute.next()) {
	        product_KeyboardDTO.setKeyboard_id(attribute.getInt("keyboard_id"));
	        product_KeyboardDTO.setKeyboard_type(attribute.getString("keyboard_type"));
	        product_KeyboardDTO.setKeyboard_connection_type(attribute.getString("keyboard_connection_type"));
	        product_KeyboardDTO.setKeyboard_size_layout(attribute.getString("keyboard_size_layout"));
	        product_KeyboardDTO.setKeyboard_led_backlighting(attribute.getString("keyboard_led_backlighting"));
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
		if (attribute.next()) {
	        product_StorageDTO.setStorage_id(attribute.getInt("storage_id"));
	        product_StorageDTO.setStorage_manufacturer(attribute.getString("storage_manufacturer"));
	        product_StorageDTO.setStorage_type(attribute.getString("storage_type"));
	        product_StorageDTO.setStorage_capacity(attribute.getString("storage_capacity"));
	        product_StorageDTO.setStorage_m2_pcie_type(attribute.getString("storage_m2_pcie_type"));
	        product_StorageDTO.setStorage_rpm(attribute.getString("storage_rpm"));
	    }
		return product_StorageDTO;
	}

	public Product_RamDTO getProduct_RamDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		Product_RamDTO product_RamDTO = new Product_RamDTO();
		if (attribute.next()) {
	        product_RamDTO.setRam_id(attribute.getInt("ram_id"));
	        product_RamDTO.setRam_manufacturer(attribute.getString("ram_manufacturer"));
	        product_RamDTO.setRam_type(attribute.getString("ram_type"));
	        product_RamDTO.setRam_capacity(attribute.getString("ram_capacity"));
	        product_RamDTO.setRam_bus_speed(attribute.getString("ram_bus_speed"));
	        product_RamDTO.setRam_standard(attribute.getString("ram_standard"));
	    }
		return product_RamDTO;
	}

	public Product_PowerSuppyDTO getProduct_PowerSuppyDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_PowerSuppyDTO product_PowerSuppyDTO = new Product_PowerSuppyDTO();
		if (attribute.next()) {
	        product_PowerSuppyDTO.setPsu_id(attribute.getInt("psu_id"));
	        product_PowerSuppyDTO.setPsu_manufacturer(attribute.getString("psu_manufacturer"));
	        product_PowerSuppyDTO.setPsu_certification(attribute.getString("psu_certification"));
	        product_PowerSuppyDTO.setPsu_cable_type(attribute.getString("psu_cable_type"));
	        product_PowerSuppyDTO.setPsu_size(attribute.getString("psu_size"));
	        product_PowerSuppyDTO.setPsu_power_output(attribute.getString("psu_power_output"));
	    }
		return product_PowerSuppyDTO;
	}

	public Product_MotherboardDTO getProduct_MotherboardDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_MotherboardDTO product_MotherboardDTO = new Product_MotherboardDTO();
		if (attribute.next()) {
	        product_MotherboardDTO.setMotherboard_id(attribute.getInt("motherboard_id"));
	        product_MotherboardDTO.setMotherboard_manufacturer(attribute.getString("motherboard_manufacturer"));
	        product_MotherboardDTO.setMotherboard_chipset(attribute.getString("motherboard_chipset"));
	        product_MotherboardDTO.setMotherboard_socket(attribute.getString("motherboard_socket"));
	        product_MotherboardDTO.setMotherboard_size(attribute.getString("motherboard_size"));
	        product_MotherboardDTO.setMotherboard_ram_support(attribute.getString("motherboard_ram_support"));
	        product_MotherboardDTO.setMotherboard_ram_slots(attribute.getString("motherboard_ram_slots"));
	    }
		return product_MotherboardDTO;
	}

	public Product_MonitorDTO getProduct_MonitorDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_MonitorDTO product_MonitorDTO = new Product_MonitorDTO();
		if (attribute.next()) {
	        product_MonitorDTO.setMonitor_id(attribute.getInt("monitor_id"));
	        product_MonitorDTO.setMonitor_manufacturer(attribute.getString("monitor_manufacturer"));
	        product_MonitorDTO.setMonitor_size(attribute.getString("monitor_size"));
	        product_MonitorDTO.setMonitor_type(attribute.getString("monitor_type"));
	        product_MonitorDTO.setMonitor_resolution(attribute.getString("monitor_resolution"));
	        product_MonitorDTO.setMonitor_panel_type(attribute.getString("monitor_panel_type"));
	        product_MonitorDTO.setMonitor_refresh_rate(attribute.getInt("monitor_refresh_rate"));
	        product_MonitorDTO.setMonitor_screen_type(attribute.getString("monitor_screen_type"));
	        product_MonitorDTO.setMonitor_response(attribute.getDouble("monitor_response"));
	    }
		return product_MonitorDTO;
	}

	public Product_MiceDTO getProduct_MiceDTO(Product_DTO product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		Product_MiceDTO product_MiceDTO = new Product_MiceDTO();
		if (attribute.next()) {
	        product_MiceDTO.setMouse_id(attribute.getInt("mouse_id"));
	        product_MiceDTO.setMouse_manufacturer(attribute.getString("mouse_manufacturer"));
	        product_MiceDTO.setMouse_type(attribute.getString("mouse_type"));
	        product_MiceDTO.setMouse_connection_type(attribute.getString("mouse_connection_type"));
	        product_MiceDTO.setMouse_design(attribute.getString("mouse_design"));
	        product_MiceDTO.setMouse_battery(attribute.getString("mouse_battery"));
	    }
		return product_MiceDTO;
	}
	public Product_UsbDTO getProduct_UsbDTO(Product_DTO product_DTO) throws SQLException {    
	    ProductObject productObject = new ProductObject();
	    product_DTO.ApplyToEntity(productObject);
	    ResultSet attribute = this.pc.getProductAttribute(productObject);
	    Product_UsbDTO product_UsbDTO = new Product_UsbDTO();
	    if (attribute.next()) {
	        product_UsbDTO.setUsb_id(attribute.getInt("usb_id"));
	        product_UsbDTO.setUsb_manufacturer(attribute.getString("usb_manufacturer"));
	        product_UsbDTO.setUsb_capacity(attribute.getString("usb_capacity"));
	    }
	    return product_UsbDTO;
	}
}
