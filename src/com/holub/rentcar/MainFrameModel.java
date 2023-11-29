package com.holub.rentcar;

import com.holub.rentcar.models.CarsFactory;
import com.holub.rentcar.models.PlacesFactory;
import com.holub.rentcar.models.row.Car;
import com.holub.rentcar.models.row.CarType;
import com.holub.rentcar.models.CarTypesFactory;
import com.holub.rentcar.models.Selection;
import com.holub.rentcar.models.row.Place;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class MainFrameModel extends Observable {
    public String currentMenu = "test";
    public ArrayList<Selection<CarType>> infos = new ArrayList<>();
    public ArrayList<Selection<Place>> places = new ArrayList<>();
    public ArrayList<Car> results = new ArrayList<>();
    public int year;
    public int month;
    public int day;

    public MainFrameModel() {
        CarTypesFactory carTypesFactory = new CarTypesFactory();
        ArrayList<CarType> carTypes = carTypesFactory.createFrom(RentcarDB.orm.carTypes);
        this.infos.clear();
        for (CarType type : carTypes)
            this.infos.add(new Selection<>(type));

        PlacesFactory placesFactory = new PlacesFactory();
        ArrayList<Place> places = placesFactory.createFrom(RentcarDB.orm.spot);
        this.places.clear();
        for (Place place : places)
            this.places.add(new Selection<>(place));

        LocalDate currentDate = LocalDate.now();
        this.year = currentDate.getYear();
        this.month = currentDate.getMonthValue();
        this.day = currentDate.getDayOfMonth();
    }

    public void searchResults() {
        RentcarFinder resultFinder = new RentcarFinder();

        Set<String> infoSet = new HashSet<>();
        for (Selection<CarType> infoSelection : infos) {
            if (infoSelection.selected) {
                infoSet.add(infoSelection.obj.id);
            }
        }
        if(!infoSet.isEmpty()) {
            resultFinder = resultFinder.types(infoSet);
        }

        Set<String> placeSet = new HashSet<>();
        for (Selection<Place> placeSelection : places) {
            if (placeSelection.selected) {
                placeSet.add(placeSelection.obj.spotId);
            }
        }
        if(!placeSet.isEmpty()) {
            resultFinder = resultFinder.spots(placeSet);
        }

        CarsFactory carsFactory = new CarsFactory();
        this.results = carsFactory.createFrom(resultFinder.getResult());
        setChanged();
        notifyObservers();
    }

    public void changeMenu(String menuId) {
        this.currentMenu = menuId;
        setChanged();
        notifyObservers();
    }

    public void setInfos(ArrayList<Selection<CarType>> infos) {
        this.infos = infos;
        setChanged();
        notifyObservers();
    }

    public void checkInfo(int index, boolean selected) {
        this.infos.get(index).selected = selected;
        setChanged();
        notifyObservers();
    }
    public void checkPlace(int index, boolean selected) {
        this.places.get(index).selected = selected;
        setChanged();
        notifyObservers();
    }

    public void changeTime(int year, int month, int day) {
        LocalDate changedDate = LocalDate.of(this.year, this.month, this.day);
        try {
            changedDate = LocalDate.of(year, month, day);
        } catch (Exception e) {
            int dom = switch (month) {
                case 2 -> (IsoChronology.INSTANCE.isLeapYear(changedDate.getYear()) ? 29 : 28);
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
            if (month < 1)
                changedDate = changedDate.minusMonths(1);
            else if (month > 12)
                changedDate = changedDate.plusMonths(1);
            else if (day < 1)
                changedDate = changedDate.minusDays(1);
            else if (day > dom)
                changedDate = changedDate.plusDays(1);
        } finally {
            if (changedDate.isBefore(LocalDate.now())) {
                changedDate = LocalDate.now();
            }
            this.year = changedDate.getYear();
            this.month = changedDate.getMonthValue();
            this.day = changedDate.getDayOfMonth();
            setChanged();
            notifyObservers();
        }
    }
}

