package com.example.foodapplication.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapplication.R
import com.example.foodapplication.data.model.ResponseAllMealsCategory
import com.example.foodapplication.databinding.ItemCategoriesBinding
import javax.inject.Inject

class CategoryAdapter @Inject constructor() :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    lateinit var binding: ItemCategoriesBinding
    private var categoryList = emptyList<ResponseAllMealsCategory.Category>()
    private var selectedItem=-1

    inner class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun onBind(oneItem: ResponseAllMealsCategory.Category) {


            binding.itemCategoriesTxt.text = oneItem.strCategory
            binding.itemCategoriesImg.load(oneItem.strCategoryThumb) {
                crossfade(true)
                crossfade(500)
            }

            binding.root.setOnClickListener {

                selectedItem=adapterPosition
                notifyDataSetChanged()

                onItemClicked?.let {

                    it(oneItem)

                }


            }

            if (selectedItem==adapterPosition){



                binding.root.setBackgroundResource(R.drawable.bg_rounded_selcted)
            }else{
                binding.root.setBackgroundResource(R.drawable.bg_rounded_white)
            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(categoryList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = categoryList.size


    private var onItemClicked: ((ResponseAllMealsCategory.Category) -> Unit)? = null

    fun setOnItemClickListener(listener: (ResponseAllMealsCategory.Category) -> Unit) {

        onItemClicked = listener

    }


    fun setData(data: List<ResponseAllMealsCategory.Category>) {

        val diff = DiffUtilCategory(categoryList, data)

        val categoryDiff = DiffUtil.calculateDiff(diff)
        categoryList = data

        categoryDiff.dispatchUpdatesTo(this)


    }


    class DiffUtilCategory(
        val oldItem: List<ResponseAllMealsCategory.Category>,
        val newItem: List<ResponseAllMealsCategory.Category>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
            return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }


    }
}