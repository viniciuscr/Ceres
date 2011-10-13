
package ceres.input.dtbehavior;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTxt implements ReadDataBehavior {

	private FileReader fileReader = null;
	private BufferedReader bufferReader = null;
	// seta o separador
	private String tab;
	// seta o tipo de leitura
	// 1 = com separador
	// 2 = com um limites
	private int type;
	// array com os limiteadores
	// array(inicio, fim)
	private ArrayList<int[]> limits;

	// contrutor para o caso do arquivo trabalhar com separadores
	public ReadTxt(String tab) {
		this.tab = tab;
		this.type = 1;
	}

	// construtor para o caso do arquivo trabalhar com limites
	public ReadTxt(ArrayList<int[]> limits) {
		this.limits = limits;
		this.type = 2;
	}
	
	public String[] read(File arquivo) {
		try {
			if(this.fileReader==null)
				this.fileReader = new FileReader(arquivo);
			if(this.bufferReader == null)
				this.bufferReader = new BufferedReader(fileReader);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
				String line;
		try {
			
				if((line = this.bufferReader.readLine() ) != null)
				
				if (this.type == 1)
					 return readWithTab(line);
				else
					return readWithLimits(line);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String[] readWithLimits(String line) {
		String[] linha = new String[limits.size()];
		for(int i =0; i <= limits.size() -1; i++){
			int[] limit = limits.get(i);
			
			linha[i] = line.substring(limit[0], limit[1]);
		
		}
		return linha;

	}

	private String[] readWithTab(String line) {
		return line.split(tab);

	}

}
