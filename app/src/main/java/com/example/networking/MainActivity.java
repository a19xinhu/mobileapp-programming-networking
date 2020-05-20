package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] mountainNames={"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations={"Alps","Alps","Alaska"};
    private int[] mountainHeights={4478,4808,6190};
    private ArrayList<String> listData= new ArrayList<>(Arrays.asList(mountainNames));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.list_item_textview,R.id.listview,listData);

        ListView my_listview=(ListView) findViewById(R.id.listview);

        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Enter yout text here", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


