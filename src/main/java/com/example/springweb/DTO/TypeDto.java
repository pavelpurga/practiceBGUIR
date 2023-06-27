package com.example.springweb.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.example.springweb.entity.Type}
 */
public class TypeDto implements Serializable {
    private  Integer type_id;
    private  String name;

    public TypeDto(){

    }
    public TypeDto(Integer type_id, String name, List<ProductDto> products) {
        this.type_id = type_id;
        this.name = name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public String getName() {
        return name;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDto entity = (TypeDto) o;
        return Objects.equals(this.type_id, entity.type_id) &&
                Objects.equals(this.name, entity.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type_id, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "type_id = " + type_id + ", " +
                "name = " + name ;
    }
}