
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
		Profile profile = new Profile();
		//criar um campo
		Field campo = new Field("ct_cidade", "CIDADE");
		//setar o tipo
		campo.setType("varchar(150)");
		//setar tabela de saida
		campo.setOutputTable("USUARIOS");
		
		//teste tosco
		campo.equals(profile);
		
		profile.addFields(campo);
		
		

	}
}
