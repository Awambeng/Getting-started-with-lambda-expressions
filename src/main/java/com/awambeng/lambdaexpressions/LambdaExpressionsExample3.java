package com.awambeng.lambdaexpressions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

// Handling exceptions in java.
// use case: Print the list of employees in a file.
public class LambdaExpressionsExample3 {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeData.getEmployeeList();
        // writing in the file using the FileWriter class.
        try(FileWriter writer = new FileWriter("Employee_List.txt")){
            employeeList.forEach(employee -> {
                try{
                    writer.write(employee.toString() + "\n");
                }catch(IOException e){
                    throw new RuntimeException(e.getMessage());
                }
            });
            // for (Employee employee : employeeList){
            //     writer.write(employee.toString() + "\n");
            // }
        } catch (IOException | RuntimeException e) {
            System.out.println("An IO Exception occured: " + e.getMessage());
        }
    }
}
