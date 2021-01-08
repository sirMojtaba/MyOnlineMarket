package com.example.myonlinemarket.network;

import com.example.myonlinemarket.model.ProductCategories;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryDeserializer implements JsonDeserializer<List<ProductCategories>> {
    @Override
    public List<ProductCategories> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<ProductCategories> categoriesList = new ArrayList<>();
        JsonArray body = json.getAsJsonArray();
        for (int i = 0; i <body.size() ; i++) {
            JsonObject object = body.get(i).getAsJsonObject();
            String name = object.get("name").getAsString();
            String id = object.get("id").getAsString();
            String parent = object.get("parent").getAsString();
            ProductCategories category = new ProductCategories(name, id, parent);
            categoriesList.add(category);
        }
        return categoriesList;
    }
}
