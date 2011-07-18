package ceres.output.outbehavior;

import java.util.ArrayList;

import ceres.control.Field;
import ceres.control.Profile;

public class OutputSql implements OutputBehavior {

	@Override
	public String generate(String[] linha, Profile profile) {

		ArrayList<Field> fields = profile.getFields();

		for (Field f : fields) {
			
		}

		return null;
	}
}
