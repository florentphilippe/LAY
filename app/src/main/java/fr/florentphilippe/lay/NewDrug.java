package fr.florentphilippe.lay;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import fr.florentphilippe.lay.fragments.DatePickerFragment;


public class NewDrug extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drug);

        //Importing EditText from UI
        Button buttonStartDate = (Button) findViewById(R.id.button_start_date);
        Button buttonEndDate = (Button) findViewById(R.id.button_end_date);

        //Initialise the current date
        Calendar currentCalendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String format = dateFormat.format(currentCalendar.getTime());

        //Setting current date to the button's text
        buttonStartDate.setText(format);
        buttonEndDate.setText(format);

        //Start and End days calendars
        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();



    }

    //Method which shows the date picker fragment dialog
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

}
