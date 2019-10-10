package com.kk.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.kk.ui.adapter.RecyclerViewFruitAdapter;
import com.kk.ui.bean.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Fruit> fruitList = new ArrayList<>();
    private List<Fruit> fruitFallList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recyclerview);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        recyclerView = findViewById(R.id.recyclerView);
        Button btnVertical = findViewById(R.id.btn_vertical);
        Button btnHorizontal = findViewById(R.id.btn_horizontal);
        Button btnGrip = findViewById(R.id.btn_grip);
        Button btnFall = findViewById(R.id.btn_fall);
        btnVertical.setOnClickListener(this);
        btnHorizontal.setOnClickListener(this);
        btnGrip.setOnClickListener(this);
        btnFall.setOnClickListener(this);

        initFruit();


        initFruitFall();
    }


    private void initFruit() {
        for (int i = 0; i < 2; i++) {
            //todo 加2遍

            fruitList.add(new Fruit("苹果", R.drawable.apple));
            fruitList.add(new Fruit("香蕉", R.drawable.banana));
            fruitList.add(new Fruit("橙子", R.drawable.orange));
            fruitList.add(new Fruit("西瓜", R.drawable.watermelon));
            fruitList.add(new Fruit("梨", R.drawable.pear));
            fruitList.add(new Fruit("草莓", R.drawable.strawberry));
            fruitList.add(new Fruit("菠萝", R.drawable.pineapple));
            fruitList.add(new Fruit("葡萄", R.drawable.grape));
            fruitList.add(new Fruit("芒果", R.drawable.mango));
        }
    }

    private void initFruitFall() {
        for (int i = 0; i < 2; i++) {
            //todo 加2遍

            fruitFallList.add(new Fruit(getRandomLengthName("苹果"), R.drawable.apple));
            fruitFallList.add(new Fruit(getRandomLengthName("香蕉"), R.drawable.banana));
            fruitFallList.add(new Fruit(getRandomLengthName("橙子"), R.drawable.orange));
            fruitFallList.add(new Fruit(getRandomLengthName("西瓜"), R.drawable.watermelon));
            fruitFallList.add(new Fruit(getRandomLengthName("梨"), R.drawable.pear));
            fruitFallList.add(new Fruit(getRandomLengthName("草莓"), R.drawable.strawberry));
            fruitFallList.add(new Fruit(getRandomLengthName("菠萝"), R.drawable.pineapple));
            fruitFallList.add(new Fruit(getRandomLengthName("葡萄"), R.drawable.grape));
            fruitFallList.add(new Fruit(getRandomLengthName("芒果"), R.drawable.mango));
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(30) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == length / 2) {
                stringBuilder.append(name);
            } else {
                for (int j = 0; j < name.length(); j++) {
                    stringBuilder.append("**");
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vertical:
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);

                RecyclerViewFruitAdapter adapter =
                        new RecyclerViewFruitAdapter(fruitList, RecyclerViewFruitAdapter.Type.Vertical);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn_horizontal:
                LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager2);
                layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                RecyclerViewFruitAdapter adapter2 =
                        new RecyclerViewFruitAdapter(fruitList, RecyclerViewFruitAdapter.Type.Horizontal);
                recyclerView.setAdapter(adapter2);
                break;
            case R.id.btn_grip:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(gridLayoutManager);
                RecyclerViewFruitAdapter adapter3 =
                        new RecyclerViewFruitAdapter(fruitList, RecyclerViewFruitAdapter.Type.Vertical);
                recyclerView.setAdapter(adapter3);
                break;
            case R.id.btn_fall:
                StaggeredGridLayoutManager staggeredGridLayoutManager
                        = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                RecyclerViewFruitAdapter adapter4
                        = new RecyclerViewFruitAdapter(fruitFallList, RecyclerViewFruitAdapter.Type.Fall);
                recyclerView.setAdapter(adapter4);
                break;
            default:
                break;
        }
    }
}
