# DatabaseHandler.java
package com.framgia.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "schoolManager";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "users";

	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_LOGIN_NAME = "login_name";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_users_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_PASSWORD, KEY_LOGIN_NAME);
		db.execSQL(create_users_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String drop_users_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
		db.execSQL(drop_users_table);

		onCreate(db);
	}
}
