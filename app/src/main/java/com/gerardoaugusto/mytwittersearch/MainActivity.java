package com.gerardoaugusto.mytwittersearch;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String SEARCHES = "searches";

    private EditText queryEditText; // where user enters a query
    private EditText tagEditText; // where user enters a query's tag
    private FloatingActionButton saveFloatingActionButton; // save search
    private SharedPreferences savedSearches; // user's favorite searches
    private List<String> tags; // list of tags for saved searches
    private SearchesAdapter adapter; // for binding data to RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        queryEditText= ((TextInputLayout) findViewById(R.id.queryTextInputLayout)).getEditText();
        queryEditText.addTextChangedListener(textwatcher);
        tagEditText= ((TextInputLayout) findViewById(R.id.tagTextInputLayout)).getEditText();
        tagEditText.addTextChangedListener(textwatcher);

        savedSearches=getSharedPreferences(SEARCHES, MODE_PRIVATE);
        tags=new ArrayList<>(savedSearches.getAll().keySet());

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        saveFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        saveFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private TextWatcher textwatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            updateSaveFAB();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    private View.OnClickListener saveButtonListenet=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    }

    private void updateSaveFAB() {

    }
}
