package DAO;

import Model.Customer;
import Model.Order;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    Connection conn = ConnectionUtil.getConnection();

    public CustomerRepository() {
        conn = ConnectionUtil.getConnection();
    }

    public int getCustomerIdFromName(String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from customer where name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return -1;
    }

    public void addCustomer(Customer c) {
        List<Customer> customer = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("insert into customer(id, name, petname)" + "values(?, ?, ?)");
            statement.setInt(1, c.getId());
            statement.setString(2, c.getName());
            statement.setString(3, c.getPetname());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getOrderByID(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from customer where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("petname"));
                return c;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From customer");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer loadedOrder = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("petname"));
                allCustomers.add(loadedOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }
}

