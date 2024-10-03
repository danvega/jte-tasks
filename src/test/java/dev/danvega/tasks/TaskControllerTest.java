package dev.danvega.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Import(TaskRepository.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("tasks"));
    }

    @Test
    public void testAddTask() throws Exception {
        String newTaskDescription = "New Test Task";
        MvcResult result = mockMvc.perform(post("/add-task")
                        .param("description", newTaskDescription))
                .andExpect(status().isOk())
                .andExpect(view().name("task-row"))
                .andReturn();

        Task addedTask = (Task) result.getModelAndView().getModel().get("task");
        assertNotNull(addedTask);
        assertEquals(newTaskDescription, addedTask.getDescription());
    }

    @Test
    public void testDeleteTask() throws Exception {
        // First, add a task
        MvcResult addResult = mockMvc.perform(post("/add-task")
                        .param("description", "Task to be deleted"))
                .andExpect(status().isOk())
                .andReturn();

        Task addedTask = (Task) addResult.getModelAndView().getModel().get("task");

        // Now, delete the task
        mockMvc.perform(delete("/delete-task/" + addedTask.getId()))
                .andExpect(status().isOk());

        // Try to delete the same task again, should fail
        mockMvc.perform(delete("/delete-task/" + addedTask.getId()))
                .andExpect(status().isOk());
    }
}
