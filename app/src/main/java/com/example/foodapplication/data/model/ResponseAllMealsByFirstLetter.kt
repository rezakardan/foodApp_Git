package com.example.foodapplication.data.model


import com.google.gson.annotations.SerializedName


data class ResponseAllMealsByFirstLetter(
    @SerializedName("meals")
    val meals: List<Meal>
)  {

    data class Meal(
        @SerializedName("dateModified")
        val dateModified: Any?, // null
        @SerializedName("idMeal")
        val idMeal: String?, // 52768
        @SerializedName("strArea")
        val strArea: String?, // British
        @SerializedName("strCategory")
        val strCategory: String?, // Dessert
        @SerializedName("strCreativeCommonsConfirmed")
        val strCreativeCommonsConfirmed: Any?, // null
        @SerializedName("strDrinkAlternate")
        val strDrinkAlternate: Any?, // null
        @SerializedName("strImageSource")
        val strImageSource: Any?, // null
        @SerializedName("strIngredient1")
        val strIngredient1: String?, // digestive biscuits
        @SerializedName("strIngredient10")
        val strIngredient10: String?,
        @SerializedName("strIngredient11")
        val strIngredient11: String?,
        @SerializedName("strIngredient12")
        val strIngredient12: String?,
        @SerializedName("strIngredient13")
        val strIngredient13: String?,
        @SerializedName("strIngredient14")
        val strIngredient14: String?,
        @SerializedName("strIngredient15")
        val strIngredient15: String?,
        @SerializedName("strIngredient16")
        val strIngredient16: String?,
        @SerializedName("strIngredient17")
        val strIngredient17: String?,
        @SerializedName("strIngredient18")
        val strIngredient18: String?,
        @SerializedName("strIngredient19")
        val strIngredient19: String?,
        @SerializedName("strIngredient2")
        val strIngredient2: String?, // butter
        @SerializedName("strIngredient20")
        val strIngredient20: String?,
        @SerializedName("strIngredient3")
        val strIngredient3: String?, // Bramley apples
        @SerializedName("strIngredient4")
        val strIngredient4: String?, // butter, softened
        @SerializedName("strIngredient5")
        val strIngredient5: String?, // caster sugar
        @SerializedName("strIngredient6")
        val strIngredient6: String?, // free-range eggs, beaten
        @SerializedName("strIngredient7")
        val strIngredient7: String?, // ground almonds
        @SerializedName("strIngredient8")
        val strIngredient8: String?, // almond extract
        @SerializedName("strIngredient9")
        val strIngredient9: String?, // flaked almonds
        @SerializedName("strInstructions")
        val strInstructions: String?, // Preheat the oven to 200C/180C Fan/Gas 6.Put the biscuits in a large re-sealable freezer bag and bash with a rolling pin into fine crumbs. Melt the butter in a small pan, then add the biscuit crumbs and stir until coated with butter. Tip into the tart tin and, using the back of a spoon, press over the base and sides of the tin to give an even layer. Chill in the fridge while you make the filling.Cream together the butter and sugar until light and fluffy. You can do this in a food processor if you have one. Process for 2-3 minutes. Mix in the eggs, then add the ground almonds and almond extract and blend until well combined.Peel the apples, and cut thin slices of apple. Do this at the last minute to prevent the apple going brown. Arrange the slices over the biscuit base. Spread the frangipane filling evenly on top. Level the surface and sprinkle with the flaked almonds.Bake for 20-25 minutes until golden-brown and set.Remove from the oven and leave to cool for 15 minutes. Remove the sides of the tin. An easy way to do this is to stand the tin on a can of beans and push down gently on the edges of the tin.Transfer the tart, with the tin base attached, to a serving plate. Serve warm with cream, crème fraiche or ice cream.
        @SerializedName("strMeal")
        val strMeal: String?, // Apple Frangipan Tart
        @SerializedName("strMealThumb")
        val strMealThumb: String?, // https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg
        @SerializedName("strMeasure1")
        val strMeasure1: String?, // 175g/6oz
        @SerializedName("strMeasure10")
        val strMeasure10: String?,
        @SerializedName("strMeasure11")
        val strMeasure11: String?,
        @SerializedName("strMeasure12")
        val strMeasure12: String?,
        @SerializedName("strMeasure13")
        val strMeasure13: String?,
        @SerializedName("strMeasure14")
        val strMeasure14: String?,
        @SerializedName("strMeasure15")
        val strMeasure15: String?,
        @SerializedName("strMeasure16")
        val strMeasure16: String?,
        @SerializedName("strMeasure17")
        val strMeasure17: String?,
        @SerializedName("strMeasure18")
        val strMeasure18: String?,
        @SerializedName("strMeasure19")
        val strMeasure19: String?,
        @SerializedName("strMeasure2")
        val strMeasure2: String?, // 75g/3oz
        @SerializedName("strMeasure20")
        val strMeasure20: String?,
        @SerializedName("strMeasure3")
        val strMeasure3: String?, // 200g/7oz
        @SerializedName("strMeasure4")
        val strMeasure4: String?, // 75g/3oz
        @SerializedName("strMeasure5")
        val strMeasure5: String?, // 75g/3oz
        @SerializedName("strMeasure6")
        val strMeasure6: String?, // 2
        @SerializedName("strMeasure7")
        val strMeasure7: String?, // 75g/3oz
        @SerializedName("strMeasure8")
        val strMeasure8: String?, // 1 tsp
        @SerializedName("strMeasure9")
        val strMeasure9: String?, // 50g/1¾oz
        @SerializedName("strSource")
        val strSource: String?, // https://www.bbcgoodfood.com/recipes/778642/apple-and-blackberry-crumble
        @SerializedName("strTags")
        val strTags: String?, // Tart,Baking,Fruity
        @SerializedName("strYoutube")
        val strYoutube: String? // https://www.youtube.com/watch?v=rp8Slv4INLk
    )
}