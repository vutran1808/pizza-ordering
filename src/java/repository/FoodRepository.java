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

    public void update(Food food) {
        Connection con = SQLConnection.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE food SET food_name = ?, food_img = ?, price = ?, menu_id = ? where food_id = ? ;");
            pst.setString(1, food.getFood_name());
            pst.setString(2, food.getFood_img());
            pst.setInt(3, food.getPrice());
            pst.setInt(4, food.getMenu_id());
            pst.setInt(5, food.getFood_id());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
        }
    }

    public List<Food> getFoodAll() {
        Connection connection = SQLConnection.getConnection();
        List<Food> foodList = new ArrayList<>();

        try {
            String query = "select * from food ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                Food food = new Food();
                foodList.add(new Food(rsSet.getInt("food_id"),
                        rsSet.getString("food_name"),
                        rsSet.getString("food_img"),
                        rsSet.getInt("price"),
                        rsSet.getInt("menu_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return foodList;
    }

    public Food getFoodById(int id) {
        Connection connection = SQLConnection.getConnection();
        Food food = null;
        try {
            String query = "select * from food where food_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                food = new Food(rsSet.getInt("food_id"),
                        rsSet.getString("food_name"),
                        rsSet.getString("food_img"),
                        rsSet.getInt("price"),
                        rsSet.getInt("menu_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return food;
    }

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

    public void deleteFood(int idFood) {
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("delete from food where food_id = ?");
            pst.setInt(1, idFood);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addFood(Food food) {
        Connection con = SQLConnection.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("insert into food (food_name, food_img, price,menu_id) "
                    + "values ( ? , ?,?,?)");
            pst.setString(1, food.getFood_name());
            pst.setString(2, food.getFood_img());
            pst.setInt(3, food.getPrice());
            pst.setInt(4, food.getMenu_id());
            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        FoodRepository fr = new FoodRepository();
        List<Food> foddList = fr.getFoodAll();
        for (Food f : foddList) {
            System.out.println(f.toString());
        }
    }
}
