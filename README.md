## Project Structure

```bash
src/
 └── main/
      └── java/
           └── com/enviro/assessment/grad001/banelemjaji/
                ├── controller/           # REST API endpoints
                ├── model/                # Entity classes
                ├── repository/           # JPA repositories
                ├── service/              # Business logic
                └── Application.java      # Main application entry point
```

---

### Steps to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/banelemjaji/Enviro365_Assessment.git
    ```

2. Navigate into the project directory:
    ```bash
    cd Enviro365_Assessment
    ```

3. Build the application using Maven:
    ```bash
    mvn clean install
    ```

4. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

5. The application will start on `http://localhost:8080`.

---

## API Endpoints

### Waste Categories

- **GET** `/api/waste-categories`: Retrieve all waste categories.
- **GET** `/api/waste-categories/{id}`: Retrieve a waste category by ID.
- **POST** `/api/waste-categories`: Create a new waste category.
- **PUT** `/api/waste-categories/{id}`: Update an existing waste category.
- **DELETE** `/api/waste-categories/{id}`: Delete a waste category.

### Recycling Tips

- **GET** `/api/recycling-tips`: Retrieve all recycling tips.
- **POST** `/api/recycling-tips`: Create a new recycling tip.

### Disposal Guidelines

- **GET** `/api/disposal-guidelines`: Retrieve all disposal guidelines.
- **GET** `/api/disposal-guidelines/category/{categoryId}`: Retrieve disposal guidelines for a specific waste category.
- **POST** `/api/disposal-guidelines`: Create a new disposal guideline.

---

## Testing with Postman

1. **Waste Category Endpoints**:
    - Test the **GET**, **POST**, **PUT**, and **DELETE** endpoints using Postman.
    - Use the `/api/waste-categories` endpoint to create, retrieve, update, and delete waste categories.

2. **Recycling Tip Endpoints**:
    - Test the **GET** and **POST** endpoints for managing recycling tips.

3. **Disposal Guideline Endpoints**:
    - Test the **GET** and **POST** endpoints for managing disposal guidelines.

---

### Key Design Decisions:

- **H2 Database**: I used an in-memory database for simplicity, which allows for fast testing and easy setup without external database dependencies.
- **Controller Layer**: Each controller is responsible for exposing the REST endpoints, while the service layer handles business logic. This follows the **separation of concerns** principle.
- **Validation**: I used **Jakarta Validation annotations** (e.g., `@NotBlank`) to validate incoming request data to ensure integrity.
- **DTOs**: For this assessment, the entities themselves are used directly as request/response models.