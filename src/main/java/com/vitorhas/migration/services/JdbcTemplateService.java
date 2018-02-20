package com.vitorhas.migration.services;

import com.vitorhas.migration.config.DatabaseConfig;

public class JdbcTemplateService {

    public void sqlServerCreateTest(DatabaseConfig databaseConfig){
        String sql =    "USE TestDB;" +
                        "CREATE TABLE TB_DOCVIEW(" +
                        "ID_DOC INTEGER, DS_PROPRIEDADE VARCHAR(255), DS_VARIAVEL VARCHAR(255));";

        //getJdbcTemplate().update(sql)
        databaseConfig.sqlserverJdbcTemplate(databaseConfig.sqlserverDataSource()).execute(sql);
    }
}
