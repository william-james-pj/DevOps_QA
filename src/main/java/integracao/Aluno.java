package integracao;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private int ra;
	private String nome;
	private int qtdCursosDisponivel;
	private List<Matricula> matriculas;
	
	public Aluno(int ra, String nome) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.qtdCursosDisponivel = 1;
		this.matriculas = new ArrayList<>();
	}
	
	public void inscreverCurso(Curso curso) {
		if(this.qtdCursosDisponivel < 1) {
			return;
		}
		
		Matricula matricula = new Matricula(curso);
		matriculas.add(matricula);
		this.qtdCursosDisponivel -= 1;
	}
	
	public void finalizarCurso(double nota, Curso curso) {	
		for (Matricula matricula : matriculas) {
			if(matricula.getCurso().equals(curso)) {
				matricula.setNota(nota);
				if(nota >= 7) {
					matricula.setStatus(MatriculaStatus.FINALIZADO);
					this.qtdCursosDisponivel += 3;
				} else {
					matricula.setStatus(MatriculaStatus.REPROVADO);
					matricula.setPodeFazerSub(true);
					this.qtdCursosDisponivel += 1;
				}
			}
		}
	}

	public int getRA() {
		return ra;
	}
	
	public void setRA(int ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public int getQtdCursosDisponivel() {
		return qtdCursosDisponivel;
	}

	public void setQtdCursosDisponivel(int qtdCursosDisponivel) {
		this.qtdCursosDisponivel = qtdCursosDisponivel;
	}
}
