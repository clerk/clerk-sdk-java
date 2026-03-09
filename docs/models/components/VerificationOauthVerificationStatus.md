# VerificationOauthVerificationStatus

## Example Usage

```java
import com.clerk.backend_api.models.components.VerificationOauthVerificationStatus;

VerificationOauthVerificationStatus value = VerificationOauthVerificationStatus.UNVERIFIED;

// Open enum: use .of() to create instances from custom string values
VerificationOauthVerificationStatus custom = VerificationOauthVerificationStatus.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `UNVERIFIED`   | unverified     |
| `VERIFIED`     | verified       |
| `FAILED`       | failed         |
| `EXPIRED`      | expired        |
| `TRANSFERABLE` | transferable   |