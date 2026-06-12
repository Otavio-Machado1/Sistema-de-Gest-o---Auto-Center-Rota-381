public class MecanicoController {
    static Mecanico[] lista = new Mecanico[100];
    static int total = 0;

    public static void cadastrar() {
        MecanicoView.cabecalhoCadastro();

        Mecanico m = new Mecanico();
        m.codigo        = MecanicoView.pedirCodigo();
        m.nome          = MecanicoView.pedirNome();
        m.especialidade = MecanicoView.pedirEspecialidade();

        lista[total] = m;
        total++;

        Dados.salvar();

        MecanicoView.msgSucesso();
        Helper.pressEnter();
    }

    public static void listar() {
        MecanicoView.cabecalhoListar();

        String codigo = "";
        String nome = "";
        String especialidade = "";


        for (int i = 0; i < total; i++) {
            Mecanico m = lista[i];
            codigo = m.codigo;
            nome = m.nome;
            especialidade = m.especialidade;
        }

        MecanicoView.mostrarTabela(codigo, nome, especialidade, total);
        Helper.pressEnter();
    }

    public static int buscar(String codigo) {
        for (int i = 0; i < total; i++) {
            if (lista[i].codigo.equals(codigo)) return i;
        }
        return -1;
    }
}
