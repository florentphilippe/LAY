package fr.florentphilippe.lay;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.florentphilippe.lay.classes.Drug;

/*
L.A.Y. : Look After Yourself

Project by Florent Philippe : https://github.com/florentphilippe
Started on March, 7th 2017

 */

public class MainActivity extends AppCompatActivity {

    //Drugs container
    static ArrayList<Drug> drugsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("appAction","=====SERVICE START=====");
        Log.i("appAction","Launching MainActivity ...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Import drug container from file
        Log.i("appAction","Grabbing drugs Array container");
        drugsList = Tools.readAnArray(getApplicationContext());
        Log.i("appAction","Drugs container length : " + drugsList.size());

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
        for (int i = 0; i <= drugsList.size(); i++){
            drugsList.remove(i);
        }
        Log.i("appAction", "onDestroy list length : " + drugsList.size());
        Tools.writeAnArray(drugsList, getApplicationContext());
        Log.i("appAction", "ArrayList cleared !");
    }
}
