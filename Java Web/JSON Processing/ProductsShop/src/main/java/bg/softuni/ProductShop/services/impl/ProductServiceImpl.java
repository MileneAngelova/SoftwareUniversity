package bg.softuni.ProductShop.services.impl;

import bg.softuni.ProductShop.models.dto.ProductPrintDTO;
import bg.softuni.ProductShop.repositories.ProductRepository;
import bg.softuni.ProductShop.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductPrintDTO> printProductInRangeWhereBuyerIsNull() {
        BigDecimal minPrice = BigDecimal.valueOf(500);
        BigDecimal maxPrice = BigDecimal.valueOf(1000);

        return this.productRepository.findAllByPriceBetweenAndBuyerIdIsNullOrderByPriceAsc(minPrice, maxPrice)
                .stream().map(p -> {
                    ProductPrintDTO productPrintDTO = this.modelMapper.map(p, ProductPrintDTO.class);

                    productPrintDTO.setSellerFullName(String.format("%s %s", p.getSellerId().getFirstName(), p.getSellerId().getLastName()));
                    return productPrintDTO;
                }).collect(Collectors.toList());


    }
}
