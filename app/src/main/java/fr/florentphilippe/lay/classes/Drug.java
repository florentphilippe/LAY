package fr.florentphilippe.lay.classes;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import fr.florentphilippe.lay.Tools;

/*
This class represent the "Drug" Object and all its parameters
 */
public class Drug implements Serializable{


    //Main titles and period
    private String drugName;
    private String laboratoryName;
    private Calendar startDate;
    private Calendar endDate;

    //Frequency
    private Integer timesPerFrequency;
    private String frequency;

    //Time in the frequency
    private String absoluteTime;
    private String relativeTime;



    //Drug static container
    //private static ArrayList<Drug> drugsList;


    //***Constructors***
    public Drug(){
        drugName = "";
        laboratoryName = "";
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();
        timesPerFrequency = 1;
        frequency = "Day";
        absoluteTime = "Breakfast";
        relativeTime = "Before";
    }

    public Drug(String cDrugName, String cLaboratoryName, Calendar cStartDate, Calendar cEndDate, Integer cTimesPerFrequency, String cFrequency, String cAbsoluteTime, String cRelativeTime){
        drugName = cDrugName;
        laboratoryName = cLaboratoryName;
        startDate = cStartDate;
        endDate = cEndDate;
        timesPerFrequency = cTimesPerFrequency;
        frequency = cFrequency;
        absoluteTime = cAbsoluteTime;
        relativeTime = cRelativeTime;
    }

    //Determine if the drug has to be taken on the current day
    public Boolean isHappeningToday (){
        Log.i("appAction", "Launching isHappeningToday method ...");
        Log.i("appAction", "Converting calendars to integers ...");

        //Converting calendars date to integers
        int startDateInt = Tools.dateToInteger(this.getStartDate());
        int endDateInt = Tools.dateToInteger(this.getEndDate());
        int currentDateInt = Tools.dateToInteger(Calendar.getInstance());

        //Date used in the process
        Calendar targetDate = this.getStartDate();

        //Container for all the dates (integers) which match with the frequency
        ArrayList matchingDates = new ArrayList<>();
        matchingDates.add(startDateInt);


        //Case when frequency is set to 'Day'
        if (this.frequency.equals("Day")){
            Log.i("appAction","The Drug object frequency is set to 'Day'.");

            while(targetDate.compareTo(this.getEndDate()) < 0){
                targetDate.add(Calendar.DAY_OF_MONTH, this.timesPerFrequency);
                matchingDates.add(Tools.dateToInteger(targetDate));
            }

            Log.i("appAction","Matching dates list length : " + matchingDates.size());
            Log.i("appAction","3 fist elements description  : " + matchingDates.get(0) + "; " + matchingDates.get(1) + "; " + matchingDates.get(2) + "; " );
        }





        return false;
    }




    //***Getters***
    public String getDrugName() {
        return drugName;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Integer getTimesPerFrequency() {
        return timesPerFrequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getAbsoluteTime() {
        return absoluteTime;
    }

    public String getRelativeTime() {
        return relativeTime;
    }




    //***Setters***
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setTimesPerFrequency(Integer timesPerFrequency) {
        this.timesPerFrequency = timesPerFrequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setAbsoluteTime(String absoluteTime) {
        this.absoluteTime = absoluteTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }



    //***ToString***
    public String toString(){
        return "\n>>>>>Drug Object<<<<<<\n"
                +"-Drug Name = " + this.drugName + "\n"
                +"-Laboratory Name = " + this.laboratoryName + "\n"
                +"-Start Date = " + this.startDate + "\n"
                +"-End Date = " + this.endDate + "\n"
                +"-Times per Frequency = " + this.timesPerFrequency + "\n"
                +"-Frequency = " + this.frequency + "\n"
                +"-Absolute Time = " + this.absoluteTime + "\n"
                +"-Relative Time = " + this.relativeTime + "\n\n";
    }


}

