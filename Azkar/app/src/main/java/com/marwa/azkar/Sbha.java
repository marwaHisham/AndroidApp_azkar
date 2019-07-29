package com.marwa.azkar;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Sbha extends Fragment {
    @Nullable
    AzkarAdapter az;
    private TextView total;
    Button increment;
    private int totalcount = 0;
    private int num = 0;
    private SQLiteDatabase mDatabase;
    private SQLiteDatabase dbr;
    int silent;

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fregmant_profile, container, false);
        //DBHelper dbhelper = new DBHelper(getContext());
        //dbhelper.onCreate(dbr);
        // az = new AzkarAdapter(this, getAllItems());

        total = view.findViewById(R.id.total);
        increment = view.findViewById(R.id.numcount);

        //mDatabase = dbhelper.getWritableDatabase();
        readData(view);
     /*  Cursor c = dbr.rawQuery("SELECT * FROM " + DataBase.DatabaseTable.TABLE_NAME, null);
        if (c.getCount() <= 0) {
            c.close();

           // c.moveToFirst();
        } else {
            //Cursor c=dbr.rawQuery("SELECT * FROM "+DataBase.DatabaseTable.TABLE_NAME ,null);
            System.out.println("mmmmm");
        }
        */

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, "num", Toast.LENGTH_SHORT).show();
                if (savedInstanceState == null) {
                    increase();
                } else {
                    num = 0;
                    increase();
                }
            }
        });
        return view;
    }

    private void increase() {
        if (num != 100) {
            num++;
            increment.setText(String.valueOf(num));
            totalcount++;
            total.setText(String.valueOf(totalcount));
            saveData(view);

        } else {
            num = 0;
            increment.setText(String.valueOf(num));
        }

    }
    public void saveData(View view){
        SharedPreferences settings =getContext().getSharedPreferences("counter", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

       editor.putInt("counter", totalcount+silent);

        // Commit the edits!
        editor.commit();
    }
    public void readData(View view){
        SharedPreferences settings =getContext().getSharedPreferences("counter", Context.MODE_PRIVATE);
        silent = settings.getInt("counter",0);
        total.setText(String.valueOf(silent));
    }

    @Override
    public void onStop() {

        super.onStop();
       // addItem();


        // Commit the edits!
        //editor.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
/*
    private void addItem() {
        if (total.getText().toString().trim().length() == 0 ) {
            return;
        }

        String name = total.getText().toString();
        ContentValues cv = new ContentValues();
     //   cv.put("5",5);
        cv.put(DataBase.DatabaseTable.COLUMN_AMOUNT, name);
        //cv.put(DataBase.DatabaseTable.COLUMN_AMOUNT,"5");

       mDatabase.insert(DataBase.DatabaseTable.TABLE_NAME, null, cv);
        // az.swapCursor(getAllItems());

        cv.clear();

        }*/


    }

