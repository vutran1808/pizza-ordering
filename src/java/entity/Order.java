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
public class Order {
    private int order_id;
    private int user_id;
    private Date create_date;

    public Order() {
    }

    public Order(int order_id, int user_id, Date create_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.create_date = create_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", user_id=" + user_id + ", create_date=" + create_date + '}';
    }
    
}
