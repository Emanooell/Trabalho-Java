import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<AtividadeComplementar> atividades = new ArrayList<>();

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
            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()

            switch (escolha) {
                case 1:
                    System.out.println("Informe o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Informe a matrícula do aluno:");
                    int matricula = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Informe o curso do aluno:");
                    String curso = scanner.nextLine();
                    Aluno aluno = new Aluno(nomeAluno, matricula, curso);
                    alunos.add(aluno);
                    System.out.println("Aluno cadastrado!");
                    break;

                case 2:
                    System.out.println("Informe o nome do aluno:");
                    String nomeAlunoAtividade = scanner.nextLine();
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaAtividade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Informe o número do registro da atividade:");
                    int numeroRegistro = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Informe o número do grupo da atividade:");
                    int grupoAtividade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Informe a descrição da atividade:");
                    String descricaoAtividade = scanner.nextLine();
                    System.out.println("Qual a carga horária?");
                    int cargaHoraria = scanner.nextInt();
                    AtividadeComplementar atividade = new AtividadeComplementar(nomeAlunoAtividade, matriculaAtividade, numeroRegistro, grupoAtividade, descricaoAtividade, cargaHoraria);
                    atividades.add(atividade);
                    System.out.println("Atividade complementar cadastrada!");
                    break;

                case 3:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaPesquisa = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Atividades complementares do aluno:");
                    for (AtividadeComplementar a : atividades) {
                        if (a.getMatricula() == matriculaPesquisa) {
                            System.out.println("Número de Registro: " + a.getNumeroRegistro());
                            System.out.println("Descrição: " + a.getDescricaoAtividade());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaAlterar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Informe o número do registro da atividade:");
                    int numeroRegistroAlterar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    for (AtividadeComplementar a : atividades) {
                        if (a.getMatricula() == matriculaAlterar && a.getNumeroRegistro() == numeroRegistroAlterar) {
                            System.out.println("Informe o novo status de aproveitamento (TRUE ou FALSE):");
                            boolean novoStatus = Boolean.parseBoolean(scanner.nextLine());
                            a.setStatusAproveitamento(novoStatus);
                            System.out.println("Informe a carga horária considerada:");
                            int cargaHorariaConsiderada = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                            a.setCargaHorariaConsiderada(cargaHorariaConsiderada);

                            // Atualizar carga horária total do aluno, se a atividade for aprovada
                            if (novoStatus) {
                                for (Aluno aluno : alunos) {
                                    if (aluno.getMatricula() == matriculaAlterar) {
                                        aluno.adicionarCargaHoraria(cargaHorariaConsiderada);
                                    }
                                }
                            }
                            System.out.println("Status da atividade alterado com sucesso!");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Carga horária total das atividades complementares de todos os alunos:");
                    for (Aluno aluno : alunos) {
                        System.out.println("Nome: " + aluno.getNomeCompleto());
                        System.out.println("Matrícula: " + aluno.getMatricula());
                        System.out.println("Curso: " + aluno.getCurso());
                        System.out.println("Carga Horária Total: " + aluno.getCargaHorariaTotal());
                        System.out.println("Quantidade de Atividades: " + aluno.getQuantidadeAtividades());
                        System.out.println("------");
                    }
                    break;

                case 6:
                    System.out.println("Informe a matrícula do aluno:");
                    int matriculaPesquisaAluno = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    for (Aluno aluno : alunos) {
                        if (aluno.getMatricula() == matriculaPesquisaAluno) {
                            System.out.println("Nome: " + aluno.getNomeCompleto());
                            System.out.println("Matrícula: " + aluno.getMatricula());
                            System.out.println("Curso: " + aluno.getCurso());
                            System.out.println("Carga Horária Total: " + aluno.getCargaHorariaTotal());
                            System.out.println("Quantidade de Atividades: " + aluno.getQuantidadeAtividades());
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
