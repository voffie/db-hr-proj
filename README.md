<p align="center">
  <img align="center" src="https://www.ithsdistans.se/pluginfile.php/1/core_admin/favicon/64x64/1723553478/ITHS_LOGO_SMALL.png" />
</p>
<h1 align="center">
  <strong>JPA CRUD Application</strong>
</h1>
<p align="center">
  A CRUD application that is written using the JPA framework
</p>
<p align="center">
  <b>Built with</b>
  <br />
  <img alt="Java" width="30px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />
</p>

## About

This project was a group assignment while studying at [IT-Högskolan](https://www.iths.se/). The goal was to learn how JPA and ORMs work.

## Technologies & Libraries

- **Java** - Core programming language used.
- **JPA** - ORM used to talk to the database.
- **MySQL** - Database used.

## Learnings

This project allowed us to dive deep into:

- **JPA** - A deeper understanding of ORMs and their function.
- **Entity & Repository layout** - Learned how to structure a JPA application

## Installation and Setup

1. Clone the repository:
   
   ```bash
   git clone https://github.com/voffie/db-hr-proj.git
   cd db-hr-proj
   ```
2. Ensure you have Java & [Docker](https://www.docker.com/) installed (this project is developed with JDK 23)
3. Open the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/):
   - Go to **File > Open** and select the project folder
   - Intellij should detect the project structure and automatically set up the necessary configurations.
4. Create & run the database:
   - Make sure Docker is running
   - Open `docker-compose.yml`, and run the file. Alternatively, run `docker-compose up`.
5. Run the application:
   - Open `main.java`, and run the main function to start the application.
