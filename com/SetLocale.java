package com;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    final static String baseName = "res.Messages";

    public static Locale set(Locale locale , String languageTag){
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        String pattern = messages.getString("locale.set");
        Object[] arguments = {languageTag};
        String message = new MessageFormat(pattern).format(arguments);
        Locale available[] = Locale.getAvailableLocales();
        if (languageTag.equals("RO") || languageTag.equals("EN")) {
            for (Locale locales : available) {
                if (locales.getCountry().equals(languageTag)) {
                    System.out.println(message);
                    return locales;
                }
            }
        }
        System.out.println("Country not found or not available.");
        return Locale.getDefault();
    }
}
