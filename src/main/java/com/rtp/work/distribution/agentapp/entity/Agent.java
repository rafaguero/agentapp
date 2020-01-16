package com.rtp.work.distribution.agentapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Agent {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String skills;

    @OneToMany(mappedBy="agent")
    private List<Task> tasks;

    protected Agent(){}
    public Agent(Integer id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

        @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
