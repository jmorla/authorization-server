# Authorization server


The authorization server consumes USERS and AUTHORITIES tables to authenticate the user, for now the client is hard coded in order to minimize the configuration (it will change later).

### New Features!

  - Authenticate user against database (it's using testing environment with H2 database)
  - BCrypt to encrypt client and user passwords

### Installation and Run

This server requires [java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and maven to run.

Install the dependencies and start the server.

```sh
$ cd authorization-server
$ gradle bootRun
```


If exist any conflict with the port then

```sh
$ mvn bootRun -Dserver.port=2000
```


After that we are able to issue tokens using the follow command  
```sh
$ curl -X POST --user 'educminWeb:s3cr3t@1' http://localhost:9999/auth-server/oauth/token -d 'grant_type=password&username=admin&password=admin' 
```


Then you should get a response like below 

```json
{
    "access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MzM3NTc1MzYsImF1dGhvcml0aWVzIjpbImxvZ2lzdGljLXdyaXRlIiwiYWRtaW5pc3RyYXRpb24tcmVhZCIsImFkbWluaXN0cmF0aW9uLXdyaXRlIiwibG9naXN0aWMtcmVhZCJdLCJqdGkiOiI3NjEyYzIzZC03NTIwLTQzZmYtYjVkNi0yNjY2NzA0MGQ0ODIiLCJjbGllbnRfaWQiOiJlZHVjbWluV2ViIiwidXNlcm5hbWUiOiJhZG1pbiJ9.sAdeLgNMcuvvLRQm4_Offv4PHQVaApUCabbCbUnQI6c",
    "token_type":"bearer",
    "expires_in":3599,
    "scope":"read write",
    "username":"admin",
    "jti":"7612c23d-7520-43ff-b5d6-26667040d482"
}
```


Then to use a private resource server take an example
```sh
$ curl -X GET -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MzM3NTc1MzYsImF1dGhvcml0aWVzIjpbImxvZ2lzdGljLXdyaXRlIiwiYWRtaW5pc3RyYXRpb24tcmVhZCIsImFkbWluaXN0cmF0aW9uLXdyaXRlIiwibG9naXN0aWMtcmVhZCJdLCJqdGkiOiI3NjEyYzIzZC03NTIwLTQzZmYtYjVkNi0yNjY2NzA0MGQ0ODIiLCJjbGllbnRfaWQiOiJlZHVjbWluV2ViIiwidXNlcm5hbWUiOiJhZG1pbiJ9.sAdeLgNMcuvvLRQm4_Offv4PHQVaApUCabbCbUnQI6c' http://another-service/api/v1/resource/1 
```
