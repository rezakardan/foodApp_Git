package com.example.foodapplication.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapplication.R
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.databinding.FragmentFavoriteBinding
import com.example.foodapplication.ui.detail.DetailFragmentDirections
import com.example.foodapplication.utils.isNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteFragment : Fragment(),FavoriteContracts.View {
lateinit var binding: FragmentFavoriteBinding


@Inject
lateinit var presenter:FavoritePresenter

@Inject
lateinit var favoriteAdapter:FavoriteAdapter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

presenter.getAllFoods()



    }

    override fun showGetAllFoods(data: MutableList<FavoriteEntity>) {

        favoriteAdapter.favoriteDiff(data)

        binding.recyclerFavorite.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.recyclerFavorite.adapter=favoriteAdapter


        favoriteAdapter.onItemClickListener {

            val direction=FavoriteFragmentDirections.actionToDetailFragment(it.id)

            findNavController().navigate(direction)



        }




    }

    override fun emptyList() {
        binding.recyclerFavorite.visibility=View.GONE

        binding.homeDisLay.visibility=View.VISIBLE


        binding.disconnectLay.disImg.setImageResource(R.drawable.empty)

        binding.disconnectLay.disTxt.text=getString(R.string.emptyList)
    }


    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }


}