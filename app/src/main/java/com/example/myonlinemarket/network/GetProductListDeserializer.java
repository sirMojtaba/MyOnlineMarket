package com.example.myonlinemarket.network;

import com.example.myonlinemarket.model.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetProductListDeserializer implements JsonDeserializer<List<Product>> {
    @Override
    public List<Product> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<Product> productList = new ArrayList<>();

        JsonArray body = json.getAsJsonArray();
        for (int i = 0; i < body.size(); i++) {
            JsonObject productObject = body.get(i).getAsJsonObject();
            String name = productObject.get("name").getAsString();
            String price = productObject.get("price").getAsString();
            JsonArray images = productObject.get("images").getAsJsonArray();

            List<String> imageUrlList = new ArrayList<>();
            for (int j = 0; j < images.size(); j++) {
                JsonObject image = images.get(j).getAsJsonObject();
                String url = image.get("src").getAsString();
                imageUrlList.add(url);
            }

            Product product = new Product(name, price, imageUrlList);
            productList.add(product);
        }

        return productList;
    }
}
