# OauthConfig

Present when the enterprise connection uses OIDC


## Fields

| Field                                                           | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `id`                                                            | *Optional\<String>*                                             | :heavy_minus_sign:                                              | OAuth config ID                                                 |
| `name`                                                          | *Optional\<String>*                                             | :heavy_minus_sign:                                              | Custom OIDC provider display name                               |
| `providerKey`                                                   | *Optional\<String>*                                             | :heavy_minus_sign:                                              | OAuth provider key (e.g. oidc_custom)                           |
| `clientId`                                                      | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | OAuth client ID                                                 |
| `discoveryUrl`                                                  | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | OIDC discovery URL                                              |
| `logoPublicUrl`                                                 | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | Logo URL for the provider                                       |
| `createdAt`                                                     | *Optional\<Long>*                                               | :heavy_minus_sign:                                              | Unix timestamp in milliseconds when the config was created      |
| `updatedAt`                                                     | *Optional\<Long>*                                               | :heavy_minus_sign:                                              | Unix timestamp in milliseconds when the config was last updated |