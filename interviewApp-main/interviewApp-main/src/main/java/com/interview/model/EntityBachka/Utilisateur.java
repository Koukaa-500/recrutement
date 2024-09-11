        package com.interview.model.EntityBachka;

        import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import java.io.Serializable;

        @Entity
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

        public class Utilisateur implements Serializable {
            @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateur_seq")
            @SequenceGenerator(name = "utilisateur_seq", sequenceName = "utilisateur_seq", allocationSize = 1)
            private Integer id;
            private String nom;
            private String prenom;
            private Integer age;
            private String motDePasse;
            private String email;
            private RoleUtilisateur role;
        }
