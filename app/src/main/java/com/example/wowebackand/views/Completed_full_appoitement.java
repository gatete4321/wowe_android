package com.example.wowebackand.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wowebackand.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Completed_full_appoitement extends Fragment
{
    Button submit,delete;
    TextView date,serviceName,contact,techName,description;
    EditText feedback;
    ImageView techPic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.display_completed_appoitement_view,container,false);
        submit=view.findViewById(R.id.app_view_button_submit);
        delete=view.findViewById(R.id.app_view_button_delete);
        date=view.findViewById(R.id.app_view_date);
        serviceName=view.findViewById(R.id.app_view_service_name);
        contact=view.findViewById(R.id.app_view_contact);
        techName=view.findViewById(R.id.app_view_tech_name);
        description=view.findViewById(R.id.app_view_description);
        feedback=view.findViewById(R.id.app_view_feedback);
        techPic=view.findViewById(R.id.app_image_view);






        return view;
    }

    /**
     * this will get all data to be displayed on the appointement form
     */
    public void setData(){

    }

    /**
     * this will handle all onclick events
     */
    public void onClickListeners(){
        delete.setOnClickListener((view)->{
            //delete the appoitement
        });

        submit.setOnClickListener((view)->{
            //submit ratings
            //submit feedback
        });
    }
}
