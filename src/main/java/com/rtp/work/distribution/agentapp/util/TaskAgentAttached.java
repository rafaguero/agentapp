package com.rtp.work.distribution.agentapp.util;

import com.rtp.work.distribution.agentapp.entity.Agent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskAgentAttached {
    private Integer id;
    private Date assignedDate;
    private String description;
    private String priority;   //low or high
    private String skills; //skill1,skill2,skill3
    private String status; // open,assigned,complete
    private Agent agent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "TaskAgentAttached{" +
                "id=" + id +
                ", assignedDate=" + assignedDate +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", skills='" + skills + '\'' +
                ", status='" + status + '\'' +
                ", agent=" + agent +
                '}';
    }
}
