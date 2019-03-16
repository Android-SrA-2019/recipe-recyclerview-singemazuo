/**
 * @Author Yinbin Zuo
 * @Date March 16th, 2019
 */

package com.nbcc.android.exercise.reciperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbcc.android.exercise.reciperecyclerview.DataProvider;
import com.nbcc.android.exercise.reciperecyclerview.MainActivity;
import com.nbcc.android.exercise.reciperecyclerview.R;
import com.nbcc.android.exercise.reciperecyclerview.Recipe;
import com.squareup.picasso.Picasso;

/**
 * Recipe Details Page
 */
public class RecipeDetailsActivity extends AppCompatActivity {

    private TextView mTxtName;
    private ImageView mImg;
    private TextView mTxtIngredients;
    private TextView mTxtDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        mTxtName = findViewById(R.id.recipe_item_name);
        mImg = findViewById(R.id.recipe_item_img);
        mTxtIngredients = findViewById(R.id.recipe_item_ingredients);
        mTxtDirections = findViewById(R.id.recipe_item_directions);

        // get position for selected recipe
        int index = getIntent().getIntExtra(MainActivity.SELECTED_RECIPE_INDEX,0);
        // According to position that obtains the selected recipe
        Recipe recipe = DataProvider.getRecipes().get(index);

        if(recipe != null){
            // invoke fillRecipe method for populating recipe
            fillRecipe(recipe);
        }
    }

    /**
     * Fill up all fields by passing recipe
     */
    private void fillRecipe(Recipe recipe){
        mTxtName.setText(recipe.name);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(mImg);
        mTxtIngredients.setText(recipe.ingredients);
        mTxtDirections.setText(recipe.directions);
    }
}
