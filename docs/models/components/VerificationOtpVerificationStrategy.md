# VerificationOtpVerificationStrategy

## Example Usage

```java
import com.clerk.backend_api.models.components.VerificationOtpVerificationStrategy;

VerificationOtpVerificationStrategy value = VerificationOtpVerificationStrategy.PHONE_CODE;

// Open enum: use .of() to create instances from custom string values
VerificationOtpVerificationStrategy custom = VerificationOtpVerificationStrategy.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `PHONE_CODE`                | phone_code                  |
| `EMAIL_CODE`                | email_code                  |
| `RESET_PASSWORD_EMAIL_CODE` | reset_password_email_code   |