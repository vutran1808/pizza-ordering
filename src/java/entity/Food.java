/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Food {
    
    private int food_id;
    private String food_name;
    private String food_img;
    private int price;
    private int menu_id;

    public Food() {
    }

    public Food(int food_id, String food_name, String food_img, int price, int menu_id) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_img = food_img;
        this.price = price;
        this.menu_id = menu_id;
    }
    
    public Food(String food_name, String food_img, int price, int menu_id) {
        this.food_name = food_name;
        this.food_img = food_img;
        this.price = price;
        this.menu_id = menu_id;
    }
    
    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_img() {
        return food_img;
    }

    public void setFood_img(String food_img) {
        this.food_img = food_img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public String toString() {
        return "Food{" + "food_id=" + food_id + ", food_name=" + food_name + ", food_img=" + food_img + ", price=" + price + ", menu_id=" + menu_id + '}';
    }
    
    
}
