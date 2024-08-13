# Admin


## Fields

| Field                                                                         | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `status`                                                                      | [AdminVerificationStatus](../../models/components/AdminVerificationStatus.md) | :heavy_check_mark:                                                            | N/A                                                                           |
| `strategy`                                                                    | [VerificationStrategy](../../models/components/VerificationStrategy.md)       | :heavy_check_mark:                                                            | N/A                                                                           |
| `attempts`                                                                    | *JsonNullable<Long>*                                                          | :heavy_minus_sign:                                                            | N/A                                                                           |
| `expireAt`                                                                    | *JsonNullable<Long>*                                                          | :heavy_minus_sign:                                                            | N/A                                                                           |