
package ceres.output.outbehavior;

import ceres.control.Profile;


public interface OutputBehavior {
        public String generate(String[] linha, Profile profile);
}
