package com.quest.section01.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        do {
            System.out.println("======= 직원 정보 ==========");
            System.out.println("1. 직원 전체 조회");
            System.out.println("2. 직원 상세 조회");
            System.out.println("3. 직원 추가");
            System.out.println("4. 직원 정보 수정");
            System.out.println("5. 직원 탈퇴");
            System.out.println("9. 종료하기");
            System.out.print("입력할 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : employeeController.selectAllMenu();break;
                case 2 : employeeController.selectSearchEmployee(inputEmployeeId());break;
                case 3 : employeeController.registEmployee(inputEmployee());break;
                case 4 : employeeController.modifyEmployee(inputModifyEmployee());break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");return;
            }
        } while (true);
    }



    private static Map<String, String> inputEmployeeId() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직원 코드를 입력하세요 : ");
        String empId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);

        return parameter;
    }

    private static Map<String, String> inputEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("추가할 사원명을 입력해주세요 : ");
        String empName = sc.nextLine();
        System.out.print("추가할 사원의 주민번호를 입력하세요 : ");
        String empNo = sc.nextLine();
        System.out.print("추가할 사원의 이메일을 입력해주세요 : ");
        String email = sc.nextLine();
        System.out.print("추가할 사원의 전화번호를 입력해주세요 : ");
        String phone = sc.nextLine();
        System.out.print("추가할 사원의 직급을 입력해주세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("추가할 사원의 급여를 입력해주세요 : ");
        String salLevel = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empName", empName);
        parameter.put("empNo", empNo);
        parameter.put("email", email);
        parameter.put("phone", phone);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);

        return parameter;
    }

    private static Map<String, String> inputModifyEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 직원 코드를 입력하세요 : ");
        String empId = sc.nextLine();
        System.out.println("수정할 직원 이름을 수정해주세요 : ");
    }

}
