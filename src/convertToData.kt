import com.google.gson.Gson

fun convertToData(dataJSON: String): Person {
    val gson = Gson()
    val person = gson.fromJson(dataJSON, Person::class.java)
    return person
}