# UserCursorPage

A page of users from `GET /v1/users` with `pagination=cursor`.


## Fields

| Field                                          | Type                                           | Required                                       | Description                                    |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| `data`                                         | List\<[User](../../models/components/User.md)> | :heavy_check_mark:                             | N/A                                            |
| `cursor`                                       | [Cursor](../../models/components/Cursor.md)    | :heavy_check_mark:                             | Cursor information for pagination.             |