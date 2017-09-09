package com.example.xwy.firstpractice;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button loginDialog = (Button)findViewById(R.id.login);
        Button messageDialog = (Button)findViewById(R.id.prompt);
        loginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                final View layout = inflater.inflate(R.layout.login,(ViewGroup) findViewById(R.id.logindialog));
                final EditText editUser = (EditText)layout.findViewById(R.id.edituser);
                final EditText editPassword = (EditText)layout.findViewById(R.id.editpassword);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Login")
                        .setView(layout)
                        .setPositiveButton("Clean", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editUser.setText("");
                                editPassword.setText("");
                            }
                        })
                        .setNegativeButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String user = editUser.getText().toString();
                                String password = editPassword.getText().toString();
                                if(user.equals("abc") && password.equals("123")){
                                    Toast.makeText(MainActivity.this,"Login access",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this,"UserId or password wrong",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
            }
        });

        messageDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }
}
