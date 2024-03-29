package com.luzhikun.domain;

/**
 * @Author Rookie Coder
 * @Description 商品
 * @Date
 **/
public class Goods_Product {

    // 商品编号
    private int PRODUCT_ID;
    // 商品的名称
    private String PRODUCT_NAME;
    // 商品描述
    private String PRODUCT_DESCRIPTION;
    // 商品价格
    private int PRODUCT_PRICE;
    // 商品库存
    private int PRODUCT_STOCK;
    // 商品的父id
    private int PRODUCT_FID;
    // 商品的子id
    private int PRODUCT_CID;
    // 商品的文件名称
    private String PRODUCT_FILENAME;

    public Goods_Product() {
    }

    public Goods_Product(int PRODUCT_ID, String PRODUCT_NAME,
                         String PRODUCT_DESCRIPTION, int PRODUCT_PRICE,
                         int PRODUCT_STOCK, int PRODUCT_FID, int PRODUCT_CID,
                         String PRODUCT_FILENAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_FID = PRODUCT_FID;
        this.PRODUCT_CID = PRODUCT_CID;
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public int getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(int PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public int getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(int PRODUCT_STOCE) {
        this.PRODUCT_STOCK = PRODUCT_STOCE;
    }

    public int getPRODUCT_FID() {
        return PRODUCT_FID;
    }

    public void setPRODUCT_FID(int PRODUCT_FID) {
        this.PRODUCT_FID = PRODUCT_FID;
    }

    public int getPRODUCT_CID() {
        return PRODUCT_CID;
    }

    public void setPRODUCT_CID(int PRODUCT_CID) {
        this.PRODUCT_CID = PRODUCT_CID;
    }

    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }

    public void setPRODUCT_FILENAME(String PRODUCT_FILENAME) {
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    @Override
    public String toString() {
        return "Goods_Product{" +
                "PRODUCT_ID=" + PRODUCT_ID +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                ", PRODUCT_DESCRIPTION='" + PRODUCT_DESCRIPTION + '\'' +
                ", PRODUCT_PRICE=" + PRODUCT_PRICE +
                ", PRODUCT_STOCK=" + PRODUCT_STOCK +
                ", PRODUCT_FID=" + PRODUCT_FID +
                ", PRODUCT_CID=" + PRODUCT_CID +
                ", PRODUCT_FILENAME='" + PRODUCT_FILENAME + '\'' +
                '}';
    }
}
