package marco.ebac;

import marco.ebac.dao.ClienteMapDAO;
import marco.ebac.dao.IClienteDAO;
import marco.ebac.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String option = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair",
                "Opções:", JOptionPane.INFORMATION_MESSAGE);

        while (!isOptionValid(option)) {
            if ("".equals(option)) {
                sair();
            }
            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair",
                    "Opções:", JOptionPane.INFORMATION_MESSAGE);
        }

        while ((isOptionValid(option))) {
            if (isExit(option)) {
                sair();
            } else if (isCadastro(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados para cadastro: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro:", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(data);
            } else if (isConsulta(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite o CPF para consulta",
                        "Consulta:", JOptionPane.INFORMATION_MESSAGE);
                consultar(data);
            } else if (isExclusao(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite o CPF para exclusão.",
                        "Exclusão:", JOptionPane.INFORMATION_MESSAGE);
                excluir(option);
            } else {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados para cadastro: Nome, CPF, Telefone, ",
                        "Atualização:", JOptionPane.INFORMATION_MESSAGE);
                atualizar(data);
            }

            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair",
                    "Opções:", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String data) {
        String[] dataSep = data.split(",");
        Cliente cliente = new Cliente(dataSep[0], dataSep[1], dataSep[2], dataSep[3], dataSep[4], dataSep[5], dataSep[6]);
        Boolean isCadastro = iClienteDAO.cadastrar(cliente);
        if (isCadastro) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já está cadastrado");
        }
    }

    private static void consultar(String data) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(data));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private static void excluir(String data) {
        iClienteDAO.excluir(Long.parseLong(data));
        JOptionPane.showMessageDialog(null, "Cliente excluído");
    }

    private static void atualizar(String data) {
        String[] dataSep = data.split(",");
        Cliente cliente = new Cliente(dataSep[0], dataSep[1], dataSep[2], dataSep[3], dataSep[4], dataSep[5], dataSep[6]);
        iClienteDAO.alterar(cliente);
    }

    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, "Clientes Cadastrados: " + clientesCadastrados);
        System.exit(0);
    }

    private static boolean isCadastro(String option) {
        return "1".equals(option);
    }

    private static boolean isConsulta(String option) {
        return "2".equals(option);
    }

    private static boolean isExclusao(String option) {
        return "3".equals(option);
    }

    private static boolean isExit(String option) {
        return "5".equals(option);
    }

    private static boolean isOptionValid(String option) {
        return "1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option);
    }
}