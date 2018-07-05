/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmt;

import java.sql.SQLException;

public class Operations {

public Sql sql = new Sql();

public void rollNumberAllocation() throws SQLException{
    sql.rollNumberAllocation();
}    

}
