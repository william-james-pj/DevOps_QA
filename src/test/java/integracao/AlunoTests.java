package integracao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlunoTests {
	
	@Test
	public void deveSeMatricularSeForOPrimeiroCurso() {
		Aluno aluno = new Aluno(887, "Thiago");
		Curso curso = new Curso(1, "Botanica");
		
		aluno.inscreverCurso(curso);
		
		assertEquals(aluno.getMatriculas().size(), 1);
	}
	
	@Test
	public void naoDeveSeMatricularSeNaoTiverCursoDisponivel() {
		Aluno aluno = new Aluno(887, "Thiago");
		Curso curso = new Curso(1, "Botanica");
		Curso curso2 = new Curso(2, "Ciencias Socias");
		
		aluno.inscreverCurso(curso);
		aluno.inscreverCurso(curso2);
		
		assertEquals(aluno.getMatriculas().size(), 1);
	}
	
	@Test
	public void deveFinalizarCursoSeMediaForMaiorIgualASete() {
		Aluno aluno = new Aluno(887, "Thiago");
		Curso curso = new Curso(1, "Botanica");
		
		aluno.inscreverCurso(curso);
		aluno.finalizarCurso(8, curso);
		
		assertEquals(aluno.getQtdCursosDisponivel(), 3);
		assertEquals(aluno.getMatriculas().get(0).getStatus(), MatriculaStatus.FINALIZADO);
	}
	
	@Test
	public void deveReprovarCursoSeMediaForMenorQueSete() {
		Aluno aluno = new Aluno(887, "Thiago");
		Curso curso = new Curso(1, "Botanica");
		
		aluno.inscreverCurso(curso);
		aluno.finalizarCurso(3, curso);
		
		assertEquals(aluno.getQtdCursosDisponivel(), 1);
		assertEquals(aluno.getMatriculas().get(0).getStatus(), MatriculaStatus.REPROVADO);
		assertEquals(aluno.getMatriculas().get(0).isPodeFazerSub(), true);
	}
	
	@Test
	public void deveFazerNadaSePassarUmCursoInvalido() {
		Aluno aluno = new Aluno(887, "Thiago");
		Curso curso = new Curso(1, "Botanica");
		Curso curso2 = new Curso(2, "Botanica 2");
		
		aluno.inscreverCurso(curso);
		aluno.finalizarCurso(3, curso2);
		
		assertEquals(aluno.getQtdCursosDisponivel(), 0);
		assertEquals(aluno.getMatriculas().get(0).getStatus(), MatriculaStatus.CURSANDO);
	}
}
