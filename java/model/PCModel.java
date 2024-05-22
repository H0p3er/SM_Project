package model;

import repository.PC;
import repository.PCImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionPool;
import dto.pc.PC_DTO;
import dto.product.ProductDTO;
import dto.product.Product_DTO;
import dto.product.Product_addProductDTO;
import dto.product.Product_manageBillDTO;
import dto.product.Product_manageShopDTO;
import dto.product.Product_viewBillDTO;
import dto.product.Product_viewProductDTO;
import dto.product.Product_viewShopDTO;
import dto.productAttribute.Product_AttributeDTO;
import dto.productAttribute.CPUDTO;
import dto.productAttribute.CaseDTO;
import dto.productAttribute.CoolingDTO;
import dto.productAttribute.DesktopDTO;
import dto.productAttribute.GraphicsCardDTO;
import dto.productAttribute.HeadphoneSpeakerDTO;
import dto.productAttribute.KeyboardDTO;
import dto.productAttribute.LaptopDTO;
import dto.productAttribute.MiceDTO;
import dto.productAttribute.MonitorDTO;
import dto.productAttribute.MotherboardDTO;
import dto.productAttribute.PowerSuppyDTO;
import dto.productAttribute.RamDTO;
import dto.productAttribute.StorageDTO;
import dto.productAttribute.UsbDTO;
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
	public PC_DTO getPC_DTOByID(int id) {
		ResultSet rs = this.pc.getPCById(id);	
		PC_DTO pc_DTO = null;
		if (rs!=null) {
			try {
				if (rs.next()) {
					pc_DTO = new PC_DTO();
					pc_DTO.setId(rs.getInt("pc_id"));
					pc_DTO.setName("created_date");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pc_DTO;
	}
	
	
	public void getCaseDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		CaseDTO product_CaseDTO = new CaseDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_CaseDTO.setCase_size(attribute.getString("case_size"));
				product_CaseDTO.setCase_manufacturer(attribute.getString("case_manufacturer"));
				product_CaseDTO.setCase_color(attribute.getString("case_color"));
				
			}
		}

		setProductAttribute(product_DTO, product_CaseDTO);
		//return product_CaseDTO;
	}
	
	public void getCoolingDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		CoolingDTO product_CoolingDTO = new CoolingDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_CoolingDTO.setCooling_color(attribute.getString("cooling_color"));
				product_CoolingDTO.setCooling_type(attribute.getString("cooling_color"));
				product_CoolingDTO.setCooling_fan_size(attribute.getString("cooling_fan_size"));
				product_CoolingDTO.setCooling_manufacturer(attribute.getString("cooling_manufacturer"));
			}
		}

		setProductAttribute(product_DTO, product_CoolingDTO);

		//return product_CoolingDTO;
	}
	
	public void getCPUDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		CPUDTO product_CPUDTO = new CPUDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_CPUDTO.setCpu_collection(attribute.getString("cpu_collection"));
				product_CPUDTO.setCpu_socket(attribute.getString("cpu_socket"));
				product_CPUDTO.setCpu_cores(attribute.getInt("cpu_cores"));
				product_CPUDTO.setCpu_threads(attribute.getInt("cpu_threads"));
				product_CPUDTO.setCpu_speed_ghz(attribute.getString("cpu_speed_ghz"));
			}
		}

		setProductAttribute(product_DTO, product_CPUDTO);
		//return product_CPUDTO;
	}
	
	public void getDesktopDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		DesktopDTO product_DesktopDTO = new DesktopDTO();
		if (attribute != null) {
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
		}
		setProductAttribute(product_DTO, product_DesktopDTO);
		// return product_DesktopDTO;
	}
	
	public void getGraphicsCardDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		GraphicsCardDTO product_GraphicsCardDTO = new GraphicsCardDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_GraphicsCardDTO.setGraphics_card_manufacturer(attribute.getString("graphics_card_manufacturer"));
				product_GraphicsCardDTO.setGraphics_card_speed(attribute.getString("graphics_card_speed"));
				product_GraphicsCardDTO.setGraphics_card_cores(attribute.getString("graphics_card_cores"));
				product_GraphicsCardDTO.setGraphics_card_version(attribute.getString("graphics_card_version"));
				product_GraphicsCardDTO.setGraphics_card_vram_capacity(attribute.getString("graphics_card_vram_capacity"));
				product_GraphicsCardDTO.setGraphics_card_require_psu(attribute.getString("graphics_card_require_psu"));
			}
		}
		setProductAttribute(product_DTO, product_GraphicsCardDTO);
