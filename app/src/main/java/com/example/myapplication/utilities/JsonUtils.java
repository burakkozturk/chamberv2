package com.example.myapplication.utilities;

import android.content.res.AssetManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static List<Countries> loadCountriesFromJson(AssetManager assetManager) {
        List<Countries> countryList = new ArrayList<>();
        try {
            InputStream inputStream = assetManager.open("countries.json"); // JSON dosyasının adını buraya ekleyin
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String dialCode = jsonObject.getString("dial_code");
                countryList.add(new Countries(name, dialCode));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return countryList;
    }
}
