package itc.hoseo.springproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {

	private Integer no;
	private Integer postNo;
	private String originName;
	private String encodeName;
	@Builder.Default
	private Boolean visible = Boolean.TRUE;

}
