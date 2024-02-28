package hexlet.code.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusCreateDTO {
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String slug;
}
