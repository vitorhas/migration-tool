package com.vitorhas.migration.repository;

import com.vitorhas.migration.config.DatabaseConfig;
import com.vitorhas.migration.model.DocViewStaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DocViewStagingRepository {
    @Autowired
    DatabaseConfig databaseConfig;

    @Transactional
    public List<DocViewStaging> findAll(){
        databaseConfig.sqlserverJdbcTemplate(databaseConfig.sqlserverDataSource()).execute("USE TestDB");
        return databaseConfig.sqlserverJdbcTemplate(
                        databaseConfig.sqlserverDataSource())
                        .query("select * from TB_DOCVIEW", new DocViewStagingMapper());
    }

    class DocViewStagingMapper implements RowMapper<DocViewStaging> {
        @Override
        public DocViewStaging mapRow(ResultSet rs, int rowNum) throws SQLException {
            DocViewStaging docViewStaging = new DocViewStaging();
            docViewStaging.setIdDoc(rs.getInt("id_doc"));
            docViewStaging.setDsTipo(rs.getString("ds_tipo"));
            docViewStaging.setDsVariavel(rs.getString("ds_variavel"));
            docViewStaging.setDsPropriedade(rs.getString("ds_propriedade"));
            return docViewStaging;
        }
    }

}
