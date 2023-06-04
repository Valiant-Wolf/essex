package net.valiantwolf.essex.entity;

import com.squareup.moshi.Json;

public class Post {

  int id;
  File file;
  File preview;
  File sample;
  Score score;
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

  public Score getScore() {
    return score;
  }

  public Flags getFlags() {
    return flags;
  }

  public Rating getRating() {
    return rating;
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

  public static class Score {

    int up;
    int down;
    int total;
  }

  public static class Flags {

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
}
