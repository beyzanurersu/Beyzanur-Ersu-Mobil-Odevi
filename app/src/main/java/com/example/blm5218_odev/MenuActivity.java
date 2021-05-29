package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button soru_ekle,soru_listele,sinav_olustur,sinav_ayarlari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        soru_ekle=findViewById(R.id.soru_ekle);
        soru_listele=findViewById(R.id.soru_listele);
        sinav_olustur=findViewById(R.id.sinav_olustur);
        sinav_ayarlari=findViewById(R.id.sinav_ayarlari);

        soru_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(v.getContext(), AddQuestionActivity.class);
                startActivity(intent);
            }
        });
        soru_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(v.getContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        sinav_olustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(v.getContext(), ExamActivity.class);
                startActivity(intent);
            }
        });

        sinav_ayarlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

    }
}