//		return product_GraphicsCardDTO ;
	}
	
	public void getHeadphoneSpeakerDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		HeadphoneSpeakerDTO product_HeadphoneSpeakerDTO = new HeadphoneSpeakerDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_HeadphoneSpeakerDTO.setHeadphones_manufacturer(attribute.getString("headphones_manufacturer"));
				product_HeadphoneSpeakerDTO.setHeadphone_type(attribute.getString("headphone_type"));
				product_HeadphoneSpeakerDTO.setHeadphones_connection(attribute.getString("headphones_connection"));
				product_HeadphoneSpeakerDTO.setHeadphones_connection_ports(attribute.getString("headphones_connection_ports"));
			}
		}
		setProductAttribute(product_DTO, product_HeadphoneSpeakerDTO);
//		return product_HeadphoneSpeakerDTO;
	}
	
	public void getKeyboardDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		KeyboardDTO product_KeyboardDTO = new KeyboardDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_KeyboardDTO.setKeyboard_id(attribute.getInt("keyboard_id"));
		        product_KeyboardDTO.setKeyboard_type(attribute.getString("keyboard_type"));
		        product_KeyboardDTO.setKeyboard_connection_type(attribute.getString("keyboard_connection_type"));
		        product_KeyboardDTO.setKeyboard_size_layout(attribute.getString("keyboard_size_layout"));
		        product_KeyboardDTO.setKeyboard_led_backlighting(attribute.getString("keyboard_led_backlighting"));
		    }		
		}
		setProductAttribute(product_DTO, product_KeyboardDTO);
		//return product_KeyboardDTO;
	}
	
	public void getLaptopDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {	
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		LaptopDTO product_LaptopDTO = new LaptopDTO();
		if (attribute != null) {
			if (attribute.next()) {
				product_LaptopDTO.setLaptop_manufacturer(attribute.getString("laptop_manufacturer"));
				product_LaptopDTO.setLaptop_cpu(attribute.getString("laptop_cpu"));
				product_LaptopDTO.setLaptop_ram(attribute.getString("laptop_ram"));
				product_LaptopDTO.setLaptop_storage(attribute.getString("laptop_storage"));
				product_LaptopDTO.setLaptop_screen_size(attribute.getString("laptop_screen_size"));
				product_LaptopDTO.setLaptop_resolution(attribute.getString("laptop_resolution"));
				product_LaptopDTO.setLaptop_type(attribute.getString("laptop_type"));
			}
		}
		setProductAttribute(product_DTO, product_LaptopDTO);
		//return product_LaptopDTO;
	}

	public void getStorageDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		StorageDTO product_StorageDTO = new StorageDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_StorageDTO.setStorage_id(attribute.getInt("storage_id"));
		        product_StorageDTO.setStorage_manufacturer(attribute.getString("storage_manufacturer"));
		        product_StorageDTO.setStorage_type(attribute.getString("storage_type"));
		        product_StorageDTO.setStorage_capacity(attribute.getString("storage_capacity"));
		        product_StorageDTO.setStorage_m2_pcie_type(attribute.getString("storage_m2_pcie_type"));
		        product_StorageDTO.setStorage_rpm(attribute.getString("storage_rpm"));
		    }
		}
	
		setProductAttribute(product_DTO, product_StorageDTO);
		//return product_StorageDTO;
	}

	public void getRamDTO(ProductDTO<Product_AttributeDTO> product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);	
		RamDTO product_RamDTO = new RamDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_RamDTO.setRam_id(attribute.getInt("ram_id"));
		        product_RamDTO.setRam_manufacturer(attribute.getString("ram_manufacturer"));
		        product_RamDTO.setRam_type(attribute.getString("ram_type"));
		        product_RamDTO.setRam_capacity(attribute.getString("ram_capacity"));
		        product_RamDTO.setRam_bus_speed(attribute.getString("ram_bus_speed"));
		        product_RamDTO.setRam_standard(attribute.getString("ram_standard"));
		    }
		}
		setProductAttribute(product_DTO, product_RamDTO);
		//return product_RamDTO;
	}

	public void getPowerSuppyDTO(ProductDTO<Product_AttributeDTO> product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		PowerSuppyDTO product_PowerSuppyDTO = new PowerSuppyDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_PowerSuppyDTO.setPsu_id(attribute.getInt("psu_id"));
		        product_PowerSuppyDTO.setPsu_manufacturer(attribute.getString("psu_manufacturer"));
		        product_PowerSuppyDTO.setPsu_certification(attribute.getString("psu_certification"));
		        product_PowerSuppyDTO.setPsu_cable_type(attribute.getString("psu_cable_type"));
		        product_PowerSuppyDTO.setPsu_size(attribute.getString("psu_size"));
		        product_PowerSuppyDTO.setPsu_power_output(attribute.getString("psu_power_output"));
		    }
		}
		setProductAttribute(product_DTO, product_PowerSuppyDTO);
		//return product_PowerSuppyDTO;
	}

	public void getMotherboardDTO(ProductDTO<Product_AttributeDTO> product_DTO)  throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		MotherboardDTO product_MotherboardDTO = new MotherboardDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_MotherboardDTO.setMotherboard_id(attribute.getInt("motherboard_id"));
		        product_MotherboardDTO.setMotherboard_manufacturer(attribute.getString("motherboard_manufacturer"));
		        product_MotherboardDTO.setMotherboard_chipset(attribute.getString("motherboard_chipset"));
		        product_MotherboardDTO.setMotherboard_socket(attribute.getString("motherboard_socket"));
		        product_MotherboardDTO.setMotherboard_size(attribute.getString("motherboard_size"));
		        product_MotherboardDTO.setMotherboard_ram_support(attribute.getString("motherboard_ram_support"));
		        product_MotherboardDTO.setMotherboard_ram_slots(attribute.getString("motherboard_ram_slots"));
		    }
		}
		setProductAttribute(product_DTO, product_MotherboardDTO);
		//return product_MotherboardDTO;
	}

	public void getMonitorDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException{
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		MonitorDTO product_MonitorDTO = new MonitorDTO();
		if (attribute != null) {
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
		}
		setProductAttribute(product_DTO, product_MonitorDTO);
//		return product_MonitorDTO;
	}

	public void getMiceDTO(ProductDTO<Product_AttributeDTO> product_DTO)  throws SQLException {
		ProductObject productObject = new ProductObject();
		product_DTO.ApplyToEntity(productObject);
		ResultSet attribute = this.pc.getProductAttribute(productObject);
		MiceDTO product_MiceDTO = new MiceDTO();
		if (attribute != null) {
			if (attribute.next()) {
		        product_MiceDTO.setMouse_id(attribute.getInt("mouse_id"));
		        product_MiceDTO.setMouse_manufacturer(attribute.getString("mouse_manufacturer"));
		        product_MiceDTO.setMouse_type(attribute.getString("mouse_type"));
		        product_MiceDTO.setMouse_connection_type(attribute.getString("mouse_connection_type"));
		        product_MiceDTO.setMouse_design(attribute.getString("mouse_design"));
		        product_MiceDTO.setMouse_battery(attribute.getString("mouse_battery"));
		    }
		}
		setProductAttribute(product_DTO, product_MiceDTO);
		
//		return product_MiceDTO;
	}
	public void getUsbDTO(ProductDTO<Product_AttributeDTO> product_DTO) throws SQLException {    
	    ProductObject productObject = new ProductObject();
	    product_DTO.ApplyToEntity(productObject);
	    ResultSet attribute = this.pc.getProductAttribute(productObject);
	    UsbDTO product_UsbDTO = new UsbDTO();
		if (attribute != null) {
		    if (attribute.next()) {
		        product_UsbDTO.setUsb_id(attribute.getInt("usb_id"));
		        product_UsbDTO.setUsb_manufacturer(attribute.getString("usb_manufacturer"));
		        product_UsbDTO.setUsb_capacity(attribute.getString("usb_capacity"));
		    }
		}
	    setProductAttribute(product_DTO, product_UsbDTO);
//	    return product_UsbDTO;
	}
	
	private void setProductAttribute(ProductDTO<Product_AttributeDTO> product_DTO, Product_AttributeDTO product_AttributeDTO) {
		if (product_DTO instanceof Product_viewProductDTO) {
			((Product_viewProductDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
		
		if (product_DTO instanceof Product_manageShopDTO) {
			((Product_manageShopDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
		
		if (product_DTO instanceof Product_addProductDTO) {
			((Product_addProductDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
		
		if (product_DTO instanceof Product_viewShopDTO) {
			((Product_viewShopDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
		
		if (product_DTO instanceof Product_manageBillDTO) {
			((Product_manageBillDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
		
		if (product_DTO instanceof Product_viewBillDTO) {
			((Product_viewBillDTO) product_DTO).setAttribute(product_AttributeDTO);
		}
	}
}
