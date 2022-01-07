package br.com.aula.CRUDCliente.model;

import lombok.*;

import javax.persistence.*;

//ANNOTATION LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

//ANNOTATION JPA
@Entity
@Table(name = "Endereco" )
public class Endereco {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "Id_Address")
    private Long id;

    @Column(name = "street" )
    private String street;

    @Column(name = "neighborhood" )
    private String neighborhood;

    @Column(name = "number" )
    private int number;

    @NonNull
    @Column(name = "city", nullable = false )
    private String city;

    @NonNull
    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "cep" )
    private String cep;
}
