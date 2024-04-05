package com.ohgiraffers.section03.remix;



import java.util.List;

public interface MenuMapper {


    //반환형           키값
    List<MenuDTO> selectAllMenu();
    //
    MenuDTO selectMenuByCode(int code);

    int registMenu(MenuDTO menu);

    int modifyMenu(MenuDTO menu);


    int deleteMenu(MenuDTO menu);
}
