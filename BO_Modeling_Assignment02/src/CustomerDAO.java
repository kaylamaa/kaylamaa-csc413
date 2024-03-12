/*************************************************
 File: CustomerDAO.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Customer DAO Interface
 *************************************************/
import java.util.List;

public interface CustomerDAO {
    int insert(CustomerDTO customer) throws Exception;
    CustomerDTO get(String id) throws Exception;
    int update(CustomerDTO customer) throws Exception;
    int delete(String id) throws Exception;
    List<CustomerDTO> getAll() throws Exception;
}
