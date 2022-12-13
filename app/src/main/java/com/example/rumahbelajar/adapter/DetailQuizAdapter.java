package com.example.rumahbelajar.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rumahbelajar.R;
import com.example.rumahbelajar.quiz.QuestionData;

import java.util.ArrayList;

public class DetailQuizAdapter extends RecyclerView.Adapter<DetailQuizAdapter.ListViewHolder>{

    private final Context context;
    private final ArrayList<QuestionData> resultList;

    public DetailQuizAdapter(Context context, ArrayList<QuestionData> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public DetailQuizAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_coba, parent, false);

        DetailQuizAdapter.ListViewHolder viewHolder = new DetailQuizAdapter.ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tvQuestion.setText(resultList.get(position).getQuestion());
//        holder.rbA.setText(resultList.get(position).getAnswer(0));
//        holder.rbB.setText(resultList.get(position).getAnswer(1));
//        holder.rbC.setText(resultList.get(position).getAnswer(2));
//        holder.rbD.setText(resultList.get(position).getAnswer(3));
//        holder.rbE.setText(resultList.get(position).getAnswer(4));
    }

    @Override
    public int getItemCount() {
        Log.d("jumlah baru: ", String.valueOf(resultList.size()));
        return resultList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion, tv1, tv2;
        RadioGroup rdg;
        RadioButton rbA,rbB,rbC,rbD,rbE;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
//            rdg = itemView.findViewById(R.id.rg);
//            rbA = itemView.findViewById(R.id.rbA);
//            rbB = itemView.findViewById(R.id.rbB);
//            rbC = itemView.findViewById(R.id.rbC);
//            rbD = itemView.findViewById(R.id.rbD);
//            rbE = itemView.findViewById(R.id.rbE);
        }
    }
}
