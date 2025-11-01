# Billing
(*billing()*)

## Overview

### Available Operations

* [extendSubscriptionItemFreeTrial](#extendsubscriptionitemfreetrial) - Extend free trial for a subscription item

## extendSubscriptionItemFreeTrial

Extends the free trial period for a specific subscription item to the specified timestamp.
The subscription item must be currently in a free trial period, and the plan must support free trials.
The timestamp must be in the future and not more than 365 days from the end of the current trial period
This operation is idempotent - repeated requests with the same timestamp will not change the trial period.

### Example Usage

<!-- UsageSnippet language="java" operationID="ExtendBillingSubscriptionItemFreeTrial" method="post" path="/billing/subscription_items/{subscription_item_id}/extend_free_trial" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.components.ExtendFreeTrialRequest;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.ExtendBillingSubscriptionItemFreeTrialResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        ExtendBillingSubscriptionItemFreeTrialResponse res = sdk.billing().extendSubscriptionItemFreeTrial()
                .subscriptionItemId("<id>")
                .extendFreeTrialRequest(ExtendFreeTrialRequest.builder()
                    .extendTo(OffsetDateTime.parse("2026-01-08T00:00:00Z"))
                    .build())
                .call();

        if (res.commerceSubscriptionItem().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `subscriptionItemId`                                                        | *String*                                                                    | :heavy_check_mark:                                                          | The ID of the subscription item to extend the free trial for                |
| `extendFreeTrialRequest`                                                    | [ExtendFreeTrialRequest](../../models/components/ExtendFreeTrialRequest.md) | :heavy_check_mark:                                                          | Parameters for extending the free trial                                     |

### Response

**[ExtendBillingSubscriptionItemFreeTrialResponse](../../models/operations/ExtendBillingSubscriptionItemFreeTrialResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |