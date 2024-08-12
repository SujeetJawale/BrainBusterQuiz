## OVERVIEW:
This is a monolithic application built using Java Spring Boot. It leverages Spring Data JPA for database interactions and MySQL as the relational database. 
The application is designed following a three-layered architecture (Controller, Service, and DAO) to ensure a clean separation of concerns, making the 
codebase easier to manage and extend. Additionally, Aspect-Oriented Programming (AOP) is used to handle cross-cutting concerns such as logging and error 
handling, further improving code modularity and reusability.

## PROJECT STRUCTURE
This is a monolithic application organized under the package com.sujeet.brainbuster. The project follows a layered architecture with clearly defined modules, as described below:

### 1. RestController
QuestionController: REST controller for managing Question-related operations like creation, retrieval, updating, and deletion.
QuizController: REST controller for managing Quiz-related operations including creation, retrieval, and handling quizzes.

### 2. Service
IQuestionService: Interface defining business logic operations for Question entities.
IQuizService: Interface defining business logic operations for Quiz entities.
QuestionServiceImpl: Implementation of IQuestionService, containing the core business logic for Question management.
QuizServiceImpl: Implementation of IQuizService, handling the core business logic for Quiz management.

### 3. DAO (Data Access Object)
IQuestionRepo: Interface for Question entity repository, handling CRUD operations and custom queries.
IQuizRepo: Interface for Quiz entity repository, managing CRUD operations and custom queries.

### 4. Model
ErrorDetails: Model class representing the structure of error responses.
Question: Entity class representing a Question in the system.
QuestionWrapper: Helper class to wrap a collection of Question objects.
Quiz: Entity class representing a Quiz which is composed of multiple Question objects.
Response: Model class to encapsulate responses from the REST API

### 5. Advice
QuestionErrorController: This class handles global exceptions and provides custom error responses for the application.

### 6. Exception
QuestionNotFoundError: Custom exception class to handle cases where a requested Question is not found.

### Main Application
BrainBusterApplication: The entry point of the application which boots the Spring Boot application.

## APIS:

### 1. QuestionController
The QuestionController class is a RESTful controller responsible for handling HTTP requests related to Question entities. It exposes several endpoints to perform CRUD (Create, Read, Update, Delete) operations on questions within the application. Below are the key endpoints:

#### GET /question/allquestions: 
Retrieves a list of all questions available in the system.

#### POST /question/addquestion: 
Adds a new question to the system. The question data is passed in the request body.

#### POST /question/addallquestion: 
Adds a collection of questions to the system in a single request.

#### GET /question/category/{category}: 
Fetches questions based on their category.

#### PUT /question/updatequestion/{id}: 
Updates an existing question identified by its ID with new data provided in the request body.

#### PATCH /question/updateanswer/{id}/{answer}: 
Updates the answer for a specific question, identified by its ID.

#### DELETE /question/deletequestion/{id}: 
Deletes a question from the system based on its ID.

This controller interacts with the IQuestionService interface to process business logic and manage data operations related to questions.

### 2. QuizController
The QuizController class is another RESTful controller that manages HTTP requests related to Quiz entities. It facilitates the creation of quizzes, retrieval of quiz details, and calculation of quiz results. Key endpoints include:

#### POST /quiz/create: 
Creates a new quiz based on a specified category, number of questions, and title. The selected questions are pulled randomly from the available questions in the specified category.

#### GET /quiz/{id}: 
Retrieves the details of a quiz, including the questions, based on its unique ID.

#### POST /quiz/{id}/calculate: 
Calculates the result of a quiz based on the user's responses. The correct answers are compared with the user-provided answers to determine the score.

The QuizController leverages the IQuizService interface to orchestrate the business logic and data interactions required for managing quizzes.
