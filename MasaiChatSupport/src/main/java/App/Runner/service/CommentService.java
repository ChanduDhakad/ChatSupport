package App.Runner.service;

import App.Runner.Exception.CommentException;
import App.Runner.Model.Comment;

public interface CommentService {
	
	public String CreateComment(Integer BlogId,Integer userId,Comment comment) throws CommentException;

}
