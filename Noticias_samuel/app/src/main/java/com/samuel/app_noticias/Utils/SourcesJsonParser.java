package com.samuel.app_noticias.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SourcesJsonParser {
    static ArrayList<SourcesModel> sourcesModelArrayList;

    public static ArrayList<SourcesModel> parseData(String content, int code) {

        JSONArray sources_arry = null;
        SourcesModel model = null;
        try {


            sourcesModelArrayList = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            sources_arry = jObj.getJSONArray("sources");

            for (int i = 0; i < sources_arry.length(); i++) {

                JSONObject obj = sources_arry.getJSONObject(i);

                model = new SourcesModel();

                model.setId(obj.getString(Constants.KEY_SOURCE_ID));
                model.setName(obj.getString(Constants.KEY_SOURCE_NAME));
                model.setDescription(obj.getString(Constants.KEY_SOURCE_DESCRIPTION));
                model.setUrl(obj.getString(Constants.KEY_SOURCE_URL));
                model.setCategory(obj.getString(Constants.KEY_SOURCE_CATEGORY));
                model.setLanguage(obj.getString(Constants.KEY_SOURCE_LANGUAGE));
                model.setCountry(obj.getString(Constants.KEY_SOURCE_COUNTRY));


                sourcesModelArrayList.add(model);

            }
            return sourcesModelArrayList;

        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
