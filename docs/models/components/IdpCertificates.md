# IdpCertificates


## Fields

| Field                                                | Type                                                 | Required                                             | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `certificate`                                        | *String*                                             | :heavy_check_mark:                                   | The X.509 certificate, base64 DER without PEM armor  |
| `issuedAt`                                           | *Optional\<Long>*                                    | :heavy_check_mark:                                   | Unix timestamp (milliseconds) of the X.509 NotBefore |
| `expiresAt`                                          | *Optional\<Long>*                                    | :heavy_check_mark:                                   | Unix timestamp (milliseconds) of the X.509 NotAfter  |