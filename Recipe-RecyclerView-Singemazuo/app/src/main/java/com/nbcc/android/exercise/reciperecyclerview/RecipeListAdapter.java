/**
 * @Author Yinbin Zuo
 * @Date March 16th, 2019
 */

package com.nbcc.android.exercise.reciperecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nbcc.android.exercise.reciperecyclerview.DataProvider;
import com.nbcc.android.exercise.reciperecyclerview.Recipe;

import java.util.List;

/**
 * This class is an implementation for RecyclerView Adapter
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeItemHolder> {

    // this variable holds the inflater for recipe list item
    private LayoutInflater mInflater;

    // this context stores the eventing activity context
    private Context mContext;

    // this variable stores the list of datas
    private List<Recipe> mRecipeList;

    /**
     * A constructor for RecipeListAdapter
     * @param context this accepting parameter is the context for eventing activity, this can be helpful for switch activity page
     */
    public RecipeListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mRecipeList = DataProvider.getRecipes();
    }

    @Override
    public RecipeItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item,viewGroup,false);
        return new RecipeItemHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeItemHolder viewHolder, int i) {
        Recipe recipe = mRecipeList.get(i);
        viewHolder.mTxtRecipeName.setText(recipe.name);
        viewHolder.mTxtRecipeIntro.setText(recipe.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    /**
     * a ViewHolder for Recycler View List Item, that is derived from RecyclerView.ViewHolder and implementation of View.OnCickListener
     */
    class RecipeItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTxtRecipeName;
        TextView mTxtRecipeIntro;
        RecyclerView.Adapter mAdapter;

        public RecipeItemHolder(View itemView,RecyclerView.Adapter adapter) {
            super(itemView);

            mAdapter = adapter;
            mTxtRecipeName = itemView.findViewById(R.id.recipe_name);
            mTxtRecipeIntro = itemView.findViewById(R.id.recipe_introduction);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // get position of recipe list
            int mPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailsActivity.class);
            intent.putExtra(MainActivity.SELECTED_RECIPE_INDEX,mPosition);
            mContext.startActivity(intent);
        }
    }
}
