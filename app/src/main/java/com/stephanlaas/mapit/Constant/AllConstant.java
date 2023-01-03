package com.stephanlaas.mapit.Constant;

import com.stephanlaas.mapit.PlaceModel;
import com.stephanlaas.mapit.R;

import java.util.ArrayList;
import java.util.Arrays;

public interface AllConstant {

    int STORAGE_REQUEST_CODE = 1000;
    int LOCATION_REQUEST_CODE = 2000;
    String IMAGE_PATH = "/Profile/image_profile.jpg";

    ArrayList<PlaceModel> placesName = new ArrayList<>(
            Arrays.asList(
                    new PlaceModel(1, R.drawable.ic_atm, "ATM", "atm"),
                    new PlaceModel(2, R.drawable.ic_home, "School", "school"),
                    new PlaceModel(3, R.drawable.accounting, "Accounting", "accounting"),
                    new PlaceModel(4, R.drawable.ic_shopping_cart, "Groceries", "supermarket"),
                    new PlaceModel(5, R.drawable.ic_hotel, "Hotels", "hotel"),
                    new PlaceModel(6, R.drawable.bread, "Bakery", "bakery"),
                    new PlaceModel(7, R.drawable.coffee, "Cafe", "cafe"),
                    new PlaceModel(8, R.drawable.church, "Church", "church"),
                    new PlaceModel(9, R.drawable.flower, "Florist", "florist"),
                    new PlaceModel(10, R.drawable.ic_hospital, "Hospitals & Clinics", "hospital"),
                    new PlaceModel(11, R.drawable.ic_car_wash, "Car Wash", "car_wash"),
                    new PlaceModel(12, R.drawable.ic_saloon, "Beauty Salons", "beauty_salon"),
                    new PlaceModel(13, R.drawable.ic_gas_station, "Gas", "gas_station"),
                    new PlaceModel(14, R.drawable.ic_restaurant, "Restaurant", "restaurant"),
                    new PlaceModel(15, R.drawable.boxes, "Storage", "storage"),
                    new PlaceModel(16, R.drawable.church, "University", "university"),
                    new PlaceModel(17, R.drawable.ic_person, "Police", "police"),
                    new PlaceModel(18, R.drawable.ic_pharmacy, "Pharmacies", "pharmacy")


            )
    );
}
