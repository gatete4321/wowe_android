package com.example.wowebackand.views.recycles;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.wowebackand.R;
import com.example.wowebackand.viewModel.PendingViewModel;
import com.example.wowebackand.views.adapter.PendingAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * iyi fragment icyo imaze nu ku displayinga list yama appoitements atarakorwa
 */
public class DisplayFragPending extends Fragment {

    private RecyclerView recyclerView;
    private PendingViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_frag_pending,container,false);
        recyclerView=view.findViewById(R.id.recycle_view_pending);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        viewModel= ViewModelProviders.of(this).get(PendingViewModel.class);
        PendingAdapter adapter=new PendingAdapter(((position, id) -> {
            /**
             * ni kimwe nka FragCompleted
             */
        }));
        recyclerView.setAdapter(adapter);
        viewModel.getLiveData().observe(this,appoitements -> {
            adapter.setAppoitements(appoitements);
        });
        return view;
    }
}
