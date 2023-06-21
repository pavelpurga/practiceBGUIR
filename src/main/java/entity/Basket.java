package entity;

import java.util.Objects;

public class Basket {
 private int id;
 private int product_id;
 private int user_id;

 public Basket(){

 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id && product_id == basket.product_id && user_id == basket.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_id, user_id);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                '}';
    }
}
