package DAO;
import org.apache.log4j.Logger;
import Model.Order;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    Connection conn;

    public OrderRepository() {
        conn = ConnectionUtil.getConnection();
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From orderdb");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order loadedOrder = new Order(rs.getInt("order_id"), rs.getString("protein"),
                        rs.getInt("price"), rs.getInt("yearorder"), rs.getInt("customerID"));
                allOrders.add(loadedOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOrders;
    }

    public List<Order> getAllOrdersByCustomerID(int id) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from customer inner join on orderdb.customerID = customer.id= ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order loadedOrder = new Order(rs.getInt("order_id"), rs.getString("protein"),
                        rs.getInt("price"), rs.getInt("yearorder"), rs.getInt("customerID"));
                orders.add(loadedOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orders;
    }

    public List<Order> getAllOrdersByYear(int year) {
        List<Order> OrdersByYear = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From orderdb where yearorder = ?");
            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order loadedOrder = new Order(rs.getInt("order_id"), rs.getString("protein"),
                        rs.getInt("price"), (rs.getInt("yearorder")), (rs.getInt("customerID")));
                OrdersByYear.add(loadedOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OrdersByYear;
    }

    public void addOrder(Order r) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("insert into orderdb (order_id, protein, price, yearorder, customerID)"
                    + "values(?, ?, ?, ?, ?)");
            statement.setInt(1, r.getId());
            statement.setString(2, r.getProtein());
            statement.setFloat(3, r.getPrice());
            statement.setInt(4, r.getYearorder());
            statement.setInt(5, r.getCustomerID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getOrderByID(int order_id) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from orderdb where order_id = ?");
            statement.setInt(1, order_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("order_id"), rs.getString("protein"),
                        rs.getInt("price"), rs.getInt("yearorder"), rs.getInt("customerID"));
                return o;
            }
        } catch (SQLException e) {

        }
        return null;
     }

     public void removeOrder(int order_id){
         try {
             PreparedStatement statement = conn.prepareStatement("Delete from orderdb where order_id = ?");
             statement.setInt(1, order_id);
                 statement.executeUpdate();
                 Logger log = Logger.getLogger(OrderRepository.class);
                 log.info("Order remove Completed");
         } catch (SQLException e) {
             e.printStackTrace();
         }

     }
}

