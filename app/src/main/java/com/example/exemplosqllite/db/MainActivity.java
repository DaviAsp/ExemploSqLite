package com.example.exemplosqllite.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exemplosqllite.R;
import com.example.exemplosqllite.db.bean.Musica;
import com.example.exemplosqllite.db.dal.MusicaDAL;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        MusicaDAL dal = new MusicaDAL(this);
        ArrayAdapter <Musica> adapter;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dal.get("") );
        listView.setAdapter(adapter);
    }
}