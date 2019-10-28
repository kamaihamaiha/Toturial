package com.custom.view.day3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-22 09:48
 * @Description: Canvas 绘制图片和文字
 */
public class Day3Activity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PERMISSION_CODE = 100;
    private DrawBitmapView drawBitmapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_day3);


        findViewById(R.id.btn_next).setOnClickListener(this);
        drawBitmapView = findViewById(R.id.drawBitmap);

        checkPermission();
    }

    private void checkPermission() {
        if ( ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                 PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
         }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Day3Activity.this,"授权成功！",Toast.LENGTH_SHORT).show();
                } else {
                    checkPermission();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                drawBitmapView.play(3);
                break;
            default:
                break;
        }
    }
}
