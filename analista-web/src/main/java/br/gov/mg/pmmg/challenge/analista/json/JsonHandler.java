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

/**
 * An abstraction to deal with serialization and deserialization of objects to/from JSON.
 * Reference:
 * http://www.javaindeed.com/getting-started-with-json-b/?elq_mid=69404&sh=2426915128252692422151512815415748&cmid=WWMK160429P00027
 */
public interface JsonHandler {

	/**
	 * Parse an object to JSON format.
	 * @param obj object to be parsed.
	 * @return object parsed.
	 * @throws ParseException when parse cannot be executed.
	 */
	public String toJson(Object obj);

	/**
	 * Parse a JSON string to object.
	 * @param stringObject an object represented by his string format.
	 * @param clazz class reference of string object.
	 * @return an object
	 * @throws ParseException when parse cannot be executed.
	 */
	public Object fromJson(String stringObject, Class<?> clazz);

}
