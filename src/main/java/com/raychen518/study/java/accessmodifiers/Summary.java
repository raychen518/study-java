package com.raychen518.study.java.accessmodifiers;

public class Summary {

	public static void main(String[] args) {
		System.out.println("\t\tSelf\tPackage\t    Children\tAll Others");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("public\t\tYes\tYes\t    Yes\t\tYes");
		System.out.println("protected\tYes\tYes\t    Yes\t\tNo");
		System.out.println("<default>\tYes\tYes\t    No\t\tNo");
		System.out.println("private\t\tYes\tNo\t    No\t\tNo");

	}

}
