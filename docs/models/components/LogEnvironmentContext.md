# LogEnvironmentContext

Environment context for the log event.


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `type`                                                                               | *JsonNullable\<String>*                                                              | :heavy_minus_sign:                                                                   | The environment type (e.g., "development", "production").                            |
| `application`                                                                        | [Optional\<LogApplicationContext>](../../models/components/LogApplicationContext.md) | :heavy_minus_sign:                                                                   | Application context information.                                                     |
| `domain`                                                                             | [Optional\<LogDomainContext>](../../models/components/LogDomainContext.md)           | :heavy_minus_sign:                                                                   | Domain context information.                                                          |
| `primaryDomain`                                                                      | [Optional\<LogDomainContext>](../../models/components/LogDomainContext.md)           | :heavy_minus_sign:                                                                   | Domain context information.                                                          |