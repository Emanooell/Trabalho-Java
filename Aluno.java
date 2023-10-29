public class Aluno {
    private String nomeCompleto;
    private int matricula;
    private String curso;
    private int cargaHorariaTotal;

    public Aluno(String nomeCompleto, int matricula, String curso) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.curso = curso;
        this.cargaHorariaTotal = 0;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void adicionarCargaHoraria(int cargaHoraria) {
        this.cargaHorariaTotal += cargaHoraria;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public int getQuantidadeAtividades() {
      
        return 0;
    }
    
public void adicionarCargaHorariaAtividade(int cargaHoraria) {
    this.cargaHorariaTotal += cargaHoraria;
}

public void atualizarStatusAtividade(boolean statusAproveitamento, int cargaHorariaConsiderada) {
    if (statusAproveitamento) {
        adicionarCargaHoraria(cargaHorariaConsiderada);
    }
}

}
