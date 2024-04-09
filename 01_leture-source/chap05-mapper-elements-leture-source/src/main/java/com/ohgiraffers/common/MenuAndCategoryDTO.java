package com.ohgiraffers.common;

import jdk.jfr.Category;

import java.util.List;

public class MenuAndCategoryDTO {

    private int code;
    private String name;
    private int price;
    private CategoryDTO category; // List<CategoryDTO> 복합 연관 관계라서 리스트로 해줌(컬렉션)
    private String orderableStatus;

    // DTO를 여러개 만들어 놓으면 좋음 쓸 수 있는
    // 한 곳에 DTO가 몰려있으면 에러가 날 수 있는데 에러가나면 어디서 에러가 났는지 알기가 힘듬

    public MenuAndCategoryDTO() {}

    public MenuAndCategoryDTO(int code, String name, int price, CategoryDTO category, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
