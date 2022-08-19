package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText name, age, job, phone, mail;
    Button next;
    boolean full, phValid, mlValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        job = findViewById(R.id.job);
        phone = findViewById(R.id.phoneNum);
        mail = findViewById(R.id.mail);
        next = findViewById(R.id.next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty() || age.getText().toString().isEmpty()
                || job.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || mail.getText().toString().isEmpty()) {


                    if (name.getText().toString().isEmpty()) {
                        name.setError("insert your name!");
                    }

                    if (age.getText().toString().isEmpty()) {
                        age.setError("insert your age!");
                    }

                    if (job.getText().toString().isEmpty()) {
                        job.setError("insert your last job!");
                    }

                    if (phone.getText().toString().isEmpty()) {
                        phone.setError("insert your phone number!");
                    }

                    if (mail.getText().toString().isEmpty()) {
                        mail.setError("insert your Email!");
                    }

                }else if (phone.getText().toString().getBytes().length != 8 || !(mail.getText().toString().contains("@")) || !(mail.getText().toString().contains(".com"))) {

                    if (phone.getText().toString().getBytes().length != 8){
                        phone.setError("insert a VALID phone number!");
                    }

                    if (!(mail.getText().toString().contains("@")) || !(mail.getText().toString().contains(".com"))) {
                        mail.setError("insert a VALID Email!");
                    }

                }else  {



                    String nm = name.getText().toString();
                    int ag = Integer.parseInt(age.getText().toString());
                    String jb = job.getText().toString();
                    int ph = Integer.parseInt(phone.getText().toString());
                    String ml = mail.getText().toString();



                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", nm);
                    intent.putExtra("age", ag);
                    intent.putExtra("job", jb);
                    intent.putExtra("phone", ph);
                    intent.putExtra("mail", ml);
                    startActivity(intent);

                }
            }
        });
    }
}