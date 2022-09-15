package com.mahmudul.rickandmortyapi.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mahmudul.rickandmortyapi.R
import com.mahmudul.rickandmortyapi.databinding.FragmentCharactersBinding
import com.mahmudul.rickandmortyapi.domain.adapters.CharacterAdapter
import com.mahmudul.rickandmortyapi.presentation.viewmodels.CharactersViewModel
import com.mahmudul.rickandmortyapi.util.autoCleared

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private var binding: FragmentCharactersBinding by autoCleared()
    private val charactersViewModel: CharactersViewModel by viewModels()
    private var charactersAdapter: CharacterAdapter? = null

    var isLoading = false
    var isLastPage = false
    var isScrolling = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCharactersBinding.bind(view)
    }

}