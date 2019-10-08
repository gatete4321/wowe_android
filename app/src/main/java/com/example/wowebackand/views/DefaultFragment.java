package com.example.wowebackand.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wowebackand.R;
import com.example.wowebackand.views.recycles.DisplayFragComplete;
import com.example.wowebackand.views.recycles.DisplayFragPending;
import com.example.wowebackand.views.recycles.DisplayFragService;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class DefaultFragment extends Fragment {

    ViewPager viewPager;

    TabLayout tabLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.default_fragment, container, false);

        tabLayout=view.findViewById(R.id.default_Fragment_tablayout);

        viewPager=view.findViewById(R.id.my_view_pager);
       FragmentManager manager=getFragmentManager();
       viewPager.setAdapter(new MyPagerAdapter(manager));
       tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}

class MyPagerAdapter extends FragmentStatePagerAdapter{

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new DisplayFragService();
            case 1:
                return new DisplayFragComplete();
            case 2:
                return new DisplayFragPending();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "services";
           case 1:
               return "completed";
           case 2:
               return "peding";
       }
        return null;
    }

}
