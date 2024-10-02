<div align="center"> <h1>Eurofarma Training Managment</h1>
  
![logo_eurofarma (1)](https://github.com/user-attachments/assets/57fec90d-fc6f-4c3a-9d3e-f24c3e49bfbb)
</div>

## 📑 About the project 
API developed for training management at Eurofarma company. Currently, the trainings are carried out manually without a centralized system for storing it. This project includes carrying out the entire training registration flow, as well as access to the training in which the user has signed up. We will have an ADMIN profile to register the training, and a USER profile to register and have access to each of them.

<br>

## 🔎 Domain Model 

![Class Diagram0](https://github.com/user-attachments/assets/614aa02f-92f0-4ab8-a589-2f00f0805427)

<br>



## 💻 How to run the project 


```bash
# Clone the project
git clone https://github.com/anaeliza12/Projeto-Eurofarma.git

```


```bash
# Run the project
mvn spring-boot:run
```

<br>

##  <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="23" height="23"/>   Testing with Postman 

## Profile: Admin
### Auth
Send a **POST** Request to `http://localhost:8080/api-eurofarma/auth/v1/login` to log in the site

**Admin Object DTO**
```json
{
      "email": "pedro.santos@eurofarma.com.br",
      "password": "admin123"
}

```
<br>

### Trainings
Send a **POST** Request to `http://localhost:8080/api-eurofarma/training/v1/all` to return all avaible training

**Training Object**
```json
{
      "id": 1,
        "name": "Desenvolvimento de Liderança",
        "department": {
            "id": 1,
            "name": "Recursos Humanos "
        },
        "duration": "44min",
        "date": "2024-08-29",
        "time": "15:30:00",
        "description": "Treinamento focado em desenvolver habilidades de liderança, incluindo técnicas de motivação, comunicação eficaz e gestão de equipes. Ideal para líderes atuais e futuros.",
        "modality": "On-line",
        "local": "Sala 11",
        "userTraining": []
}

```


<br> 

## Profile: User
### Auth
Send a **POST** Request to `http://localhost:8080/api-eurofarma/v1/login` to log in the site

**User Object DTO**
```json
{
      "id": "4",
      "email": "maria.silva@eurofarma.com.br",
      "password": "123maria"

}

```

<br>

### My Trainings
Send a **GET** Request to `http://localhost:8080/api-eurofarma/v1/my-trainings` to return all trainings subscribed by the corresponding user

**UserTraining Object**
```json
{
      "id": "7",
      "name": "Auditoria de Qualidade",
      "department": 4,
      "duration": "50min",
      "date": "2025-02-08",
      "time": "15:50:00",
      "description": "Técnicas e procedimentos para realizar auditorias de qualidade, identificando não conformidades e oportunidades de melhoria.",
      "modality": "On-line",
      "local": "Teams",
      "status": "Em andamento" 
}

```
<br> 

### 📥 Download the collection !


[![Run Eurofarma collection in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/28811195-e12e9528-6d10-4de2-9b85-06c949a5ea8d)

<br> 




# 📂 Project File Tree

```
Projeto-Eurofarma/src/main/java/com/eurofarma/eurofarma
├── config
│   └── DataConfig.java
│   └── SecurityConfig.java
│  
├── controller
│   └── AuthController.java
│   └── 
│  
├── entities
│   └── Departament.java
│   └── Permission.java
│   └── Training.java
│   └── User.java
│   └── UserTraining.java
|
│── exception
│       ├── handler
│           └── CustumizedRespondeEntityExceptionHanldler.java
│   └── InvalidJwtAuthenticationException.java 
|
│── repositories
│       └── DepartamentRepository.java
│       └── TrainingRepository.java
│       └── UserRepository.java
│       └── UserTrainingRepository.java
|
│── security
│       ├── jwt
│           └── TokenFilter.java
│           └── TokenProvider.java
│       ├── vo
│           └── AccountCredencialsVO.java
│           └── TokenVO.java
│ 
|── services
        └── AuthService.java
        └── UserService.java
```


## <img src="https://github.com/user-attachments/assets/c987ba08-8ca4-44c3-ab75-2b823579b827" width="23" height="23"/>  Swagger links
swagger.json:
```
http://localhost:8080/swagger-ui/index.html
```
swagger-ui:
```
http://localhost:8080/swagger-ui/v2/api-docs
```

## ✅ JWT Token

```json
{
  "roles": [
    "ADMIN",
    "MANAGER"
  ],
  "iat": 1724324000,
  "exp": 1724327600,
  "sub": "ana",
  "iss": "http://localhost:8080"
}

```

## 🛠 Tech Stack

#### Languages
- Java with SpringBoot
- SQL

#### External Libraries
- JPA/Hibernate
- Spring Security
- HATEOAS
- JWT
- Swagger

#### Containerization Tool
- Docker
  
#### Architecture
- Layered Architecture

## 📌Adicional Information
For testing purposes, data insertion scripts for all tables were made available


