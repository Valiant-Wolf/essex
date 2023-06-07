package net.valiantwolf.essex.ui.home;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import net.valiantwolf.essex.databinding.PostItemLayoutBinding;
import net.valiantwolf.essex.entity.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

  private final PostItemLayoutBinding binding;

  public PostViewHolder(PostAdapter adapter, PostItemLayoutBinding binding) {
    super(binding.getRoot());
    this.binding = binding;
  }

  public void bind(Post post) {
    binding.setPost(post);

    binding.executePendingBindings();
  }
}
