package com.example.wowebackand.views.recycles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wowebackand.R;
import com.example.wowebackand.viewModel.ProvideViewModel;
import com.example.wowebackand.views.adapter.ProvidersAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * iyi fragment icyo imaze nu ku displayinga list ya ba techinicie
 * bakora ako kazi
 */
public class DisplayServiceProvider extends Fragment
{
    private RecyclerView recyclerView;

    private ProvideViewModel viewModel;

    private ProvidersAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_frag_service_provider,container,false);




        recyclerView=view.findViewById(R.id.service_provider);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel= ViewModelProviders.of(getActivity()).get(ProvideViewModel.class);
        /**
         * i have not yet implement the eventClickListener
         * in this fragment
         * na data passinga mo zishobora guhinduka
         * zikareka kuba Client.class zikaba wend
     ClientForm.class extend Client.class
         * {
         *    private String serviceName;         *
         * }
         * on 30/9/2019         */

        adapter=new ProvidersAdapter(getActivity().getApplicationContext());

        recyclerView.setAdapter(adapter);

//        viewModel.getClientLivedata().observe(this,client -> {
//            adapter.setTechnicians(client);
//        });


        return view;
    }
}
