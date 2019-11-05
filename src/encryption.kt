
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