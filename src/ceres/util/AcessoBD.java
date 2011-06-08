/*
 * Classe para estabelecer conexÃ£o com banco de dados Postgres.
 * Certifique-se que o projeto tenha a biblioteca (arquivo .jar) do Postgres
 *  senÃ£o tiver adicione na pasta Bibliotecas.
 */

package ceres.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author evandro, vinícius
 */
public class AcessoBD {    
    private Connection conn;
    private String stringDeConexao;
    private String enderecoServidor;
    private String nomeBancoDeDados;
    private String nomeUsuario;
    private String senhaUsuario;

    // Construtor
    public AcessoBD(){
        // Carrega o driver de conexÃ£o com o banco de dados
        // se nÃ£o achar o driver lanÃ§a uma exceÃ§Ã£o.
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }
    }
    // Construtor com parÃ¢metros
    public AcessoBD(String servidorBD, String nomeBD, String usuarioBD, String senhaBD){
        this();
        this.setStringConexao(servidorBD, nomeBD, usuarioBD, senhaBD);
    }

    // Estabelece conexÃ£o com banco de dados.
    public void conectar(){
        // Tenta conectar na base de dados.
        try{
            conn = DriverManager.getConnection(getStringDeConexao());
            System.out.println("ConexÃ£o com BD estabelecida com sucesso!");
        }
        catch (SQLException sqlex){
            System.out.println(sqlex.getMessage());
        }
    }
    // Desconecta do banco de dados.
    public void desconectar(){
        if (conn!=null){
            try{
                conn.close();
                System.out.println("ConexÃ£o encerrada com sucesso!");
            }
            catch (Exception e){
                System.out.println("desconectar: erro ao fechar a conexÃ£o.");
            }
        }
    }
    // Retorna um objeto Connection
    public Connection getConexao(){
        return conn;
    }
    // Retorna string de conexÃ£o com o banco
    public String getStringDeConexao(){
        return stringDeConexao;
    }
    // Configura a string de conexÃ£o
    public void setStringConexao(String servidorBD, String nomeBD, String usuarioBD, String senhaBD){
        this.setEnderecoServidor(servidorBD);
        this.setNomeBancoDeDados(nomeBD);
        this.setNomeUsuario(usuarioBD);
        this.setSenhaUsuario(senhaBD);
        // Monta a string de conexÃ£o com banco de dados.
        // Essa string serve apenas para banco Postgres
        // Exemplo de string de conexÃ£o:
        // "jdbc:postgresql://localhost/teste?user=postgres&password=ifsul"
        stringDeConexao = "jdbc:postgresql://";
        stringDeConexao += enderecoServidor+"/";
        stringDeConexao += nomeBancoDeDados+"?";
        stringDeConexao += "user="+nomeUsuario+"&";
        stringDeConexao += "password="+senhaUsuario;
    }
    
    // Metado que retorna os metadados do banco de dados
    public DatabaseMetaData getMetaData() throws SQLException{
        DatabaseMetaData metadado = conn.getMetaData();
        return metadado;
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
