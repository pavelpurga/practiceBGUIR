package dao;

import entity.Brand;
import entity.Product;
import entity.Product_type_brand;
import entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    //create
    void add(Product product) throws SQLException;
    //read
    void searchAll() throws SQLException;
    Product getByName(String name);

    //update
    void update (Product product, Type type, Brand brand) throws SQLException;

    //search
    void search (Product product) throws SQLException;
    //delete
    void remove(Product product) throws SQLException;
    boolean correctInput(Product product) throws SQLException;
}
