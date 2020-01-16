package com.rtp.work.distribution.agentapp.util;


import com.rtp.work.distribution.agentapp.entity.Agent;
import com.rtp.work.distribution.agentapp.entity.Task;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class AgentFinder {


    public static Agent findFreeAgent(List<Agent>agents, Task task, List<Task>tasks){
        boolean agentMatched=false;
        for (Agent agent : agents){
            if (agent.getTasks().isEmpty() || checkTaskComplete(agent.getTasks()) ){
                agentMatched = matchSkills(agent,task);
                if (agentMatched) {
                    return agent;
                }
            }
        }

        Agent tempAgent = checkPriorities(agents,tasks);
        return tempAgent;
    }
    public static boolean matchSkills(Agent agent, Task task){
        String[] taskSkills = task.getSkills().split(",");
        String[] agentSkills = agent.getSkills().split(",");
        int numOfSkills = taskSkills.length;
        for (int i = 0; i < numOfSkills; i++){
            if (!agent.getSkills().contains(taskSkills[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean checkTaskComplete(List<Task> tasks){
        for (Task task : tasks){
            if (!task.getStatus().equals("complete")){
                return false;
            }
        }
        return true;
    }
    public static Agent checkPriorities(List<Agent>agents,List<Task>tasks){
        boolean allTasksLowPriority = true;
        Instant instant;
        LocalDateTime localDateTime;
        LocalDate taskAssignedDate;
        LocalDate oldDate = LocalDate.of(2019,01,01);
        Agent selectedAgent = null;

        for (Task task: tasks){
            instant = Instant.ofEpochMilli(task.getAssignedDate().getTime());
            localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            taskAssignedDate = localDateTime.toLocalDate();
            if (!task.getPriority().equals("low")){
                allTasksLowPriority = false;
            }else if ( taskAssignedDate.isAfter(oldDate)){
                oldDate = taskAssignedDate;
                selectedAgent = task.getAgent();
            }
        }

        return selectedAgent;
    }
}
