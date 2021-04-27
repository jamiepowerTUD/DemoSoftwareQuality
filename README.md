# Demonstrating Software Quality

### Sprint Backlog and Task Estimation 

Before starting a new software project it is worthwhile outlining goals and 
objects and to budget the time and effort required to complete these tasks.

<br>

The scrum methodology begins by developing a **Sprint Backlog**. A sprint 
backlog is a series of tasks derived from the product backlog, the demands
of the product owner are translated into small manageable tasks to be completed
during a sprint. It is important to discuss these objectives with your team 
and outline what tasks will be completed in the next sprint. 

<br>

There are a few ways to make your sprint backlog as effective and 
efficient as possible 

* Include all members of the team to ensure a sense of inclusivity 
and to offer varying perspectives
* Define a criteria by which all team members will consider a 
task to be finished
* Allow team members to delegate and assign tasks to each other
to foster ongoing collaboration and communication
* Ensure the backlog is dynamic, and it can adapt and react to 
changes


<br>

<table>
<thead>
<tr>
<th>User Story</th>
<th>In progress</th>
<th>Completed</th>
</tr>
</thead>
<tbody>
<tr>
<td><b>  Grading Management</b></td>
<td align="center"></td>
<td></td>
</tr>
<tr>
<td>Define a Grade </td>
<td align="center"></td>
<td>X</td>
</tr>
<tr>
<td>Define a Rubric </td>
<td align="center"></td>
<td>X</td>
</tr>
<tr>
<td>Define a Criterion</td>
<td align="center"></td>
<td>X</td>
</tr>
<tr>
<td>Define a Student Grade</td>
<td align="center"></td>
<td>X</td>
</tr>
<tr>
<td> <b>Adding and Searching features </b> </td>
<td></td>
<td></td>
</tr>
<tr>
<tr>
<td>Create a new Rubric</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Add Criterion to Rubric</td>
<td></td>
<td></td>
</tr>
<tr>
<td>List all Rubrics</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Retrieve Rubric by Name</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Add Score to a Grade</td>
<td></td>
<td></td>
</tr>
<tr>
<td>List all Student Grades</td>
<td></td>
<td></td>
</tr>
<tr>
<td><b>Grade Summaries</b></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Generate Graded Students Summary</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Generate Rubric Summary</td>
<td></td>
<td></td>
</tr>
<tr>
<td>Generate Criterion Summary</td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

<br>

We see that we have defined the goals are our project, we have defined three 
Sprints with their own set of tasks. The Sprints give your team a chance to 
reflect on the tasks, and the progress made, this is also a good opportunity 
to detect any significant changes which might alter the direction of the 
project. 

<br>

Once you have outlined the sprints, and the tasks associated with them the next
approach is to develop a task estimation. Task estimation is the process of 
estimating the effort or time needed to complete a task. The metric by which a 
tasks' completion is measured by is completely ambiguous and decided by the team. For this project 
will we measure our increments of effort in units of 5 minutes worth of work, we will
also determine the difficulty of each task from a scale of 1-5. When we examine
each task we will assess the difficulty and expected time of completion in order to manage and
control project resources and meet time constraints.

**1 unit = 5 minutes**
<br>


<table>
<thead>
<tr>
<th> Task </th>
<th> Unit </th>
<th align="center"> Difficulty   </th>
</tr>
</thead>
<tbody>
<tr>
<td>Define a Grade </td>
<td align="center">3</td>
<td align="center">2</td>
</tr>
<tr>
<td>Define a Rubric </td>
<td align="center">3</td>
<td align="center">2</td>
</tr>
<tr>
<td>Define a Criterion</td>
<td align="center">3</td>
<td align="center">2</td>
</tr>
<tr>
<td>Define a Student Grade</td>
<td align="center">3</td>
<td align="center">2</td>
<tr>
<td>Create a new Rubric</td>
<td align="center">1</td>
<td align="center">1</td>
</tr>
<tr>
<td>Add Criterion to Rubric</td>
<td align="center">2</td>
<td align="center">3</td>
</tr>
<tr>
<td>List all Rubrics</td>
<td align="center">2</td>
<td align="center">1</td>
</tr>
<tr>
<td>Retrieve Rubric by Name</td>
<td align="center">4</td>
<td align="center">4</td>
</tr>
<tr>
<td>Add Score to a Grade</td>
<td align="center">5</td>
<td align="center">4</td>
</tr>
<tr>
<td>List all Student Grades</td>
<td align="center">2</td>
<td align="center">2</td>
</tr>
<tr>
<td>Generate Graded Students Summary</td>
<td align="center">9</td>
<td align="center">5</td>
</tr>
<tr>
<td>Generate Rubric Summary</td>
<td align="center">6</td>
<td align="center">5</td>
</tr>
<tr>
<td>Generate Criterion Summary</td>
<td align="center">6</td>
<td align="center">5</td>
</tr>
</tbody>
</table>

<br>

In our task estimation we have assigned an estimated amount of time required to complete
each task as well as the complexity of the task. The implementation of each task varies in time and
difficulty as some tasks are easy to complete but time-consuming while others require a lot of thought
but are quick to.
<br>
Take for instance creating a new Rubric, this task involves defining the attributes of 
the object and instantiating it which is a straightforward task, compared to the generating a Student
grade summary which involves iterating over each grade and accumulating their attributes to perform
calculations on them to create the summary which is a more cumbersome task.

<br>

By defining an effort metric, we can also calculate the velocity of our sprints by comparing
the total number of units achieved by the number of sprints completed. If our project went 
as expected we should observe a velocity of 3 (46 / 3). Velocity acts as a feedback mechanism  
for teams by giving them a tangible measure of progress, it is expected so be slightly volatile, but a well-organised team should expect an average downward trend of 10% when being examined on 
a burndown chart.


###References 


[Effective Sprint Backlog](https://www.sealights.io/sprint-velocity/the-sprint-backlog-why-its-important-and-how-to-make-it-great/)
[Agile Metrics](https://www.atlassian.com/agile/project-management/metrics)
[Sprint Velocity](https://www.scruminc.com/velocity/#:~:text=Velocity%20is%20a%20measure%20of,all%20fully%20completed%20User%20Stories.)