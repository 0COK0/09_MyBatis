package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

            menuMapper = sqlSession.getMapper(MenuMapper.class);

            List<MenuDTO> menuList = menuMapper.selectAllMenu();

            sqlSession.close();

            return menuList;
        }


    public MenuDTO selectMenuByCode(int code) {

        return null;
    }

    public boolean registMenu(MenuDTO menu) {

        return false;

    }

    public boolean modifyMenu(MenuDTO menu) {

        return false;

    }

    //public boolean deleteMenu(int code) {

    //    return false;

    //}
}
