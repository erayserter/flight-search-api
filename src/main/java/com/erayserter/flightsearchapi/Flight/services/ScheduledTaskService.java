package com.erayserter.flightsearchapi.Flight.services;

import com.erayserter.flightsearchapi.Airport.model.Airport;
import com.erayserter.flightsearchapi.Airport.repository.AirportRepository;
import com.erayserter.flightsearchapi.Flight.models.Flight;
import com.erayserter.flightsearchapi.Flight.repositories.FlightRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ScheduledTaskService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    private final List<String> airport_cities = Arrays.asList(
            "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa",
            "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay",
            "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli",
            "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş",
            "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun",
            "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa",
            "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale",
            "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis",
            "Osmaniye", "Düzce"
    );

    public ScheduledTaskService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    private void fetchFlights() {
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = rand.nextInt(airport_cities.size());
            String randomCity = airport_cities.get(randomIndex);

            Airport airport = Airport
                    .builder()
                    .id(randomIndex)
                    .city(randomCity)
                    .build();

            airportRepository.save(airport);
        }

        List<Airport> airports = airportRepository.findAll();

        for (int i = 0; i < 100; i++) {
            int randomIndex = rand.nextInt(airports.size());
            int randomIndex2 = rand.nextInt(airports.size());
            Airport randomAirport = airports.get(randomIndex);
            Airport randomAirport2 = airports.get(randomIndex2);

            while(randomAirport == randomAirport2) {
                randomIndex2 = rand.nextInt(airports.size());
                randomAirport2 = airports.get(randomIndex2);
            }

            Flight flight = Flight
                    .builder()
                    .id(rand.nextInt())
                    .departureAirport(randomAirport)
                    .arrivalAirport(randomAirport2)
                    .outwardDate(new java.sql.Date(System.currentTimeMillis()))
                    .returnDate(new java.sql.Date(System.currentTimeMillis() + 1000000))
                    .price(new BigDecimal(rand.nextInt(30000)))
                    .build();

            flightRepository.save(flight);
        }
    }
}
