package com.nav.hsql;

import java.nio.MappedByteBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component("OffersDAO")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired//@Inject
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Offer> getOffers() {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Navneet");
		List<Offer> offers = jdbcTemplate.query("select * from offers",  new RowMapper<Offer>(){
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;	
			}});
		return offers;
	}
	
	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		Offer offer = jdbcTemplate.queryForObject("select * from PUBLIC.offers where id = :id",params,  new RowMapper<Offer>(){
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;	
			}});
		return offer;
	}
	
	public int delete(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		//jdbcTemplate.getJdbcOperations().update("delete from offers")''
		return jdbcTemplate.update("delete from offers where id = :id", params);
	}
	public int create(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbcTemplate.update("insert into offers (name, text, email) values (:name, :text, :email)", params);
	}
	
	
	//@Transactional(isolation=Isolation.READ_COMMITTED) // all inserted or none
	@Transactional
	public int[] create(List<Offer> offers){
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbcTemplate.batchUpdate("insert into offers (name, text, email) values (:name, :text, :email)", params);
	}
	
	public int update(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbcTemplate.update("update offers set name=:name, text=:text, email=:email where id=:id", params);
	}
}
