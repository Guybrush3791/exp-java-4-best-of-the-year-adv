package org.java.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.java.demo.pojo.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Movie> movies = getMovies(); // simulazione lettura dati db (mock-up dati)
		
		model.addAttribute("movies", movies);
		
		return "index";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(
			Model model,
			@PathVariable("id") int id
		) {
		
		Movie movie = getMovieById(id);
		if (movie != null) 
			model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	private Movie getMovieById(int id) {
		
		Movie resM = null;
		for (Movie m : getMovies()) 
			if (m.getId() == id)
				resM = m;
		
		return resM;
	}
	private List<Movie> getMovies() {
		
		return Arrays.asList(new Movie[] {
				
				new Movie(1, "my movie 2343"),
				new Movie(2, "my movie 273"),
				new Movie(3, "my movie 43"),
				new Movie(4, "my movie 111"),
				new Movie(5, "my movie 198")
		});
	}
	
}
