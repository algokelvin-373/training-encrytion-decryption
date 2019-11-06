import com.google.gson.Gson

fun convertToData(dataJSON: String): Person {
    val gson = Gson()
    val person = gson.fromJson(dataJSON, Person::class.java)
    return person
}

fun <T> convertToData(dataJSON: String, dataModel: Class<T>): T {
    val gson = Gson()
    val data = gson.fromJson(dataJSON, dataModel)
    return data
}