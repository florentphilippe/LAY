package fr.florentphilippe.lay;


import java.util.Calendar;

/*
* A class containing all tools for converting, processing values ...
*/
public class Tools {

    //Text button converter from string to calendar
    public static Calendar stringConverterToDate (String buttonText){

        //Dates values
        int year;
        int month;
        int day;

        Calendar calendar = Calendar.getInstance();

        //processing the buttonText String
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(new StringBuilder().append(buttonText.charAt(0))
                                                                                 .append(buttonText.charAt(1))
                                                                                 .toString()));
        month = Integer.parseInt(new StringBuilder(buttonText.charAt(3)).append(buttonText.charAt(4)).toString());
        year = Integer.parseInt(new StringBuilder(buttonText.charAt(6)).append(buttonText.charAt(7))
                                                                        .append(buttonText.charAt(8))
                                                                        .append(buttonText.charAt(9))
                                                                        .toString());

        //Setting the calendar's values
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        //calendar.set(Calendar.DAY_OF_MONTH,day);

        return calendar;
    }
}
