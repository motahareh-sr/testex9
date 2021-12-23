package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleview;
    String s1[],s2[],s3[];
    ImageButton info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomnavi);
        navigation.setBackground(null);

        recycleview=findViewById(R.id.recycleview);
        s1=getResources().getStringArray(R.array.p_name);
        s2=getResources().getStringArray(R.array.p_dec);
        s3=getResources().getStringArray(R.array.p_name2);
        info=findViewById(R.id.info);

        MyAdapter MyAdaptor= new MyAdapter(this,s1,s2,s3);
        recycleview.setAdapter(MyAdaptor);
        recycleview.setLayoutManager(new LinearLayoutManager(this));

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Motahareh sadeghi rad",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}
