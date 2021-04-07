//https://stackoverflow.com/questions/31158509/how-to-generate-custom-id-using-hibernate-while-it-must-be-primary-key-of-table

package com.petar.model;

import java.io.Serializable;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

	public class OfficeIdGenerator implements IdentifierGenerator{
		
		private String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";

		@Override
		public Serializable generate(SharedSessionContractImplementor session, Object object)
				throws HibernateException {
			Serializable result = null;
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;

	        //String prefix = "emp";
	        try {
	            connection = session.connection();
	            statement = connection.createStatement();
	            try {
	                /*
	                * uncomment below line if you are using mysql and the sequence DOES NOT EXIST.
	                * As we all know MySql does not support sequence, instead there is AUTO INCREMENT
	                * if you are using other databases change SQL according to that
	                * e.g. Oracle: "SELECT "+sequenceName+".NEXTVAL FROM DUAL"
	                * PostgreSQL: "SELECT  NEXTVAL('+sequenceName+"')  
	                * */
	                statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
	                resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
	            } catch (Exception e) {

	                System.out.println("In catch, cause : Table is not available.");
	                // if sequence is not found then creating the sequence
	                // Below code is for MySql database you change according to your database
	                statement.execute("CREATE table " + DEFAULT_SEQUENCE_NAME + " (next_val INT NOT NULL)");
	                statement.executeUpdate("INSERT INTO " + DEFAULT_SEQUENCE_NAME + " VALUES(0)");
	                //==> LAST_INSERT_ID(next_val+1)  -> this is inbuilt function of MySql so by using this we can achieve our custom sequence like auto increment
	                statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
	                resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
	                //e.printStackTrace();
	            }
	            if (resultSet.next()) {

	                int nextValue = resultSet.getInt(1);
	                String suffix = String.format("%04d", nextValue);
	                result = suffix; //prefix.concat(suffix);
	                System.out.println("Custom generated sequence is : " + result);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
		}
	}
