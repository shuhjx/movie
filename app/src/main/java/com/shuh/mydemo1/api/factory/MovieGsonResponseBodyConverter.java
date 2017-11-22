package com.shuh.mydemo1.api.factory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by pc-135 on 2017/11/22.
 */

public class MovieGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public MovieGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter){
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            JSONObject jsonObject = new JSONObject(value.string());
            MediaType mediaType = value.contentType();
            Charset charset= mediaType == null ? UTF_8 : mediaType.charset(UTF_8);
            JSONArray jsonArray = jsonObject.optJSONObject("data").optJSONArray("movies");
            InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(jsonArray.toString().getBytes()), charset);

            return adapter.read(gson.newJsonReader(reader));
        } catch (JSONException e) {
            e.printStackTrace();
            return adapter.read(gson.newJsonReader(value.charStream()));
        } finally {
            value.close();
        }
    }
}
