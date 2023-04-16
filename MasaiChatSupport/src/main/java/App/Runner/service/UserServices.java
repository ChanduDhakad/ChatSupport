package App.Runner.service;

import java.util.List;

import App.Runner.Exception.BlogException;
import App.Runner.Exception.CommentException;
import App.Runner.Exception.UserExeption;
import App.Runner.Model.Blog;
import App.Runner.Model.User;

public interface UserServices  {
	

	public String CreateUser(User user)throws UserExeption; 
	
	public List<Blog> SeeAllBlog()throws BlogException;
	
	public String RemoveBlog(Integer BlogId,Integer userid)throws BlogException;
	
	public String RemoveComment(Integer commentid) throws CommentException;
	
}
