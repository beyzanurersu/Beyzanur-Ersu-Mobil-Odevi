package com.example.blm5218_odev;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder> {

    Context context;
    List<Quiz> quiz;

    QuizAdapter(Context context , List<Quiz> quiz){

        this.context=context;
        this.quiz=quiz;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.soru.setText(quiz.get(position).getSoru());
        holder.cevap1.setText(quiz.get(position).getCevap1());
        holder.cevap2.setText(quiz.get(position).getCevap2());
        holder.cevap3.setText(quiz.get(position).getCevap3());
        holder.cevap4.setText(quiz.get(position).getCevap4());
        holder.dogrucevap.setText(quiz.get(position).getDogru_cevap());
        holder.imageView.setImageResource(quiz.get(position).getPhotoid());
        holder.btn_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        quiz.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, quiz.size());
                        holder.itemView.setVisibility(View.GONE);
                    }
                });
                builder.show();


            }
        });
        holder.btn_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(context,AddQuestionActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return quiz.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView soru,cevap1,cevap2,cevap3,cevap4,dogrucevap;
        Button btn_sil,btn_guncelle;

        public MyViewHolder(View itemview){
            super(itemview);
            imageView=itemview.findViewById(R.id.photo);
            soru=itemview.findViewById(R.id.soru);
            cevap1=itemview.findViewById(R.id.cevap1);
            cevap2=itemview.findViewById(R.id.cevap2);
            cevap3=itemview.findViewById(R.id.cevap3);
            cevap4=itemview.findViewById(R.id.cevap4);
            dogrucevap=itemview.findViewById(R.id.dogru_cevap);
            btn_sil=itemview.findViewById(R.id.btn_sil);
            btn_guncelle=itemview.findViewById(R.id.btn_güncelle);


        }
    }
}
