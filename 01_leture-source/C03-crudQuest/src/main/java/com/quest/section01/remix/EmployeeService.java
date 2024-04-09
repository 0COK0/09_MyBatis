package com.quest.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.quest.section01.remix.Template.getSqlSession;

public class EmployeeService {



    public List<EmployeeDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = employeeMapper.selectAllMenu();

        sqlSession.close();

        return employeeList;
    }
    public EmployeeDTO selectSearchEmployee(int empId) {

        SqlSession sqlSession = getSqlSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

//        System.out.println(employeeMapper); 잘들어갔나 체크한거랍니다.

        EmployeeDTO employee = employeeMapper.selectSearchEmployee(empId);

        sqlSession.close();

        return employee;
    }

    public boolean registEmployee(EmployeeDTO employee) {

        SqlSession sqlSession = getSqlSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.registEmployee(employee);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result > 0? true: false;
    }
}
