package ceres.util.acbehavior;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoPostgres implements AcessoBDBehavior {

    private Connection conn;
    private String stringDeConexao;
    private String enderecoServidor;
    private String nomeBancoDeDados;
    private String nomeUsuario;
    private String senhaUsuario;

    /**
     * 
     * Método construtor da classe que tem como objetivo inicializar o drive
     * de conexão no banco de dados.<br />
     * 
     */
    public AcessoPostgres() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    /**
     * 
     * Método construtor que configura a conexão com o banco de dados.
     * @param servidorBD
     * @param nomeBD
     * @param usuarioBD
     * @param senhaBD
     * 
     */
    public AcessoPostgres(String servidorBD, String nomeBD, String usuarioBD, String senhaBD) {
        this();
        this.setStringConexao(servidorBD, nomeBD, usuarioBD, senhaBD);
    }

    /**
     * Método que estabelece conexão com o banco de dados.
     * @throws SQLException
     */
    public void conectar() {

        try {
            conn = DriverManager.getConnection(getStringDeConexao());
            System.out.println("Conexão com BD estabelecida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("[ERRO] Erro ao conectar: " + ex);
        }
    }

    /**
     * Método que desestabelece conexão com o banco de dados.
     */
    public void desconectar() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão encerrada com sucesso!");
            } catch (Exception ex) {
                System.out.println("[ERRO] Erro ao desconectar: " + ex);
            }
        }
    }

    public Connection getConexao() {
        return conn;
    }

    public String getStringDeConexao() {
        return stringDeConexao;
    }

    /**
     * 
     * Método de configuração da conexão com o banco de dados.<br />
     * @param servidorBD
     * @param nomeBD
     * @param usuarioBD
     * @param senhaBD 
     * 
     */
    public void setStringConexao(String servidorBD, String nomeBD, String usuarioBD, String senhaBD) {
        this.setEnderecoServidor(servidorBD);
        this.setNomeBancoDeDados(nomeBD);
        this.setNomeUsuario(usuarioBD);
        this.setSenhaUsuario(senhaBD);
        stringDeConexao = "jdbc:postgresql://";
        stringDeConexao += enderecoServidor + "/";
        stringDeConexao += nomeBancoDeDados + "?";
        stringDeConexao += "user=" + nomeUsuario + "&";
        stringDeConexao += "password=" + senhaUsuario;
    }

    public DatabaseMetaData getMetaData() {
        DatabaseMetaData metadado = null;
        try {
            metadado = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println("[ERRO] Erro ao recuperar Metadados do Banco de Dados: " + ex);
        }
        return metadado;
    }

    /**
     * Método que retorna os metadados do banco de dados.<br />
     * @return DatabaseMetaData - Metadados do banco de dados.
     * @throws SQLException
     */
    public void getDatabaseTabels() {
        // Código adaptado de http://www.exampledepot.com

        try {
            DatabaseMetaData dbmd = getMetaData();

            // Especifica o tipo do objeto(metadado); Nesse caso os nomes das tabelas.
            String[] types = {"TABLE"};
            ResultSet resultSet = dbmd.getTables(null, null, "%", types);

            while (resultSet.next()) {
                String tableName = resultSet.getString(3);
                String tableCatalog = resultSet.getString(1);
                String tableSchema = resultSet.getString(2);

                System.out.println("Nome da tabela: < "+tableName+" >; Catalogo(?): < "+tableCatalog+" >; Esquema: < "+tableSchema+" >");
            }
        } catch (SQLException ex) {
            System.out.println("[ERRO] Erro ao ler informações do Banco de Dados(Tabelas): " + ex);
        } finally {
            //desconectar();
        }
    }

    /**
     * 
     * Método de retorno das informações referentes às colunas do banco de dados. <br />
     * @version 1.0
     * @param tableName 
     * @throws SQLException
     * 
     */
    public void getTabelsColumns(String tableName) {
        try {
            DatabaseMetaData dbmd = getMetaData();

            // Especifica o tipo do objeto(metadado); Nesse caso as Colunas.
            ResultSet resultSet = dbmd.getColumns(null, null, tableName, null);

            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                String type = resultSet.getString("TYPE_NAME");
                int size = resultSet.getInt("COLUMN_SIZE");

                System.out.println("Nome da coluna: < "+name+" >; Tipo: < "+type+" >; Tamanho: < "+size+" >");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler informações do Banco de Dados(Colunas): " + ex);
        } finally {
            //desconectar();
        }
    }

    public String getEnderecoServidor() {
        return enderecoServidor;
    }

    public void setEnderecoServidor(String enderecoServidor) {
        this.enderecoServidor = enderecoServidor;
    }

    public String getNomeBancoDeDados() {
        return nomeBancoDeDados;
    }

    public void setNomeBancoDeDados(String nomeBancoDeDados) {
        this.nomeBancoDeDados = nomeBancoDeDados;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
