import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    public static void main(String[] args) {

        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);


        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon); // temp is still Earth
        temp.addMoons(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon); // temp is still Mars
        temp.addMoons(tempMoon);

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon); // temp is still Mars
        temp.addMoons(tempMoon);

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoons(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoons(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoons(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoons(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("PLANETS");
        for (HeavenlyBody planet:
             planets) {
            System.out.println("\t" + planet.getName().toUpperCase());
            HeavenlyBody body = planet;
            System.out.println("\tMoons of " + body.getName() + " : " + body.getSatellites().size());
            for (HeavenlyBody moonBody:
                    body.getSatellites()) {
                System.out.println("\t\t" + moonBody.getName());
            }
            System.out.println("=".repeat(50));
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet:
             planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("=".repeat(25) + "ALL MOONS" + "=".repeat(25));
        for (HeavenlyBody moon:
                moons) {
            System.out.println("\t" + moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 845);
        planets.add(pluto);

        for (HeavenlyBody body : planets) {
            System.out.println(body.getName() + ": " + body.getOrbitalPeriod());
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");

    }
}