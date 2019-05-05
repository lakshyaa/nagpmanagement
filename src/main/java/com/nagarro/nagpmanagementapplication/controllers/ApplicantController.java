package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.*;
import com.nagarro.nagpmanagementapplication.service.ActivityService;
import com.nagarro.nagpmanagementapplication.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;
    /**
     * for log
     */
    Logger logger = Logger.getLogger(ApplicantController.class.getName());

    /**
     * for checking if the controller get loaded properly.
     */
    @PostConstruct
    public void init(){
        System.out.println(applicantService+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /**
     *
     * @param applicant contains info of new applicant
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */

    @PostMapping(value="/applicant",consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Applicant applicant) throws  AddressException, MessagingException, IOException
    {
        //System.out.println("reached in controller");
        logger.info("adding or editing  applicant");
        applicantService.addApplicant(applicant);
        Levels level=new Levels();

        level.setId(1);


        applicant.setLevel(level);
        /**
         * to send email to the applicant
         */
        this.sendmail(applicant);

        System.out.println(applicant.getContactNo()+" "+applicant.getNagpStatus()+" "+applicant.getPassword()+" "+applicant.getLevel());

    }

    /**
     *
     * @param applicant applicant to which email is to be send .Email consist of email and password.
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    private void sendmail(Applicant applicant) throws AddressException, MessagingException, IOException {
        System.out.println("in sendmail method");
        Properties props = new Properties();
        logger.info("MY EMAIL IS="+applicant.getEmail()+">>>>>>>>>>>>>");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        System.out.println("sent email");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lakshyaa149@gmail.com", "youcandoitlaksh07@");
            }
        });
        Message msg = new MimeMessage(session);
        String recip =applicant.getEmail();
        msg.setFrom(new InternetAddress(recip, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(applicant.getEmail()));
        msg.setSubject("Hi, Thanks for registering");
        msg.setContent("Deep email", "text/html");
        msg.setSentDate(new Date());
        String content ="your email:"+ applicant.getEmail() +", password:"+applicant.getPassword();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("C://Users//Lakshay01//Downloads//20190104_003020.jpg");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }


    /**
     *
     * @return fetch all applicants from the database.
     */

    @GetMapping(value="/getAllApplicants")
    public List getApplicants()
    {
        logger.info("Fetching all applicants");


        System.out.println("not at the right placereached in activity controller");


        System.out.println(applicantService.getApplicants());

        return  applicantService.getApplicants();

    }

    /**
     *
     * @param pageno its a number to get paginated results.
     * @return a list of paginated results.
     */

    @GetMapping(value="/getAllApplicants/{pageno}")
    public Page<Applicant> getApplicants(@PathVariable("pageno") int pageno)
    {
        System.out.println("reached in activity controller");

        //  System.out.println(applicantService.getApplicants());

        return  applicantService.findAll(pageno);

    }

    /**
     *
     * @param batchId
     * @param levelId
     * @return list of applicants which belongs to mentionedd levelid and batchid.
     */
    @GetMapping("/applicants")
    public List<Applicant> getApplicants(@RequestParam("batchId") Integer batchId, @RequestParam("levelId") Integer levelId){
        List<Applicant> nagpActivities =	applicantService.findAllByBatchIdAndLevelId(batchId, levelId);
        return nagpActivities;
    }

    /**
     *
     * @param name name of the applicant
     * @return list of applicants which have a same name
     */

    @PostMapping("/applicantsbyname")
    public List<Applicant>  getApplicantsByName(@RequestParam("name") String name)
    {

        return applicantService.findByName(name);
    }


    /**
     *
     * @param user details of the login user.
     * @return applicant if the email and password matches with existing user.
     */
    @PostMapping(value = "/login")
    public ApplicantIds authenticate(@RequestBody Applicant user) {
        logger.info("data of applicant"+user.getPassword()+""+user.getEmail());
        return applicantService.authenticate(user);
    }

    /**
     *
     * @param id id of the applicant
     * @return applicant with that id or returns null id do not exist.
     */
    @GetMapping(value="/applicant/{id}")
public Applicant getApplicantById(@PathVariable("id") int id)
{
return applicantService.getApplicantById(id);


}

    /**
     *
     * @param applicant updated applicant info.
     * @param id of the updated applicant.
     */
    @PutMapping(value="updateapplicant/{id}")
public void updateApplicant(@RequestBody Applicant applicant,Integer id)
{


logger.info("UPDATING APPLICANT THAT IS CURRENT ONE"+applicant.getName()+""+applicant.getEmail()+""+applicant.getPassword());




}


}