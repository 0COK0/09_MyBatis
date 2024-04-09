package com.ohgiraffer.section01.xml;

import java.util.List;

public class PrintResult {
    public PrintResult() {}

    public void printEmployeeList(List<EmployeeDTO> employeeList) {
        for(EmployeeDTO employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void printEmployeeMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "사원 목록 조회를 실패하였습니다.";break;
        }
        System.out.println(errorMessage);
    }
//    public void printSuccessMessage(String successCode) {
//
//        String successMessage = "";
//        switch (successCode) {
//
//        }
//    }

}

