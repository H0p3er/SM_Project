package dto.product;

import java.io.Serializable;

import entity.ProductObject;

public interface ProductDTO<Product_Attribute> extends Serializable{
    public void ApplyToEntity(ProductObject productObject);
}
