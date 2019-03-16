package com.nbcc.android.exercise.reciperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    public final static String SELECTED_RECIPE_INDEX = "SELECTED_RECIPE_INDEX";

    public final static String SELECTED_RECIPE_INDEX_BUNDLE = "SELECTED_RECIPE_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecycler = findViewById(R.id.recyclerview);
        mRecycler.setAdapter(new RecipeListAdapter(this));
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
