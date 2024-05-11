package com.awambeng.lambdaexpressions;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

// practical examples of standard functional interfaces.
// search employees and fetch salary - Predicate, Function and Consumer.
public class LambdaExpressionsExample5 {

    // seraching for employees and returning an optional employee.
    static Optional<Employee> findEmployee(List<Employee> employees, Predicate<Employee> predicate){
        for(Employee employee : employees){
            if(predicate.test(employee)){
                return Optional.of(employee);   
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args){
        List<Employee> employees = EmployeeData.getEmployeeList();

        Optional<Employee> employee = findEmployee(employees, emp -> emp.getName().equals("Blesing"));

        // old way
        // if(employee.isPresent()){
        //     System.out.println(employee.get().getSalary());
        // }

        // using the functional stye.
        employee.map(Employee::getSalary).ifPresent(System.out::println);
    }
}
