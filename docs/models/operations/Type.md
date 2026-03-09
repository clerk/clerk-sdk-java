# Type

The type of the role set. "initial" role sets are the default for new organizations.
Only one role set can be "initial" per instance.

## Example Usage

```java
import com.clerk.backend_api.models.operations.Type;

Type value = Type.INITIAL;
```


## Values

| Name      | Value     |
| --------- | --------- |
| `INITIAL` | initial   |
| `CUSTOM`  | custom    |