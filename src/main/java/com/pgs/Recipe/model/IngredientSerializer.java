package com.pgs.Recipe.model;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class IngredientSerializer extends JsonSerializer<Ingredient> {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void serialize(Ingredient value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		StringWriter writer = new StringWriter();
		mapper.writeValue(writer, value);
		gen.writeFieldName(writer.toString());
		
	}
}
