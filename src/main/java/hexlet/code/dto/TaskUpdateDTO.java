package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter

public class TaskUpdateDTO {
    @NotNull
    @JsonProperty("title")
    private JsonNullable<String> name;
    private JsonNullable<Integer> index;
    @JsonProperty("content")
    private JsonNullable<String> description;
    private JsonNullable<String> status;
    @JsonProperty("assignee_id")
    private JsonNullable<Long> assigneeId;
}
