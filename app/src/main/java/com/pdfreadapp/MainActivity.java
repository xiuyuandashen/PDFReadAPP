package com.pdfreadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.barteksc.pdfviewer.PDFView;
import com.pdfreadapp.base.CustomAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;

    private ListView listView;
    private CustomAdapter adapter;
    private List<String> titles;
    private List<String> contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pdfView = findViewById(R.id.pdfView);
//        pdfView.fromAsset("documentv1.0.0.2.pdf")
//                .load();

        listView = findViewById(R.id.listView);
        // 模拟数据
        titles = new ArrayList<>();
        contents = new ArrayList<>();

        titles.add("固晶");
        contents.add("固晶站SOPv1.0.PDF");

        titles.add("灯面SPI");
        contents.add("灯面SPI站SOPv1.1.PDF");

        titles.add("回流焊");
        contents.add("回流焊站SOPv1.0.PDF");

        adapter = new CustomAdapter(this, titles, contents);
        listView.setAdapter(adapter);

        // 设置点击事件监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取点击项的标题和内容
                String title = titles.get(position);
                String content = contents.get(position);

                // 跳转到 DetailActivity
                Intent intent = new Intent(MainActivity.this, PDFViewActivity.class);
                // 将数据传递到 DetailActivity
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                startActivity(intent);
            }
        });

    }
}
