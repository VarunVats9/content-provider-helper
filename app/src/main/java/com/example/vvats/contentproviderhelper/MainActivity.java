package com.example.vvats.contentproviderhelper;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String BLANK_SPACES = "      ";

    Uri CONTENT_URI = Uri.parse("content://com.varun.own.contentprovider/emp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLoad(View view) {
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, "_id");
        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String student = cursor.getString(1);
            String college = cursor.getString(2);
            stringBuilder.append(id + BLANK_SPACES + student + BLANK_SPACES + college + "\n");
        }
        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }
}
