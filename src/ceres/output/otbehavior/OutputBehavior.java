
package ceres.output.otbehavior;

import java.io.Writer;

import ceres.control.Profile;


public interface OutputBehavior {
        public String generate(String[] linha, Profile profile);
}
