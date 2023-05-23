package com.yutils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class NetworkUtil {
 
    public static String doGet(String urlPath) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlPath).openConnection();
            conn.setRequestMethod("GET");
            conn.addRequestProperty("Accept","application/vnd.github.v3.raw");
            if (200 == conn.getResponseCode()) {
                return new BufferedReader(new InputStreamReader(conn.getInputStream())).readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{ \"success\": false,\n   \"errorMsg\": \"后台服务器开小差了!\",\n     \"result\":{}}";
    }
}