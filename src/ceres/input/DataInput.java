
package ceres.input;
import ceres.input.dtbehavior.ReadDataBehavior;
import java.io.File;


public class DataInput {
	private ReadDataBehavior readBehaivor;
	private File file;

        public DataInput(String caminho) {
		this.file = new File(caminho);
	}
        public String[] read(){
        	return this.readBehaivor.read(file);
	}

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public ReadDataBehavior getReadBehaivor() {
            return readBehaivor;
        }

        public void setReadBehaivor(ReadDataBehavior readBehaivor) {
            this.readBehaivor = readBehaivor;
        }
        
}
