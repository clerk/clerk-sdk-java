# CreateBillingPriceRequest


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `planId`                                                            | *String*                                                            | :heavy_check_mark:                                                  | The ID of the plan this price belongs to.                           |
| `currency`                                                          | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | The currency code (e.g., "USD"). Defaults to USD.                   |
| `amount`                                                            | *long*                                                              | :heavy_check_mark:                                                  | The amount in cents for the price. Must be at least $1 (100 cents). |
| `annualMonthlyAmount`                                               | *Optional\<Long>*                                                   | :heavy_minus_sign:                                                  | The monthly amount in cents when billed annually. Optional.         |
| `description`                                                       | *Optional\<String>*                                                 | :heavy_minus_sign:                                                  | An optional description for this custom price.                      |