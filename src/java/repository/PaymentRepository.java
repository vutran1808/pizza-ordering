/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class PaymentRepository {

    public boolean addPayment(int user_id, int order_id, int amount, String payment_type) {
        Connection connection = SQLConnection.getConnection();
        int isSuccess = 0;

        try {
            String query = "insert into payment(user_id, order_id, amount, payment_type) values(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, order_id);
            preparedStatement.setInt(3, amount);
            preparedStatement.setString(4, payment_type);
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
}
