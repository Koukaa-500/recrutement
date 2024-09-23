package com.interview.model.Entity1;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reclamation {

    @Id
    @GeneratedValue()
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(nullable = false)
    private String content;

    private String response;

    @Column(nullable = false)
    private String status; // e.g., "OPEN", "CLOSED"

    @Column(name = "is_responded", nullable = false)
    private Boolean isResponded = false; // Default value


}
