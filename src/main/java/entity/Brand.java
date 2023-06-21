package entity;

import java.util.Objects;

public class Brand {
    private int brand_id;
    private String name;

    public Brand() {

    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return brand_id == brand.brand_id && Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand_id, name);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", name='" + name + '\'' +
                '}';
    }
}

