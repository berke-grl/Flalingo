## Spring Boot Security with JWT Bearer Token

Overview

This project demonstrates the implementation of security features in a Spring Boot application using JSON Web Tokens (JWT) and Bearer token authentication. This setup provides a robust and stateless authentication mechanism, allowing secure access to endpoints.

Prerequisites

Ensure you have the following software installed on your machine:

Java Development Kit (JDK) 8 or later
Apache Maven
Your preferred IDE (e.g., IntelliJ, Eclipse)
Getting Started


Configuration

Security Configuration
The security configuration is defined in the SecurityConfig class. This class extends WebSecurityConfigurerAdapter and configures security settings, such as enabling JWT authentication, specifying token filters, and defining authentication entry points.

JWT Configuration
JWT configuration is in the JwtTokenProvider class, responsible for token generation, validation, and extraction. Customize JWT-related settings in this class based on your requirements.

Controller Endpoints
Sample protected and public endpoints are available in the SampleController class. The /api/public endpoint is accessible without authentication, while the /api/private endpoint requires a valid Bearer token.

Usage

Obtain a JWT token by authenticating against the /api/authenticate endpoint with valid credentials.
Include the obtained token in the Authorization header of your requests to access protected endpoints. The header should be in the format: Bearer <your-token>.
Example Request

Customization

Feel free to customize the project according to your specific requirements. Modify the security configurations, user authentication logic, or extend the application with additional features.

