package com.nagarro.nagpmanagementapplication.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.nagarro.nagpmanagementapplication.entity.ApplicantIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import com.nagarro.nagpmanagementapplication.repository.ApplicantRepository;
import com.nagarro.nagpmanagementapplication.service.ApplicantService;

import javax.sql.DataSource;

@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService {

	Logger logger = Logger.getLogger(ApplicantServiceImpl.class.getName());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicantRepository applicantRepository;

	@Override
	public void addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub

		applicantRepository.save(applicant);
	}

	@Override
	public List  getApplicants() {
		// TODO Auto-generated method stub
		String sql = "select * from applicant";
		return jdbcTemplate.queryForList(sql);
		//return applicantRepository.findAll();

		// return applicantRepository.findAll();
	}


	public List<Applicant> findAllByBatchIdAndLevelId(Integer batchId, Integer levelId) {


		return applicantRepository.findAllByBatchIdAndLevelId(batchId, levelId);
	}

	public List<Applicant> findByName(String name) {
		return applicantRepository.findByName(name);
	}

	public Page<Applicant> findAll(int pageno) {


		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(pageno);
		Pageable pageable = PageRequest.of(pageno, 2);
		Page<Applicant> pages = applicantRepository.findAll(pageable);
		return pages;
	}

	public ApplicantIds authenticate(Applicant user) {
		/*Applicant userob = applicantRepository.findByEmail(user.getEmail());
		String email = user.getEmail();

		if(userob.getPassword().equals(userob.getPassword()))
		{
			return userob;
		}
		else
		{
			return null;
		}
		//jdbcTemplate.queryForList(sql);


//logger.info("THE USER OB IS"+userob);

		//if((jdbcTemplate.queryForList(sql))==null) {
		//	return null;
		//}
		//jdbcTemplate.queryForList(sql).get(0).get()

		//List<String> = jdbcTemplate.queryForList(sql).get(0);
		/*String sql="select * from applicant where email=?";

		Applicant applicant= jdbcTemplate.queryForObject(
				sql, new Object[] { email
				},
				new BeanPropertyRowMapper<>(Applicant.class));
		logger.info("info is="+applicant.getName()+" "+applicant.getPassword()+" "+applicant.getEmail());

		if(applicant.getPassword().equals(user.getPassword()))
		{
			return applicant;
		}

	else
		{
return null;
		}
		*/
String email=user.getEmail();
		//String sql = "select * from applicant where email=:'email'";
	//return 	jdbcTemplate.queryForList(sql);
/*
		//Applicant applicant= jdbcTemplate.queryForObject(
				sql, new Object[] { email
				},
				new BeanPropertyRowMapper<>(Applicant.class));
		logger.info("info is="+applicant.getName()+" "+applicant.getPassword()+" "+applicant.getEmail());


String email=user.getEmail();
		String sql = "select * from applicant where email=?";
		List list= jdbcTemplate.queryForObject(sql,email,Applicant);

*/
Applicant applicant=applicantRepository.findFirstByEmail(user.getEmail());

int arr[]=new int[2];
logger.info("level id is="+applicant.getLevel().getId());
		Applicant applicant1=new Applicant();
		applicant1.setLevel(applicant.getLevel());

		applicant1.setBatch(applicant.getBatch());
		ApplicantIds app=new ApplicantIds();
if(applicant.getPassword().equals(user.getPassword()))
{
	int id1= applicant.getLevel().getId();
int id2=	applicant.getBatch().getId();
int id3=applicant.getApplicantId();
app.setLevelid(id1);
app.setBatchid(id2);
app.setApplicantid(id3);
return app;


}
return null;
	}
	public Applicant getApplicantById(int id)
	{
		logger.info("GETTING APPLICANT BY ID THAT IS="+id+">>>>>>>>>>>>>>>>");
		return applicantRepository.findById(id).get();



	}

	public void updateApplicant(Applicant applicant,int id)
	{

		logger.info("updating current applicant >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Applicant old=applicantRepository.findById(id).get();
applicant.setApplicantId(id);
		/*old.setName(applicant.getName());
		old.setPassword(applicant.getPassword());
		old.setEmail(applicant.getEmail());
		old.setNagpStatus(applicant.getNagpStatus());
		old.setContactNo(applicant.getContactNo());
*/
		 applicantRepository.updateApplicant(applicant.getName(),applicant.getPassword(),applicant.getNagpStatus(),applicant.getEmail(),applicant.getContactNo(),id);
	}







}

			

	

