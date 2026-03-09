# EmailAddressObject

String representing the object's type. Objects of the same type share the same value.


## Example Usage

```java
import com.clerk.backend_api.models.components.EmailAddressObject;

EmailAddressObject value = EmailAddressObject.EMAIL_ADDRESS;

// Open enum: use .of() to create instances from custom string values
EmailAddressObject custom = EmailAddressObject.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `EMAIL_ADDRESS` | email_address   |