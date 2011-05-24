
package ceres.control;

import java.util.ArrayList;
import java.util.HashMap;


public class Profile {

	//lista de campos das tabelas
	private ArrayList<Field> fields;
	private String typeInput;
	private HashMap<String, String> connection = new HashMap<String, String>(); 
	
	public ArrayList<Field> getFields() {
		return fields;
	}
	/**
	 * Adiciona um campo ao profile
	 * @param field Field
	 */
	public void addFields(Field field) {
		this.fields.add(field);
	}
	/**
	 * Seta o tipo de arquivo de entrada para XML
	 */
	public void setTypeInputXML() {
		this.typeInput = "xml";
	}
	/**
	 * Seta o tipo de arquivo de entrada para TXT
	 */
	public void setTypeInputTXT() {
		this.typeInput = "txt";
	}
	/**
	 * Seta o tipo de arquivo de entrada para SQL
	 */
	public void setTypeInputSQL() {
		this.typeInput = "sql";
	}
	/***
	 * Seta o tipo de arquivo de ebtrada para Conexão direta com Banco
	 * @param host String Endereço IP para conexão
	 * @param user String Nome de usuário do banco
	 * @param pass String Senha do usuário
	 * @return Boolean <b>true</b> caso consiga conectar ou <b>false</b> caso ocorra algum erro
	 */
	public void setTypeInputDB(String host, String user,String pass) {
		this.typeInput = "database";
		this.connection.put("host", host);
		this.connection.put("user", user);
		this.connection.put("pass", pass);

	}
	/**
	 * Seta o tipo de arquivo de entrada para XML
	 */
	public String getTypeInput() {
		return typeInput;
	}
}
