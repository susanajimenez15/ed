package org.institutoserpis.ed.acategoria;

import android.database.Cursor;
import android.database.sqlite.*;
import  android.content.*;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 25/05/16.
 */
public class dbpruebahelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "dbprueba.db";
    private static final int DATABASE_VERSION = 1;
    private static Context context;


    public static void inic(Context context){
        dbpruebahelper.context=context;
    }


    private static dbpruebahelper instance;
    public static dbpruebahelper getInstance(){
        if (instance==null)
                instance= new dbpruebahelper(context);
        return  instance;
    }


    public static abstract class TableCategoria implements BaseColumns{

        public static final String NAME = "Categoria";
        public static final String COLUMN_NAME = "Nombre";
    }


    private static final String CREATE_TABLE_CATEGORIA ="Create table " + TableCategoria.NAME + "("
            + TableCategoria._ID+ "integer primary key, "+ TableCategoria.COLUMN_NAME + "Text" + ");";


    private static final String DROP_TABLE_CATEGORIA = "drop table if exists" + TableCategoria.NAME;

    public dbpruebahelper(Context contex){
        super(contex,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATEGORIA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_CATEGORIA);
        onCreate(db);
    }

    public long  insertcategoria(String nombre){
        SQLiteDatabase database= getReadableDatabase();
        ContentValues contentvalues =new ContentValues();
        contentvalues.put(TableCategoria.COLUMN_NAME,nombre);
        return database.insert(TableCategoria.NAME,null,contentvalues);
    }

    public List<Categoria> getCategorias(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //TODO sqLiteDatabase.query();
        String[] columns = new String[]{

                TableCategoria._ID,
                TableCategoria.COLUMN_NAME,

        };
        Cursor cursor = sqLiteDatabase.query(
                TableCategoria.NAME,
                columns,
                null,
                null,
                null,
                null,
                null

        );
        List<Categoria> categorias = new ArrayList<>();
        while(cursor.moveToNext())
            categorias.add(new Categoria(cursor.getLong(0), cursor.getString(1)));
            cursor.close();
        return categorias;
    }



}
