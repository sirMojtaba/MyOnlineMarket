package com.example.myonlinemarket.network;

import android.util.Log;

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
    public List<ProductCategories> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        Log.d("tag", "category deserializer");
        List<ProductCategories> categoriesList = new ArrayList<>();
        JsonArray body = json.getAsJsonArray();
        for (int i = 0; i <body.size() ; i++) {
            JsonObject object = body.get(i).getAsJsonObject();
            String name = object.get("name").getAsString();
            int id = object.get("id").getAsInt();
            int parent = object.get("parent").getAsInt();
            JsonObject image = object.get("image").getAsJsonObject();
            String imageUrl = image.get("src").getAsString();
            ProductCategories category = new ProductCategories(name, id, parent, imageUrl);
            categoriesList.add(category);
        }
        return categoriesList;
    }
}
