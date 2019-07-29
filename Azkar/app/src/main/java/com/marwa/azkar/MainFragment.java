package com.marwa.azkar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment  extends Fragment  implements View.OnClickListener {
    @Nullable
    Button trynow,sbha,rokya;
    View view;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       // return inflater.inflate(R.layout.main,container,false);

        view = inflater.inflate(R.layout.main, container, false);



    trynow=view.findViewById(R.id.trynow);
        sbha=view.findViewById(R.id.signup);
        rokya=view.findViewById(R.id.login);

        trynow.setOnClickListener(this);
        sbha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Sbha sbha  = new Sbha();
                fragmentTransaction.add(R.id.fragment_container, sbha);
                fragmentTransaction.commit();
            }
        });
        rokya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 Rokya rokya  = new Rokya();
                fragmentTransaction.add(R.id.fragment_container, rokya);
                fragmentTransaction.commit();
            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Morning messageFrag  = new Morning();
        fragmentTransaction.add(R.id.fragment_container, messageFrag);
        fragmentTransaction.commit();
        }

}

