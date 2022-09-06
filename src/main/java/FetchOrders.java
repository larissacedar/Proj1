import org.apache.log4j.Logger;
import Service.CustomerDetails;
import Service.OrderDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class FetchOrders {
    public static void main(String[] args) throws SQLException {

        Logger logger = Logger.getLogger(FetchOrders.class);
        logger.info("Log Fetch Food System");

    //Connection conn = ConnectionUtil.getConnection();
        boolean inputInvoice = true;
        OrderDetails od = new OrderDetails();
        CustomerDetails cd = new CustomerDetails();

        while (inputInvoice) {
            System.out.println("Fetch Food System: all orders, customer id, year order, add order, add customer, cancel order, done");
            Scanner fetchInput = new Scanner(System.in);
            String line = fetchInput.nextLine();
            int id = 0;
            String name;
            if (line.equals("done")) {
                inputInvoice = false;

            } else if (line.equals("all orders")) {
                System.out.println(od.getAllOrders());
                System.out.println("all customers");
                System.out.println(cd.getAllCustomers());

            } else if (line.equals("customer id")) {
                System.out.println("name: ");
                name = fetchInput.nextLine();
                System.out.println(cd.getCustomerIdFromName(name));

            } else if (line.equals("year order")) {
                System.out.println("year order: ");
                int yearorder = fetchInput.nextInt();
                System.out.println(od.getAllOrdersByYear(yearorder));



            } else if (line.equals("add order")) {
                System.out.println("input order_id: ");
                int order_id = fetchInput.nextInt();
                System.out.println("protein: ");
                fetchInput.nextLine();
                String protein = fetchInput.nextLine();
                //fetchInput.nextLine();
                System.out.println("input price: ");
                int price = fetchInput.nextInt();
                System.out.println("input year order: ");
                int year = fetchInput.nextInt();
                System.out.println("customer id: ");
                int customerID = fetchInput.nextInt();
                od.addOrder(order_id, protein, price, year, customerID);

            } else if (line.equals("add customer")) {
                System.out.println("customer id: ");
                id = fetchInput.nextInt();
                fetchInput.nextLine();
                System.out.println("customer name: ");
                name = fetchInput.nextLine();
                System.out.println("petname: ");
                String petname = fetchInput.nextLine();
                cd.addCustomer(id, name, petname);

            } else if(line.equals("cancel order")){
                System.out.println("Order id: ");
                int order_id = fetchInput.nextInt();
                od.removeOrder(order_id);

            }

        }
    }
}
