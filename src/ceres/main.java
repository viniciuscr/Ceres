
package ceres;

import java.util.ArrayList;

import ceres.input.DataInput;
import ceres.input.dtbehavior.ReadTxt;
import ceres.output.Output;
import ceres.control.Field;
import ceres.control.Profile;

class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<int[]> limits = new ArrayList<int[]>();
		int [] limit = new int[2];
		
		//adicionar  limite
		limit[0] = 0;
		limit[1] = 7;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 8;
		limit[1] = 19;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 20;
		limit[1] = 29;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 30;
		limit[1] = 40;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 41;
		limit[1] = 51;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 52;
		limit[1] = 64;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 65;
		limit[1] = 73;
		limits.add(limit);
		//adicionar  limite
		limit = new int[2];
		limit[0] = 74;
		limit[1] = 79;
		limits.add(limit);
		
		//selecionar arquivo com a estrutura
		DataInput dados = new DataInput("/home/vinicius/dadosleitura.dat");
		//setar a forma como deve ser tratado o arquivo
		dados.setReadBehaivor(new ReadTxt(limits));
		
		
		
		//criar profile 
		Profile profile = Profile.getInstance();
		//criar um campo
		Field campo = new Field(1, "temperatura");

		//setar tabela de saida
		campo.setOutputTable("USUARIOS");
	
		
		profile.addField(campo);
		
		Output saida = new Output(profile, dados);
		
		String exemplo = saida.getASample();
		System.out.println(exemplo);

	}
}
