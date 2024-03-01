package com.example.starwars.utils.json

import com.google.gson.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.lang.reflect.Type


//https://www.javaguides.net/2018/10/gson-custom-serialization-and-deseriliazation-examples.html
internal class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime> {
    private val formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            //.withLocale(Locale.ENGLISH)

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LocalDateTime {
        return LocalDateTime.parse(
            json.asString,
            formatter
        )
    }
}