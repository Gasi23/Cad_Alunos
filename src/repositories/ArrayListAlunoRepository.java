package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Aluno;
import contracts.iAlunoRepository;
import exceptions.AlunoNaoEncontradoException;
import exceptions.MatriculaInvalidaException;

public class ArrayListAlunoRepository implements iAlunoRepository {

    private List<Aluno> alunos;

    public ArrayListAlunoRepository() {
        alunos = new ArrayList<Aluno>();
    }

    public void adicionar(Aluno aluno) {
        if (aluno.getMatricula().length() == 10) {
            alunos.add(aluno);
        } else {
            try {
                throw new MatriculaInvalidaException("Matricula com menos de 10 números");
            } catch (MatriculaInvalidaException e) {
                e.printStackTrace();
            }
        }
    }

    public void remover(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
        } else {
            try {
                throw new AlunoNaoEncontradoException("Aluno não encontrado");
            } catch (AlunoNaoEncontradoException e) {
                e.printStackTrace();
            }
        }
    }

    public Aluno buscar(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        try {
            throw new AlunoNaoEncontradoException("Aluno não encontrado");
        } catch (AlunoNaoEncontradoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Aluno> listar() {
        return alunos;
    }
}
