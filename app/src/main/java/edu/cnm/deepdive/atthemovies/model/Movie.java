package edu.cnm.deepdive.atthemovies.model;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Movie implements Serializable {

  private static final long serialVersionUID = 1L;

  @PrimaryKey(autoGenerate = true)
  private Long id;

  private String title;

  private String screenwriter;



  @TypeConverters(DateConverter.class)
  private Date timestamp;


  public enum Genre{
    HORROR, ACTION, ROMCOM, DOCUMENTARY, ANIME, SCIFI,FANTASY
  }

  @TypeConverters(GenreConverter.class)
  private Genre genre;

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public String getScreenwriter() {
    return screenwriter;
  }

  public void setScreenwriter(String screenwriter) {
    this.screenwriter = screenwriter;
  }

  @NonNull
  @Override
  public String toString() {
    return title + ":" + genre;
  }

  public static class GenreConverter {

    @TypeConverter
    public static Genre stringToGenre (String value) {
      return Genre.valueOf(value);
    }

    @TypeConverter
    public static String genreToString(Genre genre){
      return genre.name();
    }

  }

  public  static class DateConverter {

    @TypeConverter
    public static Date LongToDate(Long value) {
      return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToLong(Date value) {
      return value == null ? null : value.getTime();
    }
  }
}
