package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddQuestionActivity extends AppCompatActivity {

    EditText soru,cevap1,cevap2,cevap3,cevap4,dogru_cevap,soru_no,zorluk;
    Button kaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        define();
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename= String.valueOf(soru_no.getText());

                String filecontents=soru_no.getText()+"\n"+soru.getText()+"\n"+cevap1.getText()+"\n"+cevap2.getText()+"\n"+cevap3.getText()+"\n"+cevap4.getText()+"\n"+dogru_cevap.getText()+"\n"+zorluk.getText();

                File file=new File(getApplicationContext().getFilesDir(),filename);
                try(FileOutputStream fos =getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE)){
                    fos.write(filecontents.getBytes());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent;
                intent=new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

            }
        });

    }





    private void define() {
        soru=findViewById(R.id.soru);
        cevap1=findViewById(R.id.cevap1);
        cevap2=findViewById(R.id.cevap2);
        cevap3=findViewById(R.id.cevap3);
        cevap4=findViewById(R.id.cevap4);
        dogru_cevap=findViewById(R.id.dogru_cevap);
        kaydet=findViewById(R.id.kaydet);
        soru_no=findViewById(R.id.soruno);
        zorluk=findViewById(R.id.zorluk);


    }
}