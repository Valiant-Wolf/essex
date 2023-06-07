package net.valiantwolf.essex.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import com.bumptech.glide.ListPreloader.PreloadModelProvider;
import com.bumptech.glide.ListPreloader.PreloadSizeProvider;
import net.valiantwolf.essex.databinding.PostItemLayoutBinding;
import net.valiantwolf.essex.entity.Post;

public class PostAdapter extends ListAdapter<Post, PostViewHolder> {

  public PostAdapter() {
    super(new Post.DiffCallback());
  }

  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new PostViewHolder(
        this,
        PostItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
    );
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    holder.bind(getItem(position));

  }
}
