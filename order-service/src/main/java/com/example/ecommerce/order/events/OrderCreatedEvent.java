package com.example.ecommerce.order.events;
import java.io.Serializable;
public class OrderCreatedEvent implements Serializable {
    private String orderId;
    private String userId;
    private double total;
    // getters and setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
