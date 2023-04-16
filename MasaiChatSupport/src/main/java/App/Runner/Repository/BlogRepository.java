package App.Runner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import App.Runner.Model.Blog;
import App.Runner.Model.category;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	public List<Blog> findByCat(category cat);

}
