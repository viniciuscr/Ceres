
package ceres.input.dtbehavior;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ceres.control.Field;

public class ReadTxt implements ReadDataBehavior {

	private FileReader fileReader;
	private BufferedReader bufferReader;
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
			this.fileReader = new FileReader(arquivo);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		this.bufferReader = new BufferedReader(fileReader);

		String line;
		try {
			if(this.bufferReader.ready()){
				line = this.bufferReader.readLine();
				if (this.type == 1)
					 return readWithTab(line);
				else
					return readWithLimits(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String[] readWithLimits(String line) {
		String[] linha = null;
		for(int i =0; i <= limits.size(); i++){

			linha[i] = line.substring(limits.get(i)[0], limits.get(i)[1]);
		
		}
		return linha;

	}

	private String[] readWithTab(String line) {
		return line.split(tab);

	}

}
