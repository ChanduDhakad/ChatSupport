package App.Runner.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer blogId;
	@Enumerated(EnumType.STRING)
	private category cat;
	private String content;
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@OneToMany
	@JsonIgnore
	private List<Comment> list=new ArrayList<>();
	

}
