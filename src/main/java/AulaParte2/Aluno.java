package AulaParte2;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Aluno {

    private int id;
    private String nome;
    private int idade;
    private String estado;

    public Aluno(int id, String nome, int idade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno(String nome, int idade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno() { }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AulaParte2.Aluno{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append(", estado='").append(estado).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
