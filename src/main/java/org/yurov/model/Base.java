package org.yurov.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bases")
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "base_name")
    private String baseName;

    @Column(name = "base_owner")
    private String baseOwner;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private Long size;

}
