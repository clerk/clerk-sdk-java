# MachineScopeDeleted

Machine scope deleted successfully for a machine


## Fields

| Field                                                                             | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `object`                                                                          | [MachineScopeDeletedObject](../../models/components/MachineScopeDeletedObject.md) | :heavy_check_mark:                                                                | String representing the object's type.                                            |
| `fromMachineId`                                                                   | *String*                                                                          | :heavy_check_mark:                                                                | The ID of the machine that had access to the target machine                       |
| `toMachineId`                                                                     | *String*                                                                          | :heavy_check_mark:                                                                | The ID of the machine that was being accessed                                     |
| `deleted`                                                                         | *boolean*                                                                         | :heavy_check_mark:                                                                | Whether the machine scope was successfully deleted                                |