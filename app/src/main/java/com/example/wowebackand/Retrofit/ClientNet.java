package com.example.wowebackand.Retrofit;


import com.example.wowebackand.models.Appoitement;
import com.example.wowebackand.models.Client;
import com.example.wowebackand.models.filters.AppoitementFilter;
import com.example.wowebackand.models.filters.ClientFilter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClientNet
{
    @POST("/create")
    Call<String> createClient(@Body Client client);

    Call<String> deleteClient(@Body ClientFilter filter);


    @POST("/updateinfo")
    Call<String> updateClient(@Body Client client);


    @POST("public/client/info")
    Call<Client> getClient(@Body ClientFilter filter);

    @POST("public/client/all")
    Call<List<Client>> getListTech(@Body ClientFilter filter);
}
