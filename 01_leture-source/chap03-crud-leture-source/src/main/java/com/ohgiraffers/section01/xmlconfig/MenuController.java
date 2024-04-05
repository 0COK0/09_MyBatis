package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintReult printReult;
    private final MenuService menuService;

    public MenuController() {

        printReult = new PrintReult();
        menuService = new MenuService();

    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null) {
            printReult.printMenuList(menuList);

        } else {
            printReult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null) {
            printReult.printMenu(menu);
        } else {
            printReult.printErrorMessage("selectOne");
        }


    }

    public void registMenu(Map<String, String> parameter) {
        String name = parameter.get("name");
        //int를 정수로 변환 - 기본형 값이 아닌 객체로 저장해야할 때
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)) {
            printReult.printSuccessMessage("insert");
        } else {
            printReult.printErrorMessage("insert");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.modifyMenu(menu)) {
            printReult.printSuccessMessage("correction");
        } else {
            printReult.printErrorMessage("correction");
        }


    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);

        if (menuService.deleteMenu(menu)) {
            printReult.printSuccessMessage("delete");
        } else {
            printReult.printErrorMessage("delete");
        }

    }
}



