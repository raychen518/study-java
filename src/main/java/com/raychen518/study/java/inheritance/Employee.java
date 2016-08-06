package com.raychen518.study.java.inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String name, double salary, int hireDayYear, int hireDayMonth, int hireDayDay) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(hireDayYear, hireDayMonth - 1, hireDayDay);
		this.hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public void raiseSalary(double raisePercent) {
		double raiseAmount = salary * raisePercent / 100;
		salary += raiseAmount;
	}

	public static void main(String[] args) {
		Employee[] employees = new Employee[3];

		employees[0] = new Employee("Ray Chen", 12000, 2011, 1, 21);
		employees[1] = new Employee("Tee Zhang", 10000, 2006, 7, 13);
		employees[2] = new Employee("Tom Cruise", 47000, 1995, 11, 6);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		for (Employee employee : employees) {
			System.out.println(employee.getName() + "\t" + employee.getSalary() + "\t\t"
					+ dateFormat.format(employee.getHireDay()));
		}
		System.out.println();

		for (Employee employee : employees) {
			employee.raiseSalary(5);
		}

		for (Employee employee : employees) {
			System.out.println(employee.getName() + "\t" + employee.getSalary() + "\t\t"
					+ dateFormat.format(employee.getHireDay()));
		}
	}

}
