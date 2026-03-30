# 🐳 Spring Boot Docker App – Commands & Setup Guide

This document provides essential Docker and MySQL commands used in this project.

---

# 📦 Docker Basics

## 🔍 View Containers

```bash
docker ps -a
```

Lists all containers (running + stopped)

---

## 🗑️ Remove Container

```bash
docker rm <container_id>
```

---

## 🗑️ Remove Image

```bash
docker rmi <image_id>
```

---

## ▶️ Start Container

```bash
docker start <container_id>
```

---

## ⏹️ Stop Container

```bash
docker stop <container_id>
```

---

# 🏗️ Build Docker Image

```bash
docker build -t <image_name>:<version> .
```

### Example:

```bash
docker build -t springboot-docker-app:v1 .
```

### Notes:

* `-t` → Tag name
* `.` → Current directory (build context)

---

# 🚀 Run Docker Container

```bash
docker run <container_id_or_name>
```

### With Port Mapping:

```bash
docker run -p <host_port>:<container_port> <image_name>
```

### Example:

```bash
docker run -p 8080:8080 springboot-docker-app:v1
```

### Port Explanation:

```
host_port : container_port
```

---

# 🐳 Docker Compose Commands

## Stop & Remove Containers + Volumes

```bash
docker-compose down -v
```

---

## Start Services

```bash
docker-compose up
```

---

## Rebuild & Start

```bash
docker-compose up --build
```

---

# 📜 View Logs

```bash
docker logs springboot-docker-app-app-1
```

---

# 🐬 MySQL Commands (Docker)

## Connect to MySQL Container

```bash
docker exec -it mysql-db mysql -uroot -proot
```

---

## Select Database

```sql
USE employee_db;
```

---

## Show Tables

```sql
SHOW TABLES;
```

---

# 🧠 Key Concepts

## Docker Terminology

| Term      | Meaning                          |
| --------- | -------------------------------- |
| Image     | Blueprint of application         |
| Container | Running instance of image        |
| Volume    | Persistent storage               |
| Network   | Communication between containers |

---

## Port Mapping

```bash
-p host_port:container_port
```

Example:

```bash
-p 8081:8080
```

* App runs on `8080` inside container
* Accessible via `localhost:8081`

---

## Common Troubleshooting

### ❌ Port already in use

```bash
netstat -ano | findstr :8080
```

---

### ❌ Container not starting

```bash
docker logs <container_name>
```

---

### ❌ DB not connecting

* Use service name (`mysql`) instead of `localhost`
* Ensure Docker network is shared

---

# 🚀 Project Workflow

```bash
# Build & start everything
docker-compose up --build

# Stop everything
docker-compose down -v

# Check logs
docker logs springboot-docker-app-app-1

# Connect to DB
docker exec -it mysql-db mysql -uroot -proot
```

---

# ✅ Best Practices

* Use **Docker Compose** for multi-container apps
* Avoid hardcoding DB configs
* Use **profiles (dev/prod)**
* Always check logs for debugging
* Prefer service name over localhost in Docker

---

# 📌 Summary

This project demonstrates:

* Spring Boot + MySQL integration
* Docker containerization
* Docker Compose orchestration
* Environment-based configuration

---

💡 Tip: Always debug in this order:

1. `docker ps`
2. `docker logs`
3. DB connection
4. Port mapping

---
