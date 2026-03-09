# AgentTasks

## Overview

### Available Operations

* [create](#create) - Create agent task
* [revoke](#revoke) - Revoke agent task

## create

Create an agent task on behalf of a user.
The response contains a URL that, when visited, creates a session for the user.
The agent_id is stable per agent_name within an instance. The task_id is unique per call.

### Example Usage

<!-- UsageSnippet language="java" operationID="CreateAgentTask" method="post" path="/agents/tasks" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CreateAgentTaskResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CreateAgentTaskResponse res = sdk.agentTasks().create()
                .call();

        if (res.agentTask().isPresent()) {
            System.out.println(res.agentTask().get());
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `request`                                                                           | [CreateAgentTaskRequestBody](../../models/operations/CreateAgentTaskRequestBody.md) | :heavy_check_mark:                                                                  | The request object to use for the request.                                          |

### Response

**[CreateAgentTaskResponse](../../models/operations/CreateAgentTaskResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404, 422             | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## revoke

Revokes a pending agent task.

### Example Usage

<!-- UsageSnippet language="java" operationID="RevokeAgentTask" method="post" path="/agents/tasks/{agent_task_id}/revoke" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.RevokeAgentTaskResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        RevokeAgentTaskResponse res = sdk.agentTasks().revoke()
                .agentTaskId("<id>")
                .call();

        if (res.agentTask().isPresent()) {
            System.out.println(res.agentTask().get());
        }
    }
}
```

### Parameters

| Parameter                               | Type                                    | Required                                | Description                             |
| --------------------------------------- | --------------------------------------- | --------------------------------------- | --------------------------------------- |
| `agentTaskId`                           | *String*                                | :heavy_check_mark:                      | The ID of the agent task to be revoked. |

### Response

**[RevokeAgentTaskResponse](../../models/operations/RevokeAgentTaskResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 404                  | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |