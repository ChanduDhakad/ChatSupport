package App.Runner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import App.Runner.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
