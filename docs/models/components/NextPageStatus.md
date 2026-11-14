# NextPageStatus

Pagination status. "true" means more results exist, "false" means no more results, "unknown" means the query was time-windowed and more results may exist beyond the window.

## Example Usage

```java
import com.clerk.backend_api.models.components.NextPageStatus;

NextPageStatus value = NextPageStatus.TRUE;
```


## Values

| Name      | Value     |
| --------- | --------- |
| `TRUE`    | true      |
| `FALSE`   | false     |
| `UNKNOWN` | unknown   |