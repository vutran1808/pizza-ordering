/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Payment {
    
    private int user_id;
    private Order order;
    private int amount;
    private String payment_type;

    public Payment() {
    }

    public Payment(int user_id, Order order, int amount, String payment_type) {
        this.user_id = user_id;
        this.order = order;
        this.amount = amount;
        this.payment_type = payment_type;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    @Override
    public String toString() {
        return "Payment{" + "user_id=" + user_id + ", order=" + order + ", amount=" + amount + ", payment_type=" + payment_type + '}';
    }
}
