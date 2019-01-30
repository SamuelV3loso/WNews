package com.samuel.app_noticias.Utils;

public class Constants {

    public final static String API_KEY = "4c451402f34f4c65b30da5a2db93eaaf";
    public final static String ARTICLES_END_POINT = "https://newsapi.org/v1/articles?source=";
    public final static String SOURCES_END_POINT = "https://newsapi.org/v1/sources";

    public final static int ALL_SORUCES_PARSING_CODE = 100;
    public final static int ALL_TECH_SOURCES_PARSING_CODE = 200;

    public final static String KEY_CATEGORY_TECH = "technology";
    public final static String KEY_URL_TAG = "key_url";
    public final static String KEY_URL_TO_IMAGE_TAG = "key_url_to_image";

    public static String country;

    //SOURCE
    public final static String KEY_SOURCE_ID = "id";
    public final static String KEY_SOURCE_NAME = "name";
    public final static String KEY_SOURCE_DESCRIPTION = "description";
    public final static String KEY_SOURCE_URL = "url";
    public final static String KEY_SOURCE_CATEGORY = "category";
    public final static String KEY_SOURCE_LANGUAGE = "language";
    public final static String KEY_SOURCE_COUNTRY = "country";
    public final static boolean brasil = false;



    //ARTICLES
    public final static String KEY_ARTICLE_AUTOR = "author";
    public final static String KEY_ARTICLE_TITLE = "title";
    public final static String KEY_ARTICLE_DESCRIPTION = "description";
    public final static String KEY_ARTICLE_URL = "url";
    public final static String KEY_ARTICLE_URLTOIMAGE = "urlToImage";
    public final static String KEY_ARTICLE_PUBLISHEDAT = "publishedAt";
    //REQUEST CODES
    public final static int KEY_ARTICLE_REQUEST = 200;
    public final static int KEY_SOURCES_REQUEST = 300;

    //CATEGORY INTENTS KEYS
    public static final String KEY_CATEGORY_INTENT = "com.samuel.app_noticias_category";
    public static final String KEY_CATEGORY_LABEL = "com.samuel.app_noticias_label";


    public final static String KEY_CATEGORY_BUSINESS = "business";
    public final static String KEY_CATEGORY_ENTERTAINMENT = "entertainment";
    public final static String KEY_CATEGORY_POLITICS = "technology";
    public final static String KEY_CATEGORY_SPORTS = "sports";
    public final static String KEY_CATEGORY_SCIENCE = "science";

    public static String SEARCH_TEXT = "sad";

}
