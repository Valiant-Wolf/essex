package net.valiantwolf.essex.entity;

import com.squareup.moshi.Json;

public class Post
{

    int id;
    File file;
    File preview;
    File sample;
    Score score;
    Flags flags;
    Rating rating;


    public static class File
    {

        int width;
        int height;
        Ext ext = Ext.JPG;
        int size;
        String url;

        public static enum Ext
        {
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

    public static class Score
    {
        int up;
        int down;
        int total;
    }

    public static class Flags
    {
        boolean pending;
    }

    public static enum Rating
    {
        @Json(name = "s")
        S,

        @Json(name = "q")
        Q,

        @Json(name = "e")
        E
    }
}
