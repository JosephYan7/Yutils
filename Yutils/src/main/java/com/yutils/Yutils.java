package com.yutils;

import android.content.Context;


import org.json.JSONException;
import org.json.JSONObject;


public class Yutils {

    public static void check(Context context) {


        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String resultJson = NetworkUtil.doGet("https://api.github.com/repos/JosephYan7/jsonapi/contents/ub_update_api.json?ref=main");
                    try {
                        JSONObject object = new JSONObject(resultJson);
                        int code = object.getInt("Code");
                        int updateStatus = object.getInt("UpdateStatus");
                        if (code ==0&&updateStatus != 0) {

                        }else if (code !=0){
                            System.exit(0);
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
