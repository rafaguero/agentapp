package com.rtp.work.distribution.agentapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rtp.work.distribution.agentapp.entity.Agent;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;
    private Date assignedDate;
    private String description;
    private String priority;   //low or high
    private String skills; //skill1,skill2,skill3
    private String status; // open,assigned,complete

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private Agent agent;

    protected Task(){}

    public Task(Integer id, String description, String priority, String skills, Date assignedDate, String status) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.skills = skills;
        this.assignedDate = assignedDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
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
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", skills='" + skills + '\'' +
                ", assignedDate=" + assignedDate +
                ", status='" + status + '\'' +
                ", agent=" + agent +
                '}';
    }
}
