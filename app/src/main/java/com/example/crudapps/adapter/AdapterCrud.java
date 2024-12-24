package com.example.crudapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.crudapps.R;
import com.example.crudapps.dataset.ItemData;

import java.util.ArrayList;

public class AdapterCrud extends RecyclerView.Adapter<AdapterCrud.ViewHolder> {

    ArrayList<ItemData> array;
    Context context;

    public AdapterCrud(Context context, ArrayList<ItemData> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_custom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemData data = array.get(position);
        if (data != null) {
            holder.setImageView(data.getImages());
            holder.setTitle(data.getTitle());
            holder.setJumlah(data.getJumlah());

            // Set onClickListeners for add and min buttons
            holder.btnAdd.setOnClickListener(v -> {
                int currentJumlah = data.getJumlah();
                data.setJumlah(currentJumlah + 1); // Increment quantity
                notifyItemChanged(position); // Notify adapter to refresh this item
            });

            holder.btnMin.setOnClickListener(v -> {
                int currentJumlah = data.getJumlah();
                if (currentJumlah > 0) {
                    data.setJumlah(currentJumlah - 1); // Decrement quantity
                    notifyItemChanged(position); // Notify adapter to refresh this item
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, jumlah;
        ImageView imageView, btnAdd, btnMin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_name);
            jumlah = itemView.findViewById(R.id.text_jumlah);
            imageView = itemView.findViewById(R.id.img_custom);

            btnAdd = itemView.findViewById(R.id.btn_add);
            btnMin = itemView.findViewById(R.id.btn_min);
        }

        public void setImageView(String url) {
            Glide.with(context)
                    .load(url)
                    .into(imageView);
        }

        public void setTitle(String title_text) {
            title.setText(title_text);
        }

        public void setJumlah(int j) {
            jumlah.setText(String.valueOf(j)); // Update the quantity displayed
        }
    }
}
