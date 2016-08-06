package com.raychen518.study.java.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class GregorianCalendarClass {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();

		System.out.println("========================================");
		System.out.println("Construction and Common Usages");
		System.out.println("========================================");
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println("GregorianCalendar calendar = new GregorianCalendar();");
		System.out.println("calendar: " + calendar);
		System.out.println("calendar.getTime(): " + calendar.getTime());
		System.out.println("calendar.getTimeInMillis(): " + calendar.getTimeInMillis());
		System.out.println();

		System.out.println("calendar.get(Calendar.YEAR)\t\t: " + calendar.get(Calendar.YEAR));
		System.out.println("calendar.get(Calendar.MONTH) + 1\t: " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("calendar.get(Calendar.DAY_OF_MONTH)\t: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("calendar.get(Calendar.DATE)\t\t: " + calendar.get(Calendar.DATE));
		System.out.println("calendar.get(Calendar.DAY_OF_WEEK)\t: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("calendar.get(Calendar.DAY_OF_YEAR)\t: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("calendar.get(Calendar.WEEK_OF_MONTH)\t: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("calendar.get(Calendar.WEEK_OF_YEAR)\t: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println();

		System.out.println("calendar.get(Calendar.HOUR)\t\t: " + calendar.get(Calendar.HOUR));
		System.out.println("calendar.get(Calendar.HOUR_OF_DAY)\t: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("calendar.get(Calendar.MINUTE)\t\t: " + calendar.get(Calendar.MINUTE));
		System.out.println("calendar.get(Calendar.SECOND)\t\t: " + calendar.get(Calendar.SECOND));
		System.out.println("calendar.get(Calendar.MILLISECOND)\t: " + calendar.get(Calendar.MILLISECOND));
		System.out.println("calendar.get(Calendar.AM_PM)\t\t: " + calendar.get(Calendar.AM_PM) + " (AM: " + Calendar.AM
				+ "; PM: " + Calendar.PM + ")");
		System.out.println();

		System.out.println("========================================");
		System.out.println("Setting and Formatting");
		System.out.println("========================================");
		dateFormat.applyPattern("yyyy/MM/dd HH:mm:ss:SSS");
		System.out.println("dateFormat.applyPattern(\"yyyy/MM/dd HH:mm:ss:SSS\");");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		dateFormat.applyPattern("yyyy/MM/dd");
		System.out.println("dateFormat.applyPattern(\"yyyy/MM/dd\");");
		System.out.println();

		calendar.set(Calendar.YEAR, 1977);
		calendar.set(Calendar.MONTH, Calendar.MAY);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		System.out.println("calendar.set(Calendar.YEAR, 1977);");
		System.out.println("calendar.set(Calendar.MONTH, Calendar.MAY);");
		System.out.println("calendar.set(Calendar.DAY_OF_MONTH, 18);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar.set(1981, Calendar.JUNE, 3);
		System.out.println("calendar.set(1981, Calendar.JUNE, 3);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar.add(Calendar.YEAR, 19);
		System.out.println("calendar.add(Calendar.YEAR, 19);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar.add(Calendar.DAY_OF_MONTH, -13);
		System.out.println("calendar.add(Calendar.DAY_OF_MONTH, -7);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		System.out.println("========================================");
		System.out.println("Comparison");
		System.out.println("========================================");
		GregorianCalendar calendarA = new GregorianCalendar(1977, Calendar.MAY, 18);
		GregorianCalendar calendarB = new GregorianCalendar(1981, Calendar.JUNE, 3);

		System.out.println("GregorianCalendar calendarA = new GregorianCalendar(1977, Calendar.MAY, 18);");
		System.out.println("GregorianCalendar calendarB = new GregorianCalendar(1981, Calendar.JUNE, 3);");
		System.out.println("calendarA.compareTo(calendarB): " + calendarA.compareTo(calendarB));
		System.out.println("calendarA.before(calendarB): " + calendarA.before(calendarB));
		System.out.println("calendarA.after(calendarB): " + calendarA.after(calendarB));
		System.out.println();

		System.out.println("========================================");
		System.out.println("Other Usages");
		System.out.println("========================================");
		System.out.println("calendar.getFirstDayOfWeek(): " + calendar.getFirstDayOfWeek() + " (Sunday: "
				+ Calendar.SUNDAY + "; Monday: " + Calendar.MONDAY + ")");
		System.out.println();

		System.out.println("calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH): "
				+ calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH));
		System.out.println("calendar.getDisplayNames(Calendar.MONTH, Calendar.SHORT_FORMAT, Locale.ENGLISH): "
				+ calendar.getDisplayNames(Calendar.MONTH, Calendar.SHORT_FORMAT, Locale.ENGLISH));
		System.out.println("calendar.getDisplayNames(Calendar.MONTH, Calendar.SHORT_FORMAT, Locale.CHINESE): "
				+ calendar.getDisplayNames(Calendar.MONTH, Calendar.SHORT_FORMAT, Locale.CHINESE));
		System.out.println();

		System.out.println("calendar.getActualMaximum(Calendar.MONTH): " + calendar.getActualMaximum(Calendar.MONTH));
		System.out.println("calendar.getActualMaximum(Calendar.DAY_OF_MONTH): "
				+ calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("calendar.getActualMinimum(Calendar.DAY_OF_MONTH): "
				+ calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println(
				"calendar.getActualMinimum(Calendar.HOUR_OF_DAY): " + calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		System.out.println();

		System.out.println("calendar.isLeapYear(calendar.get(Calendar.YEAR)): "
				+ calendar.isLeapYear(calendar.get(Calendar.YEAR)));
		System.out.println("calendar.getTimeZone().toString(): " + calendar.getTimeZone().toString());
		System.out.println("calendar.getCalendarType(): " + calendar.getCalendarType());
		System.out.println();

		System.out.println("========================================");
		System.out.println("Rolling");
		System.out.println("========================================");
		dateFormat.applyPattern("yyyy/MM/dd");

		calendar = new GregorianCalendar(1999, Calendar.DECEMBER, 25);
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.MONTH, 1);
		System.out.println("calendar.add(Calendar.MONTH, 1);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar = new GregorianCalendar(1999, Calendar.DECEMBER, 25);
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		calendar.roll(Calendar.MONTH, true);
		System.out.println("calendar.roll(Calendar.MONTH, true);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println("calendar.add(Calendar.DAY_OF_MONTH, -1);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		System.out.println("calendar.roll(Calendar.DAY_OF_MONTH, -1);");
		System.out.println("dateFormat.format(calendar.getTime()): " + dateFormat.format(calendar.getTime()));
		System.out.println();

		System.out.println("========================================");
		System.out.println("Constants");
		System.out.println("========================================");
		System.out.println("GregorianCalendar.SUNDAY\t: " + GregorianCalendar.SUNDAY);
		System.out.println("GregorianCalendar.MONDAY\t: " + GregorianCalendar.MONDAY);
		System.out.println("GregorianCalendar.TUESDAY\t: " + GregorianCalendar.TUESDAY);
		System.out.println("GregorianCalendar.WEDNESDAY\t: " + GregorianCalendar.WEDNESDAY);
		System.out.println("GregorianCalendar.THURSDAY\t: " + GregorianCalendar.THURSDAY);
		System.out.println("GregorianCalendar.FRIDAY\t: " + GregorianCalendar.FRIDAY);
		System.out.println("GregorianCalendar.SATURDAY\t: " + GregorianCalendar.SATURDAY);
		System.out.println();

		System.out.println("GregorianCalendar.JANUARY\t: " + GregorianCalendar.JANUARY);
		System.out.println("GregorianCalendar.FEBRUARY\t: " + GregorianCalendar.FEBRUARY);
		System.out.println("GregorianCalendar.MARCH\t\t: " + GregorianCalendar.MARCH);
		System.out.println("GregorianCalendar.APRIL\t\t: " + GregorianCalendar.APRIL);
		System.out.println("GregorianCalendar.MAY\t\t: " + GregorianCalendar.MAY);
		System.out.println("GregorianCalendar.JUNE\t\t: " + GregorianCalendar.JUNE);
		System.out.println("GregorianCalendar.JULY\t\t: " + GregorianCalendar.JULY);
		System.out.println("GregorianCalendar.AUGUST\t: " + GregorianCalendar.AUGUST);
		System.out.println("GregorianCalendar.SEPTEMBER\t: " + GregorianCalendar.SEPTEMBER);
		System.out.println("GregorianCalendar.OCTOBER\t: " + GregorianCalendar.OCTOBER);
		System.out.println("GregorianCalendar.NOVEMBER\t: " + GregorianCalendar.NOVEMBER);
		System.out.println("GregorianCalendar.DECEMBER\t: " + GregorianCalendar.DECEMBER);
		System.out.println();

		System.out.println("GregorianCalendar.BC\t\t: " + GregorianCalendar.BC);
		System.out.println("GregorianCalendar.AD\t\t: " + GregorianCalendar.AD);
		System.out.println();

		System.out.println("GregorianCalendar.AM\t\t: " + GregorianCalendar.AM);
		System.out.println("GregorianCalendar.PM\t\t: " + GregorianCalendar.PM);
		System.out.println();
	}

}
