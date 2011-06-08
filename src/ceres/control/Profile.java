package ceres.control;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile {

	// Aplicação do padrão Singleton
	private static Profile uniqueInstance;

	// lista de campos das tabelas
	private ArrayList<Field> fields;
	private HashMap<String, String> connection = new HashMap<String, String>();

	// Aplicação do padrão Singleton
	private Profile() {}

	// Aplicação do padrão Singleton
	public static Profile getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Profile();
		}
		return uniqueInstance;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}

	/**
	 * Adiciona um campo ao profile
	 * 
	 * @param field
	 *            Field
	 */
	public void addFields(Field field) {
		this.fields.add(field);
	}
	
	/***
	 * Seta o tipo de arquivo de entrada para Conexão direta com Banco
	 * 
	 * @param host
	 *            String Endereço IP para conexão
	 * @param user
	 *            String Nome de usuário do banco
	 * @param pass
	 *            String Senha do usuário
	 * @return Boolean <b>true</b> caso consiga conectar ou <b>false</b> caso
	 *         ocorra algum erro
	 */
	public void setTypeInputDB(String host, String user, String pass) {
		this.connection.put("host", host);
		this.connection.put("user", user);
		this.connection.put("pass", pass);

	}
}