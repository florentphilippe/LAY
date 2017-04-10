package fr.florentphilippe.lay;


import java.util.Calendar;

/*
* A class containing all tools for converting, processing values ...
*/
public class Tools {

    //Text button converter from string to calendar
    public static Calendar stringConverterToDate (String buttonText){


        Calendar calendar = Calendar.getInstance();

        //processing the buttonText String using a StringBuilder
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(new StringBuilder().append(buttonText.charAt(0))
                                                                                 .append(buttonText.charAt(1))
                                                                                 .toString()));
        calendar.set(Calendar.MONTH, Integer.parseInt(new StringBuilder().append(buttonText.charAt(3))
                                                                        .append(buttonText.charAt(4))
                                                                        .toString()));
        calendar.set(Calendar.YEAR, Integer.parseInt(new StringBuilder(buttonText.charAt(6)).append(buttonText.charAt(7))
                                                                        .append(buttonText.charAt(8))
                                                                        .append(buttonText.charAt(9))
                                                                        .toString()));

        return calendar;
    }
}
