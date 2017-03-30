package fr.florentphilippe.lay.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;



public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    //Creating a receiver calendar
    Calendar receiver = Calendar.getInstance();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Creating a default calendar with the current date
        final Calendar calendar = Calendar.getInstance();

        //Initialize variables with current date
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //Create an instance of a DatePickerDialog with the current date (initialized in variables ;)
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    //Return the date set by the user
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        //Initialize the date with variables from the user
        receiver.set(Calendar.YEAR,year);
        receiver.set(Calendar.YEAR,year);
        receiver.set(Calendar.YEAR,year);


    }

    //Receiver calendar Getter
    public Calendar datePickerCalendarGetter(){
        return receiver;
    }

}

