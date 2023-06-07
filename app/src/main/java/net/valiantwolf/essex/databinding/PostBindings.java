package net.valiantwolf.essex.databinding;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import net.valiantwolf.essex.R;
import net.valiantwolf.essex.entity.Post;

public abstract class PostBindings {

  @BindingAdapter("postRating")
  public static void setPostRating(ImageView view, Post.Rating rating) {

    Context context = view.getContext();

    switch (rating)
    {
      case S:
        view.setImageResource(R.drawable.ic_safe);
        view.setColorFilter(context.getColor(R.color.yellow));
        break;
      case Q:
        view.setImageResource(R.drawable.ic_questionable);
        view.setColorFilter(context.getColor(R.color.orange));
        break;
      case E:
      default:
        view.setImageResource(R.drawable.ic_explicit);
        view.setColorFilter(context.getColor(R.color.magenta));
        break;
    }
  }

  @BindingAdapter("postScore")
  public static void setPostScore(TextView view, int score) {

    if (score > 0) {
      view.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_vote_up, 0, 0, 0);
    } else if (score < 0) {
      view.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_vote_down, 0, 0, 0);
    } else {
      view.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_vote_both, 0, 0, 0);
    }
  }

  @BindingAdapter("shortNumericText")
  public static void setShortNumericText(TextView view, int value) {
    if (value < 10000) {
      view.setText(String.format("%d", value));
    } else {
      view.setText(String.format("%d.%dk", value / 1000, (value % 1000) / 100));
    }
  }
}
