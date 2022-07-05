package my.study.portfolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import my.study.portfolio.data.model.Repo
import my.study.portfolio.databinding.RepositoryItensBinding

class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepositoryItensBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: RepositoryItensBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Repo) {
            binding.tvRepositoryName.text = item.name
            binding.tvRepositoryDescription.text = item.description
            binding.tvLanguage.text = item.language
            binding.cStar.text = item.stargazersCount.toString()
            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id
}