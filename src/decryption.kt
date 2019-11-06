import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun decryptionAffineCipher(wordEncode: String, keyOne: Int, keyTwo: Int) {
    val decryption = ""
    val inverse = getInverseModulo(keyOne)
    println("Key = $inverse")

    for (i in 0 until wordEncode.length) {
        val de = (inverse * (wordEncode[i].toInt() - keyTwo)) % 128
        println("$i -> ${wordEncode[i]}, ${wordEncode[i].toInt()} => ${de.toChar()}")
    }
}

fun getInverseModulo(x: Int): Int {
    var key = 0
    for (i in 0..128) {
        val y = (x * key) % 128
        if (y == 1) break
        key++
    }
    return key
}

fun decryptionMethod(dataEncode: ByteArray, keyValue: ByteArray): String {
    Security.addProvider(BouncyCastleProvider())
    val key = SecretKeySpec(keyValue, "DESede")
    val cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, key)
    val decVal = cipher.doFinal(dataEncode)
    return String(decVal)
}