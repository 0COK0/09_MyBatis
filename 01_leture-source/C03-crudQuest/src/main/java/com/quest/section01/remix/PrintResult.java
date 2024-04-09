package com.quest.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PrintResult {
    public void printEmployeeList(List<EmployeeDTO> employeeList) {
        for(EmployeeDTO employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "직원 조회를 실패하셨습니다.";break;
            case "selectOne" : errorMessage = "직원 검색에 실패하셨습니다";break;
            case "insert" : errorMessage = "사원 추가에 실패 하셨습니다.";break;
        }

        System.out.println(errorMessage);


    }

    public void printEmployee(EmployeeDTO employee) {
        System.out.println(employee);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "insert" : successMessage = "사원이 추가 되었습니다.";break;
        }
    }
}
