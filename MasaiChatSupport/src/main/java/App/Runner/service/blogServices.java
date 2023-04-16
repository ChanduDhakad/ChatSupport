package App.Runner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Runner.Exception.BlogException;
import App.Runner.Model.Blog;
import App.Runner.Model.category;
import App.Runner.Repository.BlogRepository;

@Service
public class blogServices implements BlogService {
	@Autowired
	BlogRepository blogRepo;

	@Override
	public String createBlog(Blog blog) {
		
		blogRepo.save(blog);
		
		return "Blog Sucessfully Created";
	}

	@Override
	public List<Blog> blogbyCategory(category cat) throws BlogException {
		
		List<Blog> list=blogRepo.findByCat(cat);
		if(list.size()==0)
			throw new BlogException("No Blog found with this category"+cat);
		else
		return list;
	}
	
	

}
