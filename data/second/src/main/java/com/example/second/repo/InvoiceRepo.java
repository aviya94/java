package com.example.second.repo;

import com.example.second.entity.Invoice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepo extends RepoBase {

    protected InvoiceRepo(JdbcTemplate jdbc) {
        super(jdbc);
    }

    public Invoice creatInvoice(String... values) {
        var sql = "INSERT INTO invoices (CustomerId,InvoiceDate, BillingAddress,BillingCity,BillingState, BillingCountry, BillingPostalCode,Total)VALUES (?,CURRENT_TIMESTAMP ,?,?,?,?,?,?);";
        if (super.getJdbc().update(sql, values) > 0) {
            return getNewInvoiceId();
        }
        throw new IllegalArgumentException();
    }

    private Invoice getNewInvoiceId() {
        var sql = "select InvoiceId from invoices order by InvoiceId desc limit 1";
        RowMapper<Invoice> toArtist = (rs, n) -> new Invoice(rs.getInt(1));
        return super.getJdbc().query(sql, toArtist).get(0);
    }

    public void updateInvoiceItem(String... values) {
        var sql = "INSERT INTO invoice_items(InvoiceId, TrackId, UnitPrice, Quantity)VALUES (?, ?, ?, ?);";
       var res= super.getJdbc().update(sql, values);
       if(res<0)
       {
           throw new IllegalArgumentException();
       }
    }
}
