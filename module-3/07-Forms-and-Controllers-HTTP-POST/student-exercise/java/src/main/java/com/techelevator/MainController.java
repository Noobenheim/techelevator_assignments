package com.techelevator;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class MainController {
	
	@Autowired
	private ReviewDao reviewDAO;

	@RequestMapping({"/", "/index", "home"})
	public String displayGreeting(ModelMap map) {
		map.put("reviews", reviewDAO.getAllReviews());
		map.put("currentURL", "homePage");
		return "homePage";
	}
	
	@RequestMapping(path="/writeReview", method=RequestMethod.POST)
	public String displayWriteReview(Review review, RedirectAttributes flashScope) {
		review.setDateSubmitted(LocalDateTime.now());
		reviewDAO.save(review);
		
		flashScope.addFlashAttribute("newReviewID", review.getId());
		
		return "redirect:/";
	}
	
	@RequestMapping(path="/writeReview", method=RequestMethod.GET)
	public String displayWriteReviewForm() {
		return "writeReview";
	}
}
