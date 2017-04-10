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
    private Integer timesInTheFrequency;
    private String frequency;

    //Time in the frequency
    private String time;
    private String relativeTime;

}
