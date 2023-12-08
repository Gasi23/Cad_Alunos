import java.util.List;

public class App {
    public static void main(String[] args) {
             iAlunoRepository repositorio = new ArrayListAlunoRepository();

        repositorio.adicionar(new Aluno("Aluno1", "1234567890"));
        repositorio.adicionar(new Aluno("Aluno2", "0987654321"));
        repositorio.adicionar(new Aluno("Aluno3", "1112233445"));
        repositorio.adicionar(new Aluno("Aluno4", "5555666677"));
        repositorio.adicionar(new Aluno("Aluno5", "9876543210"));

        List<Aluno> listaAlunos = repositorio.listar();
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : listaAlunos) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }

        Aluno alunoBuscado = repositorio.buscar("Aluno3");
        if (alunoBuscado != null) {
            System.out.println("\nAluno encontrado: " + alunoBuscado.getNome());
        } else {
            System.out.println("\nAluno não encontrado.");
        }

        Aluno alunoRemover = new Aluno("Aluno2", "0987654321");
        repositorio.remover(alunoRemover);

        System.out.println("\nLista de Alunos após a remoção:");
        List<Aluno> alunosRestantes = repositorio.listar();
        for (Aluno aluno : alunosRestantes) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }
    }
}