# OAuthApplicationSettings

Success


## Fields

| Field                                                                                                   | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `object`                                                                                                | [OAuthApplicationSettingsObject](../../models/components/OAuthApplicationSettingsObject.md)             | :heavy_check_mark:                                                                                      | String representing the object's type. Objects of the same type share the same value.                   |
| `dynamicOauthClientRegistration`                                                                        | *boolean*                                                                                               | :heavy_check_mark:                                                                                      | Whether dynamic OAuth client registration is enabled for the instance (RFC 7591).                       |
| `oauthJwtAccessTokens`                                                                                  | *boolean*                                                                                               | :heavy_check_mark:                                                                                      | Whether OAuth JWT access tokens are enabled for the instance (disabled indicates opaque access tokens). |