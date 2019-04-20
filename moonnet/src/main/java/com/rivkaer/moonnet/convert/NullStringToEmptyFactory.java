package com.rivkaer.moonnet.convert;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: 将返回值中的NULL字符串转化成空对象,
 * 以避免傻吊后台自己返了null,你据理力争去肛他发现肛不过的情况发生
 */
public class NullStringToEmptyFactory implements TypeAdapterFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

        Class<T> rawType = (Class<T>) type.getRawType();
        if (rawType != String.class) {
            return null;
        }

        return (TypeAdapter<T>) new StringNullAdapter();
    }

    /* 类型转换适配器将 null -> (String)"" */
    private static class StringNullAdapter extends TypeAdapter<String> {

        @Override
        public void write(JsonWriter out, String value) throws IOException {
            if (value == null) {
                out.value("");
                return;
            }
            out.value(value);
        }

        @Override
        public String read(JsonReader in) throws IOException {

            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return "";
            }
            return in.nextString();
        }
    }
}
