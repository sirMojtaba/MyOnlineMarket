package com.example.myonlinemarket.network;

import java.util.HashMap;
import java.util.Map;

public class NetworkParameters {

    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String CONSUMER_KEY = "ck_f025265e3479f7bee8e93bffe5685517b93ec27d";
    public static final String CONSUMER_SECRET = "cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0";

    public static Map<String, String> queryNewestList = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
        put("orderby", "date");
    }};

    public static Map<String, String> queryMostVisitedList = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
        put("orderby", "popularity");
    }};

    public static Map<String, String> queryRatingList = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
        put("orderby", "rating");
    }};
}
