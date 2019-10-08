package com.example.wowebackand.views.recycles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wowebackand.R;
import com.example.wowebackand.views.adapter.TechDetailAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * hano ni aha displayinga ama item yaba techinicie muri recycle view
 */
public class DisplayTechDetail extends Fragment
{
    RecyclerView recyclerView;
    TechDetailAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_tech_detail,container,false);
        recyclerView=view.findViewById(R.id.recycle_view_tech_detail);
        adapter=new TechDetailAdapter();

    recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
