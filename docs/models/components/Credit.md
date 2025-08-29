# Credit

Credit information (only available in PaymentAttempt events).


## Fields

| Field                                                                                                      | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `amount`                                                                                                   | [JsonNullable\<CommerceSubscriptionItemAmount>](../../models/components/CommerceSubscriptionItemAmount.md) | :heavy_minus_sign:                                                                                         | Credit amount.                                                                                             |
| `cycleRemainingPercent`                                                                                    | *Optional\<Float>*                                                                                         | :heavy_minus_sign:                                                                                         | Percentage of the billing cycle remaining.                                                                 |