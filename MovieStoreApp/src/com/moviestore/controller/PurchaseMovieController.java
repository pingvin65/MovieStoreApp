package com.moviestore.controller;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.moviestore.beans.CustomerFavMovieBeans;
import com.moviestore.beans.MoviesBean;
import com.moviestore.dao.CustomerFavMovieDAO;
import com.moviestore.dao.CustomerHasOrdersDAO;
import com.moviestore.dao.CustomerLoginDAO;
import com.moviestore.dao.MoviesDAO;
import com.moviestore.dao.OrdersDAO;
import com.moviestore.model.CustomerFavMovie;
import com.moviestore.model.CustomerLogin;
import com.moviestore.model.Movies;
import com.moviestore.utility.CipherHelper;

@Controller
@RequestMapping("/purchase")
@SessionAttributes({ "loginp", "listCustomerPreMovies", "moviekeys" })
public class PurchaseMovieController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String apptitleg = InfoPage.getApptitleg(); // "MS";
	private static final String secretKey = InfoPage.getSecretkey();
	private int custID;

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	@ModelAttribute("movieskey")
	public MoviesBean setUpUserForm() {
		return new MoviesBean();
	}

	@ModelAttribute("listCustomerPreMovies")
	public List<CustomerFavMovieBeans> setUpUserForms2() {
		return new ArrayList<CustomerFavMovieBeans>();
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getPurchaseMovieByID(HttpSession session, @PathVariable int id,
			@ModelAttribute("listCustomerPreMovies") List<CustomerFavMovieBeans> listCustomerPreMovies,
			HttpServletRequest request, ModelMap model) {
		listCustomerPreMovies.clear();
		CustomerLoginDAO customerDAO = new CustomerLoginDAO();
		MoviesDAO moviesDAO = new MoviesDAO();
		CustomerFavMovieDAO custPreorderMovieDAO;
		String requestPath = request.getServletPath();
		logger.info("----------- PurchaseMovieController  -------> {}.", requestPath);
		checkLogin(session);
		if (session.getAttribute("cusiden") != null) {
			setCustID(decCusiden((String) session.getAttribute("cusiden")));
		} else {
			// setCustID(-1);
		}

		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("apptitle", apptitleg + " | list");

		logger.info("---------------- PurchaseMovieController id -------> {}.", id);

		Movies movies = moviesDAO.getMoviesByID(id);
		try {
			if (movies.getMoviesID() == id) {
				logger.info("---------------- PurchaseMovieController id -------> {}.", movies.getMoviesID());

				CustomerLogin customer = customerDAO.getCustomerByid(getCustID());
				logger.info("---------------- PurchaseMovieController customer -------> {}.", customer.getCustomerID());
				if (customer.getCustomerID() == getCustID()) {
					CustomerFavMovieDAO cTempDAO = new CustomerFavMovieDAO();
					String sql = "INSERT INTO CUSTOMER_PREORDER_MOVIES (moviesid, customerid) VALUES(" + id + ","
							+ customer.getCustomerID() + ")";
					if (cTempDAO.inserData(sql)) {
						logger.info("---------------- PurchaseMovieController movie in list -------> {}.", id);
					}
				}
			}
		} catch (NullPointerException e) {
			logger.error("---------------- PurchaseMovieController in errormovie in list -------> {}.", id);
			return new ModelAndView("redirect:/login");
		}

		custPreorderMovieDAO = new CustomerFavMovieDAO();

		if (listCustomerPreMovies.size() > 0) {
			logger.info("---------------- PurchaseMovieController numb customer -------> {}.",
					listCustomerPreMovies.size());
			listCustomerPreMovies.clear();
		}

		for (CustomerFavMovie cus : custPreorderMovieDAO.favouriteMovie(getCustID(), "view_customer_preorder_movies")) {
			// CustomerFavMovieBeans(int moviesID, int runtime, String title, float price,
			// float score)

			listCustomerPreMovies.add(new CustomerFavMovieBeans(cus.getConsumerfmID(), cus.getMoviesID(),
					cus.getRuntime(), cus.getTitle(), cus.getPrice(), cus.getScore()));

		}
		Collections.sort(listCustomerPreMovies, new SortByMovieID());
		modelAndView.addObject("listCustomerPreMovies", listCustomerPreMovies);
		model.addAttribute("listCustomerPreMovies", listCustomerPreMovies);
		session.setAttribute("addMovieToList", "addMovieToList");
		modelAndView.addObject("pagebody", "pages/buymovie.jsp");
		// return modelAndView;
		return new ModelAndView("redirect:/purchase/movie");

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listBuyMovie(@ModelAttribute("movieskey") MoviesBean movieskey, HttpSession session,
			BindingResult result, HttpServletRequest request,
			@ModelAttribute("listCustomerPreMovies") List<CustomerFavMovieBeans> listCustomerPreMovies, ModelMap model)
			throws SQLSyntaxErrorException {
		checkLogin(session);
		
		logger.info("---------------- PurchaseMovieController numb customer -------> {}.",
				session.getAttribute("cusiden"));
		OrdersDAO ordersDAO = new OrdersDAO();
		CustomerFavMovieDAO customerFavMovieDAO = null;
		// decCusiden((String)session.getAttribute("cusiden"));
		int cusid = decCusiden((String) session.getAttribute("cusiden"));
		// Orders orders = new Orders();

		logger.info("---------------- PurchaseMovieController ordersNweID -------> {}.", "dfdfdffdf");
		if (ordersDAO.insertOrder(cusid)) {
			CustomerHasOrdersDAO customerHasOrdersDAO = new CustomerHasOrdersDAO();
			int lastOrder = ordersDAO.getLastID(cusid);
			customerHasOrdersDAO.insertOrder(lastOrder, listCustomerPreMovies);
			logger.info("---------------- PurchaseMovieController ordersDAO -------> {}.",
					session.getAttribute("cusiden"));
			customerFavMovieDAO = new CustomerFavMovieDAO();
			customerFavMovieDAO
					.deleteRecordFromTable("DELETE FROM CUSTOMER_PREORDER_MOVIES WHERE customerid =" + cusid);
			listCustomerPreMovies.clear();
			session.setAttribute("addedMovie", "Thank you very much for your order with number " + lastOrder);
			
		}

		return new ModelAndView("redirect:/purchase/movie");

	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public ModelAndView buyListMovie(@ModelAttribute("movieskey") MoviesBean movieskey, HttpSession session,
			BindingResult result, HttpServletRequest request,
			@ModelAttribute("listCustomerPreMovies") List<CustomerFavMovieBeans> listCustomerPreMovies,
			ModelMap model) {
		checkLogin(session);

		listCustomerPreMovies.clear();
		CustomerFavMovieDAO custPreorderMovieDAO = new CustomerFavMovieDAO();
		for (CustomerFavMovie cus : custPreorderMovieDAO.favouriteMovie(getCustID(), "view_customer_preorder_movies")) {
			// CustomerFavMovieBeans(int moviesID, int runtime, String title, float price,
			// float score)

			listCustomerPreMovies.add(new CustomerFavMovieBeans(cus.getConsumerfmID(), cus.getMoviesID(),
					cus.getRuntime(), cus.getTitle(), cus.getPrice(), cus.getScore()));

		}
		Collections.sort(listCustomerPreMovies, new SortByMovieID());
		model.addAttribute("listCustomerPreMovies", listCustomerPreMovies);
		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("apptitle", apptitleg + " | list");
		modelAndView.addObject("pagebody", "pages/buymovie.jsp");
		return modelAndView;

	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ModelAndView removeListMovie(@PathVariable int id, @ModelAttribute("movieskey") MoviesBean movieskey,
			HttpSession session, BindingResult result, HttpServletRequest request,
			@ModelAttribute("listCustomerPreMovies") List<CustomerFavMovieBeans> listCustomerPreMovies,
			ModelMap model) {
		checkLogin(session);
		CustomerFavMovieDAO cTempDAO = new CustomerFavMovieDAO();
		CustomerFavMovieDAO custPreorderMovieDAO = new CustomerFavMovieDAO();
		String sql = "DELETE FROM CUSTOMER_PREORDER_MOVIES WHERE consumerfmid=" + id;
		if (cTempDAO.inserData(sql)) {
			logger.info("---------------- PurchaseMovieController remove in list -------> {}.", id);
		}
		listCustomerPreMovies.clear();
		for (CustomerFavMovie cus : custPreorderMovieDAO.favouriteMovie(getCustID(), "view_customer_preorder_movies")) {
			// CustomerFavMovieBeans(int moviesID, int runtime, String title, float price,
			// float score)

			listCustomerPreMovies.add(new CustomerFavMovieBeans(cus.getConsumerfmID(), cus.getMoviesID(),
					cus.getRuntime(), cus.getTitle(), cus.getPrice(), cus.getScore()));

		}
		Collections.sort(listCustomerPreMovies, new SortByMovieID());

		model.addAttribute("listCustomerPreMovies", listCustomerPreMovies);
		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("apptitle", apptitleg + " | list");
		modelAndView.addObject("pagebody", "pages/buymovie.jsp");
		return new ModelAndView("redirect:/purchase/movie");

	}

	public void checkLogin(HttpSession session) {
		if (session.getAttribute("userlogin") == null) {
			session.setAttribute("userlogin", "logout");
		}
	}

	public int decCusiden(String cusiden) {
		String ids;
		int idcus = 0;
		try {
			ids = CipherHelper.decipher(secretKey, cusiden);
			idcus = Integer.valueOf(ids).intValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idcus;
	}

}
