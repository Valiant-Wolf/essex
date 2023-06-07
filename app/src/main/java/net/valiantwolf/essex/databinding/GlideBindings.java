package net.valiantwolf.essex.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public abstract class GlideBindings {

  @BindingAdapter({"glideUrl"})
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
