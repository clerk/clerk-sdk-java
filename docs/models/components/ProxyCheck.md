# ProxyCheck

Health check information about a domain's proxy configuration validation attempt.


## Fields

| Field                                                           | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `object`                                                        | [ProxyCheckObject](../../models/components/ProxyCheckObject.md) | :heavy_check_mark:                                              | N/A                                                             |
| `id`                                                            | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `domainId`                                                      | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `lastRunAt`                                                     | *Optional\<Long>*                                               | :heavy_check_mark:                                              | Unix timestamp of last run.<br/>                                |
| `proxyUrl`                                                      | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `successful`                                                    | *boolean*                                                       | :heavy_check_mark:                                              | N/A                                                             |
| `createdAt`                                                     | *long*                                                          | :heavy_check_mark:                                              | Unix timestamp of creation.<br/>                                |
| `updatedAt`                                                     | *long*                                                          | :heavy_check_mark:                                              | Unix timestamp of last update.<br/>                             |