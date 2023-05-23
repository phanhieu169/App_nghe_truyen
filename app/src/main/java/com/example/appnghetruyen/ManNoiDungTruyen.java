package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ManNoiDungTruyen extends AppCompatActivity {

    TextView txtTenTruyen,txtNoidung,ten;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_noi_dung_truyen);

        txtNoidung = findViewById(R.id.NoiDung);
        txtTenTruyen = findViewById(R.id.TenTruyen);
        ten = findViewById(R.id.N);

        Intent intent = getIntent();
        String tenTruyen = intent.getStringExtra("tentruyen");
        String noidung = intent.getStringExtra("noidung");

        txtTenTruyen.setText(tenTruyen);
        txtNoidung.setText(noidung);

        //Cuộn textview
        txtNoidung.setMovementMethod(new ScrollingMovementMethod());
        t1 = new TextToSpeech(this,new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR)
                    t1.setLanguage(Locale.ENGLISH);
            }
        });
        ten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                t1.speak(noidung,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}
