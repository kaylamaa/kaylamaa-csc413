/*************************************************
 File: CustomerDAOConcrete.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Customer DAO Concrete
 *************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOConcrete implements CustomerDAO {
    @Override
    public int insert(CustomerDTO customer) throws Exception {
        return 0;
    }

    @Override
    public CustomerDTO get(String id) throws Exception {

        return null;
    }

    @Override
    public int update(CustomerDTO customer) throws Exception {
        return 0;
    }

    @Override
    public int delete(String id) throws Exception {
        return 0;
    }

    @Override
    public List<CustomerDTO> getAll() throws Exception {
        // getting all the customers from DB
        return new ArrayList<>();
    }
}
