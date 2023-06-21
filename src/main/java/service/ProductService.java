package service;

import bl.Util;
import dao.ProductDAO;
import entity.Brand;
import entity.Product;
import entity.Product_type_brand;
import entity.Type;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {

    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    @Override
    public void add(Product product) throws SQLException {

        String sql = "insert into product(product.name, price, description) values(?,?,?);";
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void searchAll() throws SQLException {
        String sqlSelect = "SELECT name, price, description from product; ";
        try {
            Connection connection1 = getConnection();
            preparedStatement = connection1.prepareStatement(sqlSelect);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Product product = new Product();
                product.setName(res.getString("name"));
                product.setPrice(res.getFloat("price"));
                product.setDescription(res.getString("description"));

                System.out.println(product.getName() + "," + product.getPrice() + "," + product.getDescription());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally  {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }


    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public void update(Product product, Type type, Brand brand) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("SET SQL_SAFE_UPDATES = 0;");

        String sqlUpdate = "update product_type_brand AS ptb " +
                "INNER JOIN product AS p ON ptb.product_id = p.id " +
                "SET p.name = ?, " +
                "ptb.type_id = (SELECT type_id FROM type WHERE type.name = ?), " +
                "ptb.brand_id = (SELECT brand_id FROM brand WHERE brand.name = ?) " +
                "WHERE p.name = ?; ";
        String sqlUpdate1 =  "update product  " +
                "SET price = ?, description = ? where name = ? ;";
        try {
            PreparedStatement preparedStatementProduct = connection.prepareStatement(sqlUpdate);
            preparedStatementProduct.setString(4, product.getName());
            preparedStatementProduct.setString(1, product.getNewName());
            preparedStatementProduct.setString(2, type.getName());
            preparedStatementProduct.setString(3, brand.getName());
            preparedStatementProduct.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlUpdate1);;
            preparedStatement1.setString(3,product.getNewName());
            preparedStatement1.setFloat(1, product.getPrice());
            preparedStatement1.setString(2, product.getDescription());
            preparedStatement1.executeUpdate();
            statement.executeUpdate("SET SQL_SAFE_UPDATES = 1;");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void search(Product product) throws SQLException {
        String sqlForSearch = "select * from product where name = ?;";
        try {
            PreparedStatement statement1 = connection.prepareStatement(sqlForSearch);
            statement1.setString(1, product.getName());
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "," + resultSet.getFloat("price") + "," +
                        resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void remove(Product product) throws SQLException {
        String sqlDelete = "delete from product where name = ?;";
        PreparedStatement preparedStatementDelete = null;
        try {
            preparedStatementDelete = connection.prepareStatement(sqlDelete);
            preparedStatementDelete.setString(1, product.getName());
            preparedStatementDelete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public boolean correctInput(Product product) throws SQLException {
        String sqlForSearch = "select COUNT(*) AS count FROM product where name = ?; ";
            PreparedStatement statement1 = connection.prepareStatement(sqlForSearch);
            statement1.setString(1, product.getName());
            ResultSet resultSet = statement1.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt("count");
                return count>0;
            }
            return false;
    }
}
