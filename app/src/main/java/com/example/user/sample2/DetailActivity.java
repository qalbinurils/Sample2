package com.example.user.sample2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public int count = 1;
    public String a;
    private ImageView imageView;
    private TextView liter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mTitle = (TextView)findViewById(R.id.titlesDetail);
        ImageView mImage = (ImageView)findViewById(R.id.mwimagesDetail);

        mTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(mImage);

        imageView = (ImageView)findViewById(R.id.cellular);
        Button minus = (Button)findViewById(R.id.minus);
        Button plus = (Button)findViewById(R.id.plus);
        liter = (TextView)findViewById(R.id.liter);



        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <= 0){
                    Toast.makeText(DetailActivity.this,"Air Sedikit", Toast.LENGTH_LONG).show();
                    imageView.setImageLevel(0);
                } else {
                    count--;
                    imageView.setImageLevel(count);
                    a = String.valueOf(count);
                    liter.setText(a);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count >= 6){
                    Toast.makeText(DetailActivity.this,"Air Sudah Full", Toast.LENGTH_LONG).show();
                    imageView.setImageLevel(6);
                } else {
                    count++;
                    imageView.setImageLevel(count);
                    a = String.valueOf(count);
                    liter.setText(a);
                }

            }
        });

    }
}
