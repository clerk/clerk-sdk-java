<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.errors.ClerkErrors;
import com.clerk.backend_api.models.operations.GetEmailAddressResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ClerkErrors, Exception {

        Clerk sdk = Clerk.builder()
                .bearerAuth(System.getenv().getOrDefault("BEARER_AUTH", ""))
            .build();

        GetEmailAddressResponse res = sdk.emailAddresses().get()
                .emailAddressId("<id>")
                .call();

        if (res.emailAddress().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->