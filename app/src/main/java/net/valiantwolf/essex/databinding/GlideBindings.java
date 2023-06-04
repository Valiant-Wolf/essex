package net.valiantwolf.essex.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;

public class GlideBindings {

  @BindingAdapter("app:glideUrl")
  public static void setGlideUrl(ImageView view, String url) {
    Context context = view.getContext();

    Glide.with(context)
         .load(url)
         .placeholder(getSpinner(context))
         .into(view);
  }

  private static Drawable getSpinner(Context context) {
    CircularProgressDrawable result = new CircularProgressDrawable(context);
    result.setStrokeWidth(4);
    result.setCenterRadius(24);
    result.start();

    return result;
  }

}
