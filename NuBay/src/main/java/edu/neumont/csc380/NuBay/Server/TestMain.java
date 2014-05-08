package edu.neumont.csc380.NuBay.Server;

import javax.ws.rs.MessageProcessingException;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Profile;
import edu.neumont.csc380.ProfileWebService.services.ProfileClient;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.client.AuthClientImpl;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;
import edu.neumont.csc380.cms.client.*;

public class TestMain
{

	public static void main(String[] args) throws MessageProcessingException, IllegalStateException, InvalidInputException, InvalidTokenException, UserDoesNotExistException
	{
		AuthClientImpl auth = new AuthClientImpl();
		auth.createUser("how", "what", AuthorityLevel.User);
		auth.authenticateUser("how", "what");
		ProfileClient profile = new ProfileClient();
		Profile prof = new Profile();
		ContactInformation c = new ContactInformation();
		c.setAddress("asdf");
		c.setEmail("afd");
		c.setPhone("asdf");
		prof.setContactInformation(c);
		prof.setFirstName("Time");
		prof.setLastName("SF");
		prof.setPassword("dsfs");
		prof.setUsername("adsf");
		Profile nextProf = profile.createProfile(prof);
		System.out.println(nextProf.getFirstName());
		HelloWorldClient cms = new HelloWorldClient();
		Image image = new Image();
		image.setFileName("someFilename");
		cms.createImage(new Image());
	}

}
