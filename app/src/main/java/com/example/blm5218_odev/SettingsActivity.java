package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    Spinner soru_puani;

    SeekBar sinav_suresi,zorluk;
    Button güncelle;
    TextView txt_süre,txt_zorluk;
    int s_süre=0;
    int s_zorluk=0;
    String puan;
    String read_süre,read_zorluk,read_puan;
    String[] puan_items = new String[]{"5", "6", "7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        define();
        sharedPrefOku();

        güncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Güncellendi." ,
                        Toast.LENGTH_SHORT).show();
                puan=soru_puani.getSelectedItem().toString();
                sharedPrefKayit();

            }
        });

        sinav_suresi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s_süre=10*progress+30;

                txt_süre.setText("Sınav süresi: "+s_süre);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        zorluk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s_zorluk=progress+1;

                txt_zorluk.setText("Sınav Zorluk Düzeyi: "+s_zorluk );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void define() {
        txt_zorluk=findViewById(R.id.txt_zorluk);
        txt_süre=findViewById(R.id.txt_süre);
        sinav_suresi=findViewById(R.id.süre_bar);
        zorluk=findViewById(R.id.adet_bar);
        sharedPref = getApplicationContext().getSharedPreferences("beyza",getApplicationContext().MODE_PRIVATE);
        güncelle=findViewById(R.id.güncelle);
        soru_puani=findViewById(R.id.soru_puani);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, puan_items);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        soru_puani.setAdapter(adapter2);
    }

    private void sharedPrefKayit() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("süre",String.valueOf(s_süre));
        editor.putString("zorluk",String.valueOf(s_zorluk));
        editor.putString("puan",puan);
        editor.commit();

    }

    private void sharedPrefOku() {
        read_süre = sharedPref.getString("süre","Kayıt Yok");
        read_zorluk = sharedPref.getString("zorluk","Kayıt Yok");
        read_puan = sharedPref.getString("puan","0");

        if(read_süre=="Kayıt Yok" && read_zorluk=="Kayıt Yok" && read_puan=="0"){
            txt_süre.setText("Sınav süresi "+"0");
            txt_zorluk.setText("Sınav Zorluk Düzeyi"+"0");
            sinav_suresi.setProgress(0);
            zorluk.setProgress(0);
        }
        else{
            try {
                s_süre=(Integer.parseInt(read_süre));
                s_zorluk=(Integer.parseInt(read_zorluk));
            }
            catch (Exception e){
                s_süre=30;
                s_zorluk=0;
            }

            txt_süre.setText("Sınav süresi "+String.valueOf(s_süre));
            txt_zorluk.setText("Sınav Zorluk Düzeyi "+String.valueOf(s_zorluk));
            sinav_suresi.setProgress((Integer.parseInt(String.valueOf(s_süre))-30)/10);
            zorluk.setProgress((Integer.parseInt(String.valueOf(s_zorluk))-1));



        }

    }
}