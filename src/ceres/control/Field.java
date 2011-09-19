package ceres.control;

import ceres.control.ftbehavior.FormatBehavior;

public class Field {
	//nome do campo na estrutura
	private String inputName;
	//nome do campo na estrutura
	private Integer inputPosition;
	//novo nome que ficará na saída
	private String outputName;
	//nome da tabela do campo da estrutura
	private String inputTable;
	//novo nome da tabela que ficará na saída
	private String outputTable;
	//valor do campo no arquivo de entrada
	private String value;
	//valor do campo após receber formatação
	private String formatedValue;
	//interface formatadora
	private FormatBehavior formatBehaivor;
	
	public Field(String inputName, String outputName) {
		this.inputName = inputName;
		this.outputName = outputName;
		this.inputPosition = null;
	}
	public Field(int inputPosition, String outputName) {
		this.outputName = outputName;
		this.inputPosition = inputPosition;
		this.inputName = null;
	}
	/**
	 *  Retorna o nome, posição ou limites do campo de entrada
	 * <p>
	 * <b>Example:</b>
	 * <ul>
	 * <li>"NomeDoCampo" =>   caso seja leitura de um XML</li>
	 * <li> "5"		     =>   caso seja a leitura de um txt</li>
	 * </ul>
	 * @return String or Int
	 */
	public Object getInputName() {
		if(this.inputName == null)
			return inputPosition;
		else
			return inputName;
	}
	/**
	 * Seta o nome, posição ou limites do campo de entrada
	 * <p>
	 * <b>Example:</b>
	 * <ul>
	 * <li>"NomeDoCampo" =>   caso seja leitura de um XML</li>
	 * <li> "5"		     =>   caso seja a leitura de um txt</li>
	 * </ul>
	 * @param inputName String
	 * 
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	/**
	 *  Retorna o nome, posição ou limites do campo de saída
	 * <p>
	 * <b>Example:</b>
	 * <ul>
	 * <li>"NomeDoCampo" =>   caso seja leitura de um XML</li>
	 * <li>"0;12"		 =>   caso seja leitura de um txt sem separador</li>
	 * <li> "5"		     =>   caso seja a leitura de um txt com separador</li>
	 * </ul>
	 * @return String
	 */
	public String getOutputName() {
		return outputName;
	}
	/**
	 * Seta o nome, posição ou limites do campo de saída
	 * <p>
	 * <b>Example:</b>
	 * <ul>
	 * <li>"NomeDoCampo" =>   caso seja leitura de um XML</li>
	 * <li>"0;12"		 =>   caso seja leitura de um txt sem separador</li>
	 * <li> "5"		     =>   caso seja a leitura de um txt com separador</li>
	 * </ul>
	 * @param outputName String
	 */
	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}
	/**
	 * Retorna o valor original do campo
	 * @return String
	 */
	public String getValue() {
		return value;
	}
	/**
	 * Seta o valor otiginal do campo.<p>
	 * Utilizado somente na leitura dos dados.
	 * @param value 
	 */
	public void setValue(String value) {
		this.value = value;
		this.formatedValue = value;
	}
	/**
	 *  Retorna o valor formatado de acordo
	 *  com o formatBehaivor escolhido
	 *  @return String
	 */
	public String getFormatedValue() {
		if(this.formatBehaivor != null)
			this.formatBehaivor.format(this);
		return formatedValue;
	}
	/**
	 * Seta qual formatador utilizar
	 * @param formatBehaivor FormatBehavior
	 */
	public void setFormatBehaivor(FormatBehavior formatBehaivor) {
		this.formatBehaivor = formatBehaivor;
	}
	/**
	 * Seta o nome da tabela de entrada<p>
	 * Utilizado caso os dados de entrada sejam lidos diretamente de um banco de dados
	 * @param inputTable String
	 */
	public void setInputTable(String inputTable) {
		this.inputTable = inputTable;
	}
	/**
	 * Seta o nome da tabela de saída
	 * Utilizado caso a saída seja um SQL
	 * @param outputTable
	 */
	public void setOutputTable(String outputTable) {
		this.outputTable = outputTable;
	}
	public String getOutputTable() {
		return this.outputTable;
	}

}
