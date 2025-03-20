import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    //banco de dados
    private BilheteUnico[] bilhete = new BilheteUnico[5];
    private int index= 0;

    public void menuPrincipal() {

        int opcao = 0;
        String menu = "1. Admim\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao) {
                case 1:
                    menuAdmim();
                    break;

            }
        } while (opcao != 3);
    }


    private void menuAdmim(){
            int opcao;
            String menu = "Menu Administrador\n";
            menu += "1. Emitir Bilhete\n";
            menu += "2. Listar Bilhetes\n";
            menu += "3. Excluir Bilhete\n";
            menu += "4. Sair Bilhete\n";

            do {
                opcao = parseInt(showInputDialog(menu));
                switch (opcao){
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        listarBilhetes();
                        break;
                }
            } while(opcao != 4);
        }

        private void emitirBilhete(){
        String nome, perfil;
        long cpf;
        if (index < bilhete.length){
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseLong(showInputDialog("CPF: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum: ");
            bilhete[index] = new BilheteUnico(nome, cpf, perfil);
            index++;
        } else {
            showMessageDialog(null ,"Procure um posto de atendimento");
        }
    }

    private void listarBilhetes(){
        DecimalFormat fm = new DecimalFormat("0.00");
        String aux = "";

        for(int i=0; i<index; i++){
            aux += "Número do bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do bilhete: R$" + fm.format(bilhete[i].saldo) + "\n";
            aux += "Usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF: " + bilhete[i].usuario.cpf + "\n\n";
        }
        showMessageDialog(null, aux);
    }








    } //Util

