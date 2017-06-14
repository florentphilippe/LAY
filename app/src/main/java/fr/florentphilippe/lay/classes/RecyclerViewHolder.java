package fr.florentphilippe.lay.classes;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import fr.florentphilippe.lay.R;
import fr.florentphilippe.lay.Tools;


public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private TextView cardTitle;
    private TextView subtitleContent;
    private TextView startDateValue;
    private TextView endDateValue;

    //View for 1 cell
    public RecyclerViewHolder (View v){
        super(v);

        //findViews

        cardTitle = (TextView) v.findViewById(R.id.card_title);
        subtitleContent = (TextView) v.findViewById(R.id.subtitle_content);
        startDateValue = (TextView) v.findViewById(R.id.start_date_card);
        endDateValue = (TextView)  v.findViewById(R.id.end_date_card);
    }

    //Binder
    public void bind (Drug drug){
        cardTitle.setText(drug.getDrugName());
        subtitleContent.setText(drug.getRelativeTime() + " " + drug.getAbsoluteTime());
        startDateValue.setText(Tools.dateToStringValue(drug.getStartDate()));
        endDateValue.setText(Tools.dateToStringValue(drug.getEndDate()));
    }
}
