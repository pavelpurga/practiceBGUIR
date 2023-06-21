package com.pablo.database;

import bl.Util;
import entity.Brand;
import entity.Product;
import entity.Product_type_brand;
import entity.Type;
import org.w3c.dom.ls.LSOutput;
import service.ProductService;
import service.Product_type_brandService;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Util util = new Util();
        util.getConnection();
        ProductService productService = new ProductService();
        Product_type_brandService productTypeBrandService = new Product_type_brandService();
        Product product = new Product();
        Type type = new Type();
        Brand brand = new Brand();
        Product_type_brand productTypeBrand = new Product_type_brand();

        String correctSQL = "SELECT name from product; ";

        System.out.println("что желаете провернуть?\nВам доступны CRUD-функции:");
        System.out.println("1.Добавить\n2.Посмотреть\n3.Обновить информацию\n4.Удалить\n5.Выход");
        int selector = scanner.nextInt();
        scanner.nextLine();
                switch (selector) {
                    case 1:
                        System.out.println("Введите название продукта:");
                        String nameProduct = scanner.nextLine();
                        System.out.println("Введите цену продукта:");
                        int priceProduct = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Введите описание и характеристику продукта");
                        String descrProduct = scanner.nextLine();
                        product.setName(nameProduct);
                        product.setPrice(priceProduct);
                        product.setDescription(descrProduct);
                        productService.add(product);
                        break;
                    case 2:
                        System.out.println("Для просмотра всего списка напишите 'all'\nВведите название продукта, который ищете:");
                        String nameSearch = scanner.nextLine();
                        product.setName(nameSearch);
                        if(productService.correctInput(product)) {
                            productService.search(product);
                        }  else if (Objects.equals(nameSearch, "all")) {
                                productService.searchAll();

                        }else {
                            System.out.println("Такого name не существует, попробуй ещё раз");
                        }
                        break;
                    case 3:
                        System.out.println("Введите название продукта, которого хотите изменить:");
                        String nameForChanged = scanner.nextLine();
                        product.setName(nameForChanged);
                        if (productService.correctInput(product)) {
                            System.out.println("Введите новое название:");
                            String nameUpdate = scanner.nextLine();
                            System.out.println("Введите новую цену:");
                            int newPrice = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Введите новую характеристику");
                            String newDisc = scanner.nextLine();
                            System.out.println("Введите новый тип:");
                            String newType = scanner.nextLine();
                            System.out.println("Введите новый брэнд:");
                            String newBrand = scanner.nextLine();
                           // product.setName(nameForChanged);
                            product.setNewName(nameUpdate);
                            product.setPrice(newPrice);
                            product.setDescription(newDisc);
                            type.setName(newType);
                            brand.setName(newBrand);
                            productService.update(product, type, brand);
                        } else {
                            System.out.println("Продукта с таким названием не существует");
                        }
                        break;
                    case 4:
                        System.out.println("Введите название товара, который хотите удалить:");
                        String nameDelete = scanner.nextLine();
                        product.setName(nameDelete);
                        if (productService.correctInput(product)) {
                        productService.remove(product);
                        } else System.out.println("Товара с таким названием и так нет...");
                    case 5:
                        break;
                }


    }
    }

