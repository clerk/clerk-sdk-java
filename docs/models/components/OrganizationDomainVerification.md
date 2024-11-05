# OrganizationDomainVerification

Verification details for the domain


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `status`                                                                                   | [Optional\<OrganizationDomainStatus>](../../models/components/OrganizationDomainStatus.md) | :heavy_minus_sign:                                                                         | Status of the verification. It can be `unverified` or `verified`                           |
| `strategy`                                                                                 | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | Name of the strategy used to verify the domain                                             |
| `attempts`                                                                                 | *Optional\<Long>*                                                                          | :heavy_minus_sign:                                                                         | How many attempts have been made to verify the domain                                      |
| `expireAt`                                                                                 | *JsonNullable\<Long>*                                                                      | :heavy_minus_sign:                                                                         | Unix timestamp of when the verification will expire                                        |