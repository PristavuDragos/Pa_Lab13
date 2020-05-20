package com;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    final static String baseName = "res.Messages";

    public static void displayLocales(Locale locale){
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        System.out.println(messages.getString("locales"));
        Locale available[] = Locale.getAvailableLocales();
        for(Locale locales : available) {
            System.out.println(locales.getDisplayCountry() + "\t" +
                    locales.getDisplayLanguage(locales) + locales.getCountry());
        }
    }
}
