package com.marcos.mockitodemo.service;

import com.marcos.mockitodemo.boot.Application;
import com.marcos.mockitodemo.configuration.MvcConfiguration;
import com.marcos.mockitodemo.controller.TaskController;
import com.marcos.mockitodemo.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class, secure = false)
@ContextConfiguration(classes = MvcConfiguration.class)
public class TaskControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	@Test
	public void getTaskOk() throws Exception {
		Task task = new Task(1L, "some desc 1", true);
		Mockito.when(taskService.findTask(Mockito.anyLong())).thenReturn(task);

		mockMvc.perform(get("/task/234"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("some desc 1")));
	}
}
