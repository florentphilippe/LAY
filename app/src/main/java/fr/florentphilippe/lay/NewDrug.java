package fr.florentphilippe.lay;


import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import fr.florentphilippe.lay.classes.Drug;
import fr.florentphilippe.lay.fragments.DatePickerFragment;


public class NewDrug extends AppCompatActivity {


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drug);

        //Importing all components from UI
        final EditText drugName = (EditText) findViewById(R.id.edit_name_drug);
        final EditText labName = (EditText) findViewById(R.id.edit_lab_name);

        final Button buttonStartDate = (Button) findViewById(R.id.button_start_date);
        final Button buttonEndDate = (Button) findViewById(R.id.button_end_date);

        final EditText timesPerFrequency = (EditText) findViewById(R.id.edit_frequency);
        final Spinner frequencySelector = (Spinner) findViewById(R.id.spinner_frequency_selector);

        final Spinner absoluteTime = (Spinner) findViewById(R.id.spinner_time2);
        final Spinner relativeTime = (Spinner) findViewById(R.id.spinner_time1);

        FloatingActionButton okButton = (FloatingActionButton) findViewById(R.id.fab_ok);


        //Initialise the current date
        Calendar currentCalendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String format = dateFormat.format(currentCalendar.getTime());

        //Setting current date to the button's text
        buttonStartDate.setText(format);
        buttonEndDate.setText(format);

        //Buttons listeners
        buttonStartDate.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //set marker text
                        buttonStartDate.setText("");

                        //Show the Date picker
                        showDatePickerDialog(v);
                    }
                }
        );

        buttonEndDate.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //set marker text
                        buttonEndDate.setText("");

                        //Show the Date picker
                        showDatePickerDialog(v);

                    }
                }
        );


        //okButton action
        okButton.setOnClickListener(
                new FloatingActionButton.OnClickListener(){
                    public void onClick (View v){
                        //Getting the values of the user
                        final Calendar startDay = Tools.stringConverterToDate(buttonStartDate.getText().toString());
                        final Calendar endDay = Tools.stringConverterToDate(buttonEndDate.getText().toString());


                        //Creating new Drug object with values selected by user
                        Drug drug = new Drug();
                        drug.setDrugName(drugName.getText().toString());
                        drug.setLaboratoryName(labName.getText().toString());
                        drug.setStartDate(startDay);
                        drug.setEndDate(endDay);
                        drug.setTimesPerFrequency(Integer.parseInt(timesPerFrequency.getText().toString()));
                        drug.setFrequency(frequencySelector.getSelectedItem().toString());
                        drug.setAbsoluteTime(absoluteTime.getSelectedItem().toString());
                        drug.setRelativeTime(relativeTime.getSelectedItem().toString());
                        drug.setRelativeTimeDescriber(Tools.relativeTimeToInt(drug));
                        Log.i("appAction","Creating new Drug object");
                        Log.i("appAction",drug.toString());

                        //Adding this new object to container
                        MainActivity.drugsList.add(drug);
                        Log.i("appAction","List length : " + MainActivity.drugsList.size());

                        //Write ArrayList container to the internal storage
                        Tools.writeAnArray(MainActivity.drugsList, getApplicationContext());

                        //Determine if the new drug has to be taken on this day
                        if (drug.isHappeningToday()){
                            Log.i("appAction","Drug has to be taken today !");
                            MainActivity.areHappeningToday.add(drug);
                        }

                        //Close activity
                        Log.i("appAction","Close new drug activity intent");
                        finish();
                    }
                }
        );

    }


    //Method which shows the date picker fragment dialog
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        int anInt = newFragment.getId();

    }

}
