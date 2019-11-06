import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/** Encryption Affine Cipher **/
fun encryptionAffineCipher(word: String, keyOne: Int, keyTwo: Int): String {
    var encryption = ""
    for (x in 0 until word.length) {
        val en = ((keyOne * word[x].toInt()) + keyTwo) % 128
        encryption += when {
            en < 32 -> word[x].toString()
            else -> en.toChar().toString()
        }
        println("$x -> ${word[x]} , ${word[x].toInt()} => $encryption")
    }
    return encryption
}

/** Encryption DESede Methods **/
fun encryptionMethod(data: String, keyValue: ByteArray): ByteArray {
    Security.addProvider(BouncyCastleProvider())
    val key = SecretKeySpec(keyValue, "DESede")
    val cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val encVal = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
    return encVal
}