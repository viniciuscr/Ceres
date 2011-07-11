package ceres.control;

import java.util.ArrayList;

public class Profile {

	// Aplicação do padrão Singleton
	private static Profile uniqueInstance;

	// lista de campos das tabelas
	private ArrayList<Field> fields;

	// Aplicação do padrão Singleton
	private Profile() {}

	// Aplicação do padrão Singleton
	public static Profile getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Profile();
		}
		return uniqueInstance;
	}
	/**
	 * Retorna um a lista de campos armazenados no profile
	 * 
	 * @return ArrayList<Field>
	 */
	public ArrayList<Field> getFields() {
		return fields;
	}

	/**
	 * Adiciona um campo ao profile
	 * 
	 * @param Field
	 */
	public void addField(Field field) {
		this.fields.add(field);
	}
	/**
	 * Salva o Profile em um arquivo XML
	 * 
	 * @param Field
	 */
	public void saveProfile() {
		
	}
}