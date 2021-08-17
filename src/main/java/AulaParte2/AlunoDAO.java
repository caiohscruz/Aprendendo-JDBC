package AulaParte2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    String refDB="connctionMySQL.properties";

    // CONSULTA
    public List<Aluno> consulta() {

        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM aluno";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id,nome,idade,estado));
            }
        } catch (SQLException e) {
            System.out.println("Consulta FALHOU!");
            e.printStackTrace();
        }
        return alunos;
    }

    // CONSULTA COM FILTRO
    public Aluno getById(int id) {
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        return aluno;
    }

    //  INSERÇÃO
    public void create(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO aluno(nome, idade, estado) VALUES(?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3 , aluno.getEstado());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

}