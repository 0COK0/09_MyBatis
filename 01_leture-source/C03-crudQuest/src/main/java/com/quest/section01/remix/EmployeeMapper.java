package com.quest.section01.remix;

import java.util.List;

public interface EmployeeMapper {


    List<EmployeeDTO> selectAllMenu();


    EmployeeDTO selectSearchEmployee(int empId);

    int registEmployee(EmployeeDTO employee);
}
