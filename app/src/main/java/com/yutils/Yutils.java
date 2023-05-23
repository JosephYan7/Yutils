package com.yutils;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class Yutils {

    public static void check(Context context) {

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String resultJson = NetworkUtil.doGet("https://api.github.com/repos/JosephYan7/jsonapi/contents/ub_update_api.json?ref=main");
                    UpdateInfo updateInfo = null;
                    try {
                        updateInfo = new Gson().fromJson(resultJson, UpdateInfo.class);
                        int updateStatus = updateInfo.getUpdateStatus();
                        int code = updateInfo.getCode();
                        if (code ==0&&updateStatus != 0) {

                        }else if (code !=0){
                            System.exit(0);
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
