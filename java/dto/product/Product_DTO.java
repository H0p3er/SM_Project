package dto.product;

import java.io.Serializable;

import entity.ProductObject;

public interface Product_DTO<Product_Attribute> extends Serializable{
    public void ApplyToEntity(ProductObject productObject);
}
