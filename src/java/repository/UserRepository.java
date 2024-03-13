/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.SQLConnection;
import entity.User;
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

    public UserInfo getUserbyAccount(String username, String password) {
        Connection connection = SQLConnection.getConnection();
        User user = new User();
        UserInfo userInfo = new UserInfo();
        try {
            String query = "select * from users u inner join user_info i on u.user_id = i.user_id where username = ? and password = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                user.setUser_id(rsSet.getInt("user_id"));
                user.setUsername(rsSet.getString("username"));
                user.setPassword(rsSet.getString("password"));
                userInfo.setFirstname(rsSet.getString("firstname"));
                userInfo.setLastname(rsSet.getString("lastname"));
                userInfo.setCity(rsSet.getString("city"));
                userInfo.setStreet(rsSet.getString("street"));
                userInfo.setPhone(rsSet.getString("phone"));
                userInfo.setUser(user);
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
    
    public User getUserById(int id) {
        Connection connection = SQLConnection.getConnection();
        User user = new User();
        try {
            String query = "select * from users where user_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                user.setUser_id(rsSet.getInt("user_id"));
                user.setUsername(rsSet.getString("username"));
                user.setPassword(rsSet.getString("password"));
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
        return user;
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

    public boolean updateUserInfo(UserInfo userInfo) {
        Connection connection = SQLConnection.getConnection();
        int isSuccessful = 0;

        try {
            String query = "update user_info set firstname = ? , lastname = ? , city = ?, street = ?, phone = ? where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userInfo.getFirstname());
            preparedStatement.setString(2, userInfo.getLastname());
            preparedStatement.setString(3, userInfo.getCity());
            preparedStatement.setString(4, userInfo.getStreet());
            preparedStatement.setString(5, userInfo.getPhone());
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

    public static void main(String[] args) {
    }

}
