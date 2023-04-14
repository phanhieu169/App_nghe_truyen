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
public void addUser(User user) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_NAME, user.getName());
    values.put(KEY_PASSWORD, user.getPassword());
    values.put(KEY_LOGIN_NAME, user.getLogin_name());

    db.insert(TABLE_NAME, null, values);
    db.close();
}
public UsergetStudent(int studentId) {
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(studentId) },null, null, null);
    if(cursor != null)
        cursor.moveToFirst();
    Useruser= new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
    return student;
}
public List<User> getAllStudents() {
    List<User>  userList = new ArrayList<>();
    String query = "SELECT * FROM" + TABLE_NAME;

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(query, null);
    cursor.moveToFirst();

    while(cursor.isAfterLast() == false) {
        Useruser= new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        userList.add(user);
        cursor.moveToNext();
    }
    return userList;
}
