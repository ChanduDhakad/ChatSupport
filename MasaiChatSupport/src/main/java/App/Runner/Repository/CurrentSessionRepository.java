package App.Runner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import App.Runner.Model.CurrentSession;

public interface CurrentSessionRepository extends JpaRepository<CurrentSession, Integer> {
	
	public CurrentSession findByUuid(String uuid);

}
