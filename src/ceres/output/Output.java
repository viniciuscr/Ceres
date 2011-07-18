
package ceres.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ceres.control.Profile;
import ceres.input.DataInput;
import ceres.output.outbehavior.OutputBehavior;


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
    private boolean saveLine(String line){
    	BufferedWriter writer = new BufferedWriter(this.arquivo);
    	try {
			writer.write(line);
		} catch (IOException e) {
			System.out.println("Erro ao salvar a linha");
			e.printStackTrace();
			return false;
		}
		return true;
    }
    public void setOutputBehavior(OutputBehavior outputBehavior) {
        this.outputBehavior = outputBehavior;
    }
    /*
     * Gera uma amostra de como ficará a saída
     * @return String Uma amostra da primeiral leitura no arquivo
     */
    public String getASample(){
    	String[] line  = data.read();
    	return this.outputBehavior.generate(line, profile);
    }
    /*
     * Gera arquivo de saída de acordo com as configurações préviamente definidas
     */
    public void genererateOutput(){
    	String[] line;
    	String output;
		while ((line = data.read() ) != null){
    		
			output = this.outputBehavior.generate(line, profile);
			
			// se ocorrer um erro na escrita, parar operação na linha com problema
    		if(!(this.saveLine(output))){
    			System.out.println("Linha =: "+output);
    			break;
    		}
    	}
    	
    }
    

    

}
