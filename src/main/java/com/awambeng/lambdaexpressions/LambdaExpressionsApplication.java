package com.awambeng.lambdaexpressions;

import java.util.Comparator;
import java.util.List;

import com.awambeng.lambdaexpressions.data.Employee;
import com.awambeng.lambdaexpressions.data.EmployeeData;

// problem statement: print all eployees sorted by salary using old method 
// and using lambda expressions.
public class LambdaExpressionsApplication {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeData.getEmployeeList();

		for (Employee employee : employees){
			System.out.println(employee);
		}

		// old way of implementing functional interfaces.
		// employees.sort(new Comparator<Employee>(){

		// 	@Override
		// 	public int compare(Employee arg0, Employee arg1) {
		// 		return arg0.getSalary().compareTo(arg1.getSalary());
		// 	}
		// });

		// coverting the functional interface Comparator to a lambda expression. (new way of implementing functional interface in java)
		employees.sort((arg0, arg1) -> arg0.getSalary().compareTo(arg1.getSalary()));
		
		System.out.println("Employee List - Sorted");

		for (Employee employee : employees){
			System.out.println(employee);
		}

		// implementing the Runnable interface using lambda expression.
		Runnable runnable = () -> System.out.println("Hello world");
		runnable.run();
	}

}
