package bg.softuni.MobiLeLeLe.Model.Entity;

import bg.softuni.MobiLeLeLe.Model.Enum.EngineEnum;
import bg.softuni.MobiLeLeLe.Model.Enum.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionEnum transmission;

    @Column(nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private
    UserEntity seller;

    public UserEntity getSeller() {
        return seller;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity() {
    }

    public OfferEntity(String description, EngineEnum engine, String imageUrl, int mileage, BigDecimal price, TransmissionEnum transmission, int year, ModelEntity model, UserEntity seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                '}';
    }
}
