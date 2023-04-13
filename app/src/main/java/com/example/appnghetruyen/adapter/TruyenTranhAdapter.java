package com.example.appnghetruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appnghetruyen.R;
import com.example.appnghetruyen.object.truyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TruyenTranhAdapter extends ArrayAdapter<truyen> {
    private Context ct;
    private ArrayList<truyen> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<truyen> objects) {
        super(context, resource, objects);
        TruyenTranhAdapter truyenTranhAdapter = this;
        ct = context;
        arr = new ArrayList<>(objects);

    }
    public void scrtTruyen(String s){
        s = s.toUpperCase();
        int k=0;
        for(int i=0;i<arr.size();i++){
            truyen t = arr.get(i);
            String ten = t.getTenTruyen().toUpperCase();
            if(ten.indexOf(s)>= 0){
                arr.set(i,arr.get(k));
                arr.set(k,t);
                k ++;
            }
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null) {
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen,null);
        }
        if(arr.size()>0){
            truyen truyen = this.arr.get(position);
            TextView tenTenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenTenChap = convertView.findViewById(R.id.txvTenChap);
            ImageView imgAnhTruyen = convertView.findViewById(R.id.imgAnhTruyen);

            tenTenTruyen.setText(truyen.getTenTruyen());
            tenTenChap.setText(truyen.getTenChap());
            Glide.with(this.ct).load(truyen.getLinkANh()).into(imgAnhTruyen);
        }
        return convertView;
    }
}
