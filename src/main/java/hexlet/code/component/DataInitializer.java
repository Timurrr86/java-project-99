package hexlet.code.component;

import hexlet.code.model.Label;
import hexlet.code.model.TaskStatus;
import hexlet.code.repository.LabelRepository;
import hexlet.code.repository.TaskStatusRepository;
import hexlet.code.model.User;
import hexlet.code.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
removed import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {
    private final CustomUserDetailsService userService;
    private final TaskStatusRepository taskStatusRepository;
    private final LabelRepository labelRepository;

    private final Map<String, String> taskStatuses = Map.of(
            "Draft", "draft",
            "ToReview", "to_review",
            "ToBeFixed", "to_be_fixed",
            "ToPublish", "to_publish",
            "Published", "published");

    private final List<String> labels = List.of("feature", "bug");

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var email = "hexlet@example.com";
        var userData = new User();
        userData.setEmail(email);
        userData.setPasswordDigest("qwerty");
        userService.createUser(userData);

        for (Map.Entry<String, String> taskStatus : taskStatuses.entrySet()) {
            var data = new TaskStatus();
            data.setName(taskStatus.getKey());
            data.setSlug(taskStatus.getValue());
            taskStatusRepository.save(data);
        }

        for (String labelName : labels) {
            var label = new Label();
            label.setName(labelName);
            labelRepository.save(label);
        }
    }
}
