# CreateBillingPriceRequestSupportedBillingPeriods

Which billing periods this price supports. Inferred from amounts if omitted.

## Example Usage

```java
import com.clerk.backend_api.models.components.CreateBillingPriceRequestSupportedBillingPeriods;

CreateBillingPriceRequestSupportedBillingPeriods value = CreateBillingPriceRequestSupportedBillingPeriods.MONTH;
```


## Values

| Name     | Value    |
| -------- | -------- |
| `MONTH`  | month    |
| `ANNUAL` | annual   |
| `BOTH`   | both     |