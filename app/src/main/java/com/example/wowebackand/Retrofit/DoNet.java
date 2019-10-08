package com.example.wowebackand.Retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class DoNet<T> implements Callback<T> {

    MutableLiveData<T> liveData=new MutableLiveData<>();

    public T t;


    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (!response.isSuccessful()){
            Log.e("unsucesfull","code error:"+response.code());
            return;
        }
        Log.e("Donet","nahageze tu");
       t = response.body() != null? response.body():response.body();
       liveData.postValue(response.body());
//        this.setT(response.body());

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("onFailure",t.getMessage());
    }


    public MutableLiveData<T> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<T> liveData) {
        this.liveData = liveData;
    }
}
