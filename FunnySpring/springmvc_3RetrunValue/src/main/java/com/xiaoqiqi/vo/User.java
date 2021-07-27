package com.xiaoqiqi.vo;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class User {

    private String cusername;
    private String cpassword;

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public User(String cusername, String cpassword) {
        this.cusername = cusername;
        this.cpassword = cpassword;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "cusername='" + cusername + '\'' +
                ", cpassword='" + cpassword + '\'' +
                '}';
    }
}
