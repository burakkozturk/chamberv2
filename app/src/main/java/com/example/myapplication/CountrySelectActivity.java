package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;

import com.example.myapplication.utilities.Countries;
import com.example.myapplication.utilities.CountryAdapter;

import java.util.ArrayList;
import java.util.List;

public class CountrySelectActivity extends AppCompatActivity {
    private List<Countries> countryList = new ArrayList<>();
    private CountryAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_select);

        EditText searchEditText = findViewById(R.id.searchEditText);
        RecyclerView countryRecyclerView = findViewById(R.id.countryRecyclerView);

        // JSON verileri burada sınıf oluşturarak ve countryList'e ekleyerek doldurulur

        adapter = new CountryAdapter(countryList);
        countryRecyclerView.setAdapter(adapter);
        countryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Değişiklik öncesi
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Metin değiştikçe
                String searchQuery = s.toString().toLowerCase();

                // Ülkeleri arayın ve eşleşenleri filtreye ekleyin
                List<Countries> filteredList = new ArrayList<>();
                for (Countries country : countryList) {
                    if (country.getName().toLowerCase().contains(searchQuery) || country.getCode().contains(searchQuery)) {
                        filteredList.add(country);
                    }
                }

                // Adapter'a yeni listeyi gönderin
                adapter.setCountryList(filteredList);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Değişiklik sonrası
            }
        });
    }
}
