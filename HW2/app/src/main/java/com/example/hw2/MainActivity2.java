package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    TextView name, age, job, phone, mail;
    Button back, call;
    String sNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        job = findViewById(R.id.job);
        phone = findViewById(R.id.phoneNum);
        mail = findViewById(R.id.mail);
        back = findViewById(R.id.back);

        Bundle bundle = getIntent().getExtras();
        String nm = bundle.getString("name");
        int ag = bundle.getInt("age");
        String jb = bundle.getString("job");
        int ph = bundle.getInt("phone");
        String ml = bundle.getString("mail");

        name.setText(nm);
        age.setText(String.valueOf(ag));
        job.setText(jb);
        phone.setText(String.valueOf(ph));
        mail.setText(ml);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    public void call(View view) {

        Intent i = new Intent(Intent.ACTION_CALL);
        sNum = phone.getText().toString();
        if (sNum.trim().isEmpty()) {
            i.setData(Uri.parse(""));
        } else {
            i.setData(Uri.parse("tel:" + sNum));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Please grant the permission to call", Toast.LENGTH_SHORT).show();
                requestPermission();
            } else {
                startActivity(i);
            }
        }
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

    }
}

