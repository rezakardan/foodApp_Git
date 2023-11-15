package com.example.foodapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.foodapplication.R
import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter
import com.example.foodapplication.data.model.ResponseAllMealsCategory
import com.example.foodapplication.data.model.ResponseRandomFood
import com.example.foodapplication.databinding.FragmentHomeBinding
import com.example.foodapplication.ui.home.adapters.AllMealsByLetterAdapter
import com.example.foodapplication.ui.home.adapters.CategoryAdapter
import com.example.foodapplication.utils.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding4.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import greyfox.rxnetwork.RxNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeContract.View {

    lateinit var binding: FragmentHomeBinding


    @Inject
    lateinit var presenter: HomePresenter

    @Inject
    lateinit var categoryAdapter: CategoryAdapter

    @Inject
    lateinit var foodListAdapter: AllMealsByLetterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.callRandomMealApi()

        presenter.callAllMealCategoryApi()


        presenter.callAllMealsApi("A")




        binding.searchEdt.textChanges()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)

            .observeOn(AndroidSchedulers.mainThread())

            .subscribe {


                if (it.toString().length > 1) {

                    presenter.searchMealsByName(it.toString())


                }
            }



        spinnerFilter()


        RxNetwork.init(requireContext()).observe()
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe {

                internetError(it.isConnected)


            }


    }


    private fun spinnerFilter() {

        val filters = listOf('A'..'Z').flatten()

        val adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, filters)

        adapter.setDropDownViewResource(R.layout.item_spinner_list)

        binding.filterSpinner.adapter = adapter

        binding.filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


                presenter.callAllMealsApi(filters[p2].toString())


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {


            }
        }


    }


    override fun showRandomMealApi(data: ResponseRandomFood) {

        binding.headerImg.load(data.meals[0].strMealThumb)


    }

    override fun showAllMealCategoryApi(data: ResponseAllMealsCategory) {

        categoryAdapter.setData(data.categories)

        binding.categoryList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryList.adapter = categoryAdapter




        categoryAdapter.setOnItemClickListener {

            presenter.callFilterByCategoryApi(it.strCategory.toString())


        }


    }

    override fun showAllMealsApi(data: ResponseAllMealsByFirstLetter) {
        binding.homeDisLay.visibility = View.GONE
        binding.foodsList.visibility = View.VISIBLE

        data.meals.let {

            foodListAdapter.setData(it)
        }
        binding.foodsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.foodsList.adapter = foodListAdapter




        foodListAdapter.setonItemClickListener {


val direction=HomeFragmentDirections.actionToDetailFragment(it.idMeal.toString().toInt())

            findNavController().navigate(direction)

        }


    }

    override fun allMealsLoadingState(show: Boolean) {
        if (show) {

            binding.homeFoodsLoading.visibility = View.VISIBLE
            binding.foodsList.visibility = View.GONE


        } else {
            binding.homeFoodsLoading.visibility = View.GONE
            binding.foodsList.visibility = View.VISIBLE


        }
    }

    override fun showEmptyList() {
        binding.foodsList.visibility = View.GONE
        binding.homeDisLay.visibility = View.VISIBLE


        binding.disconnectLay.disImg.setImageResource(R.drawable.box)
        binding.disconnectLay.disTxt.text = getString(R.string.emptyList)
    }


    override fun showProgress() {
        binding.categoryList.visibility = View.GONE
        binding.homeCategoryLoading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.categoryList.visibility = View.VISIBLE
        binding.homeCategoryLoading.visibility = View.GONE
    }

    override fun isInternetOrNo(): Boolean {

        return requireContext().isNetworkAvailable()

    }

    override fun internetError(isInternet: Boolean) {

        if (isInternet) {

            binding.homeContent.visibility = View.VISIBLE
            binding.homeDisLay.visibility = View.GONE

            presenter.callAllMealsApi("A")
            presenter.callAllMealCategoryApi()


        } else {

            binding.homeContent.visibility = View.GONE
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

