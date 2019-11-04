package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/filmSearch")
    public String showFilmSearchForm(ModelMap modelHolder) {
    	List<String> genres = filmDao.getGenres();
    	
    	modelHolder.put("genres", genres);
    	
        return "filmList";
    }

    @RequestMapping("/filmResult")
    public String searchFilms(@RequestParam int minLength, @RequestParam int maxLength, @RequestParam String genre, ModelMap modelHolder) {
    	List<Film> films = filmDao.getFilmsBetween(genre, minLength, maxLength);
    	List<String> genres = filmDao.getGenres();
    	
    	modelHolder.put("genres", genres);
    	modelHolder.put("films", films);
    	
        return "filmList";
    }

}