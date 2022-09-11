import Model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.apache.log4j.Logger;
import Service.CustomerDetails;
import Service.OrderDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class SystemFetchAPI {
    public static void main(String[] args) throws SQLException {
        OrderDetails od = new OrderDetails();
        CustomerDetails cd = new CustomerDetails();
        Javalin app = Javalin.create().start(9000);
        // we're passing in the expected  behavior to the web request into the method get
        // ctx.result returns a http response
        // ctx.pathParam grabs the param surrounded by curly braces in app.get
        //for our http response, return the result of ordersdetails getAllOrders(name) as a string

        app.get("/orders/", ctx -> {
            ctx.result(od.getAllOrders().toString());
        });
        app.get("/customers/", ctx -> {
            ctx.json(cd.getAllCustomers());
        });

        app.get("/orders/orderbyyear/{year}", ctx -> {
            ctx.json(od.getAllOrdersByYear(Integer.parseInt(ctx.pathParam("year"))));
            //convert a string to int
        });

        app.get("/orders/customerid/{id}", ctx -> {
            ctx.json(od.getAllOrdersByCustomerID(Integer.parseInt(ctx.pathParam("id"))));
        });

        app.post("orders", ctx ->{
        ObjectMapper mapper = new ObjectMapper();
        Order requestOrder = mapper.readValue(ctx.body(), Order.class);
        od.addOrder(requestOrder.getId(), requestOrder.getProtein(), requestOrder.getPrice(),
                requestOrder.getYearorder(), requestOrder.getCustomerID());
        });

    }
}
