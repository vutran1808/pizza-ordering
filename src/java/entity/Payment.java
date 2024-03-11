/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Payment {
    
    private int payment_id;
    private int user_id;
    private int order_id;
    private int amount;
    private String payment_type;
    private Date create_date;

    public Payment() {
    }

    public Payment(int payment_id, int user_id, int order_id, int amount, String payment_type, Date create_date) {
        this.payment_id = payment_id;
        this.user_id = user_id;
        this.order_id = order_id;
        this.amount = amount;
        this.payment_type = payment_type;
        this.create_date = create_date;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Payment{" + "payment_id=" + payment_id + ", user_id=" + user_id + ", order_id=" + order_id + ", amount=" + amount + ", payment_type=" + payment_type + ", create_date=" + create_date + '}';
    }
    
}
