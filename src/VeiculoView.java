import java.util.Scanner;

public class VeiculoView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void cabecalhoCadastro() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  CADASTRAR VEÍCULO");
        System.out.println("============================================");
    }

    public static void cabecalhoListar() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  VEÍCULOS CADASTRADOS");
        System.out.println("============================================");
    }

    public static String pedirPlaca() {
        System.out.print("  Placa: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public static String pedirNomeDono() {
        System.out.print("  Nome do dono: ");
        return scanner.nextLine().trim();
    }

    public static String pedirModelo() {
        System.out.print("  Modelo do veículo: ");
        return scanner.nextLine().trim();
    }

    public static void msgSucesso() {
        System.out.println();
        System.out.println("  Veículo cadastrado com sucesso!");
    }

    public static void msgErroLimite() {
        System.out.println("  ! Limite de veículos atingido.");
    }

    public static void msgErroDuplicado() {
        System.out.println("  ! Placa já cadastrada.");
    }

    public static void msgNenhum() {
        System.out.println("  Nenhum veículo cadastrado.");
    }

    public static void mostrarTabela(String placa, String nomeDono, String modelo, int total) {
        System.out.printf("  %-10s  %-25s  %-20s%n", "PLACA", "DONO", "MODELO");
        System.out.println("  --------------------------------------------------");
        for (int i = 0; i < total; i++) {
            Veiculo v = VeiculoController.lista[i];
            System.out.printf("  %-10s  %-25s  %-20s%n", v.placa, v.nomeDono, v.modelo);
        }
    }
}
