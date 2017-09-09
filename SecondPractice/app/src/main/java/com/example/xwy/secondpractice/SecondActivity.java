package com.example.xwy.secondpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText textToFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textFromFirst = (TextView)findViewById(R.id.textfromfirst);
        Button goFirst = (Button)findViewById(R.id.gofirst);
        textToFirst = (EditText)findViewById(R.id.texttofirst);

        Intent firstIntent = getIntent();
        String data = firstIntent.getStringExtra("extra_data");
        textFromFirst.setText(data);

        goFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String data = textToFirst.getText().toString();
                intent.putExtra("return",data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("return",textToFirst.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
