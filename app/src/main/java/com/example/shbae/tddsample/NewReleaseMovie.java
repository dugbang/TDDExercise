package com.example.shbae.tddsample;

/**
 * Created by shbae on 2017-11-21.
 */

class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    double determineAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int determineFrequentRentalPoint(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
