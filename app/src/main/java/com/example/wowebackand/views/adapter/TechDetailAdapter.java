package com.example.wowebackand.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.wowebackand.R;
import com.example.wowebackand.models.Client;
import com.example.wowebackand.views.MainActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * nsigaje gushyiramo data nzima gusa
 * 07|10|2019
 */
public class TechDetailAdapter extends RecyclerView.Adapter<TechDetailAdapter.MyViewHolderDetail> {

    List<Client> techinians;

    @NonNull
    @Override
    public MyViewHolderDetail onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tech_profile_item, parent, false);
        return new MyViewHolderDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderDetail holder, int position) {
        Client client = techinians.get(position);
        holder.techName.setText(client.getUsername());
        holder.techAbout.setText(client.getClientAbout());
        holder.techCarrier.setText("carrier: " + client.getServiceId());
        holder.techLocation.setText(client.getClientLocation());
        holder.imageView.setImageResource(client.getStatus());
        holder.button.setOnClickListener((view) -> {
            MainActivity.navController.navigate(R.id.makeAppoitement);// iyi id nago ibaho ni sample tu
        });
    }

    @Override
    public int getItemCount() {
        if (techinians == null)
            initialize();
        return techinians.size();
    }

    public class MyViewHolderDetail extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button button;
        RatingBar ratingBar;
        TextView techName, techCarrier, techAbout, techLocation;


        public MyViewHolderDetail(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tech_image);
            button = itemView.findViewById(R.id.button_make_appoitement);
            ratingBar = itemView.findViewById(R.id.tech_detail_ratingBar);
            techAbout = itemView.findViewById(R.id.profile_item_tech_about);
            techName = itemView.findViewById(R.id.profile_item_tech_name);
            techCarrier = itemView.findViewById(R.id.profile_item_tech_carier_name);
            techLocation = itemView.findViewById(R.id.profile_item_tech_location);
            itemView.setOnClickListener((view) -> {
//                MainActivity.navController.navigate();
            });

        }

    }

    void initialize() {
        techinians = new ArrayList<>();
        Client client;
        for (int i = 0; i < 20; i++) {
            client = new Client();
            client.setUsername("mbste" + i);
            client.setClientId(i);
            client.setServiceId(i <= 10 ? i <= 5 ? 4 : 6 : i <= 15 ? 4 : 5);
            client.setStatus(R.drawable.abubatsi);
            client.setClientAbout("yize iprc" + 2000 + i);

            techinians.add(client);
        }
    }
}
