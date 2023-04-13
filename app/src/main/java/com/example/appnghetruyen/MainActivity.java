package com.example.appnghetruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import com.example.appnghetruyen.adapter.TruyenTranhAdapter;
import com.example.appnghetruyen.object.truyen;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
ArrayList<truyen> truyenArrayList;
EditText thanhtimkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }
    private void init(){
        truyenArrayList = new ArrayList<>();
        truyenArrayList.add(new truyen("Vua Đảo Hải Tặc - One Piece","Chapter 1080","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-dao-hai-tac.jpg"));
        truyenArrayList.add(new truyen("Lớ Ngớ Vớ Phải Tình Yêu","Chapter 66.2","https://truyencapnhat.com/cdn/truyencapnhat/20220910/doc-truyen-tranh-lo-ngo-vo-phai-tinh-yeu.jpg"));
        truyenArrayList.add(new truyen("Ta Có Con Với Đại Boss","Chapter 50","https://truyencapnhat.com/cdn/truyencapnhat/20230122/doc-truyen-tranh-ta-co-con-voi-dai-boss.jpg"));
        truyenArrayList.add(new truyen("Ổ C Thích Thả Thính","Chapter 7","https://truyencapnhat.com/cdn/truyencapnhat/20230217/doc-truyen-tranh-o-c-thich-tha-thinh.jpg"));
        truyenArrayList.add(new truyen("Vua Đảo Hải Tặc - One Piece","Chapter 1080","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-dao-hai-tac.jpg"));
        truyenArrayList.add(new truyen("Lớ Ngớ Vớ Phải Tình Yêu","Chapter 66.2","https://truyencapnhat.com/cdn/truyencapnhat/20220910/doc-truyen-tranh-lo-ngo-vo-phai-tinh-yeu.jpg"));
        truyenArrayList.add(new truyen("Ta Có Con Với Đại Boss","Chapter 50","https://truyencapnhat.com/cdn/truyencapnhat/20230122/doc-truyen-tranh-ta-co-con-voi-dai-boss.jpg"));
        truyenArrayList.add(new truyen("Ổ C Thích Thả Thính","Chapter 7","https://truyencapnhat.com/cdn/truyencapnhat/20230217/doc-truyen-tranh-o-c-thich-tha-thinh.jpg"));
        truyenArrayList.add(new truyen("Vua Đảo Hải Tặc - One Piece","Chapter 1080","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-dao-hai-tac.jpg"));
        truyenArrayList.add(new truyen("Lớ Ngớ Vớ Phải Tình Yêu","Chapter 66.2","https://truyencapnhat.com/cdn/truyencapnhat/20220910/doc-truyen-tranh-lo-ngo-vo-phai-tinh-yeu.jpg"));
        truyenArrayList.add(new truyen("Ta Có Con Với Đại Boss","Chapter 50","https://truyencapnhat.com/cdn/truyencapnhat/20230122/doc-truyen-tranh-ta-co-con-voi-dai-boss.jpg"));
        truyenArrayList.add(new truyen("Ổ C Thích Thả Thính","Chapter 7","https://truyencapnhat.com/cdn/truyencapnhat/20230217/doc-truyen-tranh-o-c-thich-tha-thinh.jpg"));



        adapter = new TruyenTranhAdapter(this, 0 ,truyenArrayList);
    }



    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        thanhtimkiem = findViewById(R.id.thanhtimkiem);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick() {

        thanhtimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = thanhtimkiem.getText().toString();
                adapter.scrtTruyen(s);
            }
        });

    }
}
