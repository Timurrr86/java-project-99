package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class TaskDTO {
    private Long id;

    private JsonNullable<Integer> index;
    @JsonProperty("title")
    private JsonNullable<String> name;
    @JsonProperty("content")
    private JsonNullable<String> description;

    private JsonNullable<String> status;
    private LocalDate createdAt;

    @JsonProperty("assignee_id")
    private JsonNullable<Long> assigneeId;
    private JsonNullable<Set<Long>> taskLabelIds;
}
