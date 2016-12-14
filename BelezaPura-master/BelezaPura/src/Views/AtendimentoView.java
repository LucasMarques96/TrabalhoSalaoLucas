package Views;

import Banco.BaseDeDados;
import java.util.Scanner;
import Models.Cliente;
import Models.Atendente;
import Models.Atendimento;
import Views.AtendimentoView;

public class AtendimentoView {
    
    private static Scanner scan = new Scanner(System.in);
    
    public static void agendamentoAtendimento() {
        
        
        System.out.print("Digite o código do cliente: ");
        int codigoCliente = scan.nextInt();
        scan.nextLine();
        
        Cliente c = Controllers.ClienteController.buscarPorCodigo(codigoCliente);
        
        if (c != null) {
        System.out.print("Digite o código do Atendente: ");
        int codigoAtendente = scan.nextInt();
        scan.nextLine();
        
        Atendente a = Controllers.AtendenteController.buscarPorCodigo(codigoAtendente);
        
            if (a != null) {
                
                Atendimento at = new Atendimento();
                at.setCliente(c);
                at.setAtendente(a);
                
                BaseDeDados.getAtendimentos().add(at);
                System.out.println("Atendimento agendado com sucesso!");
            } else {
                System.out.println("Atendimento não agendado!");
            }
        
        }else {
            System.out.println("Cliente não cadastrado");
        }
        
    }
    
    public static void exibirAtendimentos() {
        System.out.println("");

        for (Atendimento at : BaseDeDados.getAtendimentos()) {
            System.out.println("");
            System.out.println("Cliente: " + at.getCliente().getNome());
            System.out.println("Atendente: " + at.getAtendente().getNome());
            System.out.println("Tipo: " + at.getAtendente().getTipo());
            System.out.println("");
        }
        System.out.println("");
    }
    
}