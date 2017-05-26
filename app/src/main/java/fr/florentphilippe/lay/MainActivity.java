package fr.florentphilippe.lay;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;


import fr.florentphilippe.lay.classes.Drug;

/*
L.A.Y. : Look After Yourself

Project by Florent Philippe : https://github.com/florentphilippe
Started on March, 7th 2017

 */

public class MainActivity extends AppCompatActivity {

    //Drug containers
    static ArrayList<Drug> drugsList = new ArrayList<>();
    ArrayList<Drug> areHappeningToday = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("appAction","=====SERVICE STARTS=====");
        Log.i("appAction","Launching MainActivity ...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Import drug container from file
        Log.i("appAction","Grabbing drugs Array container");
        drugsList = Tools.readAnArray(getApplicationContext());
        Log.i("appAction","Drugs container length : " + drugsList.size());

        //Set areHappeningToday list with the drugs which should be taken on this day by the use
        Log.i("appAction", "Setting areHappeningToday list from the drugs of the stored file ...");

        for (int i = 0; i < drugsList.size(); i++){
            if (drugsList.get(i).isHappeningToday()){
                areHappeningToday.add(drugsList.get(i));
            }
        }
        Log.i("appAction", "areHappeningToday list size : " + areHappeningToday.size());

        //Importing Floating Action button
        FloatingActionButton newDrugButton = (FloatingActionButton) findViewById(R.id.new_drug_button);

        //Setting the newDrugButton click listener
        newDrugButton.setOnClickListener(
            new FloatingActionButton.OnClickListener(){
                public void onClick(View v){

                    //Setting the new activity
                    Intent i = new Intent (getApplicationContext(),NewDrug.class);
                    startActivity(i);
                }
            }
        );

    }

    //====TEST STATEMENT=====
    @Override
    protected void onDestroy() {
        super.onDestroy();

        drugsList = new ArrayList<>();

        Log.i("appAction", "onDestroy list length : " + drugsList.size());
        Tools.writeAnArray(drugsList, getApplicationContext());
        Log.i("appAction", "ArrayList cleared !");
    }
}
