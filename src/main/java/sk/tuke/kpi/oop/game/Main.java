package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.gamelib.graphics.Backend;
import sk.tuke.kpi.oop.game.scenarios.FirstSteps;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        FirstSteps scenario = new FirstSteps();
        // nastavenie okna hry: nazov okna a jeho rozmery
        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);

        // vytvorenie instancie hernej aplikacie
        // pouzijeme implementaciu rozhrania `Game` triedou `GameApplication`
        Game game = new GameApplication(windowSetup, getBackend());  // v pripade Mac OS bude druhy parameter "new Lwjgl2Backend()"

        // vytvorenie sceny pre hru
        // pouzijeme implementaciu rozhrania `Scene` triedou `World`
        Scene scene = new World("world");

        scene.addListener(scenario);

        // pridanie sceny do hry
        game.addScene(scene);

        // spustenie hry
        game.start();

        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
    }

    @NotNull
    private static Backend getBackend() {
        return ServiceLoader.load(Backend.class)
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("No backend found. Please configure a GameLib backend as your dependency.")
                );
    }
}
