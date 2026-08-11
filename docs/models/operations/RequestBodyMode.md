# RequestBodyMode

Controls the login_hint sent to the IdP on SSO sign-in

## Example Usage

```java
import com.clerk.backend_api.models.operations.RequestBodyMode;

RequestBodyMode value = RequestBodyMode.EMAIL_ADDRESS;
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `EMAIL_ADDRESS`    | email_address      |
| `CUSTOM_ATTRIBUTE` | custom_attribute   |
| `OFF`              | off                |