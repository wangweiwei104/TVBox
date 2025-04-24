package com.github.tvbox.osc.util;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Base64;

import com.github.tvbox.osc.R;
import com.github.tvbox.osc.api.ApiConfig;
import com.github.tvbox.osc.base.App;
import com.github.tvbox.osc.ui.activity.HomeActivity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.lzy.okgo.OkGo;
//import com.lzy.okgo.callback.AbsCallback;
//import com.lzy.okgo.model.Response;
//import com.orhanobut.hawk.Hawk;

import org.apache.commons.lang3.StringUtils;

public class EpgUtil {

    private static JsonObject epgDoc = null;
    private static HashMap<String, JsonObject> epgHashMap = new HashMap<>();
    private static String userAgent = "okhttp/3.15";
    private static String requestAccept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
//    private static String epgDocStr = "";

    public static void init() {
        if (epgDoc != null)
            return;

        //credit by 龍
        try {
            AssetManager assetManager = App.getInstance().getAssets(); //获得assets资源管理器（assets中的文件无法直接访问，可以使用AssetManager访问）
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open("epg_data.json"), "UTF-8"); //使用IO流读取json文件内容
            BufferedReader br = new BufferedReader(inputStreamReader);//使用字符高效流
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            inputStreamReader.close();
            String epgDocStr = builder.toString();

            if (!epgDocStr.isEmpty()) {
                epgDoc = new Gson().fromJson(epgDocStr, (Type) JsonObject.class);// 从builder中读取了json中的数据。
                for (JsonElement opt : epgDoc.get("epgs").getAsJsonArray()) {
                    JsonObject obj = (JsonObject) opt;
                    String name = obj.get("name").getAsString().trim();
                    String[] names = name.split(",");
                    for (String string : names) {
                        epgHashMap.put(string, obj);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getEpgInfo(String channelName) {
        try {
            if (epgHashMap.containsKey(channelName)) {
                JsonObject obj = epgHashMap.get(channelName);
                return new String[]{
                        obj.get("logo").getAsString(),
                        obj.get("epgid").getAsString()
                };
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
