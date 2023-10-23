public class AtividadeComplementar {
    private String nomeAluno;
    private int matricula;
    private int numeroRegistro;
    private int grupoAtividade;
    private String descricaoAtividade;
    private boolean statusAproveitamento;
    private int cargaHoraria;
    private int cargaHorariaConsiderada;

    public AtividadeComplementar(String nomeAluno, int matricula, int numeroRegistro, int grupoAtividade, String descricaoAtividade, int cargaHoraria) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.numeroRegistro = numeroRegistro;
        this.grupoAtividade = grupoAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.statusAproveitamento = false;
        this.cargaHoraria = cargaHoraria;
        this.cargaHorariaConsiderada = 0;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public int getGrupoAtividade() {
        return grupoAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public boolean isStatusAproveitamento() {
        return statusAproveitamento;
    }

    public void setStatusAproveitamento(boolean statusAproveitamento) {
        this.statusAproveitamento = statusAproveitamento;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getCargaHorariaConsiderada() {
        return cargaHorariaConsiderada;
    }

    public void setCargaHorariaConsiderada(int cargaHorariaConsiderada) {
        this.cargaHorariaConsiderada = cargaHorariaConsiderada;
    }
}
