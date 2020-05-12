// Callback.aidl
package com.example.myapplication;

// Declare any non-default types here with import statements

interface Callback {

        void register(String str);

        void login(String str);

        void cancel(String str);

}
