# NextPayment

Information about the next payment.


## Fields

| Field                                                                                                      | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `amount`                                                                                                   | [JsonNullable\<CommerceSubscriptionItemAmount>](../../models/components/CommerceSubscriptionItemAmount.md) | :heavy_minus_sign:                                                                                         | Amount for the next payment.                                                                               |
| `date`                                                                                                     | *JsonNullable\<Long>*                                                                                      | :heavy_minus_sign:                                                                                         | Unix timestamp (in milliseconds) for the next payment date.                                                |