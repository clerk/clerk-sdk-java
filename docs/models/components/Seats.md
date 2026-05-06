# Seats

Seat quantity for seat-based billing.


## Fields

| Field                                                                                  | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `quantity`                                                                             | *Optional\<Long>*                                                                      | :heavy_check_mark:                                                                     | Seat quantity being billed; null means unlimited                                       |
| `tiers`                                                                                | List\<[CommercePerUnitTotalTier](../../models/components/CommercePerUnitTotalTier.md)> | :heavy_minus_sign:                                                                     | Per-unit cost breakdown by pricing tier                                                |