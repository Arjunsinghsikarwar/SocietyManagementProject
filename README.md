Community Security Management System – Backend (Spring Boot)

The Community Security Management System is a backend platform designed to manage the day-to-day operations of a residential society.
The system provides secure user authentication using JWT, role-based access control (ADMIN, LEADER, USER), and modules to manage families, members, leaders, and complaints.

This backend is built with Spring Boot, follows a layered architecture, and uses PostgreSQL for persistence.

🚀 Project Overview

This system helps societies manage:
Registration & login
Role-based access to different operations
Managing leaders of the society
Adding and managing families & members
Submitting and tracking complaints
Ensuring only authorized users can access sensitive data
The backend is designed for scalability, security, and clean code structure.

✨ Key Features in Detail
🔐 1. JWT-Based Authentication
Users log in with username + password
Passwords stored in encrypted format using Spring Security
Backend generates a JWT token
Token must be included in every request’s header:

Authorization: Bearer <token>

🛡️ 2. Role-Based Authorization
Different roles have different permissions:

ADMIN

Can create leader accounts
Can view list of all leaders
Can manage user roles if required

LEADER

Can add families
Can add members
Can view families & members under their area

USER
Can submit complaints


📦 3. Well-Structured Backend Architecture
The project follows Controller → Service → Repository architecture.

Controller Layer
Handles API calls and forwards the request to the service layer.

Service Layer
Contains business logic and interactions between entities, DTOs, and repositories.

Repository Layer
Handles database operations using Spring Data JPA.

DTO Layer
Ensures clean separation between API requests and entity models.

Global Exception Handling
All exceptions like:
Invalid user
Invalid role
Duplicate entry
Resource not found
are handled using a central exception handler to return clean JSON messages.


🧾 API Endpoints — Full Detail
Auth APIs

Method	 Endpoint	    Description
POST	/auth/register	Register a new user
POST	/auth/login	    Login & receive JWT token

Admin APIs
Method	Endpoint	Description
POST	/admin/leader	Create new leader account
GET	/admin/leaders	Get all leaders

Leader APIs
Method	    Endpoint	                 Description
POST	    /leader/family	            Add a new family
POST	    /leader/member	            Add a new member to a family
GET	     /leader/families	            Get all families
GET	     /leader/members	            Get all members

Complaint APIs

Method	    Endpoint	                 Description
POST	    /complaint	                Submit a complaint
GET	    /complaint/user/{id}	       Get complaints of a specific user

🧪 Validations

My project includes:
Null or empty field checks
Duplicate username/email checks
Invalid role handling
Custom responses for failed authentication
Structured error messages
Request body validations

🗄️ Database Design (Expanded)
Tables
users
roles
leaders
families
complaints

Relationships
One Leader → Many Families
One Family → Many Members
One User → Many Complaints
