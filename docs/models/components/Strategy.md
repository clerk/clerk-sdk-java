# Strategy

## Example Usage

```java
import com.clerk.backend_api.models.components.Strategy;

Strategy value = Strategy.PHONE_CODE;

// Open enum: use .of() to create instances from custom string values
Strategy custom = Strategy.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `PHONE_CODE`                | phone_code                  |
| `EMAIL_CODE`                | email_code                  |
| `RESET_PASSWORD_EMAIL_CODE` | reset_password_email_code   |