package mapping.crud.dtos;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;
import mapping.crud.enums.SchoolEnum;

@Getter
@Setter
public class schoolSaveUpdateDto {
	
	private long id;	
	private String name;
	private SchoolEnum typEnum;
	private LocalDateTime CreatedDate;
	private LocalDateTime UpdatedDate;
	private String state;	
	private String city;
	private String address;

}
