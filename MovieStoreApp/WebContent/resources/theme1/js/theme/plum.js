/**
 * 
 */

$(document).ready(function() {
	$(document).on('submit', '#loginform', function() {
		// do your things
		console.log("25");
		return false;
	});

	var link = $(location).attr('pathname');
	var spans = $("span");
	$("div.navbar").find("a").css("color", "red");
	$("div.navbar").find(".nav-link").css("background-color", "red");
	// $( ".nav-link" ).css( "background-color", "red" );
	var s = "your_string";
	var withoutLastChunk = link.slice(0, s.lastIndexOf("/"));
	console.log($(location).attr('pathname'));
	console.log("llllllllllllll" + withoutLastChunk);
	$("a.nav-link").each(function(index) {

		console.log(index + ": " + $(this).text());
	});

	$(".card-text").each(function() {
		var text = $(this).text();
		console.log("llllllllllllll" + $(this).text());
		$(this).text(text.replace(' ,', ',f'));
	});
});
