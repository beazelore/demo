App uses MySQL database. You need to change connection variables in application.properties file.
It runs on 8080 port. Also required jdk11 at least.

curls to check endpoints(tested in windows):
``` 
add user:

curl -X POST http://localhost:8080/user -H "content-type: application/json;charset=UTF-8" \
  -d "{
	\"fullName\":\"Samuel Long\",
	\"dateOfBirth\": \"2000-01-11\",
	\"phones\":[{\"phone\": \"12-4216-5423\"}, {\"phone\":\"2122-245142-2214\"}],
	\"gender\":\"1\"
}"

add call:

curl -X POST http://localhost:8080/call -H "content-type: application/json;charset=UTF-8" \
  -d "{
	\"callTime\":\"2000-01-11T22:46:12\",
	\"callerPhoneNumber\": \"2000-6501-0011\",
	\"recipientPhoneNumber\":\"4643-15-646\",
	\"city\":\"LA\",
	\"duration\":\"1233\",
	\"user\":{\"id\":\"6\"}
}"

get numbers by city:

curl -X GET http://localhost:8080/call/numberByCity -H "content-type: application/json;charset=UTF-8" 

get longest for user beetwen dates:

curl -X GET 'http://localhost:8080/call/longest?id=4&startDate=2000-01-01%2012%3A55%3A11&endDate=2019-10-28%2014%3A55%3A25' \
 -H "content-type: application/json;charset=UTF-8"

```