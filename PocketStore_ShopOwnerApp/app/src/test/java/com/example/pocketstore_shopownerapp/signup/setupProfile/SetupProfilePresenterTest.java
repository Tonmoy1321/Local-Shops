package com.example.pocketstore_shopownerapp.signup.setupProfile;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetupProfilePresenterTest {

    private String correctShopName = "morethan5letters";
    private String correctShopOwnerName = "morethan5letters";
    private String correctAddress = "notNull";
    private double correctLatitude = 10; // not 0
    private double correctLongitude = 10; // not 0
    private String correctShopType = "Conventional"; // Bakery, Stationary, Conventional

    // not checked here fields
    private String correctPhoneNumber = "testedOnPreviousActivity";
    private String correctUserId = "someUid";
    private double correctRadius = 100;

    // dummy testing object
    SetupProfilePresenter setupProfilePresenter = new SetupProfilePresenter(
            new SetupProfileView() {
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
        public void onShopNameIsWrong(String errorMessage) {

        }

        @Override
        public void onFullNameIsWrong(String errorMessage) {

        }

        @Override
        public void onAddressIsWrong(String errorMessage) {

        }
    }, new Shop(), null);


    @Test
    public void validateFormInputs_ShopName() {

        String wrongShopName = "         "; // more than 5 spaces

        boolean result = setupProfilePresenter.validateFormInputs(
                correctUserId, correctShopOwnerName, wrongShopName,
                correctAddress, correctLatitude, correctLongitude,
                correctPhoneNumber, correctRadius, correctShopType);

        assertEquals(false, result);

    }


    @Test
    public void validateFormInputs_ShopLatLng() {

        double wrongLatitude = 0.0;
        double wrongLongitude = 0.0;

        boolean result = setupProfilePresenter.validateFormInputs(
                correctUserId, correctShopOwnerName, correctShopName,
                correctAddress, wrongLatitude, wrongLongitude,
                correctPhoneNumber, correctRadius, correctShopType);

        assertEquals(false, result);

    }

    @Test
    public void validateFormInputs_ShopTypeIncorrect() {

        String wrongshopType = "anythingExceptAllowedOnes";

        boolean result = setupProfilePresenter.validateFormInputs(
                correctUserId, correctShopOwnerName, correctShopName,
                correctAddress, correctLatitude, correctLongitude,
                correctPhoneNumber, correctRadius, wrongshopType);

        assertEquals(false, result);

    }


    @Test
    public void validateFormInputs_ShopTypeCorrect() {

        String type[] = {"Bakery", "Conventional", "Stationary"};

        int index = (int)(Math.random() * 3);

        boolean result = setupProfilePresenter.validateFormInputs(
                correctUserId, correctShopOwnerName, correctShopName,
                correctAddress, correctLatitude, correctLongitude,
                correctPhoneNumber, correctRadius, type[index]);

        assertEquals(true, result);

    }

}