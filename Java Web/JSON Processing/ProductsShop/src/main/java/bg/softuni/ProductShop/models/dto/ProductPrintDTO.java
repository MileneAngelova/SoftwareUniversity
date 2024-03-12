package bg.softuni.ProductShop.models.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductPrintDTO {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String sellerFullName;

    public ProductPrintDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }
}
