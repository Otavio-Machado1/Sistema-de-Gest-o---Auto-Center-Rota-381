import java.util.Scanner;

public class OrdemServicoView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void cabecalhoAbrir() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  ABRIR ORDEM DE SERVIÇO");
        System.out.println("============================================");
    }

    public static void cabecalhoListar() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  ORDENS DE SERVIÇO");
        System.out.println("============================================");
    }

    public static String pedirNumero() {
        System.out.print("  Número da OS: ");
        return scanner.nextLine().trim();
    }

    public static String pedirPlaca() {
        System.out.print("  Placa do veículo: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public static String pedirCodigoMecanico() {
        System.out.print("  Código do mecânico: ");
        return scanner.nextLine().trim();
    }

    public static String pedirCodigoPeca() {
        System.out.print("  Código da peça: ");
        return scanner.nextLine().trim();
    }

    public static int pedirQuantidadePeca() {
        int qtd = 0;
        do {
            System.out.print("  Quantidade da peça: ");
            try {
                qtd = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                qtd = 0;
            }
            if (qtd <= 0) {
                System.out.println("  ! Quantidade inválida.");
            }
        } while (qtd <= 0);
        return qtd;
    }

    public static double pedirMaoObra() {
        double maoObra = -1;
        do {
            System.out.print("  Valor da mão de obra (R$): ");
            try {
                maoObra = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                maoObra = -1;
            }
            if (maoObra < 0) {
                System.out.println("  ! Valor inválido.");
            }
        } while (maoObra < 0);
        return maoObra;
    }

    public static void msgSucesso() {
        System.out.println();
        System.out.println("  OS aberta com sucesso!");
    }

    public static void msgErroLimite() {
        System.out.println("  ! Limite de ordens de serviço atingido.");
    }

    public static void msgErroDuplicado() {
        System.out.println("  ! Número de OS já existe.");
    }

    public static void msgErroVeiculoNaoEncontrado() {
        System.out.println("  ! Placa não cadastrada. Cadastre o veículo primeiro.");
    }

    public static void msgErroMecanicoNaoEncontrado() {
        System.out.println("  ! Mecânico não encontrado. Cadastre o mecânico primeiro.");
    }

    public static void msgErroPecaNaoEncontrada() {
        System.out.println("  ! Peça não encontrada. Cadastre a peça primeiro.");
    }

    public static void msgErroEstoqueInsuficiente(String nomePeca, int solicitado, int disponivel) {
        System.out.println();
        System.out.println("  !! ERRO: Estoque insuficiente!");
        System.out.println("     Peça       : " + nomePeca);
        System.out.println("     Solicitado : " + solicitado);
        System.out.println("     Disponível : " + disponivel);
        System.out.println("  OS bloqueada. Atualize o estoque antes de lançar.");
    }

    public static void msgNenhum() {
        System.out.println("  Nenhuma OS registrada.");
    }

    public static void mostrarTabela(String numero, String placa, String codMec,
                                     String codPeca, int qtd, double maoObra, int total) {
        System.out.printf("  %-6s  %-10s  %-8s  %-8s  %-6s  %-12s%n",
            "OS", "PLACA", "MECÂNICO", "PEÇA", "QTD", "MÃO DE OBRA");
        System.out.println("  ------------------------------------------------------------------");
        for (int i = 0; i < total; i++) {
            OrdemServico os = OrdemServicoController.lista[i];
            System.out.printf("  %-6s  %-10s  %-8s  %-8s  %-6d  R$ %-10.2f%n",
                os.numero, os.placa, os.codigoMecanico, os.codigoPeca, os.quantidadePeca, os.maoObra);
        }
    }
}
