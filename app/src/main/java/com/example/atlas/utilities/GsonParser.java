package com.example.atlas.utilities;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GsonParser {

    public static Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateHandler());
        return builder.create();
    }

    private static class DateHandler implements JsonDeserializer<Date> {

        private static final String mask = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Date ret = null;
            try {
                DateFormat dateFormat = new SimpleDateFormat(mask, Locale.US);
                ret = dateFormat.parse(json.getAsJsonPrimitive().getAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        }
    }
}
