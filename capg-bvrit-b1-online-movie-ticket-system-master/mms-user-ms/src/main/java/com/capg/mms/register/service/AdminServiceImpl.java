package com.capg.mms.register.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.register.model.Movie;
import com.capg.mms.register.model.Screen;
import com.capg.mms.register.model.Show;
import com.capg.mms.register.model.Theatre;


@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	RestTemplate rt;
	
//////////////////////////////////////////theatremethods//////////////////////////////////////////
	public Theatre addTheatre(Theatre theatre) {
		
		return rt.postForObject("http://theatre-ms/theatres/add", theatre, Theatre.class);
	}
	
	public Theatre updateTheatre(Theatre theatre) throws RestClientException, URISyntaxException {
		//Theatre t= rt.postForObject("http://theatre-ms/theatres/add", theatre, Theatre.class);
		if(theatre != null) {
			rt.put(new URI("http://theatre-ms/theatres/update"),theatre);
		}
		 return theatre;
	}

	@Override
	public List<Theatre>findAllTheatres() {
		Theatre[] theatreList=rt.getForObject("http://theatre-ms/theatres/all", Theatre[].class);
	return (List<Theatre>) Arrays.asList(theatreList);
	}

	@Override
	public void deleteTheatreById(int theatreId) {
	
		rt.delete("http://theatre-ms/theatres/delete/id/"+theatreId, theatreId);
	}

	

	
	
//	//////////////////////////////////show methods//////////////////////////////////////////////////////
//	
	public Show addShow(Show show) {
		
		return rt.postForObject("http://theatre-ms/show/add", show, Show.class);
	}
	
	@Override
	public void deleteShowById(int showId) {
		
		 rt.delete("http://theatre-ms/theatres/show/delete/id/"+showId,showId);
	}
	
	@Override
	public Show updateShowById(Show show) {
		Show shows=rt.postForObject("http://theatre-ms/show/add", show, Show.class);
		rt.put("http://theatre-ms/theatres/show/update", shows,shows);
		return shows;
	}

	@Override
	public List<Show> findAllShows() {
		List<Show> showList=(List<Show>) rt.getForObject("http://theatre-ms/show/all", Show.class);
		return showList;
	}
//	
//	///////////////////////////////////////////Screen methods/////////////////////////////////////////////////////
	
	public Screen addScreen(Screen screen) {
		
		return rt.postForObject("http://theatre-ms/screen/add", screen, Screen.class);
	}
	@Override
	public void deleteScreenById(int screenId) {
		
		 rt.delete("http://theatre-ms/screen/delete/id/"+screenId, screenId);
	}

	@Override
	public Screen updateScreenById(Screen screen) {
	Screen s=rt.postForObject("http://theatre-ms/screen/add", screen, Screen.class);
	rt.put("http://theatre-ms/theatres/screen/update",s,s);
		return s;
	}

	@Override
	public List<Screen> findAllScreens() {
		
		Screen screenList= rt.getForObject("http://theatre-ms/screen/all", Screen.class);
		return (List<Screen>) screenList;
	}
	
//	////////////////////////////////////////////Movie methods///////////////////////////////////////////////////////////
//	
//	
	@Override
	public Movie addMovie(Movie movie) {
		
		return rt.postForObject("http://movie-ms/movie/add", movie, Movie.class);
	}
	@Override
	public void deleteMovieById(int movieId) {
		
		rt.delete("http://movie-ms/movie/delete/id/"+movieId,movieId);
		
	}
	@Override
	public Movie updateMovie(Movie movie) {
		Movie m=rt.postForObject("http://movie-ms/movie/add", movie, Movie.class);
		rt.put("http://movie-ms/movies/update", m,m);
		return m;
	}
	@Override
	public Movie getMovieById(int movieId) {
		Movie movie=rt.getForObject("http://movie-ms/movie/get/id/"+movieId, Movie.class);
		
		return movie;
	}

	



	


}
