import java.util.*

private const val key = "0123456789abcdef"
private val charset = Charsets.UTF_8
fun main() {
    val person = Person("19967105", "Kelvin Herwanda Tandrio", "Jakarta", "Bengkulu")
    val teacher = Teacher("098555444", "Mr. Heri", "Computer Vision")

    /** Not complete **/
    /*println("Get JSON : \n$jsonPerson")
    val encryptionJson = encryptionAffineCipher(jsonPerson, 19, 157)
    println("Get encryption JSON : $encryptionJson")
    decryptionAffineCipher(encryptionJson, 19, 157)*/

    /** Using DESede, Complete **/
    /*val jsonPerson = convertToJson(person)
    println("Get JSON : \n$jsonPerson\n")

    val keyValue = key.toByteArray(charset)
    val resultEncryption = encryptionMethod(jsonPerson, keyValue)
    println("Result Encryption : \n$resultEncryption\n")
    println("Result Encryption in Base 64 : \n${Base64.getEncoder().encodeToString(resultEncryption)}\n")

    val resultDecryption = decryptionMethod(resultEncryption, keyValue)
    println("Result Decryption : \n$resultDecryption\n")

    val personData = convertToData(resultDecryption)
    println("Data Person :")
    println("id = ${personData.id}")
    println("name = ${personData.name}")*/

    /** Encode and Decode using function multi data model **/
    val jsonPerson = convertToJson(person)
    val jsonTeacher = convertToJson(teacher)
    val keyValue = key.toByteArray(charset)

    println("For Person :")
    println("Get JSON : \n$jsonPerson\n")
    val resultEncryptionPerson = encryptionMethod(jsonPerson, keyValue)
    println("Result Encryption Person : $resultEncryptionPerson")
    println("Result Encryption Person in Base 64 : ${Base64.getEncoder().encodeToString(resultEncryptionPerson)}")
    val resultDecryptionPerson = decryptionMethod(resultEncryptionPerson, keyValue)
    println("Result Decryption Person : \n$resultDecryptionPerson\n")
    val personData = convertToData(resultDecryptionPerson, Person::class.java)
    println("id = ${personData.id}")
    println("name = ${personData.name}")

    println("For Teacher :")
    println("Get JSON : \n$jsonTeacher\n")
    val resultEncryptionTeacher = encryptionMethod(jsonTeacher, keyValue)
    println("Result Encryption Teacher : $resultEncryptionTeacher")
    println("Result Encryption Teacher in Base 64 : ${Base64.getEncoder().encodeToString(resultEncryptionTeacher)}")
    val resultDecryptionTeacher = decryptionMethod(resultEncryptionTeacher, keyValue)
    println("Result Decryption Person : \n$resultDecryptionTeacher\n")
    val teacherData = convertToData(resultDecryptionTeacher, Teacher::class.java)
    println("id = ${teacherData.id}")
    println("name = ${teacherData.name}")
}