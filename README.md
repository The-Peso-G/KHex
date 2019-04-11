# KHex
KHex is a Kotlin multiplatform library to deal with hexadecimal values.

It was written as part of [KEthereum](https://github.com/komputing/KEthereum) but then extracted as it can be useful 
outside this context and deduplicate code this way.

## Supported platforms
| Module | Supported platforms |
| :------- | :-------: |
| `khex` | `common`, `jvm`, `js`, `native` |
| `khex-extensions` | `common`, `jvm`, `js`, `native` | 


# Usage
## As an Object
You can the `Hex` class contained inside this library asa common Kotlin object in order to encode or decode any 
hexadecimal value.
 
```kotlin
// === Encoding ===

val myByteValue = 31.toByte()
Hex.encode(myByteValue)

val myByteArrayValue = byteArrayOf(31, 32 , 33)
Hex.encode(myByteArrayValue)


// === Decoding ===

val myHexString = "0xaa12456789bb"
Hex.decode(myHexString)
```

## As extension functions
By including the `khex-extensions` module, you will be able to access a list of extensions functions that can be useful when 
working with strings and byte arrays/lists.

```kotlin
// === ByteArray ===
byteArrayOf(1, 2, 3).toHexString(prefix = "0x")
byteArrayOf(1, 2, 3).toNoPrefixHexString()

// === List<Byte> ===
listOf(1.toByte(), 2.toByte()).toHexString(prefix = "0x")
listOf(1.toByte(), 2.toByte()).toNoPrefixHexString()

// === String ===
"0xaa12456789bb".hexToByteArray()
"0xaa12456789bb".has0xPrefix()
"aa12456789bb".prepend0xPrefix()
"0xaa12456789bb".clean0xPrefix()

```  

# License
MIT
