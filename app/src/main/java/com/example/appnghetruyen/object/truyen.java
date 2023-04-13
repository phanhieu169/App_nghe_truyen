package com.example.appnghetruyen.object;

public class truyen {
    private String tenTruyen,tenChap,LinkANh;
    public truyen() {
    }

    public truyen(String tenTruyen, String tenChap, String linkANh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        LinkANh = linkANh;
    }
    public String getTenTruyen() {
        return tenTruyen;
    }
    public String getTenChap() {
        return tenChap;
    }
    public String getLinkANh() {
        return LinkANh;
    }
}
