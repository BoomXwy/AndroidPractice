package com.example.xwy.secondpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goSecond = (Button)findViewById(R.id.gosecond);
        final EditText textToSecond = (EditText)findViewById(R.id.texttosencond);
        goSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textToSecond.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("return");
                    TextView textFromSecond = (TextView)findViewById(R.id.textfromsencond);
                    textFromSecond.setText(returnedData);
                }
                break;
            default:
                break;
        }
    }
}
