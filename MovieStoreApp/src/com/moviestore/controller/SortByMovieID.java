package com.moviestore.controller;

import java.util.Comparator;

import com.moviestore.beans.CustomerFavMovieBeans;

public class SortByMovieID implements Comparator<CustomerFavMovieBeans> {

	@Override
	public int compare(CustomerFavMovieBeans o1, CustomerFavMovieBeans o2) {
		// TODO Auto-generated method stub
		return o1.getMoviesID()-o2.getMoviesID();
	}

}
