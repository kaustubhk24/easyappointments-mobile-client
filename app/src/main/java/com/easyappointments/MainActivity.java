package com.easyappointments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public AppointmentFragment getAppsFragment() {
        if(appsFragment == null)
            appsFragment = new AppointmentFragment();
        return appsFragment;
    }

    public CustomerFragment getCustomersFragment() {
        if(customersFragment == null)
            customersFragment = new CustomerFragment();
        return customersFragment;
    }

    public ServiceFragment getServicesFragment() {
        if(servicesFragment == null)
            servicesFragment = new ServiceFragment();
        return servicesFragment;
    }

    private AppointmentFragment appsFragment;
    private CustomerFragment customersFragment;
    private ServiceFragment servicesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment frag = null;

                switch (item.getItemId()) {
                    case R.id.navigation_next_appointments:
                        frag = getAppsFragment();
                        break;
                    case R.id.navigation_customers:
                        frag = getCustomersFragment();
                        break;
                    case R.id.navigation_services:
                        frag = getServicesFragment();
                        break;
                    default:
                        return false;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, frag)
                        .commit();

                return true;
            }

        });

        appsFragment = new AppointmentFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, getAppsFragment()).commit();
    }
}
