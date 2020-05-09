package com.example.heynotification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Cake> cakes;
    ArrayList<Cake> cartcakes;
    Context ctx;


    public Adapter (Context ctx,List<Cake> cakes){
        this.inflater=LayoutInflater.from(ctx);
        this.ctx=ctx;
        this.cakes=cakes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_file,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final Cake cake=cakes.get(i);
        holder.cakename.setText(cake.getCake_name());
//        holder.cakeprice.setText(cake.getPrice());
        holder.cakeweight.setText(cake.getWeight());
        //imageview
        Picasso.get().load(cakes.get(i).getImgUrl()).into(holder.cakeimage);



    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cakename,cakeprice,cakeweight;
        ImageView cakeimage;
        Button addButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cakename=itemView.findViewById(R.id.cakename);
//            cakeprice=itemView.findViewById(R.id.cakeprice);
            cakeweight=itemView.findViewById(R.id.cakeweight);
            cakeimage=itemView.findViewById(R.id.cakeimage);



        }
    }
}
