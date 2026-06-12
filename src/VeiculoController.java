public class VeiculoController {
    static Veiculo[] lista = new Veiculo[100];
    static int total = 0;

    public static void cadastrar() {
        VeiculoView.cabecalhoCadastro();

        Veiculo v = new Veiculo();
        v.placa    = VeiculoView.pedirPlaca();
        v.nomeDono = VeiculoView.pedirNomeDono();
        v.modelo   = VeiculoView.pedirModelo();

        lista[total] = v;
        total++;

        Dados.salvar();

        VeiculoView.msgSucesso();
        Helper.pressEnter();
    }

    public static void listar() {
        VeiculoView.cabecalhoListar();

        String placa    = "";
        String nomeDono = "";
        String modelo   = "";

        for (int i = 0; i < total; i++) {
            Veiculo v = lista[i];
            placa    = v.placa;
            nomeDono = v.nomeDono;
            modelo   = v.modelo;
        }

        VeiculoView.mostrarTabela(placa, nomeDono, modelo, total);
        Helper.pressEnter();
    }

    public static int buscar(String placa) {
        for (int i = 0; i < total; i++) {
            if (lista[i].placa.equals(placa.toUpperCase())) return i;
        }
        return -1;
    }
}
