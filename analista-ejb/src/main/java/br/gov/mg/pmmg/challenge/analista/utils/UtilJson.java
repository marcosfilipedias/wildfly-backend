package br.gov.mg.pmmg.challenge.analista.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilJson {

	private static ObjectMapper mapper = new ObjectMapper();
	
	private UtilJson(){}
	
	/**
	 * 
	 * @param objParam
	 * @return
	 */
	public static String objToJson(Object objParam){
		String strResult = null;

		if (objParam != null){

			try {
				strResult = mapper.writeValueAsString(objParam);
			} catch (IOException e) {
				Logger.getLogger(UtilJson.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return strResult;
	}

	/**
	 * 
	 * @param brJsonParam
	 * @param classe
	 * @return
	 */
	public static <T> T jsonToOjb(BufferedReader brJsonParam, Class<? extends Object> classe){
		StringBuilder sbTexto = new StringBuilder();
		String line;
		try {
			while ((line = brJsonParam.readLine()) != null) {
				sbTexto.append(line);
			}
		} catch (IOException e) {
			Logger.getLogger(UtilJson.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return jsonToOjb(sbTexto.toString(), classe);
	}
	
	/**
	 * 
	 * @param strJsonParam
	 * @param classe
	 * @return
	 */
	public static <T> T jsonToOjb(String strJsonParam, Class<? extends Object> classe){
		Object objResult = null;

		if (strJsonParam != null && classe != null){

			try {
				objResult = mapper.readValue(strJsonParam, classe);			
			} catch (IOException e) {
				Logger.getLogger(UtilJson.class.getName()).log(Level.SEVERE, null, e);
			} 
		}
		
		try {
			@SuppressWarnings("unchecked")
			T tResult = (T) objResult;
	        return tResult;
	    } catch(ClassCastException e) {
	        return null;
	    }
	}
}
