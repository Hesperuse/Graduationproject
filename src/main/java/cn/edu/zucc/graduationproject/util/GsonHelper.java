package cn.edu.zucc.graduationproject.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonHelper {
    public static Gson gson = (new GsonBuilder()).create();

    public GsonHelper() {
    }

    public static <T> T fromjson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromjson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }
}
