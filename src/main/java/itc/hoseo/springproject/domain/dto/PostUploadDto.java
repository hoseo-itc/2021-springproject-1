package itc.hoseo.springproject.domain.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostUploadDto {
    private String title;
    private String text;
    private List<MultipartFile> files;
}
