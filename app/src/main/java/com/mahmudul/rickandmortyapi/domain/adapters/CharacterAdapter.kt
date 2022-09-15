package com.mahmudul.rickandmortyapi.domain.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.mahmudul.rickandmortyapi.R
import com.mahmudul.rickandmortyapi.domain.models.Result
import com.mahmudul.rickandmortyapi.databinding.RowCharacterBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var binding: RowCharacterBinding? = null

    inner class CharacterViewHolder(itemBinding: RowCharacterBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = RowCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(requireNotNull(binding))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = differ.currentList[position]
        holder.itemView.apply {
            binding?.characterName?.text = character.name
            binding?.lastKnownLocation?.text = character.location?.name
            binding?.firstSeenIn?.text = character.origin?.name
            binding?.let {
                binding?.characterImage?.let { characterImage ->
                    characterImage.load(character.image) {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }

                }
            }
            binding?.characterSpeciesAndStatus?.text =
                "${character.status} - ${character.species}"

            if (character.status?.contains("Dead") == true) {
                binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_red)
            } else if (character.status?.contains("Alive") == true) {
                binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_green)
            } else binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_grey)

            setOnClickListener {
                onItemClickListener?.let { it(character) }
                Log.d("TAG", "${character.id}")
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    private var onItemClickListener: ((Result) -> Unit)? = null

    fun setOnItemClickListener(listener: (Result) -> Unit) {
        onItemClickListener = listener

    }


}