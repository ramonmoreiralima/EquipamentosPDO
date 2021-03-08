package br.com.pdo.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pdo.jdbc.ConnectionFactory;
import br.com.pdo.model.Equipamento;

public class EquipamentoDAO {
	
	public void save(Equipamento equipamento) {
		String sql = "INSERT INTO equipamento(hostname,descricao,ip1,ip2,mascara,gateway,tipo,batismo,serialNumber,servico)" 
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, equipamento.getHostname());
			pstm.setString(2, equipamento.getDescricao());
			pstm.setString(3, equipamento.getIp1());
			pstm.setString(4, equipamento.getIp2());
			pstm.setString(5, equipamento.getMascara());
			pstm.setString(6, equipamento.getGateway());
			pstm.setString(7, equipamento.getTipo());
			pstm.setString(8, equipamento.getBatismo());
			pstm.setString(9, equipamento.getSerialNumber());
			pstm.setString(10, equipamento.getServico());
			// pstm.setDate(3, new Date(equipamento.getDataCadastro().getTime()));
			
			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
		
	public void removeById(int id) {

		String sql = "DELETE FROM equipamento WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Equipamento equipamento) {

		String sql = "UPDATE equipamento SET hostname = ?,"
				+ " descricao = ?,"
				+ " ip1 = ?," 
				+ " ip2 = ?,"
				+ " mascara = ?,"
				+ " gateway = ?,"
				+ " tipo = ?,"
				+ " batismo = ?,"
				+ " serialNumber = ?,"
				+ " servico = ?" 
				+ " WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, equipamento.getHostname());
			pstm.setString(2, equipamento.getDescricao());
			pstm.setString(3, equipamento.getIp1());
			pstm.setString(4, equipamento.getIp2());
			pstm.setString(5, equipamento.getMascara());
			pstm.setString(6, equipamento.getGateway());
			pstm.setString(7, equipamento.getTipo());
			pstm.setString(8, equipamento.getBatismo());
			pstm.setString(9, equipamento.getSerialNumber());
			pstm.setString(10, equipamento.getServico());
			pstm.setInt(11, equipamento.getId());
			// pstm.setDate(3, new Date(equipamento.getDataCadastro().getTime()));

			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Equipamento> getEquipamentos() {

		String sql = "SELECT * FROM equipamento";

		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Equipamento equipamento = new Equipamento();

				// Recupera o id do banco e atribui ele ao objeto
				equipamento.setId(rset.getInt("id"));
				equipamento.setHostname(rset.getString("hostname"));
				equipamento.setDescricao(rset.getString("descricao"));
				equipamento.setIp1(rset.getString("ip1"));
				equipamento.setIp2(rset.getString("ip2"));
				equipamento.setMascara(rset.getString("mascara"));
				equipamento.setGateway(rset.getString("gateway"));
				equipamento.setDescricao(rset.getString("tipo"));
				equipamento.setDescricao(rset.getString("batismo"));
				equipamento.setDescricao(rset.getString("serialNumber"));
				equipamento.setDescricao(rset.getString("servico"));
				// equipamento.setDataCadastro(rset.getDate("dataCadastro"));

				// Adiciono o equipamento recuperado, a lista de equipamento
				equipamentos.add(equipamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return equipamentos;
	}
	
	// public Equipamento getEquipamento(int id) throws SQLException {
	public List<Equipamento> getEquipamento(int id) {	
		String sql = "SELECT * FROM equipamento WHERE id = "+id;

		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Equipamento equipamento = new Equipamento();

				// Recupera o id do banco e atribui ele ao objeto
				equipamento.setId(rset.getInt("id"));
				equipamento.setHostname(rset.getString("hostname"));
				equipamento.setDescricao(rset.getString("descricao"));
				equipamento.setIp1(rset.getString("ip1"));
				equipamento.setIp2(rset.getString("ip2"));
				equipamento.setMascara(rset.getString("mascara"));
				equipamento.setGateway(rset.getString("gateway"));
				equipamento.setTipo(rset.getString("tipo"));
				equipamento.setBatismo(rset.getString("batismo"));
				equipamento.setSerialNumber(rset.getString("serialNumber"));
				equipamento.setServico(rset.getString("servico"));
				// equipamento.setDataCadastro(rset.getDate("dataCadastro"));

				// Adiciono o equipamento recuperado, a lista de equipamento
				equipamentos.add(equipamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return equipamentos;
    }
	public Equipamento getEquipamentoById(int id) throws Exception {
    	Equipamento equipamento = null;
    	String sql = "SELECT * FROM equipamento WHERE id = ?";
        try{
        	 Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement statement = conn.prepareStatement(sql);
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
                 equipamento = new Equipamento(id,hostname,descricao,ip1,ip2,mascara,gateway,tipo,batismo,serialNumber,servico);
             }
              
             resultSet.close();
             statement.close();
             
        }catch (Exception e) {
			e.printStackTrace();
		}

        return equipamento;
    }
	
	
}
