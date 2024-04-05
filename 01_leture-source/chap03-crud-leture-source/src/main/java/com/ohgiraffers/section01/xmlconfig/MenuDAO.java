package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.modifyMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.delete("MenuMapper.deleteMenu", menu);
    }
}
