package App.Runner.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {

	 private LocalDateTime timestamps;
	  private String mgs;
	  private String details;
	
}
