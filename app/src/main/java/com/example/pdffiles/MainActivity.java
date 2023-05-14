package com.example.pdffiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterClass(this,pdfFiles()));

    }

    //Method for getting all pdf files from device for all android versions

    private ArrayList<String> pdfFiles(){
        ContentResolver contentResolver = getContentResolver();

        String mime = MediaStore.Files.FileColumns.MIME_TYPE + "=?";
        String memeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf");
        String[] args = new String[]{memeType};
        String[] proj = {MediaStore.Files.FileColumns.DATA,MediaStore.Files.FileColumns.DISPLAY_NAME};
        String sortingOrder = MediaStore.Files.FileColumns.DATE_ADDED + " DESC";
        Cursor cursor = contentResolver.query(MediaStore.Files.getContentUri("external")
                ,proj, mime,args,sortingOrder);
        ArrayList<String> pdfFiles = new ArrayList<>();
        if (cursor !=  null){
            while (cursor.moveToNext()){
                int index = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);

                String path = cursor.getString(index);
                pdfFiles.add(path);
            }
            cursor.close();
        }
        return pdfFiles;
    }
}