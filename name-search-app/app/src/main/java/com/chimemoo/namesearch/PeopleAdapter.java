package com.chimemoo.namesearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends ArrayAdapter<People> {
    Context context;
    int resource, textViewResourcesId;
    List<People> items, tempItems, suggestions;

    public PeopleAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<People> items) {
        super(context, resource, textViewResourceId, items);
        this.context = context;
        this.resource = resource;
        this.textViewResourcesId = textViewResourceId;
        this.items = items;
        tempItems = new ArrayList<People>(items);
        suggestions = new ArrayList<People>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_row_name, parent, false);
        }
        People people = items.get(position);
        if(people != null){
            TextView lblName = (TextView) view.findViewById(R.id.tv_name);
            if (lblName != null)
                lblName.setText(people.getName());
        }
        return view;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            String str = ((People) resultValue).getName();
            return str;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if(constraint != null){
                suggestions.clear();
                for (People people : tempItems){
                    if(people.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        suggestions.add(people);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<People> filterList = (ArrayList<People>) results.values;
            if(results != null && results.count > 0){
                clear();
                for (People people : filterList){
                    add(people);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
