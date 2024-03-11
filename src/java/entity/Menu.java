/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Menu {
    private int menu_id;
    private int menu_title;

    public Menu() {
    }

    public Menu(int menu_id, int menu_title) {
        this.menu_id = menu_id;
        this.menu_title = menu_title;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(int menu_title) {
        this.menu_title = menu_title;
    }
    
}
