package com.vitorhas.migration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_DOCPROCESS", schema = "migrationecm")
public class DocProcess {

    @Id
    @GeneratedValue
    @Column(name="ID_STATUS")
    private int idStatus;

    @Column(name="DS_STATUS")
    private String dsStatus;

    @Column(name="DS_MESSAGE")
    private String dsMessage;


}
