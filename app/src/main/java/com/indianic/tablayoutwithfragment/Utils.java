package com.indianic.tablayoutwithfragment;


import android.content.Context;
import android.content.SharedPreferences;

public class Utils{

    private SharedPreferences sharedPreferences;

    public Utils(Context mContext) {
        sharedPreferences = (SharedPreferences) mContext.getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void putInt(final String key,final int value){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public int getInt(final String key){
        return sharedPreferences.getInt(key,0);
    }
}
