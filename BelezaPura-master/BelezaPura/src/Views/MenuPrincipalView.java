package Views;

import java.util.Scanner;
import Views.ClienteView;
import Views.AtendenteView;
import Views.AtendimentoView;
import Banco.BaseDeDados;
import java.util.InputMismatchException;

public class MenuPrincipalView {

    ClienteView ClienteView = new ClienteView();
    AtendenteView AtendenteView = new AtendenteView();
    AtendimentoView AtendimentoView = new AtendimentoView();

    private static Scanner scan = new Scanner(System.in);

    public static int inicio() {

        System.out.println("");
        System.out.println("--------- SALÃO BELEZA PURA -------------");
        System.out.println("1 - Cliente");
        System.out.println("2 - Administrador");
        System.out.print("Digite a opção desejada: ");
        System.out.println("");

        int opcao = scan.nextInt();
        scan.nextLine();
        return opcao;
    }

    public void exibirMenu() {

        BaseDeDados.inicializarBaseAtendentes();
        BaseDeDados.inicializarBaseAtendimentos();
        BaseDeDados.inicializarBaseClientes();

        try {
            int opcao = 0;
            do {
                opcao = inicio();
                switch (opcao) {
                    case 1:
                        ClienteView.exibirMenuCliente();
                        break;
                    case 2:
                        AtendenteView.exibirMenuAtendente();
                        break;
                }
            } while (opcao != 3);

        } catch (InputMismatchException ie) {
            System.out.println("Erro: Esperado número inteiro.(" + ie.toString() + ")");
            scan.nextLine();
        } catch (UnsupportedOperationException ue) {
            System.out.println("Erro: Operação não suportada!(" + ue.toString() + ")");
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Erro inesperado!(" + e.toString() + ")");
            scan.nextLine();
        }

    }

}
