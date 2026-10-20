# Assignment: Customer API — Group Customers by Email Host

## Objective
Develop a REST API using Java, Spring Boot, and PostgreSQL that retrieves customers from the database and groups them by their email host/domain. The API must return the grouped data as a `HashMap`.

## Functional Requirements

### 1. Database
Use PostgreSQL with a `customers` table containing the following fields:

- `id` — Customer ID
- `first_name` — Customer's first name
- `last_name` — Customer's last name
- `email` — Customer's email address
- `phone_number` — Customer's phone number

### 2. Repository Layer
Implement a repository method that:
- Fetches all customers from PostgreSQL using `JdbcTemplate`.
- Uses the appropriate `JdbcTemplate` method and a `RowMapper<Customer>` to map database records to Java objects.
- Returns a `List<Customer>`.

### 3. Service Layer
Implement a service method that:
- Retrieves customers from the repository.
- Groups customers by their email host, extracted from the part after `@`.
- Returns a `HashMap<String, List<Customer>>`.
- Handles null or malformed email addresses safely.
- Groups email hosts case-insensitively.

### 4. Controller Layer
Expose the following REST endpoint:

**Method:** `GET`

**Endpoint:** `/api/customers/grouped-by-email-host`

The endpoint must return the grouped customer data as a JSON response.

## Expected Output

For the following sample customers:

| ID | First Name | Last Name | Email |
|---:|---|---|---|
| 1 | Rahul | Sharma | rahul@gmail.com |
| 2 | Amit | Verma | amit@gmail.com |
| 3 | Sara | Khan | sara@yahoo.com |
| 4 | John | Smith | john@outlook.com |
| 5 | Priya | Singh | priya@yahoo.com |

The API should return a response similar to:

```json
{
  "gmail.com": [
    {
      "id": 1,
      "firstName": "Rahul",
      "lastName": "Sharma",
      "email": "rahul@gmail.com"
    },
    {
      "id": 2,
      "firstName": "Amit",
      "lastName": "Verma",
      "email": "amit@gmail.com"
    }
  ],
  "yahoo.com": [
    {
      "id": 3,
      "firstName": "Sara",
      "lastName": "Khan",
      "email": "sara@yahoo.com"
    },
    {
      "id": 5,
      "firstName": "Priya",
      "lastName": "Singh",
      "email": "priya@yahoo.com"
    }
  ],
  "outlook.com": [
    {
      "id": 4,
      "firstName": "John",
      "lastName": "Smith",
      "email": "john@outlook.com"
    }
  ]
}
```
