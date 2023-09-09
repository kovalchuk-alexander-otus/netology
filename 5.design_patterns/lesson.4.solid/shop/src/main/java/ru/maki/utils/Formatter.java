package ru.maki.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.maki.shop.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Formatter<K> {

    protected Class<K> typeClass;
    protected Logger logger = Logger.getInstance();

    public Formatter(Class<K> typeClass) {
        this.typeClass = typeClass;
    }

    /**
     * формирование строки в формате JSON из списка объектов <K>
     * @param list
     * @return
     */
    public String listToJson(List<K> list) {
        Type listType = new TypeToken<List<K>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(list, listType);
    }

    /**
     * генерация списка объектов <K> из ранее прочитанного JSON
     */
    public List<K> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<K> list = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(json);
            logger.log("объекты класса [" + typeClass.getName() + "]..");
            for (Object jsonObject : jsonArray) {
                list.add(gson.fromJson(String.valueOf(jsonObject), typeClass));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        logger.log(list.toString());

        return list;
    }
}
