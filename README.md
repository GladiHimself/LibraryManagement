# 📚 Library Management Platform

A Spring Boot REST API to manage book information.

---

## 📖 Book Data Structure

Each book contains the following information:

- `id`: Unique identifier for the book
- `title`: Title of the book
- `author`: Author's name
- `publication_year`: Year the book was published
- `genre`: Book genre/category
- `price`: Price of the book

### 🧾 Example (JSON)

```json
{
  "id": 1,
  "title": "To Kill a Mockingbird",
  "author": "Harper Lee",
  "publication_year": 1960,
  "genre": "Fiction",
  "price": 10.99
}
