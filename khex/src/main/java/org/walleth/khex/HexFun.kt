package org.walleth.khex

/**
 *  chars for nibble
 */
private const val CHARS = "0123456789abcdef"

val HEX_REGEX= Regex("0[xX][0-9a-fA-F]+")

/**
 *  Returns 2 char hex string for Byte
 */
fun Byte.toHexString() = toInt().let {
    CHARS[it.shr(4) and 0x0f].toString() + CHARS[it.and(0x0f)].toString()
}

fun Char.fromHexToInt() = CHARS.indexOf(this)

fun ByteArray.toHexString(prefix: String = "0x") = prefix + map { it.toHexString() }.joinToString("")
fun List<Byte>.toHexString(prefix: String = "0x") = toByteArray().toHexString(prefix)

fun ByteArray.toNoPrefixHexString() = toHexString("")
fun List<Byte>.toNoPrefixHexString() = toHexString("")

fun String.hexToByteArray(): ByteArray {
    if (length % 2 != 0)
        throw IllegalArgumentException("hex-string must have an even number of digits (nibbles)")

    val cleanInput = if (startsWith("0x")) substring(2) else this

    return ByteArray(cleanInput.length / 2).apply {
        var i = 0
        while (i < cleanInput.length) {
            this[i / 2] = ((Character.digit(cleanInput[i], 16) shl 4) + Character.digit(cleanInput[i + 1], 16)).toByte()
            i += 2
        }
    }
}

fun String.has0xPrefix() = startsWith("0x")
fun String.prepend0xPrefix() = if (has0xPrefix()) this else "0x$this"
fun String.clean0xPrefix() = if (has0xPrefix()) this.substring(2) else this