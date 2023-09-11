package com.example.exemplosqllite.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.AccessNetworkConstants;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exemplosqllite.R;
import com.example.exemplosqllite.db.bean.Genero;
import com.example.exemplosqllite.db.bean.Musica;
import com.example.exemplosqllite.db.dal.GeneroDAL;
import com.example.exemplosqllite.db.dal.MusicaDAL;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

   private FloatingActionButton fab;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.floatingActionButton);
        MusicaDAL dal = new MusicaDAL(this);
        ArrayAdapter <Musica> adapter;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dal.get("") );
        listView.setAdapter(adapter);

        fab.setOnClickListener(e -> { addMusica();});

    }

    private  void  addMusica(){

        Genero genero = new GeneroDAL(this).get(2);
       Musica m = new Musica(1988, "Tempo Perdido","Legia Urbana", genero, 7);
        MusicaDAL mdal = new MusicaDAL(this);
      mdal.salvar(m);
      ArrayAdapter  <Musica> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mdal.get("") );
        listView.setAdapter(adapter);

    }
}