
package ceres.output.otbehavior;

import java.io.Writer;

import ceres.control.Profile;


public interface OutputBehavior {
        public int save(String[] linha, Writer arquivo, Profile profile);
}
