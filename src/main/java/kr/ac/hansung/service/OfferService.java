package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.ClassList;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDao offerDao;
	
	int gradesum;
	
	public List<Offer> getCurrent() {
		
		return offerDao.getOffers();
	}
	
	public List<Offer> getClass(int year, int semester){
		return offerDao.getYSOffers(year, semester);
	}
	
	
	public int getAllGrade() {
		return offerDao.getAllGrade();
	}
	
	public ClassList getGradeSum(int year, int semester) {
		int gs=offerDao.getSemesterGrade(year, semester);
		ClassList cl=new ClassList();
		cl.setYear(year);
		cl.setSemester(semester);
		cl.setGradesum(gs);
		return cl;
	}

	public void insert(Offer offer) {
		offerDao.insert(offer);
	}

	

}
