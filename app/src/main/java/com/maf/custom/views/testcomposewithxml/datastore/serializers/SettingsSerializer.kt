package com.maf.custom.views.testcomposewithxml.datastore.serializers

import androidx.datastore.core.Serializer
import com.maf.custom.views.testcomposewithxml.datastore.models.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class SettingsSerializer(override val defaultValue: Settings = Settings()) : Serializer<Settings> {

    override suspend fun readFrom(input: InputStream): Settings {
        return try {
            Json.decodeFromString(
                deserializer = Settings.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: Settings, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = Settings.serializer(),
                    value = t,
                ).toByteArray()
            )
        }
    }
}