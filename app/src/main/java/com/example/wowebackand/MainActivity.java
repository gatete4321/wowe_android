package com.example.wowebackand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.ui.NavigationUI;

import com.example.wowebackand.R;
import com.example.wowebackand.test.TestNavFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener
{



    Dialog dialog;

    public Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    public DrawerLayout drawerLayout;

    public static NavController navController;

    public NavigationView navigationView;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.my_linear_layout);
        setupNavigation();
    }

    private void setupNavigation() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




//        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);


        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView =findViewById(R.id.navigationView);


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawerLayout, Navigation.findNavController(this, R.id.nav_host_fragment));
    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setChecked(true);

        drawerLayout.closeDrawers();

        int id = menuItem.getItemId();

        switch (id) {

            case R.id.first:
                navController.navigate(R.id.defaultFragment);
                //             initializeViewPager();
                break;

            case R.id.second:
                navController.navigate(R.id.notification);

                break;

            case R.id.third:
                navController.navigate(R.id.MyProfileFrag);
                break;
            case R.id.about_us_menu:
                navController.navigate(R.id.aboutUsFragment);
                break;

            case R.id.logout_menu:
//                logoutP();
//                TestNavFragment.controller.navigate(R.id.loginFragment);
                navController.navigate(R.id.testNavigation);
                break;
        }
        return true;

    }

    void logoutP(){
        TextView logout,cancel;
        dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialbox_logout);
        logout=dialog.findViewById(R.id.real_logout);
        cancel=dialog.findViewById(R.id.cancel_logout);
        cancel.setOnClickListener((view)->{
            dialog.dismiss();
        });
        logout.setOnClickListener((view)->{
            /**
             * tuzahasyira code zo ku loginga out
             */
            Toast.makeText(this,"log out",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        dialog.show();
    }
}
