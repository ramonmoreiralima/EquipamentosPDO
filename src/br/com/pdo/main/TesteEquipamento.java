package br.com.pdo.main;
/*ctl+shift+f*/
import java.util.Date;

import br.com.pdo.dao.EquipamentoDAO;
import br.com.pdo.model.Equipamento;

public class TesteEquipamento {

	public static void main(String args[]) {

		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

		// Cria um contato e salva no banco
		Equipamento equip = new Equipamento();
		equip.setHostname("ramon-linux");
		equip.setDescricao("teste");
		equip.setIp1("192.168.0.1");
		equip.setIp2("192.168.0.1");
		equip.setMascara("255.255.255.0");
		equip.setGateway("192.168.0.0");
		equip.setTipo("pc");
		equip.setBatismo("123456789");
		equip.setSerialNumber("SN152463256");
		equip.setServico("teste");


		equipamentoDAO.save(equip);

		// Atualiza o contato com id = 1 com os dados do objeto contato1
		/*
		 * Contato contato1 = new Contato(); contato1.setId(1);
		 * contato1.setNome("NOME NOVO"); contato1.setIdade(32);
		 * contato1.setDataCadastro(new Date());
		 * 
		 * contatoDAO.update(contato1);
		 * 
		 * //Remove o contato com id = 1
		 * 
		 * contatoDAO.removeById(1);
		 */
		// Lista todos os contatos do banco de dados

		for (Equipamento e : equipamentoDAO.getEquipamentos()) {

			System.out.println("HOSTNAME: " + e.getHostname());
		}
	}
}