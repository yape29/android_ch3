package com.example.ch2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity1 extends AppCompatActivity {

    ListView listView;
    String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","elephant"};
    int[] images = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        List<Map<String, Object>> data = new ArrayList<>();
        for(int i = 0;i < 6;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("name",names[i]);
            item.put("image",images[i]);
            data.add(item);
        }
        String[] from = new String[]{"name","image"};
        int[] to = new int[]{R.id.name,R.id.image};

        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the selected item's name
                String selectedItemName = names[position];
                // Show a Toast with the selected item's name
                Toast.makeText(MainActivity1.this, selectedItemName, Toast.LENGTH_SHORT).show();
            }
        });
     }


}
