//package com.ascendum.lopal.tests;
//
//import com.ascendum.lopal.base.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class AllTests {
//
//    AccountCreationTest accountCreationTest = new AccountCreationTest();
//    EditProfileTest editProfileTest = new EditProfileTest();
//    ForgotPasswordTest forgotPasswordTest = new ForgotPasswordTest();
//    SignInWithExistingAccountTest signInWithExistingAccountTest = new SignInWithExistingAccountTest();
//
//    public AllTests() throws IOException {
//    }
//
//    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
//    public void executeAllTests(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
//                                String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode, String newFirstName) throws IOException{
//        accountCreationTest.createAccountFeatures( existingAccountEmail, existingAccountPassword, createAccount, createAccountPassword, createAccountConfirmPassword,
//                 firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode);
//        forgotPasswordTest.enterEmailToResetPassword(existingAccountEmail, existingAccountPassword, createAccount, createAccountPassword, createAccountConfirmPassword,
//                firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode);
//        signInWithExistingAccountTest.validateLogin(existingAccountEmail, existingAccountPassword, createAccount, createAccountPassword, createAccountConfirmPassword,
//                firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode);
//        editProfileTest.verifyEditProfile(existingAccountEmail, existingAccountPassword, createAccount, createAccountPassword, createAccountConfirmPassword,
//                firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode, newFirstName);
//    }
//}
