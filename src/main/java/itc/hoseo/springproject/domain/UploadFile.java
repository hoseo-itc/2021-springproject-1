package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Files {

	private Integer no;
	private Integer postNo;
	private String originName;
	private String encodeName;
	private Boolean visible = Boolean.TRUE;

}
