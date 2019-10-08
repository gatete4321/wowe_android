package com.example.wowebackand.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wowebackand.R;
import com.example.wowebackand.models.Appoitement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.MyviewHolderPending> {
    private List<Appoitement> appoitements;

    private MyOnRecyclerListener listener;

    public PendingAdapter(MyOnRecyclerListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyviewHolderPending onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=LayoutInflater
             .from(parent.getContext()).inflate(R.layout.layout_pending_item,parent,false);
        return new MyviewHolderPending(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolderPending holder, int position) {

        Appoitement appoitement=appoitements.get(position);
        holder.serviceName.setText("ngewe"+appoitement.getServiceId());
        holder.techName.setText("rugamaba"+appoitement.getClientId());
        holder.dateDisplay.setText(appoitement.getDoneTime().toString());
        //        holder.imageView.draw(R.drawable.ic_edi);
        holder.techName.setOnClickListener((view)->{
            //listener.onRecyclerViewItemCliked(position,view.getId());
            holder.techName.setText("gatete");
        });
    }

    @Override
    public int getItemCount() {
        if (appoitements==null)
            initializeAppoitements();
        return appoitements.size();
    }

    public class MyviewHolderPending extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView serviceName;
        TextView techName;
        TextView dateDisplay;
        public MyviewHolderPending(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.pending_item_image);
            serviceName=itemView.findViewById(R.id.pending_item_text_view_service_name);
            techName=itemView.findViewById(R.id.pending_item_display_tech_name);
            dateDisplay=itemView.findViewById(R.id.pending_item_date_display);
            itemView.setOnClickListener((view)->{
                listener.onRecyclerViewItemCliked(getAdapterPosition(),view.getId());
            });
        }
    }




    public void setAppoitements(List<Appoitement> appoitements){
        this.appoitements=appoitements;
        notifyDataSetChanged();
    }

    public void initializeAppoitements(){
        appoitements=new ArrayList<>();
        Appoitement appoitement ;
        for (int i=0;i<=12;i++){
            appoitement=new Appoitement();
            appoitement.setTechId(i);
            appoitement.setClientId(i);
            appoitement.setServiceId(i);
            appoitement.setDoneTime(new Date());
            appoitements.add(appoitement);
        }
    }
}
