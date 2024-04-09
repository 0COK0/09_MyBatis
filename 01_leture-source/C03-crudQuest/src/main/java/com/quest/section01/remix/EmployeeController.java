package com.quest.section01.remix;

import java.util.List;
import java.util.Map;


public class EmployeeController {

    private final EmployeeService employeeService;
    private final PrintResult printResult;

    public EmployeeController() {

        printResult = new PrintResult();
        employeeService = new EmployeeService();
    }

    public void selectAllMenu() {

        List<EmployeeDTO> employeeList = employeeService.selectAllMenu();

        if(employeeList != null) {
            printResult.printEmployeeList(employeeList);

        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectSearchEmployee(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));

        EmployeeDTO employee = employeeService.selectSearchEmployee(empId);

        if (employee != null) {
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registEmployee(Map<String, String> parameter) {
        String empName = parameter.get("empName");
        String empNo = parameter.get("empNo");
        String email = parameter.get("email");
        String phone = parameter.get("phone");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if (employeeService.registEmployee(employee)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }
}
