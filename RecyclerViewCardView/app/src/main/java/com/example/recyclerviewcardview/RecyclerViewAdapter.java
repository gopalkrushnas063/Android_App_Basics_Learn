package com.example.recyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<EmployeeDetails> arrEmployees;

    public RecyclerViewAdapter(Context context, ArrayList<EmployeeDetails> arrEmployees) {
        this.context = context;
        this.arrEmployees = arrEmployees;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_contact,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.empImg.setImageResource(arrEmployees.get(position).img);
        holder.empid.setText(arrEmployees.get(position).empid);
        holder.name.setText(arrEmployees.get(position).name);
        holder.email.setText(arrEmployees.get(position).email);
        holder.mobile.setText(arrEmployees.get(position).mobile);
        holder.designation.setText(arrEmployees.get(position).designation);
    }

    @Override
    public int getItemCount() {
        return arrEmployees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView empid,name,email,mobile,designation;
        ImageView empImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            empid = itemView.findViewById(R.id.empid);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            mobile = itemView.findViewById(R.id.mobile);
            designation = itemView.findViewById(R.id.designation);
            empImg = itemView.findViewById(R.id.empImg);
        }
    }
}
