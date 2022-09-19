
import Model.Customer;
import Model.Order;
import Model.User;
import Service.UserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import Service.CustomerDetails;
import Service.OrderDetails;

import java.sql.SQLException;


public class SystemFetchAPI {
    public static void main(String[] args) throws SQLException {
        OrderDetails od = new OrderDetails();
        CustomerDetails cd = new CustomerDetails();
        UserDetails ud = new UserDetails();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        app.start(9000);
        // we're passing in the expected  behavior to the web request into the method get
        // ctx.result returns a http response
        // ctx.pathParam grabs the param surrounded by curly braces in app.get
        //for our http response, return the result of ordersdetails getAllOrders(name) as a string


        app.get("/orders/", ctx -> {
            ctx.json(od.getAllOrders());
        });
        app.get("/customers/", ctx -> {
            ctx.json(cd.getAllCustomers());
        });

        app.get("/orders/orderbyyear/{year}", ctx -> {
            ctx.json(od.getAllOrdersByYear(Integer.parseInt(ctx.pathParam("year"))));
            //convert a string to int
        });

        app.get("/customer/{id}", ctx -> {
            ctx.json(cd.getCustomerFromId(Integer.parseInt(ctx.pathParam("id"))));
        });
        app.get("/user/", ctx -> {
            ctx.json(ud.getAllUsers());
        });

        app.post("orders", ctx ->{
        ObjectMapper mapper = new ObjectMapper();
        Order requestOrder = mapper.readValue(ctx.body(), Order.class);
        od.addOrder(requestOrder.getOrder_id(), requestOrder.getProtein(), requestOrder.getPrice(),
                requestOrder.getYearorder(), requestOrder.getCustomerID());
        });
        app.delete("orders", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Order requestOrder = mapper.readValue(ctx.body(), Order.class);
            od.removeOrder(requestOrder.getOrder_id());
        });

        app.post("customers", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Customer requestCustomer= mapper.readValue(ctx.body(), Customer.class);
            cd.addCustomer(requestCustomer.getId(), requestCustomer.getName(), requestCustomer.getPetname());
        });

        }
    }
