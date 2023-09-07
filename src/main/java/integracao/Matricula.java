package integracao;

public class Matricula {
	private double nota;
	private MatriculaStatus status;
	private Curso curso;
	private boolean podeFazerSub;
	
	public Matricula(Curso curso) {
		super();
		this.curso = curso;
		this.status = MatriculaStatus.CURSANDO;
		this.podeFazerSub = false;
	}

	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public MatriculaStatus getStatus() {
		return status;
	}

	public void setStatus(MatriculaStatus status) {
		this.status = status;
	}

	public boolean isPodeFazerSub() {
		return podeFazerSub;
	}

	public void setPodeFazerSub(boolean podeFazerSub) {
		this.podeFazerSub = podeFazerSub;
	}
}
