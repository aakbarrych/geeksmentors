package kg.geeks.geeksmentor.presentation.presentation.mentorlists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geeks.geeksmentor.databinding.MentorsListItemBinding
import kg.geeks.geeksmentor.presentation.data.model.MentorList

class MentorListAdapter : ListAdapter<MentorList, MentorListAdapter.MentorListViewHolder>(Comparator()) {

    class Comparator: DiffUtil.ItemCallback<MentorList>(){
        override fun areItemsTheSame(oldItem: MentorList, newItem: MentorList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MentorList, newItem: MentorList): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MentorsListItemBinding.inflate(inflater, parent, false)
        return MentorListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MentorListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MentorListViewHolder(private val binding: MentorsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mentorList: MentorList) {
            binding.rvMentorsName.text = mentorList.title
            binding.rvMentorsLikeCount.text = mentorList.price.toString()
            binding.rvMentorsDislikeCount.text = mentorList.stock.toString()
            //Glide.with(binding.rvMentorsImage).load(mentorList.images[1]).into(binding.rvMentorsImage)
        }
    }
}
