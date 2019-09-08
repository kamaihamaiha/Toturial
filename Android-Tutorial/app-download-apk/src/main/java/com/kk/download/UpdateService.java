package com.kk.download;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class UpdateService extends Service {
    private static final String TAG = "UpdateService";
    private DownloadFinishReceiver mReceiver;
    private String serverMD5;

    private onDownloadListener onDownloadListener;

    public UpdateService() {
    }

    public interface onDownloadListener {
        void onOver(DownloadFinishReceiver downloadFinishReceiver);
    }

    public void setOnDownloadListener(UpdateService.onDownloadListener onDownloadListener) {
        this.onDownloadListener = onDownloadListener;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //注册下载完成的广播
        mReceiver = new DownloadFinishReceiver();
        registerReceiver(mReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new DownBinder();
    }

    public class DownBinder extends Binder {
        public void startDownload(String downUrl, String md5, onDownloadListener downloadListener) {
            onDownloadListener = downloadListener;
            if (md5 == null || downUrl == null) {
                //todo 链接服务器失败
                return;
            }
            serverMD5 = md5;
            //删除已经存在的apk包
            File apkFile = new File(UpdateService.this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
                    , "update.apk");
            if (apkFile.exists()) {
                apkFile.delete();
            }
            //初始化DownloadManager并开始下载
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downUrl));
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "update.apk");
            Log.d(TAG, "startDownload: " + file.getAbsolutePath());
            request.setDestinationUri(Uri.fromFile(file));
            DownloadManager mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            mDownloadManager.enqueue(request);
        }
    }

    //下载完成的广播
    public class DownloadFinishReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (onDownloadListener != null) {
                onDownloadListener.onOver(mReceiver);
            }

        }

        /**
         * 更新安装
         */
        public void updateInstall() {
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "update.apk");
            String localFileMD5 = ArithmeticUtil.getFileMD5(file);
            /*if (!serverMD5.equals(localFileMD5)) {
                Toast.makeText(context, "下载失败，请重新点击下载！", Toast.LENGTH_SHORT).show();
                return;
            }*/
            //Android获取一个用于打开APK文件的intent
            Intent intent1 = new Intent(Intent.ACTION_VIEW);
            // 由于没有在Activity环境下启动Activity,设置下面的标签
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
                //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
                Uri apkUri =
                        FileProvider.getUriForFile(UpdateService.this, "com.kk.download.fileprovider",
                                new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "update.apk"));
                //添加这一句表示对目标应用临时授权该Uri所代表的文件
                intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent1.setDataAndType(apkUri, "application/vnd.android.package-archive");
            } else {
                intent1.setDataAndType(Uri.fromFile(new File(getExternalFilesDir(Environment.getExternalStorageState())
                                , "update.apk")),
                        "application/vnd.android.package-archive");
            }
            //todo 校验 md5

            UpdateService.this.startActivity(intent1);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
