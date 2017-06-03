package fr.florentphilippe.lay;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;


import fr.florentphilippe.lay.classes.Drug;
import fr.florentphilippe.lay.classes.RecyclerAdapter;

/*
L.A.Y. : Look After Yourself

Project by Florent Philippe : https://github.com/florentphilippe
Started on March, 7th 2017

 */

public class MainActivity extends AppCompatActivity {
    //Recycler view references
    private RecyclerView mainRecycler;
    private RecyclerView.LayoutManager mainRecyclerLayout;

    //Drug containers
    static ArrayList<Drug> drugsList = new ArrayList<>();
    static ArrayList<Drug> areHappeningToday = new ArrayList<>();

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

        //Set areHappeningToday list with the drugs which should be taken on this day by the user
        Log.i("appAction", "Setting areHappeningToday list from the drugs of the stored file ...");

        for (int i = 0; i < drugsList.size(); i++){
            if (drugsList.get(i).isHappeningToday()){
                areHappeningToday.add(drugsList.get(i));
            }
        }
        Log.i("appAction", "areHappeningToday list size : " + areHappeningToday.size());

        //Sort list
        areHappeningToday = Tools.drugContainerSorter(areHappeningToday);


        //--Description statement--
        StringBuilder stringBuilder = new StringBuilder();
        for (Drug drug : areHappeningToday){
            stringBuilder.append("'" + drug.getRelativeTimeDescriber() + "', ");
        }
        Log.i("appAction", "List state AreHappeningToday : " + stringBuilder.toString());
        //-- --

        //Recycler view management & integration
        mainRecycler = (RecyclerView) findViewById(R.id.main_recycler);

        mainRecycler.setHasFixedSize(true);

        mainRecyclerLayout = new LinearLayoutManager(this);
        mainRecycler.setLayoutManager(mainRecyclerLayout);

        mainRecycler.setAdapter(new RecyclerAdapter(areHappeningToday));

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
