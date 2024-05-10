package com.awambeng.lambdaexpressions;

import java.util.List;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

// print all employees sorted by salary
public class LambdaExpressionsExample1 {
    public static void main(String ... args){
        List<Employee> employees = EmployeeData.getEmployeeList();

        employees.forEach( e -> System.out.println(e));

        employees.sort((e1, e2) -> {
            return e1.getSalary().compareTo(e2.getSalary());
        });

        System.out.println("Employee List - Sorted");
        for (Employee employee : employees){
			System.out.println(employee);
		}
        
    }
}
