/*
 * @formatter:off
 * 
 * PMMG - Polícia Militar do Estado de Minas Gerais.
 * DTS - Diretoria de Tecnologia e Sistemas.
 * CTS - Centro de Tecnologia em Sistemas.
 * 
 * Copyright (c) 2017 DTS/CTS.
 * 
 * Este é um software proprietário; não é permitida a distribuição total ou parcial deste código sem a autorização da DTS ou do CTS.
 * Se você recebeu uma cópia, informe-nos através dos contatos abaixo.
 * Site: www.policiamilitar.mg.gov.br
 * DTS/CTS: Avenida Amazonas, 6455 - Gameleira, Belo Horizonte, Minas Gerais
 * E-mail: cts@pmmg.mg.gov.br
 * Telefones: (31) 2123-1133, (31) 2123-1108, (31) 2123-1113
 * 
 * @formatter:on
 */
package br.gov.mg.pmmg.challenge.analista.json;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * An implementation of {@link JsonHandler} for reading and writing
 * <code>JSON<code>.
 */
public class JacksonJsonHandler implements JsonHandler {

	private static final String PT = "pt";

	private static final String BR = "BR";

	private ObjectMapper mapper = new ObjectMapper();

	public JacksonJsonHandler(boolean enableHibernate) {
		Locale locale = new Locale.Builder().setLanguage(PT).setRegion(BR).build();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

		this.mapper.setLocale(locale);
		this.mapper.setDateFormat(dateFormat);

		this.mapper.setSerializationInclusion(Include.NON_NULL);
		this.mapper.setSerializationInclusion(Include.NON_EMPTY);
		
	}

	@Override
	public String toJson(Object obj) {

		try {
			return this.mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Object fromJson(String stringObject, Class<?> clazz) {

		try {
			return this.mapper.readValue(stringObject, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
