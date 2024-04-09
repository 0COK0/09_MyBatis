package com.ohgiraffer.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffer.section01.xml.Template.getSqlSession;

public class EmployeeService {

    public List<EmployeeDTO> selectAllView() {

        SqlSession sqlSession = getSqlSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = employeeMapper.selectAllView();

        sqlSession.close();

        return employeeList;


    }
}
