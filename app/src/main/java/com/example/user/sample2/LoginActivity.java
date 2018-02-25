package com.example.user.sample2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user, pass;
    private Intent mIntent;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }

    public void check(){
        if (user.getText().toString().equals("EAD") && pass.getText().toString().equals("MOBILE")){
            Toast.makeText(this, "Selamat Anda Berhasil Login!", Toast.LENGTH_LONG).show();
            mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
        } else {
            Toast.makeText(this, "Username dan Password salh! Anda Gagal Login!", Toast.LENGTH_LONG).show();
        }
    }
}
