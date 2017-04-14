package fr.florentphilippe.lay.classes;

import java.io.Serializable;
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

}
