package com.example.ejerciciolistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mList;
    ArrayAdapter<Sitio> mAdapter;
    Button button;
    ArrayList<Sitio> sitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sitios = new ArrayList<>();

        mList = findViewById(R.id.lista);

        mAdapter = new SitiosAdapter(this,sitios);





        button = findViewById(R.id.siguiente);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, save.class );
                startActivityForResult(intent, 2);
            }

        });

        mList.setAdapter(mAdapter);



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            String sitio = data.getStringExtra("sitio");
            sitios.add(new Sitio(sitio));
            mAdapter.notifyDataSetChanged();
        }
    }
}
