# Act

The actor chain of an access token issued by an OAuth 2.0 Token Exchange (RFC 8693 section 4.1). Omitted for other access tokens.


## Fields

| Field                                                                    | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `iss`                                                                    | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | N/A                                                                      |
| `sub`                                                                    | *String*                                                                 | :heavy_check_mark:                                                       | N/A                                                                      |
| `act`                                                                    | [Optional\<ResponseBodyAct>](../../models/operations/ResponseBodyAct.md) | :heavy_minus_sign:                                                       | N/A                                                                      |