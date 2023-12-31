package kg.geeks.geeksmentor.presentation.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.geeks.geeksmentor.databinding.List5ItemBinding
import kg.geeks.geeksmentor.presentation.data.model.Mentors

class MentorsBackendAdapter(private val mentorList: List<Mentors>) : RecyclerView.Adapter<MentorsBackendAdapter.MentorsBackendViewHolder>(){

    inner class MentorsBackendViewHolder(binding: List5ItemBinding) : RecyclerView.ViewHolder(binding.root){
        val mentorsImageView : ImageView = binding.rv5Img
        val mentorsNames : TextView = binding.rv5Name
        val mentorsStudentNumber : TextView = binding.rv5PersonNum
        val mentorsLikes : TextView = binding.rv5LikeNum
        val mentorsDislikes : TextView = binding.rv5DislikeNum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorsBackendViewHolder {
        return MentorsBackendViewHolder(List5ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MentorsBackendViewHolder, position: Int) {
        val mentors = mentorList[position]
        holder.mentorsImageView.setImageResource(mentors.image)
        holder.mentorsNames.text = mentors.name
        holder.mentorsStudentNumber.text = mentors.studentNumber.toString()
        holder.mentorsLikes.text = mentors.likes.toString()
        holder.mentorsDislikes.text = mentors.dislikes.toString()
    }

    override fun getItemCount(): Int {
        return mentorList.size
    }
}