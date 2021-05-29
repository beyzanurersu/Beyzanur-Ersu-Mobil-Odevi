package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    EditText name,surname,email,phone,birtdate,password,repassword;
    String s_name,s_surname,s_email,s_phone,s_birtdate,s_password,s_repassword;
    Button btn_kayitol;

    ArrayList<Person> persons=Person.getPersonList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        define();
        btn_kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        s_name=name.getText().toString();
        s_surname=surname.getText().toString();
        s_email=email.getText().toString();
        s_phone=phone.getText().toString();
        s_birtdate=birtdate.getText().toString();
        s_password=password.getText().toString();
        s_repassword=repassword.getText().toString();

        for (int i=1;i<=persons.size();i++){
            if(persons.get(i).getUserName().equals(s_email)){
                Toast.makeText(getApplicationContext(),"Bu kullanıcı zaten kayıtlı",Toast.LENGTH_SHORT).show();
                break;
            }
            else{
                if(s_password.equals(s_repassword)){
                    persons.add(new Person(s_email,s_password));
                    Intent intent;
                    intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("e-mail",s_email);
                    intent.putExtra("password",s_password);
                    startActivity(intent);
                    break;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Şifreler aynı değil.",Toast.LENGTH_SHORT).show();
                    break;
                }

            }

        }

    }



    private void define() {
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        email=findViewById(R.id.email);
        phone= findViewById(R.id.phone);
        birtdate=findViewById(R.id.date);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        btn_kayitol=findViewById(R.id.signup_btn);

    }
}