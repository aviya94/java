package com.example.second.repo;

import com.example.second.entity.Customer;
import com.example.second.entity.Entity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepo extends RepoBase{
    protected CustomerRepo(JdbcTemplate jdbc) {
        super(jdbc);
    }

    public List<Customer> getUser(int id) {
        var sql = "select FirstName||' '||LastName as name,Email,Address,City,State,country,PostalCode from customers where CustomerId=?";
        RowMapper<Customer> toCustomer = (rs, n) -> new Customer(id,rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        return super.getJdbc().query(sql, toCustomer, id);
    }
}
