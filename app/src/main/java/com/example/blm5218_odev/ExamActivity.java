package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ExamActivity extends AppCompatActivity {

    List<Quiz> quiz=new ArrayList<>();
    ListView lv;
    List<String> sorular=new ArrayList<>();
    Button mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        mail=findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "byznrone@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Sınav Dosyası");
                email.putExtra(Intent.EXTRA_TEXT, "Sınav Dosyası");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Sınavı Gönder"));
            }
        });

        for(int i=1;i<=100;i++){
            FileInputStream fis = null;
            try {
                fis=getApplicationContext().openFileInput(String.valueOf(i));

                InputStreamReader inputStreamReader=new InputStreamReader(fis, StandardCharsets.UTF_8);
                StringBuilder stringBuilder=new StringBuilder();
                List<String> soru=new ArrayList<>();
                try (BufferedReader reader=new BufferedReader(inputStreamReader)){
                    String line=reader.readLine();
                    soru.add(line);
                    while(line!=null){
                        stringBuilder.append(line).append('\n');
                        line=reader.readLine();
                        soru.add(line);
                    }
                    quiz.add(new Quiz(soru.get(0),soru.get(1),soru.get(2),soru.get(3),soru.get(4),soru.get(5),soru.get(6),soru.get(7),R.drawable.soru_));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }

        for (Quiz quiz:quiz){
            sorular.add(quiz.getSoruno()+". soru - Zorluk Düzeyi:  "+quiz.getZorluk());
        }
        lv = (ListView)findViewById(R.id.lv);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , android.R.id.text1, sorular);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();
            }


        });


    }
}