package com.example.foodapplication.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.foodapplication.R
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter
import com.example.foodapplication.databinding.FragmentDetailBinding
import com.example.foodapplication.utils.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import greyfox.rxnetwork.RxNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(), DetailContracts.View {

    lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var presenter: DetailPresenter
@Inject
lateinit var entity:FavoriteEntity

    private val args: DetailFragmentArgs by navArgs()

    private var foodId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        foodId = args.foodId

        if (foodId > 0) {

            presenter.detailFoodApi(foodId)


        }



        RxNetwork.init(requireContext()).observe()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

                internetError(it.isConnected)

            }


        binding.imgArrowBack.setOnClickListener {

            findNavController().popBackStack()
        }


    }

    override fun showDetailFood(data: ResponseAllMealsByFirstLetter) {







        data.meals.get(0).let {



entity.id=it.idMeal.toString().toInt()

            entity.title=it.strMeal.toString()
            entity.image=it.strMealThumb.toString()

presenter.existFood(it.idMeal.toString().toInt())


            binding.foodCoverImg.load(it.strMealThumb) {

                crossfade(true)
                crossfade(500)
            }

            binding.foodTitleTxt.text = it.strMeal

            binding.foodSourceImg.setOnClickListener {


            }


            binding.foodCategoryTxt.text = it.strCategory

            binding.foodAreaTxt.text = it.strArea

            binding.foodDescTxt.text = it.strInstructions


            if (it.strYoutube != null) {
                binding.foodPlayImg.visibility = View.VISIBLE

                binding.foodPlayImg.setOnClickListener {itView->



                    val intent=Intent(Intent.ACTION_VIEW,Uri.parse(it.strYoutube))
                    startActivity(intent)


                }


            } else {

                binding.foodPlayImg.visibility = View.GONE
            }


            if (it.strSource != null) {

                binding.foodSourceImg.visibility = View.VISIBLE

                binding.foodSourceImg.setOnClickListener { view ->

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.strSource))

                    startActivity(intent)


                }
            } else {

                binding.foodSourceImg.visibility = View.GONE
            }


            val jsonData=JSONObject(Gson().toJson(data))

            val meals=jsonData.getJSONArray("meals")

            val meal=meals.getJSONObject(0)

           for (i in 1..15){

               val ingredient=meal.getString("strIngredient$i")


               if (ingredient.isNullOrEmpty().not()) {
                   binding.ingredientsTxt.append("$ingredient\n")

               }
           }

            for (i in 1 .. 15){

                val measure=meal.getString("strMeasure$i")

                binding.measureTxt.append("$measure\n")



            }


        }


    }

    override fun showUpdateFood(isAdded: Boolean) {


        binding.favoriteImg.setOnClickListener {

            if (isAdded) {

                presenter.deleteFood(entity)


            } else {

                presenter.insertFood(entity)
            }



        }

        if (isAdded){

            binding.favoriteImg.setColorFilter(ContextCompat.getColor(requireContext(),R.color.tartOrange))


        }else{
            binding.favoriteImg.setColorFilter(ContextCompat.getColor(requireContext(),R.color.black))
        }

    }
    override fun showProgress() {
        binding.detailContentLay.visibility = View.GONE
        binding.detailLoading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.detailContentLay.visibility = View.VISIBLE
        binding.detailLoading.visibility = View.GONE
    }

    override fun isInternetOrNo(): Boolean {

        return requireContext().isNetworkAvailable()

    }

    override fun internetError(isInternet: Boolean) {

        if (isInternet) {

            binding.detailContentLay.visibility = View.VISIBLE
            binding.homeDisLay.visibility = View.GONE


        } else {

            binding.detailContentLay.visibility = View.GONE
            binding.homeDisLay.visibility = View.VISIBLE

            binding.disconnectLay.disImg.setImageResource(R.drawable.disconnect)

            binding.disconnectLay.disTxt.text = getString(R.string.checkInternet)

        }


    }

    override fun serverError(message: String) {


        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onStop()
    }


}