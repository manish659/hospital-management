# hospital-management
hospital management project

Using Java 17 to develop the project.

To run the service:
```
mvn clean install
mvn spring-boot:run
```

**Curl to Signup:**
```

curl --location 'localhost:8080/api/staff/signup' \
--header 'Content-Type: application/json' \
--data '{
    "first_name": "Manish",
    "last_name": "garg",
    "profile": "Doctor",
    "phone_no": "7014201950",
    "password": "1234"
}'
```

**Curl to Login:**
```
curl --location 'localhost:8080/api/staff/login' \
--header 'Content-Type: application/json' \
--data '{
    "phone_no": "7014201950",
    "password": "12344"
}'

```


**Curl to Admit a Patient:**
````
curl --location 'localhost:8080/api/patient/admit' \
--header 'Content-Type: application/json' \
--data '{
"name": "Manish garg",
"phone_no": "701520****",
"doctor_name": "doctor",
"room_id": 1,
"age": 25
}'
````


**Curl to Discharge a Patient:**
```
curl --location 'localhost:8080/api/patient/discharge' \
--header 'Content-Type: application/json' \
--data '{
"id": 102,
"room_id": 1
}'
```

**Curl to Fetch All the Patients:**
```
curl --location 'localhost:8080/api/patient/get-all'```
