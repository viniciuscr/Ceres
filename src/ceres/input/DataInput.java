
package ceres.input;

import ceres.input.dtbehavior.ReadDataBehavior;
import java.io.File;


public class DataInput {
	private ReadDataBehavior readBehaivor;
	private File arquivo;

        public DataInput(String caminho) {
		this.arquivo = new File(caminho);
	}
        public void read(){
		this.readBehaivor.read(arquivo);
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
        }
        
}
