package Test.demo.Post;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import Test.demo.Community.Community;
import Test.demo.User.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Post", schema = "cs206")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long postId;

    @Column(name = "community_id")
    private long communityId;

    @Column(name = "content")
    private String content;

    public Post(Long community_id, String content) {
        this.communityId = community_id;
        this.content = content;
    }

}
