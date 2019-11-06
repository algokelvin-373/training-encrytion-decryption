import com.google.gson.GsonBuilder

/** For individual parameters **/
fun convertToJson(person: Person): String {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonPerson = gson.toJson(person)
    return jsonPerson
}

fun<T> convertToJson(data: T): String {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonPerson = gson.toJson(data)
    return jsonPerson
}