package fr.florentphilippe.lay.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;
import fr.florentphilippe.lay.R;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int theYear;
    private int theMonth;
    private int theDay;

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
        //importing buttons
        Button startDate = (Button) getActivity().findViewById(R.id.button_start_date);
        Button endDate = (Button) getActivity().findViewById(R.id.button_end_date);

        //Setting the date values
        theDay = dayOfMonth;
        theMonth = month+1;
        theYear = year;

        //setting button text
        String date = dateGetter();

        //detecting which text button has to be changed
        if (startDate.getText().equals(""))
            startDate.setText(date);
        else
            endDate.setText(date);
    }



    //Date variables toString
    public String dateGetter(){
        //Putting all the integer variables into one string
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(theDay +"/" + theMonth + "/"+theYear);

        return stringBuilder.toString();
    }


}

