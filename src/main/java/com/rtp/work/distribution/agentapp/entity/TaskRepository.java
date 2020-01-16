package com.rtp.work.distribution.agentapp.entity;

import com.rtp.work.distribution.agentapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
