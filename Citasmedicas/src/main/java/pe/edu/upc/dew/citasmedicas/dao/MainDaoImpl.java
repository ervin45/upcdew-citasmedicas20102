/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.citasmedicas.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author 
 */
public class MainDaoImpl {

    protected JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }


}
