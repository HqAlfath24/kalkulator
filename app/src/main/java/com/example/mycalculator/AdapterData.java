package com.example.mycalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String>listData;
    LayoutInflater inflater;

    public AdapterData(Context context, List<String> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {
        holder.txtBil1.setText(listData.get(position));
        holder.txtBil2.setText(listData.get(position));
        holder.txtOpr.setText(listData.get(position));
        holder.txtHasil.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        TextView txtBil1, txtBil2, txtOpr, txtHasil;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtBil1 = itemView.findViewById(R.id.txtBil1);
            txtBil2 = itemView.findViewById(R.id.txtBil2);
            txtOpr = itemView.findViewById(R.id.txtOpr);
            txtHasil = itemView.findViewById(R.id.txtHasil);
        }
    }
}
