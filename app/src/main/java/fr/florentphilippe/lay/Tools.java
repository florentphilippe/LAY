package fr.florentphilippe.lay;


import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import fr.florentphilippe.lay.classes.Drug;


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
                                                                        .toString()) - 1);
        calendar.set(Calendar.YEAR, Integer.parseInt(new StringBuilder().append(buttonText.charAt(6))
                                                                        .append(buttonText.charAt(7))
                                                                        .append(buttonText.charAt(8))
                                                                        .append(buttonText.charAt(9))
                                                                        .toString()));
        Log.i("appAction","stringConverterToDate method converts : " + buttonText + " to : " + calendar.toString());
        return calendar;
    }


    //***Files writers and readers***
    //Writer
    public static void writeAnArray(ArrayList arrayList, Context context){
        Log.i("appAction","Writing Drug container ... ");
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("objects", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        }catch (Exception e){
            Log.i("appAction","An error occurred !");
            Log.e("appAction", Log.getStackTraceString(e));
        }
    }

    //Reader
    public static ArrayList<Drug> readAnArray(Context context){
        Log.i("appAction","Reading Drug container ...");
        ArrayList tempContainer = new ArrayList();
        try {
            FileInputStream fileInputStream = context.openFileInput("objects");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tempContainer = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
        }catch(Exception e){
            Log.i("appAction","No file found !");
            Log.e("appAction", Log.getStackTraceString(e));
        }
        return tempContainer;
    }


    //Get date in a unique integer => YEAR + MONTH + DAY OF THE MONTH
    public static int dateToInteger(Calendar cal){
        Log.i("appAction", "Calendar : YEAR = " + cal.get(Calendar.YEAR) + " MONTH = " + cal.get(Calendar.MONTH) + " DAY_OF_MONTH = " + cal.get(Calendar.DAY_OF_MONTH));

        StringBuilder processString = new StringBuilder();
        processString.append(cal.get(Calendar.YEAR));

        if (cal.get(Calendar.MONTH) < 10){
            processString.append(0);
        }
        processString.append(cal.get(Calendar.MONTH));

        if (cal.get(Calendar.DAY_OF_MONTH) < 10){
            processString.append(0);
        }
        processString.append(cal.get(Calendar.DAY_OF_MONTH));

        int result = Integer.parseInt(processString.toString());

        Log.i("appAction","Calendar converted to : " + result);
        return result;
    }

    //Compute relativeTimeDescriber value
    public static int relativeTimeToInt (Drug drug){
        Log.i("appAction","Determine relative time int describer ...");

        int result = 0;
        String absoluteTime = drug.getAbsoluteTime();
        String relativeTime = drug.getRelativeTime();

        switch (absoluteTime){
            case "Breakfast":
                result = 1;
                break;
            case "Lunch":
                result = 4;
                break;
            case "Dinner":
                result = 7;
                break;
        }

        switch (relativeTime){
            case "Before":
                result = result - 1;
                break;
            case "After":
                result = result + 1;
        }

        Log.i("appAction","Relative time describer value : " + result);
        return result;
    }

    public static ArrayList<Drug> drugContainerSorter (ArrayList<Drug> mainArray){
        Log.i("appAction","Sort drug container by relative time ");
        ArrayList<Drug> result = new ArrayList<>();

        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();

        //--Description statement--
        for (Drug drug : mainArray){
            before.append("'" + drug.getRelativeTimeDescriber() + "', ");
        }

        Log.i("appAction", "List state BEFORE : " + before.toString());


        //Case the array is empty
        if (mainArray.isEmpty()){
            Log.i("appAction","Drug container is Empty !");
        }else{

            Drug minObj = mainArray.get(0);
            for (int i = mainArray.size(); i >= 0; i--) {
                for (Drug drug : mainArray) {
                    if (drug.getRelativeTimeDescriber() < minObj.getRelativeTimeDescriber()) {
                        minObj = drug;
                    }
                }
                result.add(minObj);
                mainArray.remove(minObj);
                minObj = new Drug();
                minObj.setRelativeTimeDescriber(10);
                i--;
            }

            //Have a unknown issue => There is always one object left after processing
            if (mainArray.size() <= 1){
                result.add(mainArray.get(0));
            }
        }

        //--Description statement--
        for (Drug drug : result){
            after.append("'" + drug.getRelativeTimeDescriber() + "', ");
        }

        Log.i("appAction", "List state AFTER : " + after.toString());

        return result;
    }
}
