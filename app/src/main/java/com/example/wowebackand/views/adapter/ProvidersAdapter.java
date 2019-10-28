package com.example.wowebackand.views.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.wowebackand.R;
import com.example.wowebackand.models.Client;
import com.example.wowebackand.views.MainActivity;
import com.example.wowebackand.views.recycles.DisplayServiceProvider;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProvidersAdapter extends RecyclerView.Adapter<ProvidersAdapter.MyProvidersHolder> {

    List<Client> technicians;

    Context context;

    public ProvidersAdapter(Context context,List<Client> technicians) {
        this.context = context;
        this.technicians=technicians;
    }

    @NonNull
    @Override
    public MyProvidersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_provider_item,parent,false);
        return new MyProvidersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProvidersHolder holder, int position)
    {
        Client client=technicians.get(position);

        Bundle bundle=new Bundle();
        bundle.putParcelable("client",client);

        holder.techImage.setImageResource(R.drawable.ic_save_black_24dp);
        holder.techDescription.setText(client.getPassword());
        holder.techName.setText(client.getUsername());
        holder.makeApp.setOnClickListener((view)->{
            MainActivity.navController.navigate(R.id.makeAppoitement,bundle);
//            Toast.makeText(context,"make appoitement",Toast.LENGTH_SHORT).show();
            /**
             * hano nima clika ngomba kujya kuri make appoitementFragment
             */
        });


        holder.calling.setOnClickListener((view)->{

            Toast.makeText(context,"call",Toast.LENGTH_SHORT).show();
            /**
             * hano na ha click azahita ahamagara kandi ngomba kubika inshuro yahamagay
             */
        });
        holder.view.setOnClickListener((view)->{

            MainActivity.navController.navigate(R.id.techDetail,bundle);
            /**
             * hano turajya kuri displayTechnician
             * #nayo iza kuba iri muri recycleview arko iri left ariko i displayinga full size one item#hano ni cyera man
             * #twabigize fragment imwe#ibya vuba
             * dupassinzemo client.class
             */
        });

    }

    @Override
    public int getItemCount() {
        if (DisplayServiceProvider.clientList==null){
            initialize();
        }
        return technicians.size();
    }

    public static class MyProvidersHolder extends RecyclerView.ViewHolder{
        ImageView techImage;
        TextView techName,techDescription,calling,makeApp;
        View view;
        public MyProvidersHolder(@NonNull View itemView) {
            super(itemView);
            techImage=itemView.findViewById(R.id.image_view_provider_tech);
            techName=itemView.findViewById(R.id.item_tech_name);
            techDescription=itemView.findViewById(R.id.item_tech_description);
            calling=itemView.findViewById(R.id.item_tech_calling);
            makeApp=itemView.findViewById(R.id.item_tech_appoitement);
            view=itemView;
        }

    }


    public List<Client> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(List<Client> technicians) {
        this.technicians = technicians;
    }



    public void initialize(){
        technicians=new ArrayList<>();
        Client client;
        for (int i=0;i<=15;i++){
            client=new Client();
            client.setUsername("rukara"+i);
            client.setPassword("electromechanic"+i);
            technicians.add(client);
        }
    }

}
