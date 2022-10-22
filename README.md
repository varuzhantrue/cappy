# cappy
Web App Implementation 
Tech Stack
We encourage you to use Spring MVC or Spring Boot, and RDBMS (MySQL, Postgres, or similar free solutions) to build your web app.

Web App Development Milestones

In the previous weeks, you defined the purpose of your app, its main use cases, and the kind of entities it will manage.
Now it's time to proceed to the code.
The task is complex: you must design and implement lots of classes and interfaces. Let's take it step by step:

Click the heading for more information.

 Step 1: Design the Layers and Modules
It is recommended to implement three-tier architecture — a well-established software application architecture that organizes applications into three logical and physical computing tiers:

the presentation tier, or the user interface
the application tier, where data is processed
and the data tier, where the data associated with the application is stored
You are required to use this model and provide layers of controllers, services, and data access.

 Step 2: Define a Data Access Solution
There are two ways to establish access to the database from within your app:

To implement JDBC (Java Database Connectivity) — it manages the connection to a database, enables issuing queries and commands, and handling result sets obtained from the database.
To leverage an ORM solution (Hibernate) — Spring allows you to use JPA Entity Managers, Hibernate Session Factories, or the Spring Data approach.
 Step 3: Choose and Set up a Template Engine
You may choose an Internal Views based on JSPs or an advanced template engine like Thymeleaf or Freemarker. Msure to properly configure view resolving accordingly. 

 Step 4: Design General Interfaces and Classes
Start with inter-layer communication. Do not try to create a complex solution in one iteration, but design simple Services, DAO, and UI layers that can help you to deploy and start your application as soon as possible.

 Step 5: Implement Your Application
Start with introducing domain entities and appropriate attributes and relations. Afterward, implement related classes of the Service and DAO layers, then Views and Controllers.

 Step 6: Run Unit and Integration Tests
Apply the TDD approach and cover your code with unit or integration tests. Even though it is optional, we strongly recommend you do this: it will provide you with confidence that the application will run smoothly. Try to reach at least 50% of code coverage.

 Step 7: Manage Users’ Access
Consider using Spring Security to manage user access to your web app. Spring Security is the most common way to authenticate users and deal with their privileges.

Task Tracking
We encourage you to use task tracking services like GitLab Issues and Boards or Trello with simple models of three columns: To Do, In Progress, and Done.
Break down big milestones, like data access or the controller layer implementation, into smaller tasks, and put them on the board. That will help to plan workload and better understand the current project status.

Requirements

Let us consolidate all the requirements into a single check list:

The web app obtains a GUI.
There are three layers: the persistence (or data access) layer, the service layer, and the view layer.
Persistence layer requirements:
The web app is connected to a database.
There are at least 4 entities in the database.
There are relationships between these entities.
Recommended: at least one many-to-many relationship is designed.
The web app contains the persistence layer.
The persistence layer is isolated from other layers.
Service layer requirements:
Services use dependencies from the persistence layer to access data and do not interact with a database on their own.
Services do not deal with views.
Services handle the main business processes of the web app.
View layer requirements:
Controllers of the view layer do not use dependencies from the persistence layer or interact with a database.
Controllers of the view layer may use dependencies from the service layer.
There are at least 6 views.
Recommended: unit and/or integration tests are applied.
The project is completed: all the functions are implemented.
The project demo is given.
It will take you about 30 hours to complete the task.

Please be aware that this task is mandatory.

You can earn a maximum of 300 points (100%) for this task. To complete the task successfully, you need to earn at least 70% of the points.
