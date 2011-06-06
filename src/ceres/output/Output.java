
package ceres.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ceres.control.Profile;
import ceres.input.DataInput;
import ceres.output.otbehavior.OutputBehavior;


public class Output {

    private OutputBehavior outputBehavior;
    private Writer arquivo;
    private Profile profile;
    private DataInput data;
    
    public Output(Profile profile, DataInput data){
    	this.profile = profile;
    	this.data = data;
    }
    
    public void setArquivo(String arquivo) {
    	try {
			this.arquivo = new FileWriter(arquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void setOutputBehavior(OutputBehavior outputBehavior) {
        this.outputBehavior = outputBehavior;
    }
    
    /*
     * Gera arquivo de saída de acordo com as configurações préviamente definidas
     */
    public void genererateOutput(){
    	String[] linha;
		while ((linha = data.read() ) != null){
    		
			this.outputBehavior.save(linha,this.arquivo,profile);
    		
    	}
    	
    }
    

    

}
