package App.Runner.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import App.Runner.Exception.BlogException;
import App.Runner.Exception.CommentException;
import App.Runner.Exception.UserExeption;
import App.Runner.Model.Blog;
import App.Runner.Model.User;
import App.Runner.service.UserServices;
import net.bytebuddy.asm.Advice.Return;

@RestController
public class userController {
	
	@Autowired
	UserServices userService;
	
	@PostMapping("/User")
	public ResponseEntity<String> createAdmin(@Valid @RequestBody User user) throws UserExeption{
	
		
		String saveuser=userService.CreateUser(user);
		
		
		return new ResponseEntity<String>(saveuser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Blog>> seeAllBlog() throws BlogException{
		
		List<Blog> blogs=userService.SeeAllBlog();
		
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
	@DeleteMapping("/USer/{blogid}/{userid}")
	public ResponseEntity<String> RemoveBlog(@PathVariable ("blogid") Integer blog_id,@PathVariable ("userid") Integer user_id) throws BlogException{
		
		String ans=userService.RemoveBlog(blog_id, user_id);
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/user/{comment_id}")
	public ResponseEntity<String> RemoveComent(@PathVariable ("comment_id") Integer comId) throws CommentException{
		
		String ans=userService.RemoveComment(comId);
		
		return new ResponseEntity<String>(ans,HttpStatus.OK);
		
	}
	
	

}
