package com.luzhikun.domain;

/**
 * @Author Rookie Coder
 * @Description 商品分类
 * @Date
 **/
public class Goods_Category {

    // 分类ID
    private Integer CATE_ID;
    // 分类名称
    private String CATE_NAME;
    // 分类父id
    private int CATE_PARENT_ID;

    public Goods_Category(Integer CATE_ID, String CATE_NAME, int CATE_PARENT_ID) {
        this.CATE_ID = CATE_ID;
        this.CATE_NAME = CATE_NAME;
        this.CATE_PARENT_ID = CATE_PARENT_ID;
    }

    public Goods_Category(String CATE_NAME, int CATE_PARENT_ID) {
        this.CATE_NAME = CATE_NAME;
        this.CATE_PARENT_ID = CATE_PARENT_ID;
    }

    public Goods_Category() {
    }

    public Integer getCATE_ID() {
        return CATE_ID;
    }

    public void setCATE_ID(Integer CATE_ID) {
        this.CATE_ID = CATE_ID;
    }

    public String getCATE_NAME() {
        return CATE_NAME;
    }

    public void setCATE_NAME(String CATE_NAME) {
        this.CATE_NAME = CATE_NAME;
    }

    public int getCATE_PARENT_ID() {
        return CATE_PARENT_ID;
    }

    public void setCATE_PARENT_ID(int CATE_PARENT_ID) {
        this.CATE_PARENT_ID = CATE_PARENT_ID;
    }

    @Override
    public String toString() {
        return "Goods_Category{" +
                "CATE_ID=" + CATE_ID +
                ", CATE_NAME='" + CATE_NAME + '\'' +
                ", CATE_PARENT_ID=" + CATE_PARENT_ID +
                '}';
    }
}
