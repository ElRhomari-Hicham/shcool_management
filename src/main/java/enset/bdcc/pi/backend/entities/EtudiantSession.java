package enset.bdcc.pi.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@ToString
public class EtudiantSession implements Serializable {
    @EmbeddedId

    EtudiantSessionKey id;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    Etudiant etudiant;
    @ManyToOne
    @MapsId("session_id")
    @JoinColumn(name = "session_id")
    Session session;
    @JsonProperty("is_passed")
    private boolean is_passed = false;
    @JsonProperty("is_dropped")
    private boolean is_dropped = false;
    @Column(updatable = false,name = "created_at")
    @CreationTimestamp
    private Date createdAt; // initialize created date
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt; // initialize updated date
    
    public EtudiantSession(Etudiant etudiant,Session session){
        this.etudiant = etudiant;
        this.session = session;
        id = new EtudiantSessionKey(etudiant.getId(),session.getId());
    }
    public void generateKeyFromCurrentAttributes(){
        id = new EtudiantSessionKey(etudiant.getId(),session.getId());

    }

}
