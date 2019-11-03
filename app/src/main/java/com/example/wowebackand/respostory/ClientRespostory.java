package com.example.wowebackand.respostory;

import android.app.Application;

import com.example.wowebackand.Retrofit.ClientNet;
import com.example.wowebackand.Retrofit.DoNet;
import com.example.wowebackand.Retrofit.RetrofitService;
import com.example.wowebackand.models.Client;
import com.example.wowebackand.models.filters.ClientFilter;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Retrofit;

public class ClientRespostory
{

    ClientNet net;

    Application application;

    public ClientRespostory(Application application) {
        net= RetrofitService.createService(ClientNet.class);
        this.application=application;
    }

    public Client getClientInfo(ClientFilter filter){
        Call<Client> call=net.getClient(filter);
        DoNet<Client> doNet=new DoNet<>();
        call.enqueue(doNet);
        return doNet.getLiveData().getValue();
    }

    /**
     * it will return the list of technicians
     * @return
     */
    public MutableLiveData<List<Client>> techList(Integer serviceId)
    {
        ClientFilter filter=new ClientFilter();
        filter.setServiceId(serviceId);
        Call<List<Client>> call=net.getListTech(filter);
        DoNet<List<Client>> doNet=new DoNet<>();
        call.enqueue(doNet);
        return doNet.getLiveData();

    }

    public Integer createClient(Client client){
       Call<Integer> value=net.createClient(client);
        DoNet<Integer> doNet=new DoNet<>();
        value.enqueue(doNet);
        return (Integer) doNet.getLiveData().getValue();
    }

    public void deleteClient(){

    }

    public void uploadPic(){

    }

    public Client login(ClientFilter filter){
        Call<Client> call=net.getClient(filter);
        DoNet<Client> doNet=new DoNet<>();
        call.enqueue(doNet);
        return null;
    }
}
