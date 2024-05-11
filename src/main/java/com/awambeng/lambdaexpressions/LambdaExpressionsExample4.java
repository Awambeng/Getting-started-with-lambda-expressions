package com.awambeng.lambdaexpressions;

import java.math.BigDecimal;
import java.util.List;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

public class LambdaExpressionsExample4 {

    public static boolean isOverPaid(Employee employee){
        return employee.getSalary().compareTo(new BigDecimal(12000000)) > 0;
    }
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployeeList();

        employees.removeIf(LambdaExpressionsExample4::isOverPaid);
    }
}
