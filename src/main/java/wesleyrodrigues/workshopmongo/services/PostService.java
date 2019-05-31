package wesleyrodrigues.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wesleyrodrigues.workshopmongo.domain.Post;
import wesleyrodrigues.workshopmongo.repository.PostRepository;
import wesleyrodrigues.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 100));
		return repo.fullSearch(text, minDate, maxDate);
	}
}
