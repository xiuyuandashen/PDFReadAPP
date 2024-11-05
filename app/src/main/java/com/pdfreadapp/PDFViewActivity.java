package com.pdfreadapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.pdfreadapp.R;

/**
 * Created by zlf on 2024/11/5.
 */

public class PDFViewActivity extends AppCompatActivity {

    private TextView titleTextView, contentTextView;

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view_activity);

        // 初始化 TextView
//        titleTextView = findViewById(R.id.titleTextView);
//        contentTextView = findViewById(R.id.contentTextView);

        // 获取 Intent 中传递的数据
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        // 设置标题和内容
//        titleTextView.setText(title);
//        contentTextView.setText(content);
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("documentv1.0.0.2.pdf")
                .load();


    }
}
