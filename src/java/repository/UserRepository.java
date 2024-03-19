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
import java.util.ArrayList;
import java.util.List;

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

    public User checkLogin(String username, String password) {
        Connection connection = SQLConnection.getConnection();
        User user = new User();
        try {
            String query = "select * from users where username = ? and password = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
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

    public User getUserById(int id) {
        Connection connection = SQLConnection.getConnection();
        User user = null;
        try {
            PreparedStatement pst = connection.prepareStatement("select * from users where user_id = ?;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idRole = rs.getInt("role_id");
                user = new User(id, username, password, idRole);
            }
        } catch (Exception e) {
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

    public boolean updateUserInfo(int user_id, String firstname, String lastname, String city, String street, String phone) {
        Connection connection = SQLConnection.getConnection();
        int isSuccessful = 0;

        try {
            String query = "insert into user_info(firstname, lastname, city, street, phone) values( ? , ? , ?,  ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, street);
            preparedStatement.setString(5, phone);
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

    public List<UserInfo> getUserAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rsSet = null;
        List<UserInfo> userList = new ArrayList<>();
        try {
            connection = SQLConnection.getConnection();
            String query = "SELECT uf.user_id, uf.firstName, uf.lastName, uf.city, uf.street, uf.phone, u.username, u.password, u.role_id "
                    + "FROM user_info uf "
                    + "INNER JOIN users u ON uf.user_id = u.user_id";
            preparedStatement = connection.prepareStatement(query);
            rsSet = preparedStatement.executeQuery();
            while (rsSet.next()) {
                int idUserFor = rsSet.getInt("user_id");
                String firstname = rsSet.getString("firstName");
                String lastname = rsSet.getString("lastName");
                String city = rsSet.getString("city");
                String street = rsSet.getString("street");
                String phone = rsSet.getString("phone");
                // Không cần gọi UserRepository ở đây, thay vào đó bạn có thể tạo một đối tượng User trực tiếp
                User user = new User();
                user.setUser_id(idUserFor);
                user.setUsername(rsSet.getString("username"));
                user.setPassword(rsSet.getString("password"));
                user.setRole_id(rsSet.getInt("role_id"));
                UserInfo usInf = new UserInfo(user, firstname, lastname, city, street, phone);
                userList.add(usInf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rsSet != null) {
                    rsSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public boolean deleteUserById(int id) {
        Connection connection = SQLConnection.getConnection();
        int isSuccessful = 0;

        try {
            String query = "delete from user_info where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
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
    
}
