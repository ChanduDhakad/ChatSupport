package App.Runner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Runner.Exception.BlogException;
import App.Runner.Exception.CommentException;
import App.Runner.Exception.UserExeption;
import App.Runner.Model.Blog;
import App.Runner.Model.Comment;
import App.Runner.Model.User;
import App.Runner.Repository.BlogRepository;
import App.Runner.Repository.CommentRepository;
import App.Runner.Repository.UserRepository;
@Service
public class UserService implements UserServices{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BlogRepository blogRepo;
	@Autowired
	CommentRepository comRepo;
	
	@Override
	public String CreateUser(User user) throws UserExeption {

		User existing=userRepo.findByEmail(user.getEmail());
		if(existing==null) {
			userRepo.save(existing);
			return "User Sucesfully Registered";
		}else
			throw new UserExeption("User is Allready Exist with this email");
		
	}

	@Override
	public List<Blog> SeeAllBlog() throws BlogException {
		
		List<Blog> list=blogRepo.findAll();
		if(list.size()==0)
			throw new BlogException("No Blog found");
		return list;
	}

	@Override
	public String RemoveBlog(Integer BlogId,Integer userid) throws BlogException {
		Optional<Blog> opt=blogRepo.findById(BlogId);
		if(opt.isPresent()) {
			Blog blog=opt.get();
			User existing=blog.getUser();
			int id=existing.getUserId();
			if(id==userid)
			{
				blogRepo.delete(blog);
				return "blog sucessfully removed";
			}else {
				throw new BlogException("Blog is not registered with the user id");
			}
		}else {
			throw new BlogException("No blog fount with the blog id"+BlogId);
		}
		
	}

	@Override
	public String RemoveComment(Integer commentid) throws CommentException {
		Optional<Comment> opt=comRepo.findById(commentid);
		if(opt.isPresent()) {
			Comment com=opt.get();
			comRepo.delete(com);
			return "Comment is successfully deleted";
		}else
		throw new CommentException("No Comment found");
	}

}
