/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class FoodCategoryDetail {
    private int food_id;
    private int cate_id;

    public FoodCategoryDetail() {
    }

    public FoodCategoryDetail(int food_id, int cate_id) {
        this.food_id = food_id;
        this.cate_id = cate_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }
    
    
}
