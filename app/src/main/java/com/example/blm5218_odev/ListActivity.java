package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Quiz> quiz=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        define();

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

    }

    private void define() {
        rv=findViewById(R.id.rv_kullanıcı_listesi);
        LinearLayoutManager layoutManager;
        layoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        QuizAdapter adp;
        adp=new QuizAdapter(this,quiz);
        rv.setAdapter(adp);
    }
}