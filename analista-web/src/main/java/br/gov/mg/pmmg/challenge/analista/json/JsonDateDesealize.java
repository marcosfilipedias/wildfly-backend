package br.gov.mg.pmmg.challenge.analista.json;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class JsonDateDesealize implements JsonDeserializer<Date>{
	
	@Override
	public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		String date = element.getAsString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			try {
				String datex = element.getAsString();

				long i = Long.parseLong(datex);

				Date data = new Date(i);

				return data;
			} catch (Exception e2) {
				return null;
			}

		}
	}

}
