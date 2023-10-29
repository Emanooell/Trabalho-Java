import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<AtividadeComplementar> atividades = new ArrayList<>();
        Aluno aluno = null;

        while (true) {
            System.out.println("Olá, bem-vindo ao nosso sistema, o que você deseja fazer?");
            System.out.println("1- Cadastrar aluno");
            System.out.println("2- Cadastrar atividade complementar");
            System.out.println("3- Pesquisar as atividades complementares de um aluno");
            System.out.println("4- Alterar status da atividade complementar");
            System.out.println("5- Mostrar a carga horária total das atividades complementares de todos os alunos cadastrados");
            System.out.println("6- Mostrar a carga horária total das atividades complementares de um aluno cadastrado");
            System.out.println("7- Sair do sistema");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Informe o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Informe a matrícula do aluno:");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o curso do aluno:");
                    String curso = scanner.nextLine();
                    System.out.println("Tem certeza que deseja cadastrar um aluno? (s/n)");
                    String confirmacaoAluno = scanner.nextLine().toLowerCase();
                    if (confirmacaoAluno.equals("s")) {
                        aluno = new Aluno(nomeAluno, matricula, curso);
                        alunos.add(aluno);
                        System.out.println("Aluno cadastrado!");
                    } else {
                        System.out.println("Operação de cadastro de aluno cancelada.");
                    }
                    break;

                case 2:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaAluno = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoEncontrado = null;
                    for (Aluno a : alunos) {
                        if (a.getMatricula() == matriculaAluno) {
                            alunoEncontrado = a;
                            break;
                        }
                    }

                    if (alunoEncontrado != null) {
                        System.out.println("Informe o número do grupo da atividade:");
                        int grupoAtividade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Informe a descrição da atividade:");
                        String descricaoAtividade = scanner.nextLine();
                        System.out.println("Qual a carga horária?");
                        int cargaHoraria = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(
                                "Tem certeza que deseja cadastrar a atividade complementar para o aluno? (s/n)");
                        String confirmacaoAtividade = scanner.nextLine().toLowerCase();
                        if (confirmacaoAtividade.equals("s")) {

                            AtividadeComplementar atividade = new AtividadeComplementar(
                                    alunoEncontrado.getNomeCompleto(), alunoEncontrado.getMatricula(), grupoAtividade,
                                    descricaoAtividade, cargaHoraria);
                                    atividades.add(atividade);

                            alunoEncontrado.adicionarCargaHorariaAtividade(cargaHoraria);

                            System.out.println("Atividade complementar cadastrada para o aluno com matrícula "
                                    + matriculaAluno + "!");
                        } else {
                            System.out.println("Cadastro de atividade complementar cancelado.");
                        }
                    } else {
                        System.out.println("Aluno com matrícula " + matriculaAluno
                                + " não encontrado. Cadastre o aluno primeiro.");
                    }
                    System.out.println("-------------------------------------------------------------------");
                    break;

                case 3:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaPesquisa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Atividades complementares do aluno:");
                    for (AtividadeComplementar a : atividades) {
                        if (a.getMatricula() == matriculaPesquisa) {
                            System.out.println("Número de Registro: " + a.getNumeroRegistro());
                            System.out.println("Descrição: " + a.getDescricaoAtividade());
                        }
                    }
                     System.out.println("-------------------------------------------------------------------");
                    break;

                case 4:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaAlterar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o número do registro da atividade:");
                    int numeroRegistroAlterar = scanner.nextInt();
                    scanner.nextLine();
                    for (AtividadeComplementar a : atividades) {
                        if (a.getMatricula() == matriculaAlterar && a.getNumeroRegistro() == numeroRegistroAlterar) {
                            System.out.println("Informe o novo status de aproveitamento (TRUE ou FALSE):");
                            boolean novoStatus = Boolean.parseBoolean(scanner.nextLine());
                            a.setStatusAproveitamento(novoStatus);
                            System.out.println("Informe a carga horária considerada:");
                            int cargaHorariaConsiderada = scanner.nextInt();
                            scanner.nextLine();
                            a.setCargaHorariaConsiderada(cargaHorariaConsiderada);

                            if (novoStatus) {
                                for (Aluno alunoAtual : alunos) {
                                    if (alunoAtual.getMatricula() == matriculaAlterar) {
                                        alunoAtual.adicionarCargaHoraria(cargaHorariaConsiderada);
                                    }
                                }
                            }
                            System.out.println("Status da atividade alterado com sucesso!");
                            System.out.println("-------------------------------------------------------------------");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Carga horária total das atividades complementares de todos os alunos:");
                    for (Aluno alunoAtual : alunos) {
                        System.out.println("Nome: " + alunoAtual.getNomeCompleto());
                        System.out.println("Matrícula: " + alunoAtual.getMatricula());
                        System.out.println("Curso: " + alunoAtual.getCurso());
                        System.out.println("Carga Horária Total: " + alunoAtual.getCargaHorariaTotal());
                        System.out.println("Quantidade de Atividades: " + alunoAtual.getQuantidadeAtividades());
                        System.out.println("-------------------------------------------------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaPesquisaAluno = scanner.nextInt();
                    scanner.nextLine();
                    for (Aluno alunoAtual : alunos) {
                        if (alunoAtual.getMatricula() == matriculaPesquisaAluno) {
                            System.out.println("Nome: " + alunoAtual.getNomeCompleto());
                            System.out.println("Matrícula: " + alunoAtual.getMatricula());
                            System.out.println("Curso: " + alunoAtual.getCurso());
                            System.out.println("Carga Horária Total: " + alunoAtual.getCargaHorariaTotal());
                            System.out.println("Quantidade de Atividades: " + alunoAtual.getQuantidadeAtividades());
                            System.out.println("-------------------------------------------------------------------");
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Sistema encerrado.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
