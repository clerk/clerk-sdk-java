# CommercePlanUnitPriceTier


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `startsAtBlock`                                                           | *long*                                                                    | :heavy_check_mark:                                                        | Start block (inclusive) for this tier                                     |
| `endsAfterBlock`                                                          | *JsonNullable\<Long>*                                                     | :heavy_minus_sign:                                                        | End block (inclusive) for this tier; null means unlimited                 |
| `feePerBlock`                                                             | [CommerceMoneyResponse](../../models/components/CommerceMoneyResponse.md) | :heavy_check_mark:                                                        | N/A                                                                       |