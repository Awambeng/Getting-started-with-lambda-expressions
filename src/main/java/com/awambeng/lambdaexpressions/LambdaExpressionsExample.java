package com.awambeng.lambdaexpressions;

import java.math.BigDecimal;
import java.util.List;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

/**
 * problem statement:
 * print employees whose salary is less than salary limit.
 */
public class LambdaExpressionsExample {
    
    @FunctionalInterface
    interface EmployeeFilter{
        boolean test(Employee employee);
    }

    // print employees with salary less than salary limit
    // public static void printEmployeeLessThan(List<Employee> employees, BigDecimal salaryLimit){
    //     for(Employee employee : employees){
    //         if(employee.getSalary().compareTo(salaryLimit) < 0){
    //             System.out.println(employee);
    //         }
    //     }
    // }

    public static void printEmployees(List<Employee> employees, EmployeeFilter filter){
        for(Employee employee : employees){
            if(filter.test(employee)){
                System.out.println(employee);
            }
        }
    }

    // printing employees with salary greater than salaryLimit
    // public static void printEmployeeGreaterThan(List<Employee> employees, BigDecimal salaryLimit){
    //     for(Employee employee : employees){
    //         if(employee.getSalary().compareTo(salaryLimit) > 0){
    //             System.out.println(employee);
    //         }
    //     }
    // }
    public static void main(String [] args){
        List<Employee> employees = EmployeeData.getEmployeeList();

        // System.out.println("Salary less than salaryLimit");
        // printEmployeeLessThan(employees, new BigDecimal(10000000));

        // System.out.println("Salary greater than salaryLimit");
        // printEmployeeGreaterThan(employees, new BigDecimal(10000000));

        System.out.println("Salary less than salaryLimit");
        printEmployees(employees, employee -> employee.getSalary().compareTo(new BigDecimal(10000000)) < 0);

        System.out.println("Salary greater than salaryLimit");
        printEmployees(employees, employee -> employee.getSalary().compareTo(new BigDecimal(10000000)) > 0);
    
    }
}
