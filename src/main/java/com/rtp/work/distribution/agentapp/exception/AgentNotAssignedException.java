package com.rtp.work.distribution.agentapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AgentNotAssignedException extends RuntimeException{

    public AgentNotAssignedException(String message) {
        super(message);
    }
}
