# ~~UserDirectory~~

The most recently updated directory link. Use directories for all links.

> :warning: **DEPRECATED**: This will be removed in a future release, please migrate away from it as soon as possible.


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `id`                                                                            | *String*                                                                        | :heavy_check_mark:                                                              | The user's resource ID in this directory.                                       |
| `directoryName`                                                                 | *String*                                                                        | :heavy_check_mark:                                                              | N/A                                                                             |
| `provider`                                                                      | *String*                                                                        | :heavy_check_mark:                                                              | N/A                                                                             |
| `enterpriseConnectionId`                                                        | *Optional\<String>*                                                             | :heavy_check_mark:                                                              | N/A                                                                             |
| `groups`                                                                        | List\<[UserGroups](../../models/components/UserGroups.md)>                      | :heavy_minus_sign:                                                              | Omitted when groups were not loaded; an empty array means no group memberships. |
| `directoryId`                                                                   | *String*                                                                        | :heavy_check_mark:                                                              | The ID of the directory the user is provisioned from.<br/>                      |
| `directoryEnabled`                                                              | *boolean*                                                                       | :heavy_check_mark:                                                              | Whether the directory is currently enabled.<br/>                                |
| `externalId`                                                                    | *Optional\<String>*                                                             | :heavy_check_mark:                                                              | The user's external ID as reported by the directory, if any.<br/>               |