package com.example.recycleviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.MyViewHolder> {
    Context context;
    ArrayList<ModelMakanan> modelMakanans;
    private ItemClickListener mClickListener;

    public AdapterMakanan(Context context, ArrayList<ModelMakanan> modelMakanans){
        this.context = context;
        this.modelMakanans = modelMakanans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.makanan_layout, parent, false);

        return new AdapterMakanan.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(modelMakanans.get(position).getName());
        holder.tvDes.setText(modelMakanans.get(position).getDescription());
        Glide.with(new View(context)).load(modelMakanans.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelMakanans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView tvName, tvDes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textName);
            tvDes = itemView.findViewById(R.id.textDes);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
ModelMakanan getItem(int id) {return  modelMakanans.get(id);}
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
