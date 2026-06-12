import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Dados.carregar();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("  AUTO CENTER ROTA 381");
            System.out.println("============================================");
            System.out.println();
            System.out.println("  -- CADASTROS --");
            System.out.println();
            System.out.println("  1. Cadastrar Mecânico");
            System.out.println("  2. Cadastrar Veículo");
            System.out.println("  3. Cadastrar Peça");
            System.out.println();
            System.out.println("  -- CONSULTAS --");
            System.out.println();
            System.out.println("  4. Listar Mecânicos");
            System.out.println("  5. Listar Veículos");
            System.out.println("  6. Listar Peças (Estoque)");
            System.out.println();
            System.out.println("  -- OPERAÇÕES --");
            System.out.println();
            System.out.println("  7. Abrir Ordem de Serviço");
            System.out.println("  8. Listar Ordens de Serviço");
            System.out.println();
            System.out.println("  0. Sair");
            System.out.println();
            System.out.println("============================================");
            System.out.print("  > Escolha uma opção: ");

            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                escolha = -1;
            }

            switch (escolha) {
                case 1:
                    MecanicoController.cadastrar();
                    break;
                case 2:
                    VeiculoController.cadastrar();
                    break;
                case 3:
                    PecaController.cadastrar();
                    break;
                case 4:
                    MecanicoController.listar();
                    break;
                case 5:
                    VeiculoController.listar();
                    break;
                case 6:
                    PecaController.listar();
                    break;
                case 7:
                    OrdemServicoController.abrir();
                    break;
                case 8:
                    OrdemServicoController.listar();
                    break;
                case 0:
                    Dados.salvar();
                    System.out.println();
                    System.out.println("  Encerrando o sistema. Até logo!");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("  ! Opção inválida. Informe uma opção válida.");
                    System.out.println();
            }

        } while (escolha != 0);

        scanner.close();
    }
}
