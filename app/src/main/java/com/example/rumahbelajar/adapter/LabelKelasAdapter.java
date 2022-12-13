package com.example.rumahbelajar.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rumahbelajar.R;
import com.example.rumahbelajar.kelas.KelasActivity;
import com.example.rumahbelajar.kelas.KelasData;
import com.example.rumahbelajar.quiz.DetailQuizActivity;

import java.util.ArrayList;

public class LabelKelasAdapter extends RecyclerView.Adapter<LabelKelasAdapter.ListViewHolder>{

    private Context context;
    private ArrayList<KelasData> resultList;

    public LabelKelasAdapter(Context context, ArrayList<KelasData> resultList) {
        this.context = context;
        this.resultList = resultList;
    }


    @NonNull
    @Override
    public LabelKelasAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_label_kelas, parent, false);

        LabelKelasAdapter.ListViewHolder viewHolder = new LabelKelasAdapter.ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tv1.setText(resultList.get(position).getNamaKelas());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), KelasActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("namaKelas", resultList.get(position).getNamaKelas());

            intent.putExtras(bundle);
            v.getContext().startActivity(intent);

            Toast.makeText(holder.itemView.getContext(), "" + resultList.get(holder.getAdapterPosition()).getNamaKelas(), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
