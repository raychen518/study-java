package com.raychen518.study.java.datetime;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Example_CalendarOfCurrentMonth {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		// System.out.println("xx: " + Arrays.toString(new
		// DateFormatSymbols().getShortWeekdays()));

		GregorianCalendar calendar = new GregorianCalendar();

		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentMonth = calendar.get(Calendar.MONTH);

		// Get the week day of the first day in current month.
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);

		// Get the first day of a week (It is Sunday in the U.S.).
		int firstDayOfWeek = calendar.getFirstDayOfWeek();

		// Determine the required indentation for the first line (weekday names)
		// in the calendar graph.
		int indent = 0;
		while (weekDay != firstDayOfWeek) {
			indent++;
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		}

		// Print the first line (weekday names) in the calendar graph.
		String[] shortWeekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", shortWeekdayNames[weekDay]);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		} while (weekDay != firstDayOfWeek);
		System.out.println();

		for (int i = 1; i <= indent; i++) {
			System.out.print("    ");
		}

		// Print other lines (weekday numbers) in the calendar graph.
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		do {
			// Print a day.
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);

			if (day == currentDay) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}

			// Advance to the next day.
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);

			// Start a new line at the start of a week.
			if (weekDay == firstDayOfWeek) {
				System.out.println();
			}
		} while (calendar.get(Calendar.MONTH) == currentMonth);

		// Print a final line if necessary.
		if (weekDay != firstDayOfWeek) {
			System.out.println();
		}
	}

}
