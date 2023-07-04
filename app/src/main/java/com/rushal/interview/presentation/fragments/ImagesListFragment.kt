package com.rushal.interview.presentation.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.paging.LoadState
import dagger.android.support.DaggerFragment
import com.rushal.interview.R
import com.rushal.interview.data.model.ImagesResponse
import com.rushal.interview.databinding.FragmentImagesListBinding
import com.rushal.interview.presentation.adapters.ImagesAdapter
import com.rushal.interview.presentation.adapters.LoadingStateAdapter
import com.rushal.interview.presentation.viewmodels.ImagesListViewModel
import com.rushal.interview.utils.toast
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class ImagesListFragment : DaggerFragment(R.layout.fragment_images_list) {


    private var hasInitiatedInitialCall = false

    private lateinit var binding: FragmentImagesListBinding

    private var job: Job? = null

    private val adapter =
        ImagesAdapter { imagesResponse, imageView -> navigate(imagesResponse, imageView) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ImagesListViewModel by viewModels {
        viewModelFactory
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImagesListBinding.bind(view)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        setAdapter()

        //prevents the method being called again onbackpressed pressed.
        if (!hasInitiatedInitialCall) {
            getImages()
            hasInitiatedInitialCall = true
        }

    }

    private fun getImages() {
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.getImages().collect {
                adapter.submitData(it)
            }

        }
    }

    private fun setAdapter() {
        binding.imagesList.adapter = adapter.withLoadStateFooter(
            LoadingStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener {

            binding.progress.isVisible = it.refresh is LoadState.Loading

            if (it.refresh is LoadState.Error) {
                requireContext().toast("There was a problem fetching data")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.destination_search -> navigateSearch()
            R.id.scroll_down -> scrollDown()
            R.id.scroll_up -> scrollUp()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun navigateSearch() {
//        binding.root.findNavController().navigate(ImagesListFragmentDirections.toSearchFragment())
    }

    private fun scrollUp() {
        binding.imagesList.scrollToPosition(0)
    }

    private fun scrollDown() {
        binding.imagesList.scrollToPosition(adapter.itemCount - 1)
    }


    private fun navigate(imagesResponse: ImagesResponse, imageView: ImageView) {
        // val extras = FragmentNavigatorExtras(imageView to imagesResponse.urls.regular) not working

        val action = ImagesListFragmentDirections.toSingleImageFragment(imagesResponse)
        binding.root.findNavController()
            .navigate(action)
    }

}