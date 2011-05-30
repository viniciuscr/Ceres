
package ceres.output;

import ceres.output.otbehavior.OutputBehavior;


public class Output {

    private OutputBehavior outputBehavior;
    private String arquivo;
    private Profile profile;
    private DataInput data;
    
    prublic Output(Profile profile, data){
    	this.profile = profile;
    	this.data = data;
    }
    
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public void setOutputBehavior(OutputBehavior outputBehavior) {
        this.outputBehavior = outputBehavior;
    }

    public void genererateOutput(){
    	while (linha = data.read(); != EOF){
    		
    		this.outputBehavior.generateLine(linha);
    		this.arquivo recebe linha;
    	}
    }

    

}
