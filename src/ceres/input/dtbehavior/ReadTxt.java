
package ceres.input.dtbehavior;

import java.io.File;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	@SuppressWarnings("unused")
	private ArrayList<int[]> limits;

	// contrutor para o caso do arquivo trabalhar com separadores
	public ReadTxt(String tab) {
		this.tab = tab;
		this.type = 1;
	}

	// contrutor para o caso do arquivo trabalhar com limites
	public ReadTxt(ArrayList<int[]> limits) {
		this.limits = limits;
		this.type = 2;
	}
	
	public void setFile(File arquivo){
		this.file = arquivo;
	}
	
	public String[] read(File arquivo) {
		try {
			this.fileReader = new FileReader(arquivo);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		this.bufferReader = new BufferedReader(fileReader);

		String line;
		if(line = this.bufferReader.readLine() != null){
			try {
			
				if (this.type == 1)
					 return readWithTab(line);
				else
					return readWithLimits(line);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	private String[] readWithLimits(String line) {
		return line.split(null);

	}

	private String[] readWithTab(String line) {
		return line.split(tab);

	}

}
