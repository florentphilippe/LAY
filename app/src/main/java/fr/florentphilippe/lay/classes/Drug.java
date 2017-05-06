package fr.florentphilippe.lay.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

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
    private static ArrayList<Drug> drugsList;


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


    public static ArrayList<Drug> getDrugsList() {
        return drugsList;
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


    public static void setDrugsList(ArrayList<Drug> drugsList) {
        Drug.drugsList = drugsList;
    }


    //***ToString***
    public String toString(){
        return ">>>>>Drug Object<<<<<<\n"
                +"-Drug Name = " + this.drugName
                +"-Laboratory Name = " + this.laboratoryName + "\n"
                +"-Start Date = " + this.startDate.toString() + "\n"
                +"-End Date = " + this.endDate.toString() + "\n"
                +"-Times per Frequency = " + this.timesPerFrequency + "\n"
                +"-Frequency = " + this.frequency + "\n"
                +"-Absolute Time = " + this.absoluteTime + "\n"
                +"-Relative Time = " + this.relativeTime + "\n";
    }


}

