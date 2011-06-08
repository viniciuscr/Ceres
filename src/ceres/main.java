
package ceres;

import ceres.input.DataInput;
import ceres.input.dtbehavior.ReadTxt;
import ceres.control.Field;
import ceres.control.Profile;

class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//selecionar arquivo com a estrutura
		DataInput dados = new DataInput("arquivo.txt");
		//setar a forma como deve ser tratado o arquivo
		dados.setReadBehaivor(new ReadTxt(";"));
		
		//criar profile 
		Profile profile = Profile.getInstance();
		//criar um campo
		Field campo = new Field("ct_cidade", "CIDADE");

		//setar tabela de saida
		campo.setOutputTable("USUARIOS");
	
		
		profile.addField(campo);
		
		

	}
}
