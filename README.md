**Project Overview** <br>
This project is a Spring Boot application for managing users, featuring form validation and basic authentication using Spring Security. It utilizes PostgreSQL for the database and Thymeleaf for the frontend.
<br>
**Project Structure** <br>
**Configuration** <br>

**SecurityConfig**: Configures Spring Security for basic authentication.<br>
**application.properties**: Contains database configuration and other application properties.<br>

**Entity** <br>

**User**: Represents the user entity with fields id, email, and name. Validation annotations are used to enforce constraints. <br>
**Repository** <br>

**UserRepository**: Extends JpaRepository to provide CRUD operations for User entities.<br>
**Controller** <br>

**UserController**: Handles HTTP requests for creating new users and displaying success messages.<br>
**View** <br>

**user-form.html**: Thymeleaf template for the user creation form. <br>
**success.html**: Thymeleaf template displayed after a successful user creation. <br>
**Spring Boot Actuator** <br>

Provides endpoints for monitoring and managing the application. <br>
**Endpoints** <br>
**User Management** <br>

**GET** /users/new: Displays the user creation form. <br>
**URL**: http://localhost:8080/users/new <br>
**Access**: Public (no authentication required) <br>
**POST /users**: Submits the user creation form. <br>
**URL**: http://localhost:8080/users <br>
**Access**: Requires authentication <br>
**Validation**: Validates the name and email fields. If validation fails, the form is redisplayed with error messages.<br>
**GET /users/success**: Displays the success message after user creation.<br>
**URL**: http://localhost:8080/users/success<br>
**Access:** Public (no authentication required)<br>
**Authentication**<br>

**GET /login**: Displays the login form (automatically handled by Spring Security). <br>
**Actuator Endpoints** <br>

**/actuator/health**: Health check endpoint. <br>
**URL:** http://localhost:8080/actuator/health <br>
**Access:** Public (by default) <br>
**/actuator/info:** Information endpoint (if additional info is provided in configuration). <br>
**URL:** http://localhost:8080/actuator/info <br>
**Access:** Public (by default) <br>
**Instructions** <br>

**Access the User Creation Form** <br>
Open your browser and navigate to http://localhost:8080/users/new <br>
You will be prompted to log in with the username user and password password (as defined in SecurityConfig). <br>

**Submit a New User** <br>

Fill out the form with a valid name and email. <br>
Submit the form. If validation passes, you will be redirected to the success page. <br>

**Monitor Application Health** <br>

Navigate to http://localhost:8080/actuator/health to check the application's health status. <br>

**Validation Handling**  <br>

**User Entity**  <br>
@NotEmpty and @Email for email  <br>
@NotEmpty and @Size(min = 2, max = 30) for name  <br>
If there are any issues with validation, error messages will be displayed next to the respective fields in the form. The form will not be submitted until all validations pass. <br>

With this setup, you can manage users securely, ensure valid data submission, and monitor the application's health using Actuator endpoints. <br>
