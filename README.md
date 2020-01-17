<b>Work Distribution Service</b>
<br>
This service distributes tasks to agents. It allows the creation of tasks with skills required to complete the task. The agent must posses the skills in order to assign the agent to the task. The agent must be free of any other tasks in order to take the task.<br>
The tasks have two priorities "low" or "high". The skills associated with tasks and agents will be "skill1,skill2,skill3". If all the agents have a low priority task, and a new task is created the service will assign the task to the agent with the most recent assigned task date. The agents are loaded on to the database upon start of the application.
<br>
<br>
<b>Technology Used</b><br>
SpringBoot, JPA and H2 - in memory database. Docker is used to create a docker image<br>
<br>
<b>Getting Started</b><br>
To run the application there are two options.<br>
Option 1<br>
Use git to clone or download that git repo on to your machine. The code is in https://github.com/rafaguero/agentapp.git<br>
After you download import the project into intellij or eclipse. Once you have imported the project right click on class AgentappApplication located in src/main/java/com.rtp.work.distribution.agentapp
<br>
Option 2<br>
Download the docker image from my docker hub to your local environment. You must have docker container install on your environment.<br>
You can down load by entering the command docker pull rafaeltperez/jpa:taskagent<br>
To run the image type the command: docker run --publish 8080:8080 rafaeltperez/jpa:taskagent<br>
<br><b>EndPoints</b><br><br>
(1) http://localhost:8080/agent-app/retrieve-agents (issue a get request)<br>
This end point will provide a json object containing the list of preloaded agents with their attributes and any tasks assigned to them<br>
(2) http://localhost:8080/agent-app/create-task (issue a post request)<br>
in the body of the request you must pass the following json object <br>
{
               
				"assignedDate": "2020-01-16T04:51:48.333+0000",
                "description": "task1",
                "priority": "low",
                "skills": "skill1",
                "status": "assigned"
          
}
The assigned date you can put any date/time you like, description should have a description of the task. The priority can be high or low. The skill can contain one or more skills separated by a comma. For example "skill1,skill2". This means the task requires that the agent posses both skills in order to complete the task.<br>
(3) http://localhost:8080/jpa/mark-task-complete/{id} (issue a put request). Replace {id} with the task id. For example if you wanted to change the status to complete for task 1 you would issue the put request http://localhost:8080/jpa/mark-task-complete/1<br>
<b>Author: Rafael T Perez<b> <br>








