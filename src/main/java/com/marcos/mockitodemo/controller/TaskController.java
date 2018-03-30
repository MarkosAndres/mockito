package com.marcos.mockitodemo.controller;

import com.marcos.mockitodemo.entity.Task;
import com.marcos.mockitodemo.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/{id}")
	public Task findTask(@PathVariable long id) {
		return taskService.findTask(id);
	}

	@PostMapping
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}
}
