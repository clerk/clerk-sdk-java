# GetTemplateRequest


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `templateType`                                                            | [PathParamTemplateType](../../models/operations/PathParamTemplateType.md) | :heavy_check_mark:                                                        | The type of templates to retrieve (email or SMS)                          |
| `slug`                                                                    | *String*                                                                  | :heavy_check_mark:                                                        | The slug (i.e. machine-friendly name) of the template to retrieve         |