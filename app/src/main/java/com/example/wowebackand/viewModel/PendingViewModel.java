package com.example.wowebackand.viewModel;

import android.app.Application;

import com.example.wowebackand.models.Appoitement;
import com.example.wowebackand.models.filters.AppoitementFilter;
import com.example.wowebackand.respostory.AppoitementRespostory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


public class PendingViewModel extends AndroidViewModel
{

    AppoitementRespostory respostory;
    MutableLiveData<List<Appoitement>> liveData;
    List<Appoitement> appoitements;

    public PendingViewModel(@NonNull Application application) {
        super(application);
        respostory=new AppoitementRespostory(application);
    }

    public void deleteAppoitement(){

    }

    public MutableLiveData<List<Appoitement>> getLiveData(){
        AppoitementFilter filter=new AppoitementFilter();
        filter.setClientId(1);
        filter.setStatus(0);
//        appoitements=respostory.getAppoitements(filter);
        liveData=respostory.getAppoitements(filter);
        return liveData;
    }
}
