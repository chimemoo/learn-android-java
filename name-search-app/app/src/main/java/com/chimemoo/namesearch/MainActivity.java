package com.chimemoo.namesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView txtSearch;
    List<People> mList;
    PeopleAdapter adapter;
    TextView tvFirstName, tvLastName, tvId;
    TableLayout tlPeopleInfo;
    private People selectedPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mList = retrievePeople();
        txtSearch = findViewById(R.id.auto_complete);
        tvFirstName = findViewById(R.id.tv_first_name);
        tvLastName = findViewById(R.id.tv_last_name);
        tvId = findViewById(R.id.tv_id);
        tlPeopleInfo = findViewById(R.id.tl_people_info);

        adapter = new PeopleAdapter(this, R.layout.activity_main, R.id.tv_name, mList);
        txtSearch.setAdapter(adapter);
        txtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPerson = (People) parent.getItemAtPosition(position);
                if (selectedPerson != null){
                    tlPeopleInfo.setVisibility(TableLayout.VISIBLE);
                    tvFirstName.setText(selectedPerson.getFirstName());
                    tvLastName.setText(selectedPerson.getLastName());
                    tvId.setText(""+selectedPerson.getId());
                }
            }
        });
    }

    private List<People> retrievePeople() {
        List<People> list = new ArrayList<People>();
        list.add(new People("James", "Bond", 1));
        list.add(new People("Jason", "Bourne", 2));
        list.add(new People("Ethan", "Hunt", 3));
        list.add(new People("Sherlock", "Holmes", 4));
        list.add(new People("David", "Beckham", 5));
        list.add(new People("Bryan", "Adams", 6));
        list.add(new People("Arjen", "Robben", 7));
        list.add(new People("Van", "Persie", 8));
        list.add(new People("Zinedine", "Zidane", 9));
        list.add(new People("Luis", "Figo", 10));
        list.add(new People("John", "Watson", 11));
        list.add(new People("John", "Tofan", 12));
        list.add(new People("John", "Kennedy", 13));
        return list;
    }
}
