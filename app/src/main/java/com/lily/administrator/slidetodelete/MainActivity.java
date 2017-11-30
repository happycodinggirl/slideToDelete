package com.lily.administrator.slidetodelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycleView);
        SlideAdapter slideAdapter=new SlideAdapter(this);
        List<DateEntity> dateList=new ArrayList<>();
        for (int i=0;i<100;i++){
            DateEntity dateEntity=new DateEntity();
            if (i%2==0) {
                dateEntity.setCanDelete(true);
            }else{
                dateEntity.setCanDelete(false);
            }
            dateEntity.setContent("item "+i+" above the delete");
            dateList.add(dateEntity);
        }

        slideAdapter.setDataList(dateList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(slideAdapter);


    }
}
