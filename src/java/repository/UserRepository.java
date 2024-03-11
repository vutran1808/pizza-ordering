/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.SQLConnection;
import entity.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class UserRepository {

    public boolean getUserbyAccount(String username, String password) {
        Connection connection = SQLConnection.getConnection();
        boolean isExisted = false;

        try {
            String query = "select * from users where username = ? and password = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rsSet = preparedStatement.executeQuery();
            isExisted = rsSet.next();
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
        return isExisted;
    }

    public boolean createUser(String username, String password) {
        Connection connection = SQLConnection.getConnection();
        int isSuccessful = 0;

        try {
            String query = "insert into users (username, password, role_id) values ( ? , ? , 2)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            isSuccessful = preparedStatement.executeUpdate();
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
        return isSuccessful > 0;
    }

    public UserInfo getUserByUsername(String username) {
        Connection connection = SQLConnection.getConnection();
        UserInfo userInfo = new UserInfo();

        try {
            String query = "select * from users u inner join user_info i on u.user_id = i.user_id where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userInfo.setFirstname(rs.getString("firstname"));
                userInfo.setLastname(rs.getString("lastname"));
                userInfo.setCity(rs.getString("city"));
                userInfo.setStreet(rs.getString("street"));
                userInfo.setPhone(rs.getString("phone"));
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
        return userInfo;
    }

    public static void main(String[] args) {
    }

}
