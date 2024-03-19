/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.SQLConnection;
import entity.OrderDetail;
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
public class OrderRepository {

    public boolean createOrder(int user_id) {
        Connection connection = SQLConnection.getConnection();
        int isSuccess = 0;

        try {
            String query = "insert into orders(user_id) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            isSuccess = preparedStatement.executeUpdate();

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
        return isSuccess > 0;
    }

    public int getOrderId(int user_id) {
        Connection connection = SQLConnection.getConnection();
        int order_id = 0;

        try {
            String query = "select order_id from orders where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                order_id = rs.getInt("order_id");
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
        return order_id;
    }

    public boolean addOrderDetail(int order_id, int food_id, int quantity) {
        Connection connection = SQLConnection.getConnection();
        int isSuccess = 0;

        try {
            String query = "insert into order_details(order_id, food_id, quantity) values ( ?, ?, ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order_id);
            preparedStatement.setInt(2, food_id);
            preparedStatement.setInt(3, quantity);

            isSuccess = preparedStatement.executeUpdate();
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
        return isSuccess > 0;
    }

    public List<OrderDetail> getAllOrder() {
        Connection connection = SQLConnection.getConnection();
        List<OrderDetail> listOrder = new ArrayList<>();

        try {
            String query = "select * from orders o inner join order_details d on o.order_id = d.order_id";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                OrderDetail ord = new OrderDetail();
                ord.setFood_id(rs.getInt("food_id"));
                ord.setQuantity(rs.getInt("quantity"));
                listOrder.add(ord);
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
        return listOrder;
    }

}
