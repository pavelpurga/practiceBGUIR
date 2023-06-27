package com.example.springweb.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.example.springweb.entity.Brand}
 */
public class BrandDto implements Serializable {
    private  Integer brand_id;
    private  String name;

    public BrandDto(){

    }
    public BrandDto(Integer brand_id, String name, List<ProductDto> products) {
        this.brand_id = brand_id;
        this.name = name;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public String getName() {
        return name;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandDto entity = (BrandDto) o;
        return Objects.equals(this.brand_id, entity.brand_id) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand_id, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "brand_id = " + brand_id + ", " +
                "name = " + name ;
    }
}