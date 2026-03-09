# UpdateRoleSetType

Set to "initial" to make this the default role set for new organizations.
Only one role set can be "initial" per instance; setting this will change any existing initial role set to "custom".

## Example Usage

```java
import com.clerk.backend_api.models.operations.UpdateRoleSetType;

UpdateRoleSetType value = UpdateRoleSetType.INITIAL;
```


## Values

| Name      | Value     |
| --------- | --------- |
| `INITIAL` | initial   |