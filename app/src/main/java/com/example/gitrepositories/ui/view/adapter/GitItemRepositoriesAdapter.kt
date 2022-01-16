package com.example.gitrepositories.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gitrepositories.R
import com.example.gitrepositories.data.dto.GitItemPullRequestDTO
import kotlinx.android.synthetic.main.item_gititemrepositories.view.*

class GitItemRepositoriesAdapter(
    private val items: List<GitItemPullRequestDTO>
) : RecyclerView.Adapter<GitItemRepositoriesAdapter.GitItemRepositoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitItemRepositoriesAdapter.GitItemRepositoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_gititemrepositories, parent, false
        )
        return GitItemRepositoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitItemRepositoriesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class GitItemRepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: GitItemPullRequestDTO) {
            with(itemView) {
                name_autor.text = item.user.login
                title_pr.text = item.titlePullRequest
                body_pr.text = item.body
            }
            with(itemView.avatar_autor) {
                Glide.with(this)
                    .load(item.user.avatarUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(R.drawable.ic_git)
                    .into(this)
            }
        }
    }
}