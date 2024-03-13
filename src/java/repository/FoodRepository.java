/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.SQLConnection;
import entity.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class FoodRepository {

    public List<Food> getFoodbyMenu(int type) {
        Connection connection = SQLConnection.getConnection();
        List<Food> foodList = new ArrayList<>();

        try {
            String query = "select * from food where menu_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, type);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                Food food = new Food();
                food.setFood_id(rsSet.getInt("food_id"));
                food.setFood_name(rsSet.getString("food_name"));
                food.setFood_img(rsSet.getString("food_img"));
                food.setPrice(rsSet.getInt("price"));
                foodList.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return foodList;
    }

    public Food getFoodbyId(int id) {
        Connection connection = SQLConnection.getConnection();
        Food food = new Food();

        try {
            String query = "select * from food where food_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                food.setFood_id(rsSet.getInt("food_id"));
                food.setFood_name(rsSet.getString("food_name"));
                food.setFood_img(rsSet.getString("food_img"));
                food.setPrice(rsSet.getInt("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return food;
    }
}
