// IAppAidlInterface.aidl
package com.example.myapplication;

import com.example.myapplication.CallBack;

// Declare any non-default types here with import statements

interface IAppAidlInterface {

            void register(String str);

            void login(String str);

            void cancel(String str);

            void getCallback(in Callback callBack);
}
