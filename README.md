# Path Annotation Test

This is a small application to demonstrate an issue with swagger paths and subresources.

---

1. Run `mvn clean install` to build the application.
2. Start application with `java -jar target/swagger-subresource-issue-1.0.0-SNAPSHOT.jar server config.yml`
3. To look at the swagger documentation enter url `http://localhost:8080/swagger.json`

Notice the path for the resource that's been registered in Jersey is incorrect. It shows up like this:

```json
{
  "swagger": "2.0",
  "info": {},
  "tags": [
    {
      "name": "this is a parent resource"
    },
    {
      "name": "this is a test sub resource"
    }
  ],
  "paths": {
    "/v1/parentsubresource": {
      "get": {
        "tags": [
          "this is a test sub resource",
          "this is a parent resource"
        ],
        "summary": "Get a simple hello world message",
        "description": "",
        "operationId": "getHelloMessage",
        "produces": [
          "text/plain"
        ],
        "parameters": [],
        "responses": {
          "200": {
            "description": "successful operation",
            "schema": {
              "type": "string"
            }
          }
        }
      }
    }
  }
}
```

## Example Requests
```
HTTP/1.1 200 OK
http://localhost:8080/v1/parent
```



```
HTTP/1.1 404 Not Found
http://localhost:8080/v1/parentsubresource
```

There are workarounds, but this seems like an issue that should be fixed.