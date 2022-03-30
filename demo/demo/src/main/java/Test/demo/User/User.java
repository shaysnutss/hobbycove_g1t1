package Test.demo.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Test.demo.Community.*;
import Test.demo.Post.*;
import Test.demo.Skills.Skills;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "User", schema = "cs206")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "role")
    private String role; // student or teacher

    @Column(name = "location")
    private String location;

    @ManyToMany
    @JoinTable(name = "User_Communities", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "community_id", referencedColumnName = "community_id"))
    private Set<Community> communities = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Skills> skills;

    public boolean deleteSkill(Skills skill) {
        for (int i=0; i<skills.size(); i++) {
            if (skills.get(i).getId()==skill.getId()) {
                skills.remove(i);
                return true;
            }
        }
        return false;
    }


}