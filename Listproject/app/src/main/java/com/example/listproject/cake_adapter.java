package com.example.listproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cake_adapter extends RecyclerView.Adapter<cake_adapter.cakeView> {

    ArrayList<cakes> cakesList=new ArrayList<>();

    public cake_adapter(ArrayList<cakes> cakesList) {
        this.cakesList = cakesList;
    }

    @NonNull

    @Override
    public cakeView onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cakes,parent,false);
        return new cakeView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  cake_adapter.cakeView holder, int position) {
        cakes cake=cakesList.get(position);
        holder.textcakename.setText(cake.getCake_name());
        holder.cakeitem.setText(cake.cake_name);


    }

    @Override
    public int getItemCount() {
        return cakesList.size();
    }

    public class cakeView extends RecyclerView.ViewHolder{
        TextView textcakename,cakeitem;




        public cakeView(@NonNull  View itemView) {

            super(itemView);
            textcakename=(TextView)itemView.findViewById(R.id.text_cake_name);
            cakeitem=(TextView)itemView.findViewById(R.id.text_item_name);

        }
    }
}
