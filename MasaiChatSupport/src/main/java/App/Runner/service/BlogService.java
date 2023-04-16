package App.Runner.service;

import java.util.List;

import App.Runner.Exception.BlogException;
import App.Runner.Model.Blog;
import App.Runner.Model.category;

public interface BlogService {
	
	public String createBlog(Blog blog);
	
	public List<Blog> blogbyCategory(category cat) throws BlogException;
	

}
