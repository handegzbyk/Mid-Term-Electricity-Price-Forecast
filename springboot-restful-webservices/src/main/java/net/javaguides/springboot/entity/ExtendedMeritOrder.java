package net.javaguides.springboot.entity;

public class ExtendedMeritOrder {
    private long id;
    private String name;
    private String fuelType;
    private Float capacity;
    private Float op;
    private Float production;
    private Float price;
    private Float sfkCapacity;
    private Float processedValue;

    public ExtendedMeritOrder(long id, String name, String fuelType, Float capacity, Float op, Float production, Float price, Float sfkCapacity, Float processedValue) {
        this.id = id;
        this.name = name;
        this.fuelType = fuelType;
        this.capacity = capacity;
        this.op = op;
        this.production = production;
        this.price = price;
        this.sfkCapacity = sfkCapacity;
        this.processedValue = processedValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Float getCapacity() {
        return capacity;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    public Float getOp() {
        return op;
    }

    public void setOp(Float op) {
        this.op = op;
    }

    public Float getProduction() {
        return production;
    }

    public void setProduction(Float production) {
        this.production = production;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSfkCapacity() {
        return sfkCapacity;
    }

    public void setSfkCapacity(Float sfkCapacity) {
        this.sfkCapacity = sfkCapacity;
    }

    public Float getProcessedValue() {
        return processedValue;
    }

    public void setProcessedValue(Float processedValue) {
        this.processedValue = processedValue;
    }
}
