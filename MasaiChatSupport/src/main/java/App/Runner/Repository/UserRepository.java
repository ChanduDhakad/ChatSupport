package App.Runner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import App.Runner.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
