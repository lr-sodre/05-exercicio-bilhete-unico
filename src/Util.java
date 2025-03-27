import java.text.DecimalFormat;

import static java.lang.Integer.remainderUnsigned;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    //banco de dados
    private BilheteUnico[] bilhete = new BilheteUnico[5];
    private int index = 0;

    public void menuPrincipal() {

        int opcao = 0;
        String menu = "1. Admim\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao) {
                case 1:
                    menuAdmim();
                    break;
                case 2:
                    menuUsuario();
            }
        } while (opcao != 3);
    }

    private void menuAdmim() {
        int opcao;
        String menu = "Menu Administrador\n";
        menu += "1. Emitir Bilhete\n";
        menu += "2. Listar Bilhetes\n";
        menu += "3. Excluir Bilhete\n";
        menu += "4. Sair Bilhete\n";

        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao) {
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhetes();
                    break;
                case 3:
                    removerBilhete();
                    break;
            }
        } while (opcao != 4);
    }

    private void emitirBilhete() {
        String nome, perfil;
        long cpf;
        if (index < bilhete.length) {
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseLong(showInputDialog("CPF: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum: ");
            bilhete[index] = new BilheteUnico(nome, cpf, perfil);
            index++;
        } else {
            showMessageDialog(null, "Procure um posto de atendimento");
        }
    }

    private void listarBilhetes() {
        DecimalFormat fm = new DecimalFormat("0.00");
        String aux = "";

        for (int i = 0; i < index; i++) {
            aux += "Número do bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do bilhete: R$" + fm.format(bilhete[i].saldo) + "\n";
            aux += "Usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF: " + bilhete[i].usuario.cpf + "\n\n";
        }
        showMessageDialog(null, aux);
    }

    private void menuUsuario() {
        DecimalFormat fm = new DecimalFormat("0.00");
        int opcao;
        String menu = "1. Carregar bilhete\n2. Consultar saldo\n3. Passar na catraca\n4. Sair";

        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção é inválida!");
            } else {
                switch (opcao) {
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultarSaldo();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;
                }
            }
        } while (opcao != 4);
    }

    private void carregarBilhete() {
        int indice = pesquisar();
        double valor;

        if (indice != -1){
            valor = parseDouble(showInputDialog(null, "Valor da recarga!"));
            bilhete[indice].carregarBilhete(valor);
        }
    }

    private void consultarSaldo() {
        int indice = pesquisar();
        if (indice != -1){
            showMessageDialog(null, "Saldo = R$ "+ bilhete[indice].saldoBilhete());
        }
    }

    private void passarNaCatraca() {
        int indice = pesquisar();

        if(indice != -1){
            showMessageDialog(null, bilhete[indice].passarNaCatraca());
        }
    }

    private int pesquisar() {
        long cpf = parseLong(showInputDialog("CPF"));

        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf) {
                return i;
            }
        }
            showMessageDialog(null, cpf + " não encontrado!");
            return -1;
    }

    private void removerBilhete(){
        int remove;
        int indice = pesquisar();

        if (indice != -1){
            remove = showConfirmDialog(null, "Tem certeza que deseja excluir?");
            if (remove == YES_OPTION){
                bilhete[indice] = bilhete[index-1];
                index--;
            }
        }
    }


    } //Util

