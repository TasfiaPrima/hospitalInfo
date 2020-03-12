package com.prima.iut.splhospitalinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
   ListView listView;
   String[] listValues;
   private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.h);
        EditText theFilter =(EditText) findViewById(R.id.search);
        String[] values = new String[]{"Tairunnessa Memorial Medical College and Hospital", "Sultan General Hospital","Square Hospitals Limited","Samorita Hospital"};
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item, android.R.id.text1, values);
        listView.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i1, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i1, int i2, int i3) {
                (MainActivity.this).adapter.getFilter().filter( s );
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), TairunnessaHospital.class);
                    startActivityForResult(myintent, 0);
                }
                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), SultanGeneral.class);
                    startActivityForResult(myintent, 1);
                }
                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), SquareHospitalsLimited.class);
                    startActivityForResult(myintent, 2);
                }
                if (position == 3) {
                    Intent myintent = new Intent(view.getContext(), SamoritaHospital.class);
                    startActivityForResult(myintent, 3);
                }

            }
        });

    }
}
