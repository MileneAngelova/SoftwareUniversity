package bg.softuni.ProductShop.services;

import bg.softuni.ProductShop.models.dto.ProductPrintDTO;

import java.util.List;

public interface ProductService {
    List<ProductPrintDTO> printProductInRangeWhereBuyerIsNull();
}
