package project.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String brand;
    private String model;
    private Year year;
    private BigDecimal price;
    private int horsePower;
    private CategoryEnum category;
    private EuroStandardEnum euroStandard;
    private TypeEngineEnum typeEngine;
    private TransmissionTypeEnum transmissionType;
    private int maxKm;
    private String color;
    private String region;
    private String city;
    private Ad ad;

    public Car() {
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year")
    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "horse_power")
    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Column(name = "euro_standard")
    @Enumerated(EnumType.STRING)
    public EuroStandardEnum getEuroStandard() {
        return euroStandard;
    }

    public void setEuroStandard(EuroStandardEnum euroStandard) {
        this.euroStandard = euroStandard;
    }

    @Column(name = "type_engine")
    @Enumerated(EnumType.STRING)
    public TypeEngineEnum getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(TypeEngineEnum typeEngine) {
        this.typeEngine = typeEngine;
    }

    @Column(name = "transmission_type")
    @Enumerated(EnumType.STRING)
    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Column(name = "max_km")
    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne
    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
