# Spring Boot & JTE & HTMX Tasks

This project demonstrates a simple task management application built with Spring Boot, JTE (Java Template Engine), and HTMX. It showcases how to create a responsive web application with server-side rendering and dynamic updates.

## Technologies Used

- Java 23
- Spring Boot 3.3.4
- JTE (Java Template Engine)
- HTMX (for dynamic frontend updates)
- Maven (for dependency management and build)

## Project Structure

- `src/main/java/dev/danvega/tasks/`
    - `Application.java`: Main Spring Boot application class
    - `Task.java`: Task model class
    - `TaskController.java`: Controller handling HTTP requests
    - `TaskRepository.java`: Repository for managing tasks
- `src/main/jte/`: JTE templates (not visible in the provided code)
- `src/test/java/dev/danvega/tasks/`
    - `ApplicationTests.java`: Basic application context test
    - `TaskControllerTest.java`: Unit tests for TaskController

## Features

- View a list of tasks
- Add new tasks
- Delete existing tasks
- Responsive updates without full page reloads (using HTMX)

## Setup and Running

1. Ensure you have Java 23 and Maven installed on your system.

2. Clone the repository:
   ```
   git clone [repository-url]
   cd [repository-name]
   ```

3. Build the project:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Open a web browser and navigate to `http://localhost:8080`

## Testing

Run the tests using Maven:

```
mvn test
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open-source and available under the [MIT License](LICENSE).