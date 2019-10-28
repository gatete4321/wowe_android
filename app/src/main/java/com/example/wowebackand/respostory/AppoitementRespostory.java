package com.example.wowebackand.respostory;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.wowebackand.Retrofit.AppoitementNet;
import com.example.wowebackand.Retrofit.DoNet;
import com.example.wowebackand.Retrofit.RetrofitService;
import com.example.wowebackand.models.Appoitement;
import com.example.wowebackand.models.filters.AppoitementFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppoitementRespostory {

    private AppoitementNet appoitementNet;
     private Appoitement appoitement;

    public AppoitementRespostory(Application application) {
        appoitementNet= RetrofitService.createService(AppoitementNet.class);
    }

    /**
     * create an appoitement
     * @param appoitement
     * @return
     */
    public String insertAppoitement(Appoitement appoitement) {

        Call<String> call=appoitementNet.createAppoitement(appoitement);
        DoNet<String> net=new DoNet<>();
        call.enqueue(net);
        return net.getLiveData().getValue();
    }

    /**
     * update an appoitement
     * @return
     */
    public Appoitement updateAppoitement() {
        return null;
    }

    /**
     * get appoitement by id,clientId,techId,
     * @param filter
     * @return
     */
    public Appoitement getAppoitement(AppoitementFilter filter) {
        Call<Appoitement> appoitementCall=appoitementNet.getAppoitement(filter);
        DoNet net=new DoNet<Appoitement>();
        appoitementCall.enqueue(net);
        return (Appoitement) net.getLiveData().getValue();
    }

    /**
     * list of completed appoitements and pending appoitements
     *ndakoresha DoNet<Object.class>().class mu gukora operation zose za network
     * @return
     */
    public MutableLiveData<List<Appoitement>> getAppoitements(AppoitementFilter filter) {
        Call<List<Appoitement>> listCall=appoitementNet.getAllAppoitements(filter);
        DoNet<List<Appoitement>> net=new DoNet();
        listCall.enqueue(net);
        return net.getLiveData();
    }


    /**
     *
     */
    public void deleateAppoitement(){

    }

    public void feedBack(){

    }

    public void rateAppoitement(){

    }




    public void doNet(){

    }

}
