package com.moviestore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		ModelAndView errorPage = new ModelAndView("templeterror");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 402: {
			errorMsg = "Http Error Code: 402.  Payment Required";
			break;

		}
		case 403: {
			errorMsg = "Http Error Code: 403.  Forbidden";
			break;

		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 405: {
			errorMsg = "Http Error Code: 405. Method Not Allowed";
			break;
		}
		case 406: {
			errorMsg = "Http Error Code: 406.  Not Acceptable";
			break;
		}
		case 407: {
			errorMsg = "Http Error Code: 407. Proxy Authentication Required";
			break;
		}
		case 408: {
			errorMsg = "Http Error Code: 408. Request Timeout";
			break;
		}
		case 409: {
			errorMsg = "Http Error Code: 409. Conflict";
			break;
		}
		case 410: {
			errorMsg = "Http Error Code: 410. Gone";
			break;
		}
		case 411: {
			errorMsg = "Http Error Code: 411. Length Required";
			break;
		}
		case 412: {
			errorMsg = "Http Error Code: 412. Precondition Failed";
			break;
		}
		case 413: {
			errorMsg = "Http Error Code: 413. Payload Too Large";
			break;
		}
		case 414: {
			errorMsg = "Http Error Code: 414. URI Too Long";
			break;
		}
		case 415: {
			errorMsg = "Http Error Code: 415. Unsupported Media Type";
			break;
		}
		case 416: {
			errorMsg = "Http Error Code: 416. Range Not Satisfiable";
			break;
		}
		case 417: {
			errorMsg = "Http Error Code: 417. Expectation Failed";
			break;
		}
		case 418: {
			errorMsg = "Http Error Code: 418. I'm a teapot";
			break;
		}
		case 421: {
			errorMsg = "Http Error Code: 421. Misdirected Request";
			break;
		}
		case 422: {
			errorMsg = "Http Error Code: 422. Unprocessable Entity";
			break;
		}
		case 423: {
			errorMsg = "Http Error Code: 423.  Locked";
			break;
		}
		case 424: {
			errorMsg = "Http Error Code: 424. Failed Dependency";
			break;
		}
		case 426: {
			errorMsg = "Http Error Code: 426.  Upgrade Required";
			break;
		}
		case 428: {
			errorMsg = "Http Error Code: 428. Precondition Required";
			break;
		}
		case 429: {
			errorMsg = "Http Error Code: 429. Too Many Requests";
			break;
		}
		case 431: {
			errorMsg = "Http Error Code: 431. Request Header Fields Too Large";
			break;
		}
		case 451: {
			errorMsg = "Http Error Code: 451. Request Header Fields Too Large";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		case 501: {
			errorMsg = "Http Error Code: 501.  Not Implemented";
			break;
		}
		case 502: {
			errorMsg = "Http Error Code: 502. Bad Gateway";
			break;
		}
		case 503: {
			errorMsg = "Http Error Code: 503. Service Unavailable";
			break;
		}
		case 504: {
			errorMsg = "Http Error Code: 504. Gateway Timeout";
			break;
		}
		case 505: {
			errorMsg = "Http Error Code: 505. HTTP Version Not Supported";
			break;
		}
		case 506: {
			errorMsg = "Http Error Code: 506. Variant Also Negotiates";
			break;
		}
		case 507: {
			errorMsg = "Http Error Code: 507. Insufficient Storage";
			break;
		}
		case 508: {
			errorMsg = "Http Error Code: 508. Loop Detected";
			break;
		}
		case 510: {
			errorMsg = "Http Error Code: 510. Not Extended";
			break;
		}
		case 511: {
			errorMsg = "Http Error Code: 511. Network Authentication Required";
			break;
		}
		 default: {
			 errorMsg = "Http Error Code: " + httpErrorCode +". ";
         break;
		 }
		}
		errorPage.addObject("pagebody", "errorPage.jsp");
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}
