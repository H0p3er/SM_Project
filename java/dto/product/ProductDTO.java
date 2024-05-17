package dto.product;

import entity.ProductObject;

public interface ProductDTO<Product_Attribute> {
    public void ApplyToEntity(ProductObject productObject);
}
