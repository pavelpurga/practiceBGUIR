package entity;

import java.util.Objects;

public class Product_type_brand {
    private int product_id;
    private int type_id;
    private int brand_id;

    public Product_type_brand(){

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_type_brand that = (Product_type_brand) o;
        return product_id == that.product_id && type_id == that.type_id && brand_id == that.brand_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, type_id, brand_id);
    }

    @Override
    public String toString() {
        return "Product_type_brand{" +
                "product_id=" + product_id +
                ", type_id=" + type_id +
                ", brand_id=" + brand_id +
                '}';
    }
}
