package com.example.springweb.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.springweb.entity.Users}
 */
public class UsersDto implements Serializable {
    private final int id;
    private final int age;
    private final String email;
    private final String role;
    private final String password;
    private final int basket_id;

    public UsersDto(int id, int age, String email, String role, String password, int basket_id) {
        this.id = id;
        this.age = age;
        this.email = email;
        this.role = role;
        this.password = password;
        this.basket_id = basket_id;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public int getBasket_id() {
        return basket_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDto entity = (UsersDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.role, entity.role) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.basket_id, entity.basket_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, email, role, password, basket_id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "age = " + age + ", " +
                "email = " + email + ", " +
                "role = " + role + ", " +
                "password = " + password + ", " +
                "basket_id = " + basket_id + ")";
    }
}