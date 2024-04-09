package com.ohgiraffer.section01.xml;

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
                case 1 : employeeController.selectAllView();break;
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 9 :
                    System.out.println("프로그램을 종료합니다."); return;
            }
        } while (true);
    }

}
