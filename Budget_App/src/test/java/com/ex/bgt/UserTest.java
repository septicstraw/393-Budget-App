package com.ex.bgt;

import org.junit.Test;

import com.ex.bgt.domain.User;

import junit.framework.Assert;

public class UserTest {
	private int u1Id = 1;
	private int u2Id = 2;
	private int u3Id = 3;
	private int u4Id = 4;

	private String u1FirstName = "Reina";
	private String u2FirstName = "Lock";
	private String u3FirstName = "Bryn";
	private String u4FirstName = "Giulio";

	private String u1LastName = "Fessier";
	private String u2LastName = "Lyte";
	private String u3LastName = "Cressy";
	private String u4LastName = "Greener";

	private String u1Email = "rfessier0@arstechnica.com";
	private String u2Email = "llyte1@craigslist.org";
	private String u3Email = "bcressy2@bbb.org";
	private String u4Email = "ggreener3@marriott.com";

	private int u1Password = 88204;
	private int u2Password = 6425;
	private int u3Password = 71860;
	private int u4Password = 63;

	private User u1 = new User(u1Id, u1Email, u1Password, u1FirstName, u1LastName);
	private User u2 = new User(u2Id, u2Email, u2Password, u2FirstName, u2LastName);
	private User u3 = new User(u3Id, u3Email, u3Password, u3FirstName, u3LastName);
	private User u4 = new User(u4Id, u4Email, u4Password, u4FirstName, u4LastName);
	
	@Test
	public void testGetId() {
		Assert.assertEquals("User 1 returns the wrong ID", u1Id, u1.getID());
		Assert.assertEquals("User 2 returns the wrong ID", u2Id, u2.getID());
		Assert.assertEquals("User 3 returns the wrong ID", u3Id, u3.getID());
		Assert.assertEquals("User 4 returns the wrong ID", u4Id, u4.getID());
	}

	@Test
	public void testGetFirstName() {
		Assert.assertEquals("User 1 returns the wrong first name", u1FirstName, u1.getFirstName());
		Assert.assertEquals("User 2 returns the wrong first name", u2FirstName, u2.getFirstName());
		Assert.assertEquals("User 3 returns the wrong first name", u3FirstName, u3.getFirstName());
		Assert.assertEquals("User 4 returns the wrong first name", u4FirstName, u4.getFirstName());
	}

	@Test
	public void testGetLastName() {
		Assert.assertEquals("User 1 returns the wrong last name", u1LastName, u1.getLastName());
		Assert.assertEquals("User 2 returns the wrong last name", u2LastName, u2.getLastName());
		Assert.assertEquals("User 3 returns the wrong last name", u3LastName, u3.getLastName());
		Assert.assertEquals("User 4 returns the wrong last name", u4LastName, u4.getLastName());
	}

	@Test
	public void testGetEmail() {
		Assert.assertEquals("User 1 returns the wrong email", u1Email, u1.getEmail());
		Assert.assertEquals("User 2 returns the wrong email", u2Email, u2.getEmail());
		Assert.assertEquals("User 3 returns the wrong email", u3Email, u3.getEmail());
		Assert.assertEquals("User 4 returns the wrong email", u4Email, u4.getEmail());
	}

	@Test
	public void testGetPassword() {
		Assert.assertEquals("User 1 returns the wrong password", u1Password, u1.getPass());
		Assert.assertEquals("User 2 returns the wrong password", u2Password, u2.getPass());
		Assert.assertEquals("User 3 returns the wrong password", u3Password, u3.getPass());
		Assert.assertEquals("User 4 returns the wrong password", u4Password, u4.getPass());
	}

		
	@Test
	public void testSetId() {
		u1.setID(u4Id);
		u2.setID(u3Id);
		u3.setID(u2Id);
		u4.setID(u1Id);

		Assert.assertEquals("User 1 sets ID wrong", u4Id, u1.getID());
		Assert.assertEquals("User 2 sets ID wrong", u3Id, u2.getID());
		Assert.assertEquals("User 3 sets ID wrong", u2Id, u3.getID());
		Assert.assertEquals("User 4 sets ID wrong", u1Id, u4.getID());
	}

	@Test
	public void testSetFirstName() {
		u1.setFirstName(u4FirstName);
		u2.setFirstName(u3FirstName);
		u3.setFirstName(u2FirstName);
		u4.setFirstName(u1FirstName);

		Assert.assertEquals("User 1 sets first name wrong", u4FirstName, u1.getFirstName());
		Assert.assertEquals("User 2 sets first name wrong", u3FirstName, u2.getFirstName());
		Assert.assertEquals("User 3 sets first name wrong", u2FirstName, u3.getFirstName());
		Assert.assertEquals("User 4 sets first name wrong", u1FirstName, u4.getFirstName());
	}

	@Test
	public void testSetLastName() {
		u1.setLastName(u4LastName);
		u2.setLastName(u3LastName);
		u3.setLastName(u2LastName);
		u4.setLastName(u1LastName);

		Assert.assertEquals("User 1 sets last name wrong", u4LastName, u1.getLastName());
		Assert.assertEquals("User 2 sets last name wrong", u3LastName, u2.getLastName());
		Assert.assertEquals("User 3 sets last name wrong", u2LastName, u3.getLastName());
		Assert.assertEquals("User 4 sets last name wrong", u1LastName, u4.getLastName());
	}

	@Test
	public void testSetEmail() {
		u1.setEmail(u4Email);
		u2.setEmail(u3Email);
		u3.setEmail(u2Email);
		u4.setEmail(u1Email);

		Assert.assertEquals("User 1 sets email wrong", u4Email, u1.getEmail());
		Assert.assertEquals("User 2 sets email wrong", u3Email, u2.getEmail());
		Assert.assertEquals("User 3 sets email wrong", u2Email, u3.getEmail());
		Assert.assertEquals("User 4 sets email wrong", u1Email, u4.getEmail());
	}

	@Test
	public void testSetPassword() {
		u1.setPass(u4Password);
		u2.setPass(u3Password);
		u3.setPass(u2Password);
		u4.setPass(u1Password);

		Assert.assertEquals("User 1 sets password wrong", u4Password, u1.getPass());
		Assert.assertEquals("User 2 sets password wrong", u3Password, u2.getPass());
		Assert.assertEquals("User 3 sets password wrong", u2Password, u3.getPass());
		Assert.assertEquals("User 4 sets password wrong", u1Password, u4.getPass());
	}


}
