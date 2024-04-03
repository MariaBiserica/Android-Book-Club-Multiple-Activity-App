package com.example.bookclubmultipleactivityapp;

import android.content.Context;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlDataParser {

    private static final Map<String, Integer> genreIconMap = new HashMap<>();

    static {
        // Initialize the genre to icon mapping
        genreIconMap.put("Fantasy", R.drawable.fantasy_icon);
        genreIconMap.put("Contemporary Fiction", R.drawable.contemporary_fiction_icon);
        genreIconMap.put("Science Fiction", R.drawable.science_fiction_icon);
        genreIconMap.put("Historical Fiction", R.drawable.historical_fiction_icon);
        genreIconMap.put("Young Adult Fantasy", R.drawable.young_adult_fantasy_icon);
        genreIconMap.put("Mystery", R.drawable.mystery_icon);
        genreIconMap.put("Horror", R.drawable.horror_icon);
        genreIconMap.put("Urban Fantasy", R.drawable.urban_fantasy_icon);
        genreIconMap.put("Romance", R.drawable.romance_icon);
        genreIconMap.put("Paranormal Romance", R.drawable.paranormal_romance_icon);
        genreIconMap.put("Contemporary Romance", R.drawable.contemporary_romance_icon);
        genreIconMap.put("Dystopian Fantasy", R.drawable.dystopian_fantasy_icon);
        genreIconMap.put("Memoir", R.drawable.memoir_icon);
        genreIconMap.put("Middle Grade Fantasy", R.drawable.middle_grade_fantasy_icon);
        genreIconMap.put("Thriller", R.drawable.thriller_icon);
        genreIconMap.put("History", R.drawable.history_icon);
        genreIconMap.put("Middle Grade Mystery", R.drawable.middle_grade_mystery_icon);
        // Add more mappings as necessary
        genreIconMap.put("Default", R.drawable.default_icon);
    }

    public static List<Book> parseBooksXml(Context context) {
        List<Book> books = new ArrayList<>();
        XmlResourceParser parser = context.getResources().getXml(R.xml.books_data);

        try {
            int eventType = parser.getEventType();
            // Initialize variables
            String title = null, author = null, genre = null, briefDescription = null,
                    fullDescription = null, publishingDate = null, reviewUrl = null;
            float rating = 0;
            int iconDrawable = 0, coverDrawable = 0,
                    numberOfRatings = 0, numberOfReviews = 0, numberOfPages = 0;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String eltName;

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        eltName = parser.getName();

                        if ("book".equals(eltName)) {
                            title = null;
                            author = null;
                            genre = null;
                            iconDrawable = 0; // Reset to default for each new book
                            coverDrawable = 0;
                            briefDescription = null;
                            fullDescription = null;
                            rating = 0;
                            numberOfRatings = 0;
                            numberOfReviews = 0;
                            numberOfPages = 0;
                            publishingDate = null;
                            reviewUrl = null;
                        } else if ("title".equals(eltName)) {
                            title = parser.nextText();
                        } else if ("author".equals(eltName)) {
                            author = parser.nextText();
                        } else if ("genre".equals(eltName)) {
                            genre = parser.nextText();
                            // Use the genre to determine the icon
                            Integer drawableId = genreIconMap.get(genre);
                            if (drawableId != null) {
                                iconDrawable = drawableId;
                            } else {
                                iconDrawable = genreIconMap.get("Default"); // Use default icon if genre not found
                            }
                        } else if ("cover".equals(eltName)) {
                            String coverDrawableName = parser.nextText();
                            coverDrawable = context.getResources().getIdentifier(coverDrawableName, "drawable", context.getPackageName());
                        } else if ("briefDescription".equals(eltName)) {
                            briefDescription = parser.nextText();
                        } else if ("fullDescription".equals(eltName)) {
                            fullDescription = parser.nextText();
                        } else if ("rating".equals(eltName)) {
                            rating = Float.parseFloat(parser.nextText());
                        } else if ("numberOfRatings".equals(eltName)) {
                            numberOfRatings = Integer.parseInt(parser.nextText());
                        } else if ("numberOfReviews".equals(eltName)) {
                            numberOfReviews = Integer.parseInt(parser.nextText());
                        } else if ("numberOfPages".equals(eltName)) {
                            numberOfPages = Integer.parseInt(parser.nextText());
                        } else if ("publishingDate".equals(eltName)) {
                            publishingDate = parser.nextText();
                        } else if ("reviewUrl".equals(eltName)) {
                            reviewUrl = parser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        eltName = parser.getName();
                        if ("book".equals(eltName) && title != null && author != null && genre != null) {
                            // Add the book to the list
                            books.add(new Book(title, author, genre, iconDrawable, coverDrawable,
                                    briefDescription, fullDescription, rating, numberOfRatings,
                                    numberOfReviews, numberOfPages, publishingDate, reviewUrl));
                        }
                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
