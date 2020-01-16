package com.rtp.work.distribution.agentapp.entity;

import com.rtp.work.distribution.agentapp.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {
}
