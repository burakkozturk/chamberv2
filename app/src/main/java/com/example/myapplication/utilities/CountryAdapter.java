package com.example.myapplication.utilities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Countries> countryList;

    public CountryAdapter(List<Countries> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Countries country = countryList.get(position);
        holder.countryNameTextView.setText(country.getName());
        holder.countryCodeTextView.setText(country.getCode());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void setCountryList(List<Countries> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryNameTextView;
        TextView countryCodeTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
            countryCodeTextView = itemView.findViewById(R.id.countryCodeTextView);
        }
    }
}
