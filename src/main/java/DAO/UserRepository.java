package DAO;

import Model.Order;
import Model.User;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    Connection conn;
    public UserRepository() {
        conn = ConnectionUtil.getConnection();
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From users");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User loadedUser= new User(rs.getString("username"), rs.getString("password"));
                allUsers.add(loadedUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }
}
