package com.ccreanga.example.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Set;

public class Example {

    public static void main(String[] args) {
        // the current date
        LocalDate currentDate = LocalDate.now();

        // 2014-02-10
        LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);

        // months values start at 1 (2014-08-01)
        LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);

        // the 65th day of 2010 (2010-03-06)
        LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);


        LocalTime currentTime = LocalTime.now(); // current time
        LocalTime midday = LocalTime.of(12, 0); // 12:00
        LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15

        // 12345th second of day (03:25:45)
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);

        // dates with times, e.g. 2014-02-18 19:08:37.950
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 2014-10-02 12:30
        LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);

        // 2014-12-24 12:00
        LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);


        LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15

        boolean isBefore = LocalDate.now().isBefore(date); // false

        // information about the month
        Month february = date.getMonth(); // FEBRUARY
        int februaryIntValue = february.getValue(); // 2
        int minLength = february.minLength(); // 28
        int maxLength = february.maxLength(); // 29
        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

        // information about the year
        int year = date.getYear(); // 2014
        int dayOfYear = date.getDayOfYear(); // 46
        int lengthOfYear = date.lengthOfYear(); // 365
        boolean isLeapYear = date.isLeapYear(); // false

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
        String dayOfWeekName = dayOfWeek.name(); // SATURDAY

        int dayOfMonth = date.getDayOfMonth(); // 15
        LocalDateTime startOfDay = date.atStartOfDay(); // 2014-02-15 00:00

        // time information
        LocalTime time = LocalTime.of(15, 30); // 15:30:00
        int hour = time.getHour(); // 15
        int second = time.getSecond(); // 0
        int minute = time.getMinute(); // 30
        int secondOfDay = time.toSecondOfDay(); // 55800


        LocalDate tomorrow = LocalDate.now().plusDays(1);

        // before 5 houres and 30 minutes
        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);


        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZoneId berlin = ZoneId.of("Europe/Berlin");

        // 2014-02-20 12:00
        dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);

        // 2014-02-20 12:00, Europe/Berlin (+01:00)
        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);

        // 2014-02-20 03:00, America/Los_Angeles (-08:00)
        ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);

        int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800

        // a collection of all available zones
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        // using offsets
        LocalDateTime date2 = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
        ZoneOffset offset = ZoneOffset.of("+05:00");

        // 2013-07-20 03:30 +05:00
        OffsetDateTime plusFive = OffsetDateTime.of(date2, offset);

        // 2013-07-19 20:30 -02:00
        OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));


        // periods

        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
        Period period = Period.between(firstDate, secondDate);

        int days = period.getDays(); // 18
        int months = period.getMonths(); // 9
        int years = period.getYears(); // 4
        boolean isNegative = period.isNegative(); // false

        Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
        LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);

        // add two months and five days to 2014-01-06, result is 2014-03-11
        LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);


        // durations

        Instant firstInstant = Instant.ofEpochSecond(1294881180); // 2011-01-13 01:13
        Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11

        Duration between = Duration.between(firstInstant, secondInstant);

        // negative because firstInstant is after secondInstant (-172920)
        long seconds = between.getSeconds();

        // get absolute result in minutes (2882)
        long absoluteResult = between.abs().toMinutes();

        // two hours in seconds (7200)
        long twoHoursInSeconds = Duration.ofHours(2).getSeconds();


        // 2014-04-01 10:45
        LocalDateTime dateTime2 = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);

        // format as basic ISO date format (20140220)
        String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);

        // format as ISO week date (2014-W08-4)
        String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);

        // format ISO date time (2014-02-20T20:04:05.867)
        String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

        // using a custom pattern (01/04/2014)
        String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // french date formatting (1. avril 2014)
        String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));

        // using short german date/time formatting (01.04.14 10:45)
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("de"));
        String germanDateTime = dateTime.format(formatter);

        // parsing date strings
        LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
        LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
        LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

}
