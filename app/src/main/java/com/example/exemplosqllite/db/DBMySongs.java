package com.example.exemplosqllite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBMySongs extends SQLiteOpenHelper {
    private static final int VERSAO = 1;   
    public DBMySongs(Context context) {
        super(context, "mysongs.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE genero( gen_id INTEGER PRIMARY KEY AUTOINCREMENT, gen_nome VARCHAR (15));");
        db.execSQL("insert into genero values (null, 'sertanejo')");
        db.execSQL("insert into genero values (null, 'rock')");


        db.execSQL("CREATE TABLE musica " +
           "(mus_id  INTEGER PRIMARY KEY AUTOINCREMENT, " +
           "mus_ano INTEGER, mus_titulo VARCHAR (40), " +
           "mus_interprete VARCHAR (30), " +
           "mus_genero INTEGER REFERENCES genero (gen_id), " +
           "mus_duracao NUMERIC (4, 1) );");
        db.execSQL("insert into musica values (null,1970,'Stairway to heaven','led Zepellin',2,11)");
        db.execSQL("insert into musica values (null,1970,'Bohemian Rapsody','Queen',2,6)");
        db.execSQL("insert into musica values (null,1970,'Boate Azul','Trio Parada Dura',1,5)");
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS musica");
        db.execSQL ("DROP TABLE IF EXISTS genero");
        onCreate(db);
        
    }
}

