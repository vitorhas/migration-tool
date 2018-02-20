package com.vitorhas.migration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_DOCVIEW", schema = "TestDB")
public class DocViewStaging {

    @Id
    @GeneratedValue
    @Column(name="ID_DOC")
    private int idDoc;

    @Column(name="DS_TIPO")
    private String dsTipo;

    @Column(name="DS_PROPRIEDADE")
    private String dsPropriedade;

    @Column(name="DS_VARIAVEL")
    private String dsVariavel;


}
