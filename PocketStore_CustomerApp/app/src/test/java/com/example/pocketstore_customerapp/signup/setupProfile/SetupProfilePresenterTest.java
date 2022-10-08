package com.example.pocketstore_customerapp.signup.setupProfile;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetupProfilePresenterTest {

    private String correctUserame = "moreThanFourChars";
    private String correctEmail = "email@mail.com";
    private String correctAddress = "not null";
    private double correctLatitude = 10; // not 0
    private double correctLongitude = 10; // not 0
    private String correctPhoneNumber = "thisIsCheckedOnPreviousActivity";

    // dummy authId
    private String dummyUserId = "someString";

    // dummy presenter
    private SetupProfilePresenter setupProfilePresenter = new SetupProfilePresenter(new SetupProfileView() {
        @Override
        public void onProfileCreationLoading() {

        }

        @Override
        public void onProfileCreationSuccess() {

        }

        @Override
        public void onProfileCreationFailed(String errorMessage) {

        }

        @Override
        public void onEmailIsWrong(String errorMessage) {

        }

        @Override
        public void onFullNameIsWrong(String errorMessage) {

        }

        @Override
        public void onAddressIsWrong(String errorMessage) {

        }
    }, new Customer(), null);

    @Test
    public void validateFormInputs_WrongUsername() {

        String wrongUsername = "    "; // four spaces

        boolean result = setupProfilePresenter.validateFormInputs(
                dummyUserId, wrongUsername, correctEmail,
                correctAddress ,correctLatitude, correctLongitude,
                correctPhoneNumber);

        assertEquals(false, result);

    }

    @Test
    public void validateFormInputs_Latlng() {

        double wrongLatitude = 0.0 , wrongLongitude = 0.0;

        boolean result = setupProfilePresenter.validateFormInputs(
                dummyUserId, correctUserame, correctEmail,
                correctAddress ,wrongLatitude, wrongLongitude,
                correctPhoneNumber);

        assertEquals(false, result);

    }

}