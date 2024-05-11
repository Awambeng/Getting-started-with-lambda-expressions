package com.awambeng.lambdaexpressions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

/**
 * problem statement:
 * Variables used in lambda expressions must be final or effecively final.
 */
public class LambdaExpressionsExample2 {
    
    @FunctionalInterface
    interface EmployeeFilter{
        boolean test(Employee employee);
    }

    public static void printEmployees(List<Employee> employees, EmployeeFilter filter){        
        for(Employee employee : employees){
            if(filter.test(employee)){
                System.out.println(employee);
            }
        }
    }

    public static long countEmployees(List<Employee> employees, Predicate<Employee> employeePredicate){
        List<Employee> filteredEmployeeList = new ArrayList<>();
        return employees.parallelStream().filter(employeePredicate).count();
        // employees.forEach(employee -> {
        //     if(filter.test(employee)){
        //         filteredEmployeeList.add(employee);
        //     }
        // });

        // return filteredEmployeeList.size();
    }
         
    public static void main(String [] args){
        List<Employee> employees = EmployeeData.getEmployeeList();
        final BigDecimal salaryLimit = new BigDecimal(10_000_000);
        System.out.println("Salary less than salaryLimit");
        System.out.println(countEmployees(employees, employee -> employee.getSalary().compareTo(salaryLimit) < 0));
        System.out.println("Salary greater than salaryLimit");
        System.out.println(countEmployees(employees, employee -> employee.getSalary().compareTo(salaryLimit) > 0));
    }
}