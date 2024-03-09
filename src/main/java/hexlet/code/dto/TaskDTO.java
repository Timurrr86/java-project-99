package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {
    private Long id;

    private int index;
    private String title;
    private String content;
    private String status;
    private LocalDate createdAt;

    @JsonProperty("assignee_id")
    private Long assigneeId;
}
