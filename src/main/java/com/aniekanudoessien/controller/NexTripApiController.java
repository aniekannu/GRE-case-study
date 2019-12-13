package com.aniekanudoessien.controller;

import com.aniekanudoessien.model.Direction;
import com.aniekanudoessien.model.Nextrip;
import com.aniekanudoessien.model.Route;
import com.aniekanudoessien.model.Stop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/metrotransit")
public class NexTripApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/routes")
    public List<Route> getRoutes(){
        Route[] routes = restTemplate
                .getForObject("https://svc.metrotransit.org/NexTrip/Routes",
                Route[].class);

        assert routes != null;
        return Arrays.asList(routes);
    }

    @GetMapping("/directions/{route}")
    public List<Direction> getDirections(@PathVariable ("route") String route){
        Direction[] directions = restTemplate
                .getForObject("https://svc.metrotransit.org/NexTrip/Directions/" + route,
                        Direction[].class);

        assert directions != null;
        return Arrays.asList(directions);
    }

    @GetMapping("/stops/{route}/{direction}")
    public List<Stop> getStops(@PathVariable("route") String route,
                                 @PathVariable("direction") String direction){
        Stop[] stops = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/Stops/"
                        + route + "/"+ direction, Stop[].class);

        assert stops != null;
        return Arrays.asList(stops);
    }

    @GetMapping("/nextrip/{route}/{direction}/{stop}")
    public Nextrip nexTrip(@PathVariable("route") String route,
                            @PathVariable("direction") String direction,
                            @PathVariable("stop") String stop){

        Nextrip[] next = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/" +
                route + "/" + direction + "/" + stop, Nextrip[].class);

        assert next != null;
        log.info("Time till next departure = {}", next[0]);
        return next[0];
    }

    @ResponseBody
    @GetMapping("/time/{route}/{direction}/{stop}")
    public String finalResult(@PathVariable("route") String route,
                           @PathVariable("direction") String direction,
                           @PathVariable("stop") String stop){

        Optional<Route> r = getRoutes()
                .stream()
                .filter(rt -> rt.getRoute().equals(route))
                .findFirst();

        Optional<Direction> d = getDirections(route)
                .stream()
                .filter(dr -> dr.getValue().equals(direction))
                .findFirst();

        Optional<Stop> s = getStops(route, direction)
                .stream()
                .filter(st -> st.getValue().equals(stop))
                .findFirst();

        Optional<Nextrip> n = Optional.ofNullable(nexTrip(route, direction, stop));


        assert r.isPresent();
        assert d.isPresent();
        assert s.isPresent();
        assert n.isPresent();

        return  "\"" + r.get().getDescription() + "\"" + " " + "\"" + s.get().getText() + "\""
                + " " + "\"" + d.get().getText() + "\""
                + " " + n.get().getDepartureText();

    }
}
