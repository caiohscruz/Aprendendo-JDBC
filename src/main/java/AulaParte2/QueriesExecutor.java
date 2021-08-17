package AulaParte2;

    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;

public class QueriesExecutor {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        Scanner sc = new Scanner(System.in);

        int opt=404;

        do {

            System.out.println("\nQual operação deseja realizar?");
            System.out.println("Digite 1 para listar todos os registros");
            System.out.println("Digite 2 para buscar registros especificos");
            System.out.println("Digite 3 para inserir um registro");
            System.out.println("Digite 4 para deletar um registro");
            System.out.println("Digite 5 para atualizar um registro");
            System.out.println("Digite 0 para sair\n");

            try {
                opt = sc.nextInt();

                switch (opt) {
                    case 0:
                        //sair;
                        break;
                    case 1:
                        //consulta;
                        List<Aluno> alunos = alunoDAO.consulta();
                        alunos.stream().forEach(System.out::println);
                        break;
                    case 2:
                        //consulta com filtro;
                        System.out.println("\nInforme o id do aluno que deseja consultar\n");
                        Aluno alunoParaConsulta = alunoDAO.getById(sc.nextInt());
                        System.out.println(alunoParaConsulta);
                        break;
                    case 3:
                        //inserir;
                        System.out.println("\nInforme o nome\n");
                        String nome = sc.next();
                        System.out.println("\nInforme a idade\n");
                        int idade = sc.nextInt();
                        System.out.println("\nInforme o estado\n");
                        String estado = sc.next();
                        Aluno alunoParaInsercao = new Aluno(nome, idade, estado);
                        alunoDAO.create(alunoParaInsercao);
                        break;
                    case 4:
                        //deletar;
                        System.out.println("\nInforme o id do aluno que deseja deletar\n");
                        alunoDAO.delete(sc.nextInt());
                        break;
                    case 5:
                        //atualizar;
                        System.out.println("\nInforme o id do aluno que deseja atualizar\n");
                        Aluno alunoParaAtualizar = alunoDAO.getById(sc.nextInt());
                        System.out.println("\nInforme o nome\n");
                        alunoParaAtualizar.setNome(sc.next());
                        System.out.println("\nInforme a idade\n");
                        alunoParaAtualizar.setIdade(sc.nextInt());
                        System.out.println("\nInforme o estado\n");
                        alunoParaAtualizar.setEstado(sc.next());

                        alunoDAO.update(alunoParaAtualizar);
                        break;
                    default:
                        System.out.println("Opção Inválida: " + opt);
                }
            }catch (InputMismatchException e){
                System.out.println("Informe um valor inteiro");
                sc.next();
            }

            } while (opt!=0);
    }

}