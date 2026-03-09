# CommerceCreditBalanceResponse

A payer's credit balance.


## Fields

| Field                                                                    | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `object`                                                                 | *String*                                                                 | :heavy_check_mark:                                                       | String representing the object's type. Always "commerce_credit_balance". |
| `balance`                                                                | [Optional\<Balance>](../../models/components/Balance.md)                 | :heavy_check_mark:                                                       | The current credit balance. Null when the payer has never had credits.   |