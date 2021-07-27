package com.luzhikun.domain;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class User {

    private Integer id;
    private String username;
    private int money;
    
    public User() {
    }

    public User(Integer id, String username, int money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
