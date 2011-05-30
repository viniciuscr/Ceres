
package ceres.input;

import ceres.input.dtbehavior.ReadDataBehavior;
import java.io.File;


public class DataInput {
	private ReadDataBehavior readBehaivor;
	private File arquivo;

        public DataInput(String caminho) {
		this.arquivo = new File(caminho);
	}
        public String read(){
        	return this.readBehaivor.read();
	}

        public File getArquivo() {
            return arquivo;
        }

        public void setArquivo(File arquivo) {
            this.arquivo = arquivo;
        }

        public ReadDataBehavior getReadBehaivor() {
            return readBehaivor;
        }

        public void setReadBehaivor(ReadDataBehavior readBehaivor) {
            this.readBehaivor = readBehaivor;
            this.readBehaivor.setFile(arquivo);
        }
        
}
