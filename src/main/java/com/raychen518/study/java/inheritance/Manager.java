package com.raychen518.study.java.inheritance;

import java.text.SimpleDateFormat;

/**
 * <pre>
 * The Manager class extends the Employee class.
 * The Employee class is the superclass / base class / parent class.
 * The Manager class is the subclass / derived class / child class.
 * </pre>
 *
 */
public class Manager extends Employee {

	private double bonus;

	public Manager(String name, double salary, int hireDayYear, int hireDayMonth, int hireDayDay) {
		super(name, salary, hireDayYear, hireDayMonth, hireDayDay);
		bonus = 5000D;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/*
	 * Unlike an employee, besides the base salary, the salary of a manager also
	 * contains the bonus. So, the getSalary() method inherited from the
	 * Employee class should be overridden.
	 */
	@Override
	public double getSalary() {
		// return salary + bonus;
		// The following error occurs when writing above statement.
		// -------------------------------------------------
		// The field Employee.salary is not visible
		// -------------------------------------------------
		// It is because private fields in a superclass are not visible to the
		// superclass' subclasses. The solution is using the access methods of
		// those private fields.

		return super.getSalary() + bonus;
	}

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		System.out.println("========================================");
		System.out.println("Manager Acting as Employee (Subclass Acting as Superclass)");
		System.out.println("========================================");
		System.out.println("Any occurrence of a superclass can be replaced by one of its subclasses.");
		System.out.println();

		{
			Employee[] employees = new Employee[3];

			employees[0] = new Employee("Ray Chen", 12000, 2011, 1, 21);
			employees[1] = new Employee("Tee Zhang", 10000, 2006, 7, 13);
			employees[2] = new Manager("Tom Cruise", 47000, 1995, 11, 6);

			for (Employee employee : employees) {
				System.out.println(employee.getName() + "\t" + employee.getSalary() + "\t\t"
						+ dateFormat.format(employee.getHireDay()));
			}
			System.out.println(
					"Note: Tom Cruise is a manager, so his salary is the base salary (47000) plus the bonus (5000) which is 52000.");
			System.out.println();

			for (Employee employee : employees) {
				employee.raiseSalary(5);
			}

			for (Employee employee : employees) {
				System.out.println(employee.getName() + "\t" + employee.getSalary() + "\t\t"
						+ dateFormat.format(employee.getHireDay()));
			}
			System.out.println();
		}

		System.out.println("========================================");
		System.out.println("Saving Employee as Manager (Saving Superclass as Subclass)");
		System.out.println("========================================");
		System.out.println("Saving a superclass as one of its subclasses causes errors.");
		System.out.println();

		{
			Manager[] managers = new Manager[3];
			Employee[] employees = managers;

			try {
				employees[0] = new Employee("Ray Chen", 12000, 2011, 1, 21);
			} catch (Exception e) {
				System.out.println("Here is an error example.");
				e.printStackTrace();
			}
		}
	}

}
