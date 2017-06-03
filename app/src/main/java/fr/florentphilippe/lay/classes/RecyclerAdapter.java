package fr.florentphilippe.lay.classes;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import fr.florentphilippe.lay.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    ArrayList<Drug> drugContainer = new ArrayList<>();

    //Data constructor from list
    public RecyclerAdapter(ArrayList<Drug> drugs){
        this.drugContainer = drugs;
    }

    //Creates ViewHolders
    @Override
    public RecyclerViewHolder onCreateViewHolder (ViewGroup viewGroup, int itemType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drug_card, viewGroup, false);
        return new RecyclerViewHolder (view);
    }

    //Fill the cell with objects' data
    public void onBindViewHolder (RecyclerViewHolder recyclerViewHolder, int position){
        Drug drug = drugContainer.get(position);
        recyclerViewHolder.bind(drug);
    }



    @Override
    public int getItemCount() {
        return drugContainer.size();
    }
}
