package utility;

import constant.HTTP_REQUEST;
import constant.PRODUCT_ATTRIBUTE;
import dto.pc.PCDTO;
import dto.pc.PC_DTO;
import dto.pc.PC_addProductDTO;
import dto.pc.PC_manageBillDTO;
import dto.pc.PC_manageShopDTO;
import dto.pc.PC_viewBillDTO;
import dto.pc.PC_viewProductDTO;
import dto.pc.PC_viewShopDTO;

public class Utilities_data_type {
	
	public static PRODUCT_ATTRIBUTE getProductAttribute(PCDTO pcdto) {
		int pc_id=16;
		if (pcdto instanceof PC_manageBillDTO) {
			pc_id = ((PC_manageBillDTO) pcdto).getId();
		}
		if (pcdto instanceof PC_addProductDTO) {
			pc_id = ((PC_addProductDTO) pcdto).getId();
		}
		if (pcdto instanceof PC_DTO) {
			pc_id = ((PC_DTO) pcdto).getId();
		}
		if (pcdto instanceof PC_manageShopDTO) {
			pc_id = ((PC_manageShopDTO) pcdto).getId();
		}
		if (pcdto instanceof PC_viewBillDTO) {
			pc_id = ((PC_viewBillDTO) pcdto).getId();
		}
		if (pcdto instanceof PC_viewShopDTO) {
			pc_id = ((PC_viewShopDTO) pcdto).getId();
		}
		if (pcdto instanceof PC_viewProductDTO) {
			pc_id = ((PC_viewProductDTO) pcdto).getId();
		}
		switch (pc_id) {
		case 1:
			return PRODUCT_ATTRIBUTE.MONITOR;
		case 2:
			return PRODUCT_ATTRIBUTE.KEYBOARD;
		case 3:
			return PRODUCT_ATTRIBUTE.MOUSE;
		case 4:
			return PRODUCT_ATTRIBUTE.HEADPHONE;
		case 5:
			return PRODUCT_ATTRIBUTE.LAPTOP;
		case 6:
			return PRODUCT_ATTRIBUTE.DESKTOP;
		case 7:
			return PRODUCT_ATTRIBUTE.CPU;
		case 8:
			return PRODUCT_ATTRIBUTE.MAINBOARD;
		case 9:
			return PRODUCT_ATTRIBUTE.RAM;
		case 10:
			return PRODUCT_ATTRIBUTE.STORAGE;
		case 11:
			return PRODUCT_ATTRIBUTE.GRAPHIC_CARD;
		case 12:
			return PRODUCT_ATTRIBUTE.POWER_SUPPLY;
		case 13:
			return PRODUCT_ATTRIBUTE.CASE;
		case 14:
			return PRODUCT_ATTRIBUTE.COOLING;
		case 15:
			return PRODUCT_ATTRIBUTE.USB;
		case 16:
			return PRODUCT_ATTRIBUTE.OTHER;
		default:
			return PRODUCT_ATTRIBUTE.OTHER;
		}
	}

}
