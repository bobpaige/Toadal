package com.example;

import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Continent;
import com.example.model.Game;
import com.example.model.Player;
import com.example.model.Territory;
import com.example.persistence.ContinentRepository;
import com.example.persistence.GameRepository;
import com.example.persistence.PlayerRepository;
import com.example.persistence.TerritoryRepository;

@SpringBootApplication
public class ToadalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToadalApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadGames(GameRepository grepo, PlayerRepository prepo, ContinentRepository crepo,
			TerritoryRepository trepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				RandomNameGenerator namegen = new RandomNameGenerator();
				if (crepo.count() == 0) {
					Territory ter = Territory.builder().title(namegen.next())
							.description(namegen.next() + " of " + namegen.next()).build();
					trepo.save(ter);
					Continent cont = Continent.builder().name(namegen.next()).build();
					cont.getTerritories().add(ter);
					crepo.save(cont);
				}

				if (grepo.count() == 0) {
					Player player1 = Player.builder().name(namegen.next()).build();
					prepo.save(player1);
					Game game1 = Game.builder().name(namegen.next()).build();
					game1.getPlayers().add(player1);
					grepo.save(game1);
				}
			}
		};
	}
}
