
package ceres.output;

import ceres.output.otbehavior.OutputBehavior;


public class Output {

    private OutputBehavior outputBehavior;
    private String arquivo;

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public void setOutputBehavior(OutputBehavior outputBehavior) {
        this.outputBehavior = outputBehavior;
    }

    public void insert(){
        this.outputBehavior.insert();
    }

    

}
