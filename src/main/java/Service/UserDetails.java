package Service;

import DAO.OrderRepository;
import DAO.UserRepository;
import Model.Order;
import Model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDetails {
    UserRepository ur;
    OrderRepository or;
    CustomerDetails cd;

    public UserDetails() throws SQLException {
        ur = new UserRepository();
    }

    public List<User> getAllUsers() {
        return ur.getAllUsers();

        }
}


