# OrganizationDomainVerification

Verification details for the domain


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `status`                                                                        | [OrganizationDomainStatus](../../models/components/OrganizationDomainStatus.md) | :heavy_check_mark:                                                              | Status of the verification. It can be `unverified` or `verified`                |
| `strategy`                                                                      | *String*                                                                        | :heavy_check_mark:                                                              | Name of the strategy used to verify the domain                                  |
| `attempts`                                                                      | *Optional\<Long>*                                                               | :heavy_check_mark:                                                              | How many attempts have been made to verify the domain                           |
| `expireAt`                                                                      | *Optional\<Long>*                                                               | :heavy_check_mark:                                                              | Unix timestamp of when the verification will expire                             |