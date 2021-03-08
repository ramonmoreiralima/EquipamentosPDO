package br.com.pdo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.pdo.model.Equipamento;

public class Equipamento2DAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public Equipamento2DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertBook(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO equipamento (id,hostname,mascara,ip1,ip2,descricao,gateway,tipo,batismo,serialNumber,servico)"
        		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, equipamento.getId());
        statement.setString(2, equipamento.getHostname());
        statement.setString(3, equipamento.getMascara());
        
        statement.setString(4, equipamento.getIp1());
        statement.setString(5, equipamento.getIp2());
        statement.setString(6, equipamento.getDescricao());
        statement.setString(7, equipamento.getGateway());
        statement.setString(8, equipamento.getTipo());
        statement.setString(9, equipamento.getBatismo());
        statement.setString(10, equipamento.getSerialNumber());
        statement.setString(11, equipamento.getServico());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Equipamento> listAllEquipamentos() throws SQLException {
        List<Equipamento> listEquipamento = new ArrayList<>();
         
        String sql = "SELECT * FROM equipamento";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String hosname = resultSet.getString("hosname");
            String descricao = resultSet.getString("descricao");
            // float price = resultSet.getFloat("price");
            String ip1 = resultSet.getString("ip1");
            String ip2 = resultSet.getString("ip2");
            String mascara = resultSet.getString("mascara");
            String gateway = resultSet.getString("gateway");
            String tipo = resultSet.getString("tipo");
            String batismo = resultSet.getString("batismo");
            String serialNumber = resultSet.getString("serialNumber");
            String servico = resultSet.getString("servico");
             
            Equipamento equipamento = new Equipamento(id,hosname,descricao,ip1,ip2,mascara,gateway,tipo,batismo,serialNumber,servico);
            listEquipamento.add(equipamento);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listEquipamento;
    }
     
    public boolean deleteBook(Equipamento equipamento) throws SQLException {
        String sql = "DELETE FROM equipamento where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, equipamento.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateBook(Equipamento equipamento) throws SQLException {
        String sql = "UPDATE equipamento SET id = ?, hostname = ?, ip1 = ?, ip2 = ?, maascara = ?, gateway = ?, tipo = ?, batismon = ?, serialNumber = ?, servico = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, equipamento.getHostname());
        statement.setString(2, equipamento.getMascara());
        statement.setString(3, equipamento.getIp1());
        statement.setString(4, equipamento.getIp2());
        statement.setString(5, equipamento.getDescricao());
        statement.setString(6, equipamento.getGateway());
        statement.setString(7, equipamento.getTipo());
        statement.setString(8, equipamento.getBatismo());
        statement.setString(9, equipamento.getSerialNumber());
        statement.setString(10, equipamento.getServico());
        //statement.setFloat(3, equipamento.getPrice());
        statement.setInt(11, equipamento.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Equipamento getEquipamento(int id) throws SQLException {
    	Equipamento equipamento = null;
        String sql = "SELECT * FROM equipamento WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String hostname = resultSet.getString("hostname");
            String mascara = resultSet.getString("mascara");
            String ip1 = resultSet.getString("ip1");
            String ip2 = resultSet.getString("ip2");
            String descricao = resultSet.getString("descricao");
            String gateway = resultSet.getString("gateway");
            String tipo = resultSet.getString("tipo");
            String batismo = resultSet.getString("batismo");
            String serialNumber = resultSet.getString("serialNumber");
            String servico = resultSet.getString("servico");
            // float price = resultSet.getFloat("price");
             
            equipamento = new Equipamento(id,hostname,mascara,ip1,ip2,descricao,gateway,tipo,batismo,serialNumber,servico);
        }
         
        resultSet.close();
        statement.close();
         
        return equipamento;
    }
       
}