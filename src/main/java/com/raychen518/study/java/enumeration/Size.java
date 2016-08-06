package com.raychen518.study.java.enumeration;

public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

	private String abbreviation;

	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public static void main(String[] args) {
		System.out.println("Count: " + Size.values().length);
		System.out.println(".ordinal()\t.name()/.toString()\t.getAbbreviation()");
		System.out.println("----------------------------------------------------------");
		for (Size size : Size.values()) {
			String indent = (size.ordinal() < Size.values().length - 1 ? "\t\t\t" : "\t\t");
			System.out.print(size.ordinal() + "\t\t");
			System.out.print(size.name() + indent);
			System.out.print(size.getAbbreviation());
			System.out.println();
		}
		System.out.println("Note: The methods .name() and .toString() always return same values.");
		System.out.println();

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();

		System.out.println("Size.SMALL.compareTo(Size.MEDIUM)\t: " + Size.SMALL.compareTo(Size.MEDIUM));
		System.out.println("Size.MEDIUM.compareTo(Size.MEDIUM)\t: " + Size.MEDIUM.compareTo(Size.MEDIUM));
		System.out.println("Size.LARGE.compareTo(Size.MEDIUM)\t: " + Size.LARGE.compareTo(Size.MEDIUM));

	}
}
