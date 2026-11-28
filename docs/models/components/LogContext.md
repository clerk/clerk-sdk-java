# LogContext

Context information about the environment and device where the event occurred.


## Fields

| Field                                                                                | Type                                                                                 | Required                                                                             | Description                                                                          |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `environment`                                                                        | [Optional\<LogEnvironmentContext>](../../models/components/LogEnvironmentContext.md) | :heavy_minus_sign:                                                                   | Environment context for the log event.                                               |
| `device`                                                                             | [Optional\<LogDeviceContext>](../../models/components/LogDeviceContext.md)           | :heavy_minus_sign:                                                                   | Device information for the log event.                                                |