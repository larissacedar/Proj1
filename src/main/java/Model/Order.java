package Model;

public class Order {
    public int order_id;
    public String protein;
    public int price;
    public int yearorder;
    public int customerID;

    public Order(){

    }

    public Order(int order_id, String protein, int price, int yearorder, int customerID) {
        this.order_id = order_id;
        this.protein = protein;
        this.price = price;
        this.yearorder = yearorder;
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "order_id: " + order_id + ", type of food: " + protein + ", price: " + price + ", yearorder: " + yearorder + ", customerID: " + customerID + "\n";
    }
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearorder() {
        return yearorder;
    }

    public void setYearorder(int yearorder) {
        this.yearorder = yearorder;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int setCustomerID(int customerID) {
        this.customerID = customerID;

        return customerID;
    }
}
