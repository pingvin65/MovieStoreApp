package com.moviestore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.moviestore.beans.GenresBean;
import com.moviestore.beans.MediaBean;
import com.moviestore.beans.MoviesBean;
import com.moviestore.beans.PersonRolesInMoviesBean;
import com.moviestore.beans.UserBean;
import com.moviestore.dao.CustomerDAO;
import com.moviestore.dao.GenresDAO;
import com.moviestore.dao.MediaDAO;
import com.moviestore.dao.MoviesDAO;
import com.moviestore.dao.PersonRolesInMoviesDAO;
import com.moviestore.dao.ViewCustomerDAO;
import com.moviestore.model.Genres;
import com.moviestore.model.Media;
import com.moviestore.model.Movies;
import com.moviestore.model.PersonRolesInMovies;
import com.moviestore.model.ViewCustomer;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
@SessionAttributes({ "userkey", "moviekey", "moviekeys", "personRolesInMovieskey", "genreskey", "picture", "pictures" })
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String apptitleg = "MS";

	public void checkLogin(HttpSession session) {
		if (session.getAttribute("userlogin") == null) {
			session.setAttribute("userlogin", "logout");
		}
	}

	/*
	 * Add user in model attribute
	 */

	/**
	 * 
	 * @return UserBean
	 */
	@ModelAttribute("userkey")
	public UserBean setUpUserForm() {
		return new UserBean();
	}

	/**
	 * 
	 * @return List MoviesBean
	 */
	@ModelAttribute("moviekey")
	public List<MoviesBean> setUpUserForm1() {
		return new ArrayList<MoviesBean>();
	}

	/**
	 * 
	 * @return PersonRolesInMoviesBean
	 */
	@ModelAttribute("personRolesInMovieskey")
	public PersonRolesInMoviesBean setUpUserForm2() {
		return new PersonRolesInMoviesBean();
	}

	/**
	 * 
	 * @return List GenresBean
	 */
	@ModelAttribute("genreskey")
	public List<GenresBean> setUpUserForm3() {
		return new ArrayList<GenresBean>();
	}

	/**
	 * 
	 * @return List MoviesBean
	 */
	@ModelAttribute("moviekeys")
	public List<MoviesBean> setUpUserForm4() {
		return new ArrayList<MoviesBean>();
	}

	/**
	 * 
	 * @return MediaBean
	 */
	@ModelAttribute("picture")
	public MediaBean setUpUserForm5() {
		return new MediaBean();
	}

	/**
	 * 
	 * @return List MediaBean
	 */
	@ModelAttribute("pictures")
	public List<MediaBean> setUpUserForm6() {
		return new ArrayList<MediaBean>();
	}

	/**
	 * 
	 * @param  locale of Locale
	 * @param  model of Model
	 * @param  session of HttpSession
	 * @param  request of HttpServletRequest
	 * @param  moviesBeanplu of List MoviesBean
	 * @return model and view from ModelAndView
	 */
	@RequestMapping(value = { "/", "/moviesByDate", "/moviesByScore" }, method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("genreskey") List<MoviesBean> moviesBeanplu) {
		if (!moviesBeanplu.isEmpty()) {
			moviesBeanplu.clear();
		}
		logger.info("Welcome home! The client locale is {}.", locale);
		//logger.info("request.getContextPath() is{}", request.getServletPath());
		session = request.getSession();

		ModelAndView modelAndView = new ModelAndView("templet");

		MoviesDAO noviesDAO = new MoviesDAO();
		String requestPath = request.getServletPath();
		String sqlQuery = "SELECT moviesid, title, description, runtime,  TO_CHAR(release_date, 'FMMon DD, YYYY')as release_date, score, price FROM view_homepage";
		if (requestPath.equals("/")) {
			modelAndView.addObject("apptitle", apptitleg + " | home");
			String successlogin = (String) request.getSession().getAttribute("successlogin");
			//logger.info("------------------>home sesion name is    {}", successlogin);
			if (session.getAttribute("successlogin") != null) {
				modelAndView.addObject("masagebody", successlogin);
				session.removeAttribute("successlogin");
			} else {
				session.removeAttribute("successlogin");
			}
		} else if (requestPath.equals("/moviesByDate")) {
			modelAndView.addObject("apptitle", apptitleg + " | movies by date");
			sqlQuery = "SELECT moviesid, title, description, runtime,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date, release_date as date2, score, price FROM view_homepage ORDER BY date2 DESC";
		} else if (requestPath.equals("/moviesByScore")) {
			modelAndView.addObject("apptitle", apptitleg + " | movies by score");
			sqlQuery = "SELECT moviesid, title, description, runtime,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date, score, price FROM view_homepage ORDER BY score DESC";
		}

		List<Movies> moviesplu = noviesDAO.getMoviesList(sqlQuery);

		if (session.getAttribute("userlogin") == null) {
			session.setAttribute("userlogin", "logout");
		}
		// session.removeAttribute("userlogin");
		//logger.info("home user is or no login {}.", session.getAttribute("userlogin"));

		MediaDAO mediaDAO = new MediaDAO();
		//logger.info("home -------> {}.", mediaDAO.toString().length());
		if (!moviesplu.isEmpty()) {

			String mediapath;
			for (Movies m : moviesplu) {

				List<Media> mediaplu = mediaDAO.getMediaByMoviesID(m.getMoviesID());

				if (!mediaplu.isEmpty()) {
					mediapath = request.getContextPath() + "/" + mediaplu.get(0).getMediaPath();

				} else {
					mediapath = request.getContextPath() + "/images/noimage.svg";

				}
				//logger.info("--------r------> mediapath {}.", mediapath);
				MoviesBean moviesBean = new MoviesBean();
				moviesBean.setMoviesID(m.getMoviesID());
				moviesBean.setTitle(m.getTitle());
				moviesBean.setDescription(m.getDescription());
				moviesBean.setReleaseDate((m.getReleaseDate()));
				moviesBean.setScore(m.getScore());
				moviesBean.setPrice(m.getPrice());
				moviesBean.setMediaPath(mediapath);
				moviesBeanplu.add(moviesBean);

			}
			modelAndView.addObject("moviekeys", moviesBeanplu);
		} else {
			modelAndView.addObject("errorDB", "Up, Samting is rong");
			//logger.info("home -------> {}.", session.getAttribute("errorDB"));
		}

		modelAndView.addObject("pagebody", "home.jsp");
		return modelAndView;
	}

	/**
	 * 
	 * @param model of Model
	 * @param locale of Local
	 * @param session of HttpSession
	 * @param request of HttpServletRequest
	 * @return model and view from ModelAndView
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(Model model, Locale locale, HttpSession session, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("templetlogin");
		modelAndView.addObject("apptitle", apptitleg + " | login");
		modelAndView.addObject("pagebody", "pages/login.jsp");
		modelAndView.addObject("errorMessage", session.getAttribute("errorMessage"));

		session.removeAttribute("errorMessage");
		// modelAndView.addObject("errorMessage", errorMessage);
		Date date = new Date();
		// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		// DateFormat.LONG, locale);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy");
		String formattedDate = dateFormatter.format(date);
		model.addAttribute("serverTime", formattedDate);

		// session.setAttribute("userlogin", "logout2");
		return modelAndView;
	}

	/**
	 * 
	 * @param model of ModelMap
	 * @return model and view from ModelAndView
	 */ 
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage(ModelMap model) {
		UserBean userkey = new UserBean();

		ModelAndView modelAndView = new ModelAndView("templetlogin");
		modelAndView.addObject("apptitle", apptitleg + " | Register");
		modelAndView.addObject("userkey", userkey);
		modelAndView.addObject("pagebody", "pages/register.jsp");

		Date date = new Date();

		DateFormat dateFormatter = new SimpleDateFormat("yyyy");
		String formattedDate = dateFormatter.format(date);
		modelAndView.addObject("serverTime", formattedDate);

		return modelAndView;
	}

	/**
	 * 
	 * @param userkey of UserBean, Valid and ModelAttribute
	 * @param result of BindingResult
	 * @param request of HttpServletRequest
	 * @param attributes of RedirectAttributes
	 * @param session of HttpSession
	 * @return model and view from ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistration(@Valid @ModelAttribute("userkey") UserBean userkey, BindingResult result,
			HttpServletRequest request, RedirectAttributes attributes, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("templetlogin");
		modelAndView.addObject("apptitle", apptitleg + " | register");
		modelAndView.addObject("pagebody", "pages/register.jsp");
		session.removeAttribute("password2error");
		session.removeAttribute("userregistrited");
		session.removeAttribute("createCustumer");
		session.removeAttribute("userregistrited");

		// userkey.setEmail("eer.er");
		if (result.hasErrors()) {

			if (!userkey.getPassword2().equals(userkey.getPassword())) {
				modelAndView.addObject("password2error", "The password is not the same as the one above");

			} else if (!userkey.getPassword2().equals(userkey.getPassword())) {
				modelAndView.addObject("password2error", "The password is not the same as the one above");
			}

			return modelAndView;

		}

		CustomerDAO cost = new CustomerDAO();
		String costEmail = cost.getCustomerByEmail(userkey.getEmail());

		if (costEmail == null) {
			String sql = "INSERT INTO CUSTOMER (PASSWORD, FRST_NAME, LAST_NAME, EMAIL) VALUES ('"
					+ userkey.getPassword() + "', '" + userkey.getFrstName() + "', '" + userkey.getLastName() + "', '"
					+ userkey.getEmail() + "')";

			if (cost.inserData(sql)) {
				attributes.addFlashAttribute("createCustumer",
						"Mrs./Mr. " + userkey.getLastName() + " thanks for your registration");
				// modelAndView.addObject("createCustumer", "Mrs./Mr. " + userkey.getLastName()
				// +" thanks for your registration");
			} else {
				attributes.addFlashAttribute("createCustumererror", "Sorry, something went wrong. Registration failed");
				// modelAndView.addObject("createCustumererror", "Sorry, something went wrong.
				// Registration failed");
			}

		} else {

			modelAndView.addObject("userregistrited", "The user with this email address is already registered");
			return modelAndView;
		}

		return new ModelAndView("redirect:/infouser");

	}

	/**
	 * 
	 * @return model and View of class ModelAndView
	 */
	@RequestMapping(value = "/infouser", method = RequestMethod.GET)
	public ModelAndView infoUser() {
		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("apptitle", apptitleg + " | User page");
		modelAndView.addObject("pagebody", "pages/userinfo.jsp");
		Date date = new Date();

		DateFormat dateFormatter = new SimpleDateFormat("yyyy");
		String formattedDate = dateFormatter.format(date);

		modelAndView.addObject("serverTime", formattedDate);
		return modelAndView;
	}

	/**
	 * 
	 * @param password as String
	 * @param email as String
	 * @return model and View of class ModelAndView
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	public ModelAndView user_info(@RequestParam("password") String password, @RequestParam("email") String email) {
		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("password", password);
		modelAndView.addObject("email", email);

		modelAndView.addObject("pagebody", "pages/userpage.jsp");
		Date date = new Date();

		DateFormat dateFormatter = new SimpleDateFormat("yyyy");
		String formattedDate = dateFormatter.format(date);

		modelAndView.addObject("serverTime", formattedDate);
		return modelAndView;

	}

	/**
	 * 
	 * @param password as String 
	 * @param email as String
	 * @param model from Model 
	 * @param session from HttpSession
	 * @param request from  HttpServletRequest
	 * @return redirect from RedirectView Class
	 */
	@RequestMapping(value = "/login_confirm", method = RequestMethod.POST)
	public RedirectView login_confirm(@RequestParam("password") String password, @RequestParam("email") String email,
			Model model, HttpSession session, HttpServletRequest request) {
		ViewCustomerDAO viewCustomerDAO = new ViewCustomerDAO();

		ViewCustomer viewCustomer = viewCustomerDAO.getStudentByEmail(email.toString());

		if (viewCustomer != null && viewCustomer.getPassword().equals(password)
				&& viewCustomer.getEmail().equals(email)) {
			// modelAndView.addObject("password", password);
			// modelAndView.addObject("email", email);
			// modelAndView.addObject("userlogin", "login");
			session.setAttribute("successlogin", "You are success login");
			session.setAttribute("userlogin", "login");
		} else {

			// modelAndViewRedirect.addObject("errorMessage", "Email or password is wrong");
			session.setAttribute("errorMessage", "Email or password is wrong");
			// model.addAttribute("errorMessage", "Email or password is wrong");
			return new RedirectView(request.getContextPath() + "/login");
		}

		return new RedirectView(request.getContextPath() + "/");

	}

	/**
	 * 
	 * @param attributes from RedirectAttributes class
	 * @param request from HttpServletRequest
	 * @param session from HttpSession
	 * @return redirect from RedirectView Class
	 */
	@GetMapping(value = "/logout")
	public RedirectView logout(RedirectAttributes attributes, HttpServletRequest request, HttpSession session) {
		session.removeAttribute("userlogin");
		session.setAttribute("userlogin", "logout");
		// attributes.addAttribute("userlogin", "logout");

		return new RedirectView(request.getContextPath() + "/login");
	}

	/**
	 * 
	 * @param moviesBean from MoviesBean class
	 * @param personRolesInMoviesBean from PersonRolesInMoviesBean 
	 * @param id from @PathVariable int
	 * @param request from HttpServletRequest
	 * @param session from  HttpSession
	 * @param genresBeanplu from List GenresBean
	 * @param mediaBean from MediaBean
	 * @param mediaBeans from List MediaBean
	 * @return model and view from ModelAndView class
	 */
	@RequestMapping(value = "/article/movie/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getMovieByID(@ModelAttribute("movieskey") MoviesBean moviesBean,
			@ModelAttribute("personRolesInMovieskey") PersonRolesInMoviesBean personRolesInMoviesBean,
			@ModelAttribute("genreskey") List<GenresBean> genresBeanplu, @ModelAttribute("picture") MediaBean mediaBean,
			@ModelAttribute("pictures") List<MediaBean> mediaBeans, @PathVariable int id, HttpServletRequest request,
			HttpSession session) {

		if (!mediaBeans.isEmpty()) {
			mediaBeans.clear();
		}
		ModelAndView modelAndView = new ModelAndView("templet");
		modelAndView.addObject("pagebody", "pages/movie.jsp");
		MoviesDAO moviesDAO = new MoviesDAO();
		Movies movies = moviesDAO.getMoviesByID(id);
		PersonRolesInMoviesDAO personRolesInMoviesDAO = new PersonRolesInMoviesDAO();
		List<PersonRolesInMovies> personRolesInMovies = personRolesInMoviesDAO.getPersonRolesInMoviesByMovieID(id);
		checkLogin(session);
		if (movies != null) {
			modelAndView.addObject("apptitle", apptitleg + " | " + movies.getTitle());
			moviesBean = new MoviesBean(movies.getTitle().toString(), movies.getDescription().toString(),
					movies.getReleaseDate(), movies.getScore(), movies.getPrice());
			modelAndView.addObject("movieskey", moviesBean);
			if (!personRolesInMovies.isEmpty()) {
				List<PersonRolesInMoviesBean> personRolesInMoviesBeans = new ArrayList<PersonRolesInMoviesBean>();
				for (PersonRolesInMovies p : personRolesInMovies) {

					personRolesInMoviesBeans.add(new PersonRolesInMoviesBean(p.getPersonFname(), p.getPersonLname(),
							p.getOrderinmovies(), p.getRoulesID(), p.getMovieID()));
				}
				modelAndView.addObject("personRolesInMovieskey", personRolesInMoviesBeans);

			}

			MediaDAO mediaDAO = new MediaDAO();
			List<Media> medias = mediaDAO.getMediaByMoviesID(id);

			if (!medias.isEmpty()) {
				if (medias.size() > 1) {
					for (Media m : medias) {
						mediaBeans.add(new MediaBean(m.getMoviesID(),
								request.getContextPath() + "/" + m.getMediaPath().toString()));
						//logger.info("getMovieByID  if  {}.", m.getMediaPath());
					}
					modelAndView.addObject("pictures", mediaBeans);

				} else {
					mediaBean.setMediaPath(request.getContextPath() + "/" + medias.get(0).getMediaPath());
				}

			} else {

				mediaBean.setMediaPath(request.getContextPath() + "/images/noimage.svg");
				modelAndView.addObject("picture", mediaBean);
			}
			GenresDAO genresDAO = new GenresDAO();
			List<Genres> genresplu = genresDAO.getGenres(id);
			if (!genresplu.isEmpty()) {
				genresBeanplu = new ArrayList<GenresBean>();
				for (Genres g : genresplu) {
					genresBeanplu.add(new GenresBean(g.getGenres()));
				}
				modelAndView.addObject("genreskey", genresBeanplu);
			} else {
				modelAndView.addObject("genreskey", "");
			}

		} else {

			return new ModelAndView("redirect:/");
		}
		return modelAndView;
	}

}
