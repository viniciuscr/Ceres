
package ceres.output;

import ceres.output.otbehavior.OutputBehavior;


public class Output {

    private OutputBehavior outputBehavior;
    private FileOutputStream arquivo;
    private Profile profile;
    private DataInput data;
    
    prublic Output(Profile profile, data){
    	this.profile = profile;
    	this.data = data;
    }
    
    public void setArquivo(String arquivo) {
        this.arquivo = new FileOutputStream(arquivo);
    }

    public void setOutputBehavior(OutputBehavior outputBehavior) {
        this.outputBehavior = outputBehavior;
    }
    
    /*
     * Gera arquivo de saída de acordo com as configurações préviamente definidas
     */
    public void genererateOutput(){
    	while (linha = data.read() != null){
    		
    		this.outputBehavior.generateLine(linha);
    		this.arquivo recebe linha;
    	}
    	this.arquivo.close();
    }
    

    

}
