import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnhancedMain {
    private static Map<EnhancedHeavenlyBody.Key, EnhancedHeavenlyBody> solarSystem = new HashMap<>();
    private static Set<EnhancedHeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        EnhancedHeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        EnhancedHeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(EnhancedHeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        EnhancedHeavenlyBody body = solarSystem.get(EnhancedHeavenlyBody.makeKey("Mars", EnhancedHeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(EnhancedHeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<EnhancedHeavenlyBody> moons = new HashSet<>();
        for(EnhancedHeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(EnhancedHeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        // this will get added even though The planet name is Pluto, because it is of type dwarfPlanet
        EnhancedHeavenlyBody dwarfpluto = new DwarfPlanet("Pluto", 842);
        planets.add(dwarfpluto);

        // this will not get added because the Pluto here is of Planet type
        EnhancedHeavenlyBody duplicatePluto = new Planet("Pluto", 1212);
        planets.add(duplicatePluto);

        System.out.println("Planets");
        for(EnhancedHeavenlyBody planet : planets) {
            System.out.println(planet);
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
        }

        EnhancedHeavenlyBody earth1 = new Planet("Earth", 365);
        EnhancedHeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(duplicatePluto));
        System.out.println(duplicatePluto.equals(earth1));

        solarSystem.put(dwarfpluto.getKey(), dwarfpluto);
        System.out.println(solarSystem.get(EnhancedHeavenlyBody.makeKey("Pluto", EnhancedHeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(EnhancedHeavenlyBody.makeKey("Pluto", EnhancedHeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("The solar system contains:");
        for(EnhancedHeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }

    }
}
