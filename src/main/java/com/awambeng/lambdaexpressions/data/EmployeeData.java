package com.awambeng.lambdaexpressions.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    private static final List<Employee> EMPLOYEE_LIST = Arrays.asList(
        new Employee("Hush", 23, Department.DIGITAL, new BigDecimal(9000000)),
        new Employee("Blessing", 18, Department.DIGITAL, new BigDecimal(19000000)),
        new Employee("Bolan", 20, Department.DIGITAL, new BigDecimal(1000000))
    );

    public static List<Employee> getEmployeeList() {
        return new ArrayList<>(EMPLOYEE_LIST);
    }
}
