# Commerce
(*commerce()*)

## Overview

### Available Operations

* [listPlans](#listplans) - List all commerce plans
* [listSubscriptionItems](#listsubscriptionitems) - List all subscription items
* [cancelSubscriptionItem](#cancelsubscriptionitem) - Cancel a subscription item

## listPlans

Returns a list of all commerce plans for the instance. The plans are returned sorted by creation date,
with the newest plans appearing first. This includes both free and paid plans. Pagination is supported.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetCommercePlanList" method="get" path="/commerce/plans" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetCommercePlanListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetCommercePlanListResponse res = sdk.commerce().listPlans()
                .limit(10L)
                .offset(0L)
                .call();

        if (res.paginatedCommercePlanResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                 | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `paginated`                                                                                                                               | *Optional\<Boolean>*                                                                                                                      | :heavy_minus_sign:                                                                                                                        | Whether to paginate the results.<br/>If true, the results will be paginated.<br/>If false, the results will not be paginated.             |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |
| `payerType`                                                                                                                               | [Optional\<PayerType>](../../models/operations/PayerType.md)                                                                              | :heavy_minus_sign:                                                                                                                        | Filter plans by payer type                                                                                                                |

### Response

**[GetCommercePlanListResponse](../../models/operations/GetCommercePlanListResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## listSubscriptionItems

Returns a list of all subscription items for the instance. The subscription items are returned sorted by creation date,
with the newest appearing first. This includes subscriptions for both users and organizations. Pagination is supported.

### Example Usage

<!-- UsageSnippet language="java" operationID="GetCommerceSubscriptionItemList" method="get" path="/commerce/subscription_items" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetCommerceSubscriptionItemListRequest;
import com.clerk.backend_api.models.operations.GetCommerceSubscriptionItemListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetCommerceSubscriptionItemListRequest req = GetCommerceSubscriptionItemListRequest.builder()
                .build();

        GetCommerceSubscriptionItemListResponse res = sdk.commerce().listSubscriptionItems()
                .request(req)
                .call();

        if (res.paginatedCommerceSubscriptionItemResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                   | [GetCommerceSubscriptionItemListRequest](../../models/operations/GetCommerceSubscriptionItemListRequest.md) | :heavy_check_mark:                                                                                          | The request object to use for the request.                                                                  |

### Response

**[GetCommerceSubscriptionItemListResponse](../../models/operations/GetCommerceSubscriptionItemListResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 422             | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |

## cancelSubscriptionItem

Cancel a specific subscription item. The subscription item can be canceled immediately or at the end of the current billing period.

### Example Usage

<!-- UsageSnippet language="java" operationID="CancelCommerceSubscriptionItem" method="delete" path="/commerce/subscription_items/{subscription_item_id}" -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.CancelCommerceSubscriptionItemResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        CancelCommerceSubscriptionItemResponse res = sdk.commerce().cancelSubscriptionItem()
                .subscriptionItemId("<id>")
                .endNow(false)
                .call();

        if (res.commerceSubscriptionItem().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                          | Type                                                                                                               | Required                                                                                                           | Description                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ |
| `subscriptionItemId`                                                                                               | *String*                                                                                                           | :heavy_check_mark:                                                                                                 | The ID of the subscription item to cancel                                                                          |
| `endNow`                                                                                                           | *Optional\<Boolean>*                                                                                               | :heavy_minus_sign:                                                                                                 | Whether to cancel the subscription immediately (true) or at the end of the current billing period (false, default) |

### Response

**[CancelCommerceSubscriptionItemResponse](../../models/operations/CancelCommerceSubscriptionItemResponse.md)**

### Errors

| Error Type                | Status Code               | Content Type              |
| ------------------------- | ------------------------- | ------------------------- |
| models/errors/ClerkErrors | 400, 401, 403, 404, 422   | application/json          |
| models/errors/ClerkErrors | 500                       | application/json          |
| models/errors/SDKError    | 4XX, 5XX                  | \*/\*                     |