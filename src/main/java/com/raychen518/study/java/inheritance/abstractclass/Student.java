package com.raychen518.study.java.inheritance.abstractclass;

public class Student extends Person {
	private String major;

	public Student(String name, String major) {
		super(name);
		this.major = major;
	}

	@Override
	public String getDescription() {
		return "A student majoring in " + major;
	}

	public String getMajor() {
		return major;
	}

	public static void main(String[] args) {
		Student student = new Student("Ray Chen", "Computer Science");
		System.out.println(student.getName() + ": " + student.getDescription());
	}

}
