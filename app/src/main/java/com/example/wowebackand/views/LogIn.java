package com.example.wowebackand.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wowebackand.MainActivity;
import com.example.wowebackand.R;
import com.example.wowebackand.models.Client;
import com.example.wowebackand.models.filters.ClientFilter;
import com.example.wowebackand.respostory.ClientRespostory;
import com.example.wowebackand.viewModel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LogIn extends Fragment
{
    EditText userName,password;
    Button signUp;
    TextView forget,create;

    ClientRespostory respostory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_fragment,container,false);
        userName=view.findViewById(R.id.login_user_name);
        password=view.findViewById(R.id.login_password);
        signUp=view.findViewById(R.id.login);
        forget=view.findViewById(R.id.login_forget_password);
        create=view.findViewById(R.id.login_registration);

        signUp.setOnClickListener((view1)->{
            if (checkString(userName.getText().toString(),password.getText().toString())){

                Client client=clientExist(userName.getText().toString(),password.getText().toString());
                if (client!=null){
                    /**
                     * ndaza gukoresha iriya clientId nkoresheje MainViewModel.class
                     * maze nkurure completed,pending appoitements hamwe
                     */
                    MainViewModel.setClientId(client.getClientId());
                    MainActivity.navController.navigate(R.id.defaultFragment);
                }
                else {
                    Toast.makeText(getContext(),"the user does not exist",Toast.LENGTH_SHORT).show();
                }
            }
        });

        create.setOnClickListener((view1)->{
            MainActivity.navController.navigate(R.id.registerFragment);
        });

        forget.setOnClickListener((view1)->{
            /**
             * hano turaza gufungura indi fragment yo ku coveringa password
             * arko turaza kuyohereza kuri email password
             */
        });

        return view;
    }









    public boolean checkString(String username,String password){

        boolean check=false;

        if (username!=null && password!=null) {

            if (!username.trim().isEmpty()){
                check=true;
            }
        }

        return check;
    }

    public Client clientExist(String username,String password){
        ClientFilter filter=new ClientFilter();
        filter.setUsername(username);
        filter.setPassword(password);
        Client client=respostory.login(filter);
        return client;
    }





    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}
