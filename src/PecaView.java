import java.util.Scanner;

public class PecaView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void cabecalhoCadastro() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  CADASTRAR PEÇA");
        System.out.println("============================================");
    }

    public static void cabecalhoListar() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  ESTOQUE DE PEÇAS");
        System.out.println("============================================");
    }

    public static String pedirCodigo() {
        System.out.print("  Código da peça: ");
        return scanner.nextLine().trim();
    }

    public static String pedirDescricao() {
        System.out.print("  Descrição: ");
        return scanner.nextLine().trim();
    }

    public static int pedirQuantidade() {
        int quantidade = -1;
        do {
            System.out.print("  Quantidade em estoque: ");
            try {
                quantidade = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                quantidade = -1;
            }
            if (quantidade < 0) {
                System.out.println("  ! Quantidade inválida.");
            }
        } while (quantidade < 0);
        return quantidade;
    }

    public static double pedirPreco() {
        double preco = -1;
        do {
            System.out.print("  Preço unitário (R$): ");
            try {
                preco = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                preco = -1;
            }
            if (preco < 0) {
                System.out.println("  ! Preço inválido.");
            }
        } while (preco < 0);
        return preco;
    }

    public static void msgSucesso() {
        System.out.println();
        System.out.println("  Peça cadastrada com sucesso!");
    }

    public static void msgErroLimite() {
        System.out.println("  ! Limite de peças atingido.");
    }

    public static void msgErroDuplicado() {
        System.out.println("  ! Código já cadastrado.");
    }

    public static void msgNenhum() {
        System.out.println("  Nenhuma peça cadastrada.");
    }

    public static void mostrarTabela(String codigo, String descricao, int quantidade, double preco, int total) {
        System.out.printf("  %-10s  %-30s  %-8s  %-12s%n", "CÓDIGO", "DESCRIÇÃO", "ESTOQUE", "PREÇO (R$)");
        System.out.println("  ----------------------------------------------------------------");
        for (int i = 0; i < total; i++) {
            Peca p = PecaController.lista[i];
            System.out.printf("  %-10s  %-30s  %-8d  %-12.2f%n", p.codigo, p.descricao, p.quantidade, p.preco);
        }
    }
}
