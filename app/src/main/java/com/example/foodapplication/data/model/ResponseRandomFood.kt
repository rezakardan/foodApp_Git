package com.example.foodapplication.data.model


import com.google.gson.annotations.SerializedName


data class ResponseRandomFood(
    @SerializedName("meals")
    val meals: List<Meal>
)  {
    data class Meal(
        @SerializedName("dateModified")
        val dateModified: Any?, // null
        @SerializedName("idMeal")
        val idMeal: String?, // 53026
        @SerializedName("strArea")
        val strArea: String?, // Egyptian
        @SerializedName("strCategory")
        val strCategory: String?, // Vegetarian
        @SerializedName("strCreativeCommonsConfirmed")
        val strCreativeCommonsConfirmed: Any?, // null
        @SerializedName("strDrinkAlternate")
        val strDrinkAlternate: Any?, // null
        @SerializedName("strImageSource")
        val strImageSource: Any?, // null
        @SerializedName("strIngredient1")
        val strIngredient1: String?, // Broad Beans
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
        val strIngredient2: String?, // Spring Onions
        @SerializedName("strIngredient20")
        val strIngredient20: String?,
        @SerializedName("strIngredient3")
        val strIngredient3: String?, // Garlic Clove
        @SerializedName("strIngredient4")
        val strIngredient4: String?, // Parsley
        @SerializedName("strIngredient5")
        val strIngredient5: String?, // Cumin
        @SerializedName("strIngredient6")
        val strIngredient6: String?, // Baking Powder
        @SerializedName("strIngredient7")
        val strIngredient7: String?, // Cayenne Pepper
        @SerializedName("strIngredient8")
        val strIngredient8: String?, // Flour
        @SerializedName("strIngredient9")
        val strIngredient9: String?, // Vegetable Oil
        @SerializedName("strInstructions")
        val strInstructions: String?, // oak the beans in water to cover overnight.Drain. If skinless beans are unavailable, rub to loosen the skins, then discard the skins. Pat the beans dry with a towel.Grind the beans in a food mill or meat grinder.If neither appliance is available, process them in a food processor but only until the beans form a paste. (If blended too smoothly, the batter tends to fall apart during cooking.) Add the scallions, garlic, cilantro, cumin, baking powder, cayenne, salt, pepper, and coriander, if using.  Refrigerate for at least 30 minutes.Shape the bean mixture into 1-inch balls.Flatten slightly and coat with flour.Heat at least 1½-inches of oil over medium heat to 365 degrees.Fry the patties in batches, turning once, until golden brown on all sides, about 5 minutes.Remove with a wire mesh skimmer or slotted spoon. Serve as part of a meze or in pita bread with tomato-cucumber salad and tahina sauce.
        @SerializedName("strMeal")
        val strMeal: String?, // Tamiya
        @SerializedName("strMealThumb")
        val strMealThumb: String?, // https://www.themealdb.com/images/media/meals/n3xxd91598732796.jpg
        @SerializedName("strMeasure1")
        val strMeasure1: String?, // 3 cups 
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
        val strMeasure2: String?, // 6
        @SerializedName("strMeasure20")
        val strMeasure20: String?,
        @SerializedName("strMeasure3")
        val strMeasure3: String?, // 4
        @SerializedName("strMeasure4")
        val strMeasure4: String?, // 1/4 cup
        @SerializedName("strMeasure5")
        val strMeasure5: String?, // 2 tsp
        @SerializedName("strMeasure6")
        val strMeasure6: String?, // 1 tsp 
        @SerializedName("strMeasure7")
        val strMeasure7: String?, // 1/2 tsp
        @SerializedName("strMeasure8")
        val strMeasure8: String?, // Spinkling
        @SerializedName("strMeasure9")
        val strMeasure9: String?, // As required
        @SerializedName("strSource")
        val strSource: String?, // https://oukosher.org/recipes/tamiya-egyptian-dried-fava-bean-fritters/
        @SerializedName("strTags")
        val strTags: Any?, // null
        @SerializedName("strYoutube")
        val strYoutube: String? // https://www.youtube.com/watch?v=mulqW-J3Yy4
    )
}