// IAppAidlInterface.aidl
package com.example.myapplication;

// Declare any non-default types here with import statements
import com.example.myapplication.CallBack;
interface IAppAidlInterface {

            void register(String str);

            void login(String str);

            void cancel(String str);

            void getCallback(in Callback callBack);
}
