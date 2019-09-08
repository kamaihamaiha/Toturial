package com.kk.download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.google.gson.Gson;

import java.io.File;

/**
 * @author kk
 */
public class MainActivity extends AppCompatActivity {

    private static final String DOWNLOAD_URL = "http://192.168.60.127:8010/lastApk/com.kk.download_debug-2_v1.1.apk";
    private static final String REQUEST_VERSION_URL = "http://192.168.60.127:8010/update.json";

    private UpdateService.DownBinder binder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (UpdateService.DownBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvVersion = findViewById(R.id.tv_version);


        tvVersion.setText(SystemUtil.getVersion(this));

        //启动 apk 安装包服务
        Intent intent = new Intent(MainActivity.this, UpdateService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);



        findViewById(R.id.btn_check_version).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binder.startDownload(DOWNLOAD_URL,"serverMD5Value",downloadListener);
            }
        });

    }

    private UpdateService.onDownloadListener downloadListener = new UpdateService.onDownloadListener() {
        @Override
        public void onOver(final UpdateService.DownloadFinishReceiver receiver) {
            DialogUtil.showMultiChoiceDialog(MainActivity.this, new String[]{}, "更新...",
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   receiver.updateInstall();
                }
            });
        }
    };

    /**
     * 仅仅是下载安装包
     */
    private void downLoadOnly() {
        AllenVersionChecker
                .getInstance()
                .downloadOnly(
                        UIData.create().setDownloadUrl(DOWNLOAD_URL)
                )
                .executeMission(this);
    }

    /**
     * 检查版本然后下载安装包
     */
    private void requestVersionAndDownload() {
        String apkPath = Environment.getExternalStorageDirectory() + "/down/" + "app-download.apk";
        File file = new File(apkPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl(REQUEST_VERSION_URL)
                .request(new RequestVersionListener() {
                    @Nullable
                    @Override
                    public UIData onRequestVersionSuccess(String result) {
                        //todo 检查到版本情况，显示到 UI 界面，如果不想更新下面的就返回 null
                        String jsonStr = result;
                        CheckVersion checkVersion = new Gson().fromJson(jsonStr, CheckVersion.class);
                        String serverVersion = checkVersion.getVersion();
                        String curVersion = SystemUtil.getVersion(MainActivity.this);

                        String md5Sum = checkVersion.getMd5Sum();

                        String sign = SystemUtil.getSign(MainActivity.this);

                        if (curVersion.equals(serverVersion)) {
                            //todo 已经是最新版本了
                            return UIData.create().setTitle("更新").setContent("当前已是最新版本：" +
                                    serverVersion);
                        } else {
                            boolean hasNewVersion = false;
                            String[] serverVersionFragment = serverVersion.split("\\.");
                            String[] localVersion = curVersion.split("\\.");
                            for (int i = 0; i < serverVersionFragment.length; i++) {
                                if (Integer.parseInt(serverVersionFragment[i]) > Integer.parseInt(localVersion[i])) {
                                    //todo 发现新版本了
                                    hasNewVersion = true;
                                    break;
                                }
                            }

                            if (hasNewVersion) {
                                return UIData.create().setDownloadUrl(checkVersion.getUpdateUrl()).setTitle("发现新版本: "
                                        + "V " + serverVersion)
                                        .setContent("1. xxx");
                            } else {
                                return UIData.create().setTitle("更新").setContent("当前已是最新版本：" +
                                        serverVersion);
                            }

                        }

                    }

                    @Override
                    public void onRequestVersionFailure(String message) {
                        String error = message;
                    }
                })
                .setShowNotification(true)
                .setDownloadAPKPath(apkPath)
                .executeMission(this);
    }



}



