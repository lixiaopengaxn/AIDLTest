package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.IAppAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent;

    private IAppAidlInterface binder = null;

    private EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.StopService).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.un_bind_service).setOnClickListener(this);
        findViewById(R.id.each_communication).setOnClickListener(this);

        inputText = findViewById(R.id.service_data);

        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.myapplication", "com.example.myapplication.AppService"));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startService:
//                startService(serviceIntent);
                break;
            case R.id.StopService:
//                stopService(serviceIntent);
                break;
            case R.id.bind_service:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.un_bind_service:
                unbindService(this);
                binder = null;
                break;
            case R.id.each_communication:
                if (binder != null) {
                    try {
                        switch (inputText.getText().toString().trim()){
                            case "1":
                                binder.register("我注册了应用");
                                break;
                            case "2":
                                binder.login("我登陆了应用");
                                break;
                            case "3":
                                binder.cancel("我取消了应用");
                                break;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "我是空的", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = IAppAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
