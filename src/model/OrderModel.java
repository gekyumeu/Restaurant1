package model;

public class OrderModel {

    private int order_id;
    private int customer_id;
    private int menu_id;
    private int quantity;
    private String datetime_purchased;
    
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDatetime_purchased() {
        return datetime_purchased;
    }

    public void setDatetime_purchased(String datetime_purchased) {
        this.datetime_purchased = datetime_purchased;
    }
}
