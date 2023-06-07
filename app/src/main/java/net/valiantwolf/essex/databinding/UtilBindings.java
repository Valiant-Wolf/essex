package net.valiantwolf.essex.databinding;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.databinding.BindingAdapter;

public abstract class UtilBindings {

  @BindingAdapter("goneIf")
  public static void setGoneIf(View view, boolean predicate) {
    view.setVisibility( predicate ? View.VISIBLE : View.GONE );
  }

  @SuppressLint("DefaultLocale")
  @BindingAdapter({"aspectWidth", "aspectHeight"})
  public static void setAspectRatio(View view, int width, int height)
  {
    LayoutParams params = (ConstraintLayout.LayoutParams) view.getLayoutParams();
    params.dimensionRatio = String.format("h,%d:%d", width, height);
  }

}
