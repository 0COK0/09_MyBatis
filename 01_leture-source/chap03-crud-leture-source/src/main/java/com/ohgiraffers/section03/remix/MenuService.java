package com.ohgiraffers.section03.remix;


import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.Template.getSqlSession;

public class MenuService {
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        System.out.println(menuMapper);

        MenuDTO menu = menuMapper.selectMenuByCode(code);

        sqlSession.close();
        return null;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.registMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result > 0? true: false;

    }

    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.modifyMenu(menu);

        if (result > 0) {
            // sqlSession에 있는 커밋이랑 롤백을 메소드를 쓰는 것.
            // 데이터 베이스에 변경사항을 확정짓는것
            sqlSession.commit();
        } else {
            //아니면 트랜잭션을 롤백, 실패하면 철회한다는 뜻
            sqlSession.rollback();
        }
// 0보다 result 가 크면 트루 아니면 폴스
        return result > 0? true: false;

    }

    public boolean deleteMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menu);




        return result > 0? true: false;
    }
}
