package contracts;

import java.util.List;

import exceptions.MatriculaInvalidaException;
import models.Aluno;

public interface iAlunoRepository {
    void adicionar(Aluno aluno) throws MatriculaInvalidaException;
    void remover(Aluno aluno);
    Aluno buscar(String nome);
    List<Aluno> listar();
}