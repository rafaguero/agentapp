package com.rtp.work.distribution.agentapp;

import com.rtp.work.distribution.agentapp.entity.Agent;
import com.rtp.work.distribution.agentapp.entity.AgentRepository;
import com.rtp.work.distribution.agentapp.entity.Task;
import com.rtp.work.distribution.agentapp.entity.TaskRepository;
import com.rtp.work.distribution.agentapp.exception.AgentNotAssignedException;
import com.rtp.work.distribution.agentapp.exception.TaskNotFoundException;
import com.rtp.work.distribution.agentapp.util.AgentFinder;
import com.rtp.work.distribution.agentapp.util.TaskAgentAttached;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AgentTaskController {

    private static final Logger log = LoggerFactory.getLogger(AgentTaskController.class);
    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskAgentAttached taskAgentAttached;

    @GetMapping("/agent-app/retrieve-agents")
    public List<Agent> retrieveAllUsers() {
        return agentRepository.findAll();
    }
    @PostMapping("/agent-app/create-task")
    public TaskAgentAttached createTask(@RequestBody Task task) {
        log.info(task.toString());
        Agent freeAgent = AgentFinder.findFreeAgent(agentRepository.findAll(), task,taskRepository.findAll());
        if (freeAgent == null){
            log.error("no available agents were found to create task. " + task.toString());
            throw new AgentNotAssignedException("no available agents were found to create task. " + task.toString());
        }
        task.setAgent(freeAgent);
        taskRepository.save(task);
        taskAgentAttached.setAgent(freeAgent);
        taskAgentAttached.setId(task.getId());
        taskAgentAttached.setAssignedDate(task.getAssignedDate());
        taskAgentAttached.setDescription(task.getDescription());
        taskAgentAttached.setPriority(task.getPriority());
        taskAgentAttached.setSkills(task.getSkills());
        taskAgentAttached.setStatus(task.getStatus());
        return taskAgentAttached;
    }

    @PutMapping("/agent-app/mark-task-complete/{id}")
    public Task updateTask(@PathVariable String id){
        //taskRepository.
        Optional<Task> task = taskRepository.findById(Integer.parseInt(id));
        Task tempTask = null;
        if (task.isPresent()){
            tempTask = task.get();
        } else {
            log.error("Unable to update the task. The task is not found in the database. The task id is " + id);
            throw new TaskNotFoundException("Unable to update the task. The task is not found in the database. The task id is " + id);
        }
        tempTask.setStatus("complete");
        Task savedTask = taskRepository.save(tempTask);
        return savedTask;
    }
}
