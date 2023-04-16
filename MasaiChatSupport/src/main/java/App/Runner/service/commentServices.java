package App.Runner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Runner.Exception.CommentException;
import App.Runner.Model.Blog;
import App.Runner.Model.Comment;
import App.Runner.Repository.BlogRepository;
import App.Runner.Repository.CommentRepository;
import App.Runner.Repository.UserRepository;

@Service
public class commentServices implements CommentService{
	@Autowired
	BlogRepository blogRepo;
	
	@Autowired
	CommentRepository comRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public String CreateComment(Integer BlogId,Integer userid,Comment comment) throws CommentException {
		
		Optional<Blog> opt=blogRepo.findById(BlogId);
		if(opt.isPresent()) {
			Blog blog=opt.get();
			if(blog.getUser().getUserId()==userid) {
				comRepo.save(comment);
				return "Commented on Blog";
			}else {
				throw new CommentException("User is not Authorised to comment on his own Blog");
			}
		}else {
			throw new CommentException("Blog Not Found");
		}

	}

}
