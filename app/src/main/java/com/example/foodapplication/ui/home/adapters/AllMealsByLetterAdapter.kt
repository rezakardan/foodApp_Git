package com.example.foodapplication.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter
import com.example.foodapplication.databinding.ItemFoodsBinding
import javax.inject.Inject

class AllMealsByLetterAdapter @Inject constructor():RecyclerView.Adapter<AllMealsByLetterAdapter.AllMealsByLetterViewHolder>() {

    lateinit var binding: ItemFoodsBinding

    var foodList= emptyList<ResponseAllMealsByFirstLetter.Meal>()

    inner class AllMealsByLetterViewHolder(item:View):RecyclerView.ViewHolder(item){

fun onBind(oneItem: ResponseAllMealsByFirstLetter.Meal){



    if (oneItem.strArea.isNullOrEmpty().not()){
        binding.itemFoodsArea.text=oneItem.strArea
    binding.itemFoodsArea.visibility=View.VISIBLE
    }else{
        binding.itemFoodsArea.visibility=View.GONE
    }

    if (oneItem.strCategory.isNullOrEmpty().not()){
        binding.itemFoodsCategory.text=oneItem.strCategory
    binding.itemFoodsCategory.visibility=View.VISIBLE
    }else{
        binding.itemFoodsCategory.visibility=View.GONE
    }

    binding.itemFoodsTitle.text=oneItem.strMeal

    if (oneItem.strSource!=null){

        binding.itemFoodsCount.visibility=View.VISIBLE


    }else{
        binding.itemFoodsCount.visibility=View.GONE

    }


    binding.itemFoodsImg.load(oneItem.strMealThumb){
        crossfade(true)
        crossfade(500)
    }







    binding.root.setOnClickListener {

        onItemClickListener?.let {

            it(oneItem)
        }


    }



}



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMealsByLetterViewHolder {
        binding= ItemFoodsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AllMealsByLetterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: AllMealsByLetterViewHolder, position: Int) {
holder.onBind(foodList[position])
        holder.setIsRecyclable(false)

    }

    override fun getItemCount()=foodList.size





    private var onItemClickListener:((ResponseAllMealsByFirstLetter.Meal)->Unit)?=null

    fun setonItemClickListener(listener:(ResponseAllMealsByFirstLetter.Meal)->Unit){

        onItemClickListener=listener


    }



    fun setData(data:List<ResponseAllMealsByFirstLetter.Meal>){

        val diff=FoodListDiffUtils(foodList,data)

      val diffFoodList=  DiffUtil.calculateDiff(diff)

        foodList=data


diffFoodList.dispatchUpdatesTo(this)




    }

    class FoodListDiffUtils(val oldItem:List<ResponseAllMealsByFirstLetter.Meal>, val newItem:List<ResponseAllMealsByFirstLetter.Meal>):DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
return oldItem[oldItemPosition]===newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition]===newItem[newItemPosition]
        }


    }
}