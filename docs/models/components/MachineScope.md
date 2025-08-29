# MachineScope

Machine scope created successfully for a machine


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `object`                                                            | [MachineScopeObject](../../models/components/MachineScopeObject.md) | :heavy_check_mark:                                                  | N/A                                                                 |
| `fromMachineId`                                                     | *String*                                                            | :heavy_check_mark:                                                  | The ID of the machine that has access to the target machine.        |
| `toMachineId`                                                       | *String*                                                            | :heavy_check_mark:                                                  | The ID of the machine that is being accessed.                       |
| `createdAt`                                                         | *long*                                                              | :heavy_check_mark:                                                  | Unix timestamp of creation.                                         |