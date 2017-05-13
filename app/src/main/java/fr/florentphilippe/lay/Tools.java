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
                                                                        .toString()));
        calendar.set(Calendar.YEAR, Integer.parseInt(new StringBuilder(buttonText.charAt(6)).append(buttonText.charAt(7))
                                                                        .append(buttonText.charAt(8))
                                                                        .append(buttonText.charAt(9))
                                                                        .toString()));

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
}
