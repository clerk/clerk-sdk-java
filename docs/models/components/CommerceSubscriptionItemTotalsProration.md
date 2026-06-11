# CommerceSubscriptionItemTotalsProration

Proration details from passed subscription time


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `amount`                                                                  | [CommerceMoneyResponse](../../models/components/CommerceMoneyResponse.md) | :heavy_check_mark:                                                        | N/A                                                                       |
| `cycleDaysPassed`                                                         | *long*                                                                    | :heavy_check_mark:                                                        | Number of days that have passed in the billing cycle                      |
| `cycleDaysTotal`                                                          | *long*                                                                    | :heavy_check_mark:                                                        | Total number of days in the billing cycle                                 |
| `cyclePassedPercent`                                                      | *double*                                                                  | :heavy_check_mark:                                                        | Percentage of the billing cycle that has passed                           |