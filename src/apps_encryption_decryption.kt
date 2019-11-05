
fun main() {
    val person = Person("19967105", "Kelvin Herwanda Tandrio", "Jakarta", "Bengkulu")
    val jsonPerson = "kelvin"
    println("Get JSON : \n$jsonPerson")
    val encryptionJson = encryptionAffineCipher(jsonPerson, 19, 157)
    println("Get encryption JSON : $encryptionJson")
    decryptionAffineCipher(encryptionJson, 19, 157)
}