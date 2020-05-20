package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    static Locale appLocale;
    final static String baseName = "res.Messages";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setAppLocale(Locale.getDefault());
        while (true){
            ResourceBundle messages = ResourceBundle.getBundle(baseName, getAppLocale());
            System.out.println(messages.getString("prompt"));
            String input = scanner.nextLine();
            if (input.equals("display locales")){
                DisplayLocales.displayLocales(getAppLocale());
            }else if (input.length()>9 && input.substring(0,10).equals("set locale")){
                setAppLocale(SetLocale.set(getAppLocale(),input.substring(11)));
            }else if (input.length()>3 && input.substring(0,4).equals("info")){
                if (input.length()==4){
                    Info.getInfo(getAppLocale(),getAppLocale());
                }
                Boolean ok = false;
                if (input.length()>=5) {
                    String tag = input.substring(5);
                    Locale available[] = Locale.getAvailableLocales();
                    for (Locale locales : available) {
                        if (locales.getCountry().equals(tag)) {
                            Info.getInfo(getAppLocale(), locales);
                            ok = true;
                        }
                    }
                }
                if (!ok){
                    System.out.println("Invalid country tag");
                }
            }else{
                System.out.println(messages.getString("invalid"));
            }
        }
    }

    public static Locale getAppLocale() {
        return appLocale;
    }

    public static void setAppLocale(Locale appLocale) {
        LocaleExplore.appLocale = appLocale;
    }
}
