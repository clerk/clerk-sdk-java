# Role


## Fields

| Field                                                            | Type                                                             | Required                                                         | Description                                                      |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| `object`                                                         | [RoleObject](../../models/components/RoleObject.md)              | :heavy_check_mark:                                               | N/A                                                              |
| `id`                                                             | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |
| `name`                                                           | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |
| `key`                                                            | *String*                                                         | :heavy_check_mark:                                               | N/A                                                              |
| `description`                                                    | *Optional\<String>*                                              | :heavy_check_mark:                                               | N/A                                                              |
| `isCreatorEligible`                                              | *boolean*                                                        | :heavy_check_mark:                                               | Whether this role is eligible to be an organization creator role |
| `permissions`                                                    | List\<[Permission](../../models/components/Permission.md)>       | :heavy_check_mark:                                               | N/A                                                              |
| `createdAt`                                                      | *long*                                                           | :heavy_check_mark:                                               | Unix timestamp of creation.<br/>                                 |
| `updatedAt`                                                      | *long*                                                           | :heavy_check_mark:                                               | Unix timestamp of last update.<br/>                              |