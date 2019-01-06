package com.rivkaer.moonnet.Utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Create by JJ Jia on 2018/6/9
 *
 * function: Gson Process {msg:null}
 */
public class StringNullAdapter extends TypeAdapter<String> {

    @Override
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) {
            writer.value("");
            return;
        }
        writer.value(value);
    }

    @Override
    public String read(com.google.gson.stream.JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return "";  // null --> ""
        }
        return reader.nextString();
    }
}