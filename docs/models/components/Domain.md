# Domain


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `object`                                                    | [DomainObject](../../models/components/DomainObject.md)     | :heavy_check_mark:                                          | N/A                                                         |
| `id`                                                        | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `name`                                                      | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `isSatellite`                                               | *boolean*                                                   | :heavy_check_mark:                                          | N/A                                                         |
| `frontendApiUrl`                                            | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `accountsPortalUrl`                                         | *JsonNullable<String>*                                      | :heavy_minus_sign:                                          | Null for satellite domains.<br/>                            |
| `proxyUrl`                                                  | *JsonNullable<String>*                                      | :heavy_minus_sign:                                          | N/A                                                         |
| `developmentOrigin`                                         | *String*                                                    | :heavy_check_mark:                                          | N/A                                                         |
| `cnameTargets`                                              | List<[CNameTarget](../../models/components/CNameTarget.md)> | :heavy_minus_sign:                                          | N/A                                                         |