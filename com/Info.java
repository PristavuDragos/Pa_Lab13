package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.*;

public class Info {
    final static String baseName = "res.Messages";

    public static void getInfo(Locale appLocale, Locale targetLocale){
        ResourceBundle messages = ResourceBundle.getBundle(baseName, appLocale);
        String pattern = messages.getString("info");
        Object[] arguments = {targetLocale.getISO3Country()};
        String message = new MessageFormat(pattern).format(arguments);

        WeekFields wf = WeekFields.of(targetLocale);
        DayOfWeek day = wf.getFirstDayOfWeek();
        String weekDays = "";
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            weekDays = weekDays +" "+ day.getDisplayName(TextStyle.FULL,targetLocale);
            day = day.plus(1);
        }

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(targetLocale);
        String[] months = dateFormatSymbols.getMonths();

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,targetLocale);
        String today = dateFormat.format(new Date());

        System.out.println(message);
        System.out.println(messages.getString("country")+targetLocale.getDisplayCountry());
        System.out.println(messages.getString("language")+targetLocale.getDisplayLanguage());
        System.out.println(messages.getString("week.days")+weekDays);
        System.out.println(messages.getString("months")+ Arrays.toString(months));
        System.out.println(messages.getString("today")+ today);
        System.out.println(messages.getString("currency")+ (Currency.getInstance(targetLocale)).getDisplayName());
    }
}
