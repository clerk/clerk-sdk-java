# VerificationOauthVerificationEnterpriseAccountStatus

## Example Usage

```java
import com.clerk.backend_api.models.components.VerificationOauthVerificationEnterpriseAccountStatus;

VerificationOauthVerificationEnterpriseAccountStatus value = VerificationOauthVerificationEnterpriseAccountStatus.UNVERIFIED;

// Open enum: use .of() to create instances from custom string values
VerificationOauthVerificationEnterpriseAccountStatus custom = VerificationOauthVerificationEnterpriseAccountStatus.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `UNVERIFIED`   | unverified     |
| `VERIFIED`     | verified       |
| `FAILED`       | failed         |
| `EXPIRED`      | expired        |
| `TRANSFERABLE` | transferable   |