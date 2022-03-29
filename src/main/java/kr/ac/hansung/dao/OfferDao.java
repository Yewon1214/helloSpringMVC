package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.ClassList;
import kr.ac.hansung.model.Offer;

@Repository
public class OfferDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from class";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public int getSemesterGrade(int year, int semester) {
		String sqlStatement="select sum(grade) from class where year=? and semester=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {year, semester}, Integer.class);
		
	}
	
	public int getAllGrade() {
		String sqlStatement="select sum(grade) from class";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
	}
	
	//년도와 학기를 주면 그 년도와 학기에있는 모든 오브젝트 리턴
	public List<Offer> getYSOffers(int year, int semester) {
		String sqlStatement = "select * from class where year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester},
				new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setClassification(rs.getString("classification"));
				offer.setClassName(rs.getString("className"));
				offer.setProfName(rs.getString("profName"));
				offer.setGrade(rs.getInt("grade"));
				
				return offer;
			}

		});

	}

	// query and return a single object
	// cRud method
	public List<Offer> getOffers() {
		String sqlStatement = "select * from class";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setClassification(rs.getString("classification"));
				offer.setClassName(rs.getString("className"));
				offer.setProfName(rs.getString("profName"));
				offer.setGrade(rs.getInt("grade"));
				
				return offer;
			}

		});

	}

	// Crud method
	public boolean insert(Offer offer) {

		int year = offer.getYear();
		int semester=offer.getSemester();
		String className = offer.getClassName();
		String classification = offer.getClassification();
		String profName = offer.getProfName();
		int grade=offer.getGrade();

		String sqlStatement = "insert into class( year, semester, className, classification, profName, grade) values(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, className, classification, profName, grade }) == 1);

	}

	// crUd method
	public boolean update(Offer offer) {

		int id = offer.getId();
		int year = offer.getYear();
		int semester=offer.getSemester();
		String className = offer.getClassName();
		String classification = offer.getClassification();
		String profName = offer.getProfName();
		int grade=offer.getGrade();


		String sqlStatement = "update class set year=?, semester=?, className=?, classification=?, profName=?, grade=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, className, classification, profName, grade, id }) == 1);

	}

	// cruD method
	public boolean delete(int id) {
		String sqlStatement = "delete from class where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);

	}
}
