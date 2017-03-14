package fr.florentphilippe.lay;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
