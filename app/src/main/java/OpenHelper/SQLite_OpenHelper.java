package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by alfre on 30/11/2016.
 */
public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTonos ="create table tonos(_id integer primary key autoincrement,Nombre text)";
        String queryTiempos = "create table tiempos(_id integer primary key autoincrement,tonos_id integer, Tiempo integer,foreign key(tonos_id) references tonos(_id))";
        db.execSQL(queryTonos);
        db.execSQL(queryTiempos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarReg(String nombreTono){
        ContentValues values = new ContentValues();
        values.put("Nombre", nombreTono);
        this.getWritableDatabase().insert("tonos", null, values);
        this.close();
    }

    public void insertarTiempos(List<Long> tiempos){
        ContentValues values = new ContentValues();
        Cursor tono = lastTono();
        tono.moveToFirst();
        int id_tono=tono.getInt(0);
        for (int i = 0;i<tiempos.size();i++){
            values.put("Tiempo", tiempos.get(i));
            values.put("tonos_id",id_tono);
            this.getWritableDatabase().insert("tiempos", null, values);
            this.close();
        }

    }
    public Cursor lastTono(){
        Cursor cursor = null;
        cursor=this.getReadableDatabase().query("tonos",new String[]{"_id","Nombre"},null,null,null,null,"_id desc","1");
        return cursor;
    }
}
