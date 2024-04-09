package com.ohgiraffer.section01.xml;

import java.util.List;


public class EmployeeController {


    private final PrintResult printResult;
    private final EmployeeService employeeService;

    public EmployeeController() {
        printResult = new PrintResult();
        employeeService = new EmployeeService();


    }

    public void selectAllView() {

        List<EmployeeDTO> employeeList = employeeService.selectAllView();

        if (employeeList != null) {
            printResult.printEmployeeList(employeeList);

        } else {
            printResult.printEmployeeMessage("selectList");
        }
    }

}
