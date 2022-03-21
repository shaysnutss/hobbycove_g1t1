package Test.demo.Community;

import javax.persistence.*;
import lombok.*;

import Test.demo.User.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "User_Communities", schema = "cs206")
public class UserCommunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_communities_id")
    private long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "community_id")
    private Long community_id;

    public UserCommunities(Long userId, Long communityId) {
        this.userId = userId;
        this.community_id = communityId;
    }



}
