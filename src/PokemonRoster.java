public class PokemonRoster {

    private static final FirePokemon[] CHARMANDER = new FirePokemon[] {
            new FirePokemon("Charmander", 1, 80, 40, new Attack[] {
                   AttackArchive.SCRATCH
            }),
            new FirePokemon("Charmeleon", 2, 90, 60, new Attack[] {
                    AttackArchive.FLAME_TAIL
            }),
            new FirePokemon("Charizard",3,130, 80, new Attack[] {
                    AttackArchive.FIERY_BLAST
            }),
    };

    private static final FirePokemon[] SALANDIT = new FirePokemon[] {
            new FirePokemon("Salandit", 1, 100, 60, new Attack[] {
                   AttackArchive.LIVE_COAL
            }),
            new FirePokemon("Salazzle", 2, 160, 80, new Attack[] {
                    AttackArchive.FIRE_CLAWS
            })
    };

    private static final FirePokemon[] MOLTERS = new FirePokemon[] {
            new FirePokemon("Moltres", 1, 120, 60, new Attack[] {
                    AttackArchive.ASSISTING_HEATER, AttackArchive.FIRE_WING
            })
    };

    private static final ElectricPokemon[] PIKACHU = new ElectricPokemon[] {
            new ElectricPokemon("Pichu", 1, 40, 30, new Attack[] {
                    AttackArchive.QUICK_ATTACK
            }),
            new ElectricPokemon("Pikachu", 2, 50, 40, new Attack[] {
                    AttackArchive.ELECTRO_BALL
            }),
            new ElectricPokemon("Raichu", 3, 160, 80, new Attack[] {
                    AttackArchive.ELECTRIC_SURFER
            })
    };

    private static final ElectricPokemon[] BLITZLE = new ElectricPokemon[] {
            new ElectricPokemon("Blitzle", 1, 90, 35, new Attack[] {
                    AttackArchive.FLOP
            }),
            new ElectricPokemon("Zebstrika", 2, 100, 50, new Attack[] {
                    AttackArchive.ZAP_KICK
            })
    };

    private static final ElectricPokemon[] ELECTABUZZ = new ElectricPokemon[] {
            new ElectricPokemon("Electabuzz", 1, 30, 100, new Attack[] {
                   AttackArchive.THUNDER
            }),
            new ElectricPokemon("Electivire", 2, 35, 120, new Attack[] {
                    AttackArchive.THUNDER_PUNCH
            })
    };

    public static final Pokemon[][] allPokemons = new Pokemon[][] {
            CHARMANDER, SALANDIT, MOLTERS, PIKACHU, BLITZLE, ELECTABUZZ
    };

}
