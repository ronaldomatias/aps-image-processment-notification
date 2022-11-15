package com.aps.rabbit.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdJsonSerializer extends JsonSerializer<ObjectId> {
    public ObjectIdJsonSerializer() {
    }

    public void serialize(ObjectId o, JsonGenerator j, SerializerProvider s) throws IOException {
        if (o == null) {
            j.writeNull();
        } else {
            j.writeString(o.toString());
        }

    }
}