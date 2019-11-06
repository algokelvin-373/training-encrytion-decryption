import java.util.*

private const val key = "0123456789abcdef"
private val charset = Charsets.UTF_8
fun main() {
    val person = Person("19967105", "Kelvin Herwanda Tandrio", "Jakarta", "Bengkulu")

    /** Not complete **/
    /*println("Get JSON : \n$jsonPerson")
    val encryptionJson = encryptionAffineCipher(jsonPerson, 19, 157)
    println("Get encryption JSON : $encryptionJson")
    decryptionAffineCipher(encryptionJson, 19, 157)*/

    /** Using DESede, Complete **/
    val jsonPerson = convertToJson(person)
    println("Get JSON : \n$jsonPerson\n")

    val keyValue = key.toByteArray(charset)
    val resultEncryption = encryptionMethod(jsonPerson, keyValue)
    println("Result Encryption : \n$resultEncryption\n")
    println("Result Encryption in Base 64 : \n${Base64.getEncoder().encodeToString(resultEncryption)}\n")

    val resultDecryption = decryptionMethod(resultEncryption, keyValue)
    println("Result Descryption : \n$resultDecryption\n")

    val personData = convertToData(resultDecryption)
    println("Data Person :")
    println("id = ${personData.id}")
    println("name = ${personData.name}")
}