package Service;

import DAO.OrderRepository;
import Model.Customer;
import Model.Order;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
    OrderRepository or;
    CustomerDetails cd;

    public OrderDetails() throws SQLException {
        or = new OrderRepository();
        cd = new CustomerDetails();

    }

    public List<Order> getAllOrders() {
        return or.getAllOrders();
    }

    public List<Order> getAllOrdersByCustomerID(int id) {
        return or.getAllOrdersByCustomerID(id);
    }

    public List<Order> getAllOrdersByYear(int year) {
        return or.getAllOrdersByYear(year);
    }

    public void addOrder(int order_id, String protein, int price, int year, int id) {
        Order existingOrder = or.getOrderByID(order_id);
        if (existingOrder == null) {
            Order newOrder = new Order(order_id, protein, price, year, id);
            or.addOrder(newOrder);
        } else {
        }
    }

    public List<Order> getAllOrdersByCustomerName(String name) {
        int id = cd.getCustomerIdFromName(name);
        return or.getAllOrdersByCustomerID(id);
    }

   public void removeOrder(int order_id) {
        or.removeOrder(order_id);
   }
}



