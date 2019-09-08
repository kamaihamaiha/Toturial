package com.kk.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.util.Log;


public class SellTicketService extends Service {
    private static final String TAG = SellTicketService.class.getSimpleName();

    private boolean running = false;
    private int plusPrice;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ISellTicketInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                                   double aDouble, String aString) throws RemoteException {

            }

            @Override
            public Ticket generateTicket(Ticket ticket) throws RemoteException {

                return new Ticket(ticket.getStartStation(), ticket.getDesStation(), ticket.getGoOffTime(),
                        ticket.getArriveTime(), ticket.getPrice() + plusPrice);
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        running = true;
        Log.d(TAG, "onCreate: " + TAG + " start!");
        new Thread() {
            @Override
            public void run() {
                plusPrice = 0;
                while (running) {
                    try {
                        plusPrice++;
                        Log.d(TAG, "running...");
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        Log.d(TAG, " end!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }
}
