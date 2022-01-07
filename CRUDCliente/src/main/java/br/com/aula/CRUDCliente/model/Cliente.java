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
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "IdCliente")
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String Email;

    @Column(name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "Id_Address", referencedColumnName = "Id_Address")
    private Endereco address;

}
