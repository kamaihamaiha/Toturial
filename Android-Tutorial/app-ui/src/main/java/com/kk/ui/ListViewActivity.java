package com.kk.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kk.ui.adapter.FruitAdapter;
import com.kk.ui.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kk
 * @Create Date: 18-9-24 下午9:16
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is ListView 使用
 * 缺点：不能横向滑动
 */
public class ListViewActivity extends AppCompatActivity {

    private String[] fruits = {
            "苹果", "香蕉", "橘子", "西瓜", "梨", "葡萄", "菠萝", "草莓", "樱桃", "芒果",
            "苹果", "香蕉", "橘子", "西瓜", "梨", "葡萄", "菠萝", "草莓", "樱桃", "芒果"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ListView lvFruits = findViewById(R.id.lv_fruits);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                fruits);

//        lvFruits.setAdapter(adapter);

        initFruit();

        FruitAdapter adapter1 = new FruitAdapter(this, R.layout.fruit_item, fruitList);
        lvFruits.setAdapter(adapter1);

        lvFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        ListViewActivity.this,
                        fruitList.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
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
}
