package ceres.output.outbehavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ceres.control.Field;
import ceres.control.Profile;

public class OutputSql implements OutputBehavior {

	String[] linha = null;
	
	ArrayList<Field> fields = null;
	
	@Override
	public String generate(String[] linha, Profile profile) {
		
		this.linha = linha;
		
		Map<String,ArrayList<Field>> tabelas = new HashMap<String, ArrayList<Field>>();

		
		//evitar que seja copiado o profile toda interação.
		if(fields == null){
			fields = profile.getFields();
        }
		
		for (Field f : fields) {
			
			//add o valor que esta na linha para a classe campo
			f.setValue(linha[(Integer)f.getInputName()]);
			//organizar as tabelas
			if(!tabelas.containsKey(f.getOutputTable())){
				tabelas.put(f.getOutputTable(), new ArrayList<Field>());
			
			}
			tabelas.get(f.getOutputTable()).add(f);
			
		}
		
		Set<String> chaves = tabelas.keySet();
		StringBuilder sql = new StringBuilder();
		for (String chave : chaves) {
		
			sql.append("insert into ");
			sql.append(chave);
		//variável que irá conter o sql
		StringBuilder campos = new StringBuilder();
		StringBuilder valores = new StringBuilder();
		
			
			ArrayList<Field> tabela = tabelas.get(chave);
			
			int i = 1;
			for(Field f : tabela){
				campos.append(f.getOutputName());
				valores.append("'"+f.getFormatedValue()+"'");
				if(i < tabela.size()){
					campos.append(", ");
					valores.append(", ");
					i++;
				}
			}
				//setar nova tabela
				sql.append("(");
				sql.append(campos);
				sql.append(") values (");
				sql.append(valores);
				sql.append(");");
	}				
		
		return sql.toString();
	}
}
