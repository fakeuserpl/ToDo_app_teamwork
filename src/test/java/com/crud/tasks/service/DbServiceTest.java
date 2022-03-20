package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@Transactional
@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {
    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTaks() {
        //Given
        Task task = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        Task task3 = new Task(3L, "title3", "content3");
        List<Task> allTasks = new ArrayList<>();
        allTasks.add(task);
        allTasks.add(task2);
        allTasks.add(task3);
        when(dbService.getAllTasks()).thenReturn(allTasks);
        //When
        List<Task> findTasks = dbService.getAllTasks();
        //Then
        assertEquals(3, findTasks.size());
    }

    @Test
    public void testGetTask() {
        //Given
        Task task = new Task(1L, "title1", "content1");
        when(dbService.getTask(1L)).thenReturn(Optional.ofNullable(task));
        //When
        Optional<Task> findTask = dbService.getTask(1L);
        //Then
        assertNotEquals(null, findTask);
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L, "title1", "content1");
        when(dbService.saveTask(task)).thenReturn(task);
        //When
        Task saveTask = dbService.saveTask(task);
        //Then
        assertEquals(1L, (long)saveTask.getId());
    }
}
