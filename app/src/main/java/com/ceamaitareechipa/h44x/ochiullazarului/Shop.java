package com.ceamaitareechipa.h44x.ochiullazarului;;import android.database.sqlite.SQLiteDatabase;

public class Shop {
    private String cod;
    private int id;
    private String pass;
    public Shop(int id, String cod, String pass)
    {
        this.id=id;
        this.cod=cod;
        this.pass=pass;
    }
    public Shop(){};
    public void setID(int id){
        this.id=id;
    }
    public void setCode(String codu) {
        this.cod = codu;
    }
    public void setPass(String parola) {
        this.pass = parola;
    }
    public int getId(){
        return id;
    }
    public String getCode() {
        return cod;
    }
    public String getPass() {
        return pass;
    }

}

