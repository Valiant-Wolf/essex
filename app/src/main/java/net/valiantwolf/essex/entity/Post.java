package net.valiantwolf.essex.entity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.squareup.moshi.Json;
import java.util.Objects;

public class Post {

  int id;
  File file;
  File preview;
  File sample;
  Score score;
  int favCount;
  int commentCount;
  Flags flags;
  Rating rating;

  public int getId() {
    return id;
  }

  public File getFile() {
    return file;
  }

  public File getPreview() {
    return preview;
  }

  public File getSample() {
    return sample;
  }

  public int getScore() {
    return score.total;
  }

  public int getFavCount() {
    return favCount;
  }

  public int getCommentCount() {
    return commentCount;
  }

  public Rating getRating() {
    return rating;
  }

  public boolean isPending() {
    return flags.pending;
  }

  public static class File {

    int width;
    int height;
    Ext ext = Ext.JPG;
    int size;
    String url;

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }

    public Ext getExt() {
      return ext;
    }

    public int getSize() {
      return size;
    }

    public String getUrl() {
      return url;
    }

    public static enum Ext {
      @Json(name = "png")
      PNG,

      @Json(name = "jpg")
      JPG,

      @Json(name = "gif")
      GIF,

      @Json(name = "swf")
      SWF,

      @Json(name = "webm")
      WEBM
    }
  }

  private static class Score {

    int up;
    int down;
    int total;
  }

  private static class Flags {

    boolean pending;
  }

  public static enum Rating {
    @Json(name = "s")
    S,

    @Json(name = "q")
    Q,

    @Json(name = "e")
    E
  }

  public static class DiffCallback extends ItemCallback<Post> {

    @Override
    public boolean areItemsTheSame(@NonNull Post left, @NonNull Post right) {
      return left.id == right.id;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Post left, @NonNull Post right) {
      return left.score.total == right.score.total
          && left.favCount == right.favCount
          && left.commentCount == right.commentCount
          && left.flags.pending == right.flags.pending;
    }
  }
}
