# GoTNoteApp

This Application is build using the Spring Boot Application.

Technology Stack
1. Java 8
2. Spring Boot
3. Spring Security
4. JWT 
5. Rest API
6. Apache Derby 

Application is currently using the apache derby. the connection properties has been 
written in application.yml. The data.sql contains the sample data

Application cURL Command Example:

#Login : 
UserName : rkamh@gmail.com
password : test1234

curl -X POST -H "X-Requested-With: XMLHttpRequest" -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d "{"""username""":"""rkamh@gmail.com""","""password""":"""test1234"""}" http://localhost:9966/api/auth/login

Response will contain the authentication token and refresh token, the validity of the token is 60 Minutes.

#To Get the UserName:

curl -X GET -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTAzMDEsImV4cCI6MTQ5MTMxMTIwMX0.cx14e6IiFdGq-LLoPTsgOXDQKxyuWIo3G1ZdR69Zjlbygx26PQelLv4F9XszGIRKpLp_Y17wa8iqT1AGo48dVg" -H "Cache-Control: no-cache" http://localhost:9966/api/user

#POST, PUT, DELETE and GET Point for the User Note API.
Please Note : The POST and PUT Operations needs a json file. The JSON File can be found under src/main/resource/static
 
curl -X GET -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTAzMDEsImV4cCI6MTQ5MTMxMTIwMX0.cx14e6IiFdGq-LLoPTsgOXDQKxyuWIo3G1ZdR69Zjlbygx26PQelLv4F9XszGIRKpLp_Y17wa8iqT1AGo48dVg" -H "Cache-Control: no-cache" http://localhost:9966/api/user
 
curl -X GET -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTc5NTUsImV4cCI6MTQ5MTMyMTU1NX0.KaJJg5bRSnI68T2w7_nkhzxEgsfwkNoMRvSvbHAk2HU0VtCjX_0xso-Dn0mvK4_ORkHmc96kq_o89Iosw-lZFg" -H "Cache-Control: no-cache" http://localhost:9966/api/usernotes
 
curl -X GET -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTc5NTUsImV4cCI6MTQ5MTMyMTU1NX0.KaJJg5bRSnI68T2w7_nkhzxEgsfwkNoMRvSvbHAk2HU0VtCjX_0xso-Dn0mvK4_ORkHmc96kq_o89Iosw-lZFg" -H "Cache-Control: no-cache" http://localhost:9966/api/usernotes/2
 
curl -X POST -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTc5NTUsImV4cCI6MTQ5MTMyMTU1NX0.KaJJg5bRSnI68T2w7_nkhzxEgsfwkNoMRvSvbHAk2HU0VtCjX_0xso-Dn0mvK4_ORkHmc96kq_o89Iosw-lZFg" -H "Content-Type: application/json" -d @postusernote.json http://localhost:9966/api/usernotes
 
curl -X PUT -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTc5NTUsImV4cCI6MTQ5MTMyMTU1NX0.KaJJg5bRSnI68T2w7_nkhzxEgsfwkNoMRvSvbHAk2HU0VtCjX_0xso-Dn0mvK4_ORkHmc96kq_o89Iosw-lZFg" -H "Content-Type: application/json" -d @putusernote.json http://localhost:9966/api/usernotes
 
curl -X DELETE -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJya2FtaEBnbWFpbC5jb20iLCJpc3MiOiJnb3RwcmludC5jb20iLCJpYXQiOjE0OTEzMTc5NTUsImV4cCI6MTQ5MTMyMTU1NX0.KaJJg5bRSnI68T2w7_nkhzxEgsfwkNoMRvSvbHAk2HU0VtCjX_0xso-Dn0mvK4_ORkHmc96kq_o89Iosw-lZFg" -H "Cache-Control: no-cache" http://localhost:9966/api/usernotes/2
 

