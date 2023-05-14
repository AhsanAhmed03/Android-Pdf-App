package com.example.pdffiles;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;


import java.io.File;

public class ViewPdf_activity extends AppCompatActivity {

    String filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        filepath = getIntent().getStringExtra("filepath");

//        pdfView = findViewById(R.id.pdfView);
//
//        showpdf();

    }

    /*public void showpdf(){

        File file = new File(filepath);
        Uri path = Uri.fromFile(file);

        pdfView.fromUri(path)
                .autoSpacing(true)
                .enableSwipe(true)
                .fitEachPage(true)
                .enableDoubletap(true)
                .pageSnap(true)
                .swipeHorizontal(false)
                .spacing(10)
                .load();
    }*/
}