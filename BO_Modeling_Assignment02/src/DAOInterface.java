/*************************************************
 File: DAOInterface.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: General DAO interface provided
 by professor
 *************************************************/
import java.sql.SQLException;
import java.util.List;
public interface DAOInterface<T> {

    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    int save(T e) throws SQLException;
    int insert(T e) throws SQLException;
    int update(T e) throws SQLException;
    int delete(T e) throws SQLException;

}