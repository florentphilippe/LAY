package fr.florentphilippe.lay;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewDrug extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make the status bar transparent
        View decorView = getWindow().getDecorView();



        setContentView(R.layout.activity_new_drug);


    }

}
