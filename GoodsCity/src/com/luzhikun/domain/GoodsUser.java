package com.luzhikun.domain;

import java.util.Objects;

/**
 * @Author Rookie Coder
 * @Description 用户表
 * @Date
 **/
public class GoodsUser {
    // 用户名
    private String USER_ID;
    // 姓名
    private String USER_NAME;
    // 密码
    private String  USER_PASSWORD;
    // 用户性别
    private String  USER_SEX;
    // 用户生日
    private String  USER_BIRTHDAY;
    // 空闲字段
    private String USER_IDENITY_CODE;
    private String  USER_EMAIL;
    // 用户电话号码
    private String USER_MOBILE;
    private String  USER_ADDRESS;
    // 用户的状态名
    private int USER_STATUS;

    public GoodsUser() {
    }

    public GoodsUser(String USER_ID, String USER_NAME, String USER_PASSWORD, String USER_SEX, String USER_BIRTHDAY,
                     String USER_IDENITY_CODE, String USER_EMAIL, String USER_MOBILE, String USER_ADDRESS,
                     int USER_STATUS) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASSWORD = USER_PASSWORD;
        this.USER_SEX = USER_SEX;
        this.USER_BIRTHDAY = USER_BIRTHDAY;
        this.USER_IDENITY_CODE = USER_IDENITY_CODE;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_MOBILE = USER_MOBILE;
        this.USER_ADDRESS = USER_ADDRESS;
        this.USER_STATUS = USER_STATUS;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_SEX() {
        return USER_SEX;
    }

    public void setUSER_SEX(String USER_SEX) {
        this.USER_SEX = USER_SEX;
    }

    public String getUSER_BIRTHDAY() {
        return USER_BIRTHDAY;
    }

    public void setUSER_BIRTHDAY(String USER_BIRTHDAY) {
        this.USER_BIRTHDAY = USER_BIRTHDAY;
    }

    public String getUSER_IDENITY_CODE() {
        return USER_IDENITY_CODE;
    }

    public void setUSER_IDENITY_CODE(String USER_IDENITY_CODE) {
        this.USER_IDENITY_CODE = USER_IDENITY_CODE;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public String getUSER_MOBILE() {
        return USER_MOBILE;
    }

    public void setUSER_MOBILE(String USER_MOBILE) {
        this.USER_MOBILE = USER_MOBILE;
    }

    public String getUSER_ADDRESS() {
        return USER_ADDRESS;
    }

    public void setUSER_ADDRESS(String USER_ADDRESS) {
        this.USER_ADDRESS = USER_ADDRESS;
    }

    public int getUSER_STATUS() {
        return USER_STATUS;
    }

    public void setUSER_STATUS(int USER_STATUS) {
        this.USER_STATUS = USER_STATUS;
    }

    @Override
    public String toString() {
        return "GoodsUser{" +
                "USER_ID='" + USER_ID + '\'' +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PASSWORD='" + USER_PASSWORD + '\'' +
                ", USER_SEX='" + USER_SEX + '\'' +
                ", USER_BIRTHDAY='" + USER_BIRTHDAY + '\'' +
                ", USER_IDENITY_CODE='" + USER_IDENITY_CODE + '\'' +
                ", USER_EMAIL='" + USER_EMAIL + '\'' +
                ", USER_MOBILE='" + USER_MOBILE + '\'' +
                ", USER_ADDRESS='" + USER_ADDRESS + '\'' +
                ", USER_STATUS=" + USER_STATUS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsUser)) return false;
        GoodsUser goodsUser = (GoodsUser) o;
        return getUSER_STATUS() == goodsUser.getUSER_STATUS() &&
                Objects.equals(getUSER_ID(), goodsUser.getUSER_ID()) &&
                Objects.equals(getUSER_NAME(), goodsUser.getUSER_NAME()) &&
                Objects.equals(getUSER_PASSWORD(), goodsUser.getUSER_PASSWORD()) &&
                Objects.equals(getUSER_SEX(), goodsUser.getUSER_SEX()) &&
                Objects.equals(getUSER_BIRTHDAY(), goodsUser.getUSER_BIRTHDAY()) &&
                Objects.equals(getUSER_IDENITY_CODE(), goodsUser.getUSER_IDENITY_CODE()) &&
                Objects.equals(getUSER_EMAIL(), goodsUser.getUSER_EMAIL()) &&
                Objects.equals(getUSER_MOBILE(), goodsUser.getUSER_MOBILE()) &&
                Objects.equals(getUSER_ADDRESS(), goodsUser.getUSER_ADDRESS());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUSER_ID(), getUSER_NAME(), getUSER_PASSWORD(), getUSER_SEX(), getUSER_BIRTHDAY(), getUSER_IDENITY_CODE(), getUSER_EMAIL(), getUSER_MOBILE(), getUSER_ADDRESS(), getUSER_STATUS());
    }
}
