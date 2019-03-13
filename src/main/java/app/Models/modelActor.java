package app.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "actor")
public class modelActor {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Integer actor_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "last_update")
    private Date last_update;
}
