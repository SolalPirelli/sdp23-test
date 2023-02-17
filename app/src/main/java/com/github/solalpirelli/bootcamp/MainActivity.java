package com.github.solalpirelli.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleButtonClick(View view) {
        Intent myIntent = new Intent(this, GreetingActivity.class);
        String name = ((EditText) this.findViewById(R.id.mainName)).getText().toString();
        myIntent.putExtra(GreetingActivity.NAME_KEY, name);
        startActivity(myIntent);
    }
}