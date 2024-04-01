package hexlet.code.service;

import hexlet.code.dto.TaskStatusCreateDTO;
import hexlet.code.dto.TaskStatusDTO;
import hexlet.code.dto.TaskStatusUpdateDTO;
import hexlet.code.mapper.TaskStatusMapper;
import hexlet.code.repository.TaskStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;
    private final TaskStatusMapper taskStatusMapper;

    public List<TaskStatusDTO> getAllTaskStatus() {
        var taskStatuses = taskStatusRepository.findAll();
        return taskStatuses.stream()
                .map(taskStatusMapper::map)
                .toList();
    }

    public TaskStatusDTO create(TaskStatusCreateDTO taskStatusData) {
        var taskStatus = taskStatusMapper.map(taskStatusData);
        taskStatusRepository.save(taskStatus);
        return taskStatusMapper.map(taskStatus);
    }

    public TaskStatusDTO getTaskStatusById(Long id) {
        var taskStatus = taskStatusRepository.findById(id)
                .orElseThrow();
        return taskStatusMapper.map(taskStatus);
    }

    public TaskStatusDTO updateTaskStatus(Long id, TaskStatusUpdateDTO taskStatusData) {
        var taskStatus = taskStatusRepository.findById(id)
                .orElseThrow();

        taskStatusMapper.update(taskStatusData, taskStatus);
        taskStatusRepository.save(taskStatus);
        return taskStatusMapper.map(taskStatus);
    }

    public void deleteTaskStatus(Long id) {
        taskStatusRepository.findById(id)
                .orElseThrow();
        taskStatusRepository.deleteById(id);
    }
}
