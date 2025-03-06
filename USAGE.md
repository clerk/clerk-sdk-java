<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.clerk.backend_api.Clerk;
import com.clerk.backend_api.models.operations.GetPublicInterstitialRequest;
import com.clerk.backend_api.models.operations.GetPublicInterstitialResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Clerk sdk = Clerk.builder()
            .build();

        GetPublicInterstitialRequest req = GetPublicInterstitialRequest.builder()
                .build();

        GetPublicInterstitialResponse res = sdk.miscellaneous().getPublicInterstitial()
                .request(req)
                .call();

        // handle response
    }
}
```
<!-- End SDK Example Usage [usage] -->