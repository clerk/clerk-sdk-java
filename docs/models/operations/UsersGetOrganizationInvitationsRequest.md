# UsersGetOrganizationInvitationsRequest


## Fields

| Field                                                                                                                                     | Type                                                                                                                                      | Required                                                                                                                                  | Description                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `userId`                                                                                                                                  | *String*                                                                                                                                  | :heavy_check_mark:                                                                                                                        | The ID of the user whose organization invitations we want to retrieve                                                                     |
| `limit`                                                                                                                                   | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Applies a limit to the number of results returned.<br/>Can be used for paginating the results together with `offset`.                     |
| `offset`                                                                                                                                  | *Optional\<Long>*                                                                                                                         | :heavy_minus_sign:                                                                                                                        | Skip the first `offset` results when paginating.<br/>Needs to be an integer greater or equal to zero.<br/>To be used in conjunction with `limit`. |
| `status`                                                                                                                                  | [Optional\<QueryParamStatus>](../../models/operations/QueryParamStatus.md)                                                                | :heavy_minus_sign:                                                                                                                        | Filter organization invitations based on their status                                                                                     |