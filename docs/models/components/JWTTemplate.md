# JWTTemplate

List of JWT templates


## Fields

| Field                                                             | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `object`                                                          | [JWTTemplateObject](../../models/components/JWTTemplateObject.md) | :heavy_check_mark:                                                | N/A                                                               |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | N/A                                                               |
| `name`                                                            | *String*                                                          | :heavy_check_mark:                                                | N/A                                                               |
| `claims`                                                          | [Claims](../../models/components/Claims.md)                       | :heavy_check_mark:                                                | N/A                                                               |
| `lifetime`                                                        | *long*                                                            | :heavy_check_mark:                                                | N/A                                                               |
| `allowedClockSkew`                                                | *long*                                                            | :heavy_check_mark:                                                | N/A                                                               |
| `customSigningKey`                                                | *boolean*                                                         | :heavy_check_mark:                                                | N/A                                                               |
| `signingAlgorithm`                                                | *String*                                                          | :heavy_check_mark:                                                | N/A                                                               |
| `createdAt`                                                       | *long*                                                            | :heavy_check_mark:                                                | Unix timestamp of creation.<br/>                                  |
| `updatedAt`                                                       | *long*                                                            | :heavy_check_mark:                                                | Unix timestamp of last update.<br/>                               |