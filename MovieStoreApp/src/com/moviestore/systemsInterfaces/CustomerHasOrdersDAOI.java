package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.beans.CustomerFavMovieBeans;


public interface CustomerHasOrdersDAOI {
	public boolean insertOrder (int ordersID, List<CustomerFavMovieBeans> cusList);
}
