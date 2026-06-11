# IdentificationStatus

Controls the status of the replacement email address. Defaults to `verified`. Set to
`reserved` to create it reserved (unverified but usable for sign-in and locked)
instead of verified.

## Example Usage

```java
import com.clerk.backend_api.models.operations.IdentificationStatus;

IdentificationStatus value = IdentificationStatus.VERIFIED;
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `VERIFIED` | verified   |
| `RESERVED` | reserved   |