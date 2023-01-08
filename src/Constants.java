import java.util.Random;

public class Constants {
    public static final int START_ATTACK_POINTS_PERCENTAGE = 75;
    public static final int MAXIMUM_ATTACK_POINTS_PERCENTAGE = 100;

    public static final int FIRE_TYPE = 1;

    public static final int ELECTRIC_TYPE = 2;
    public static final Random RANDOM = new Random();

    public static final Attack KICK = new Attack("Kick", 0, 2, 2);

    // Fire pokemon
    public static final Attack SCRATCH = new Attack("Scratch", 15, 25, 30);
    public static final Attack FLAME_TAIL = new Attack("Flame Tail", 40, 30, 50);
    public static final Attack FIERY_BLAST = new Attack("Fiery Blast", 50, 50, 50);
    public static final Attack LIVE_COAL = new Attack("Live Coal", 10, 0, 25);
    public static final Attack FIRE_CLAWS = new Attack("Fire Claws", 25, 0, 50);
    public static final Attack ASSISTING_HEATER = new Attack("Assisting Heater", 30, 10, 60);
    public static final Attack FIRE_WING = new Attack("Fire Wing", 30, 30, 30);

    // Electric pokemon
    public static final Attack QUICK_ATTACK = new Attack("Quick Attack", 5, 10, 10);
    public static final Attack ELECTRO_BALL = new Attack("Electro Ball", 10, 30, 40);
    public static final Attack ELECTRIC_SURFER = new Attack("Electric Surfer", 60, 20, 120);
    public static final Attack FLOP = new Attack("Flop", 20, 20, 25);
    public static final Attack ZAP_KICK = new Attack("Zap Kick", 30, 30, 35);
    public static final Attack THUNDER = new Attack("Thunder", 60, 40, 50);
    public static final Attack THUNDER_PUNCH = new Attack("Thunder Punch", 80, 50, 120);



    public static final FirePokemon[] CHARMANDER = new FirePokemon[] {
            new FirePokemon("Charmander", 1, 80, 40, new Attack[] {
                    KICK, SCRATCH
            }),
            new FirePokemon("Charmeleon", 2, 90, 60, new Attack[] {
                    FLAME_TAIL
            }),
            new FirePokemon("Charizard",3,130, 80, new Attack[] {
                    FIERY_BLAST
            }),
    };

    public static final FirePokemon[] SALANDIT = new FirePokemon[] {
            new FirePokemon("Salandit", 1, 100, 60, new Attack[] {
                    KICK ,LIVE_COAL
            }),
            new FirePokemon("Salazzle", 2, 160, 80, new Attack[] {
                    FIRE_CLAWS
            })
    };

    public static final FirePokemon[] MOLTERS = new FirePokemon[] {
            new FirePokemon("Moltres", 1, 120, 60, new Attack[] {
                   KICK ,ASSISTING_HEATER, FIRE_WING
            })
    };

    public static final ElectricPokemon[] PIKACHU = new ElectricPokemon[] {
            new ElectricPokemon("Pichu", 1, 40, 30, new Attack[] {
                    KICK ,QUICK_ATTACK
            }),
            new ElectricPokemon("Pikachu", 2, 50, 40, new Attack[] {
                    ELECTRO_BALL
            }),
            new ElectricPokemon("Raichu", 3, 160, 80, new Attack[] {
                    ELECTRIC_SURFER
            })
    };

    public static final ElectricPokemon[] BLITZLE = new ElectricPokemon[] {
            new ElectricPokemon("Blitzle", 1, 90, 35, new Attack[] {
                    KICK, FLOP
            }),
            new ElectricPokemon("Zebstrika", 2, 100, 50, new Attack[] {
                    ZAP_KICK
            })
    };

    public static final ElectricPokemon[] ELECTABUZZ = new ElectricPokemon[] {
            new ElectricPokemon("Electabuzz", 1, 30, 100, new Attack[] {
                    KICK, THUNDER
            }),
            new ElectricPokemon("Electivire", 2, 35, 120, new Attack[] {
                    THUNDER_PUNCH
            })
    };
}
