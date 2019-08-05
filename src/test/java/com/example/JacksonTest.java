package com.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JacksonTest {
    @Test
    public void testNewJackson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module()); // remove this line and the test will pass
        JsonParser parser = objectMapper.getFactory().createParser(jsonInputStream());
        parseJson(objectMapper, parser);
    }

    private static InputStream jsonInputStream() {
        String jsonString = "{\"foo\":  \"fooValue\", \"bar\":  {\"baz\":  \"bazValue\"}}";
        return new ByteArrayInputStream(jsonString.getBytes());
    }

    private static void parseJson(ObjectMapper objectMapper, JsonParser jsonParser) throws IOException {
        while (!"baz".equals(jsonParser.nextFieldName())) {
            // skipping
        }
        ObjectNode node = objectMapper.readTree(jsonParser);
        assertEquals("bazValue", node.get("baz").asText());
    }
}
