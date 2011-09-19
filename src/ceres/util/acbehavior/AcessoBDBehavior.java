package ceres.util.acbehavior;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public interface AcessoBDBehavior {

    public void conectar();
    public void desconectar();
    public void setStringConexao(String servidorBD, String nomeBD, String usuarioBD, String senhaBD);
    public DatabaseMetaData getMetaData();
    public void getDatabaseTabels();
    public void getTabelsColumns(String tableName);
    public Connection getConexao();
}
