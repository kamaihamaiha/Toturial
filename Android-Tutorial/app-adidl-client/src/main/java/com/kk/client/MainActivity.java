package com.kk.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kk.server.ISellTicketInterface;
import com.kk.server.Ticket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Intent remoteSellTicketServerIntent;

    private ISellTicketInterface stub;
    private TextView tvTicketInfo;
    private EditText etStartCity;
    private EditText etEndCity;
    private StringBuffer sb = new StringBuffer();
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_other_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_other_service).setOnClickListener(this);
        findViewById(R.id.btn_bind_other_service).setOnClickListener(this);
        findViewById(R.id.btn_unbind_other_service).setOnClickListener(this);
        findViewById(R.id.btn_buy_ticket).setOnClickListener(this);

        scrollView = findViewById(R.id.scroolView);

        tvTicketInfo = findViewById(R.id.tv_ticket_info);
        etStartCity = findViewById(R.id.et_start_city);
        etEndCity = findViewById(R.id.et_start_city);

        remoteSellTicketServerIntent = new Intent();
        remoteSellTicketServerIntent.setComponent(new ComponentName("com.kk.server", "com.kk.server.SellTicketService"));

        tvTicketInfo.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public void onClick(View v) {
        int buyCount = 0;
        switch (v.getId()) {
            case R.id.btn_start_other_service:
                startService(remoteSellTicketServerIntent);
                break;
            case R.id.btn_stop_other_service:
                stopService(remoteSellTicketServerIntent);
                break;
            case R.id.btn_bind_other_service:
                bindService(remoteSellTicketServerIntent, this, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_other_service:
                unbindService(this);
                break;
            case R.id.btn_buy_ticket:
                if (stub != null) {
                    try {
                        String startStation = etStartCity.getText().toString().trim();
                        String desStation = etEndCity.getText().toString().trim();
                        Ticket ticket = stub.generateTicket(
                                new Ticket(
                                        startStation, desStation,
                                        "2019-1-1 09:00", "2019-1-1 14:00",
                                        400));

                        sb.append(String.format("出发:%s %s,到达:%s %s,票价:%d",
                                ticket.getStartStation(), ticket.getGoOffTime(), ticket.getDesStation(),
                                ticket.getArriveTime(), ticket.getPrice()) + "\n\n");
                        buyCount++;
                        tvTicketInfo.setText(sb.toString());
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(View.FOCUS_DOWN);
                            }
                        });
                        if (buyCount % 10 == 0) {
                            sb.delete(0, sb.length() - 1);
                        }

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "绑定售票服务: " + service);
        stub = ISellTicketInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        stub = null;
    }
}
