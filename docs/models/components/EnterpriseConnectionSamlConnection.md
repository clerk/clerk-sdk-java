# EnterpriseConnectionSamlConnection

Present when the enterprise connection uses SAML


## Fields

| Field                                                           | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `id`                                                            | *Optional\<String>*                                             | :heavy_minus_sign:                                              | SAML connection ID                                              |
| `name`                                                          | *Optional\<String>*                                             | :heavy_minus_sign:                                              | SAML connection display name                                    |
| `idpEntityId`                                                   | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | IdP entity ID (optional, when connection details are loaded)    |
| `idpSsoUrl`                                                     | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | IdP SSO URL (optional, when connection details are loaded)      |
| `idpMetadataUrl`                                                | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | IdP metadata URL (optional, when connection details are loaded) |
| `acsUrl`                                                        | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | Assertion Consumer Service URL                                  |
| `spEntityId`                                                    | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | Service Provider entity ID                                      |
| `spMetadataUrl`                                                 | *JsonNullable\<String>*                                         | :heavy_minus_sign:                                              | Service Provider metadata URL                                   |
| `active`                                                        | *Optional\<Boolean>*                                            | :heavy_minus_sign:                                              | Whether the SAML connection is active                           |
| `allowIdpInitiated`                                             | *Optional\<Boolean>*                                            | :heavy_minus_sign:                                              | Whether IdP-initiated SSO is allowed                            |
| `allowSubdomains`                                               | *Optional\<Boolean>*                                            | :heavy_minus_sign:                                              | Whether subdomains are allowed for domain matching              |
| `forceAuthn`                                                    | *Optional\<Boolean>*                                            | :heavy_minus_sign:                                              | Whether to force re-authentication                              |