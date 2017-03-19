package com.example.hppc.mood;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.InputStream;

/**
 * Created by HP PC on 17-03-2017.
 */

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="quotes.db";
    private static final int DATABASE_VERSION=1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);
        Log.i("db open help", "DatabaseOpenHelper: "+context.getExternalFilesDir(null).getAbsolutePath());
    }

}
