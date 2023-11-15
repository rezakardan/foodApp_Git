package com.example.foodapplication.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import coil.load
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.databinding.ItemFoodsBinding
import com.example.foodapplication.ui.detail.DetailContracts
import javax.inject.Inject

class FavoriteAdapter@Inject constructor():RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

lateinit var binding: ItemFoodsBinding
    var favoriteList= emptyList<FavoriteEntity>()


    inner class FavoriteViewHolder(item:View):RecyclerView.ViewHolder(item){

        fun onBind(oneItem:FavoriteEntity){

            binding.itemFoodsTitle.text=oneItem.title.toString()
            binding.itemFoodsImg.load(oneItem.image.toString()){

                crossfade(true)
                crossfade(500)
            }

            binding.itemFoodsArea.visibility=View.GONE

            binding.itemFoodsCount.visibility=View.GONE

            binding.itemFoodsCategory.visibility=View.GONE

            binding.root.setOnClickListener {

                onItemClicked?.let {

                    it(oneItem)


                }


            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
binding= ItemFoodsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return FavoriteViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
holder.onBind(favoriteList[position])
    holder.setIsRecyclable(false)}

    override fun getItemCount()=favoriteList.size


    private var onItemClicked:((FavoriteEntity)->Unit)?=null

    fun onItemClickListener(listener:(FavoriteEntity)->Unit){

        onItemClicked=listener


    }




    fun favoriteDiff(data:List<FavoriteEntity>){

        val favorite=FavoriteDiffUtil(favoriteList,data)

        val diff=DiffUtil.calculateDiff(favorite)

        favoriteList=data

diff.dispatchUpdatesTo(this)

    }


    class FavoriteDiffUtil(val oldItem:List<FavoriteEntity>,val newItem:List<FavoriteEntity>):DiffUtil.Callback(){
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