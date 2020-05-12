package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;

public class AppService extends Service {

    private String register;
    private String login;
    private String cancel;


    private Binder anInterface = new IAppAidlInterface.Stub() {
        @Override
        public void register(final String str) throws RemoteException {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(AppService.this, str, Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }).start();

            System.out.println(str+"-------");
        }

        @Override
        public void login(final String str) throws RemoteException {
            System.out.println(str);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(AppService.this, str, Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }).start();
        }

        @Override
        public void cancel(final String str) throws RemoteException {
            System.out.println(str);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(AppService.this, str, Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }).start();
        }

        @Override
        public void getCallback(Callback callBack) throws RemoteException {
        }

    };



    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
       return anInterface;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
