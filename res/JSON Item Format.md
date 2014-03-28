JSON Item Format Syntax
=======================
This describe how data are represented in GW2 API v1 with JSON format.
There are several type of syntax for each type of data.

- `List`, `Array` are represented with `[ ]`
- `Object`, `Class` are represented with `{ }`
- `Property`, `Field` are represented as `"name":"value"`

Then, for exemple, a class containing a property, an object (with one property), a list of object and a list of properties should be write as :
```json
"class":{
    "property name":"property value",
    "object name":{
        ...
    },
    "object list name":[
        {
            "property name":"property value"
        },
        ...
    ],
    "property list name":[
        "property name":"property value",
        ...
    ]
}
```

-----

## [ITEM][1]
The following properties are common to all item.
Name              |Type                 |Value
:-----------------|:--------------------|:--------------------------
*item_id*         | `Long`              |
*name*            | `String`            |
*description*     | `String`            |
*type*            | `Type`              | <sub>ARMOR` `BACK` `BAG` `CONSUMABLE` `CONTAINER` `CRAFTMATERIALK` `GATHERING` `GIZMO` `MINIPET` `TOOL` `TRINKET` `TROPHY` `UPGRADE_COMPONENT` `WEAPON</sub>
*level*           | `Integer`           |
*rarity*          | `Rarity`            | <sub>BASIC` `FINE` `MASTERWORK` `RARE` `EXOTIC` `ASCENDED` `LEGENDARY` `JUNK</sub>
*vendor_value*    | `Integer`           |
*game_types*      | `List<GameType>`    | <sub>ACTIVITY` `PVE` `PVP` `DUNGEONS` `WVW</sub>
*flags*           |  `List<Flag>`       | <sub>ACCOUNT_BOUND` `SOULD_BIND_ON_USE` `HIDE_SUFFIX` `NO_SALVAGE` `NO_SELL` `SOULD_BIND_ON_ACQUIRE` `NO_UNDERWATER` `NO_MYSTIC_FORGE` `NOT_UPGRADEABLE` `UNIQUE</sub>
*restrictions*    | `List<Restriction>` | <sub>ASURA` `HUMAN` `NORN` `CHARR` `SYLVARI` `GUARDIAN` `WARRIOR</sub>

Then an optional, according to the item type, json object can be added next to the restrictions. For each item type which expends the item object, an object property named like the type is added. Ex: for an armor item, `"armor":{ ... }` is added next to `restrictions` property

### [ARMOR][2]

The following properties are used to define an armor item. Start with `"armor":{ ... }`.
Name               | | |Type                      |Value
:------------------|-|-|:-------------------------|:--------------------------
*type*             | | | `ArmorType`              | <sub>CAOT` `BOOTS` `HELM` `SHOULDERS` `GLOVES` `LEGGINGS` `HELM_AQUATIC</sub>
*weight_class*     | | | `WeightClass`            | <sub>LIGHT` `MEDIUM` `HEAVY` `CLOTHING</sub>
*defense*          | | | `Integer`                |
*infusion_slots*   | | | `List<InfusionSlot>`     |
| | *flags*          | | `List<InfusionSlotFlag>` | <sub>DEFENSE` `OFFENSE` `UTILITY</sub>
| | *item_id*        | | `Long`                   |
*infix_upgrade*    | | | `InfixUpgrade`           |
| | *buff*           | | `Buff`                   |
| | | *skill_id*       | `Integer`                |
| | | *description*    | `String`                 |
| | *attributes*     | | `List<Attribute>`        |
| | | *attribute*      | `AttributeType`          | <sub>POWER` `PRECISION` `CONDITION_DAMAGE` `TOUGHNESS` `VITALITY` `CRITICAL_DAMAGE` `HEALING_POWER</sub>
| | | *modifier*       | `Integer`                |
*suffix_item_id*   | | | `String`                 |


### [CONSUMABLE][3]
The following properties are used to define a consumable item. Start with `"consumable":{ ... }`.
Name               | | |Type                      |Value
:------------------|-|-|:-------------------------|:--------------------------
*type*             | | | `ConsumableType`         | <sub>UNLOCK` `GENERIC` `FOOD` `UTILITY` `TRANSMUTATION` `APPEARANCE_CHANGE` `CONTRACT_NPC` `HALLOWEEN` `IMMEDIATE` `BOOZE</sub>




----------------------------------------------------

> **`WhyT`** | **[`GitHub`][4]** | **[`Mail`][5]**


  [1]: https://github.com/WhyTSwag/GW2/blob/master/src/fr/whyt/item/Item.java "{@Link Item.java}"
  [2]: https://github.com/WhyTSwag/GW2/blob/master/src/fr/whyt/item/extend/Armor.java "{@Link Armor.java}"
  [3]: https://github.com/WhyTSwag/GW2/blob/master/src/fr/whyt/item/extend/Consumable.java "{@Link Consumable.java}"
  [4]: https://github.com/WhyTSwag "My WhyT GitHub"
  [5]: mailto:whyt.swag@gmail.com?subject=[Contact&nbsp;from&nbsp;Stackedit.io]&body=E-mail&nbsp;sent&nbsp;from&nbsp;Stacked.io&nbsp;signature. "Mail Me"