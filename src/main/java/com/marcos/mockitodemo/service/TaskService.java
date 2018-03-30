package com.marcos.mockitodemo.service;

import com.marcos.mockitodemo.entity.Task;
import com.marcos.mockitodemo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

	private TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task findTask(long id) {
		return taskRepository.findOne(id);
	}

	@Transactional
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
}
