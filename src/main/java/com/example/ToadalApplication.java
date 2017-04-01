package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Game;
import com.example.model.Player;
import com.example.persistence.GameRepository;
import com.example.persistence.PlayerRepository;

@SpringBootApplication
public class ToadalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToadalApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadGames(GameRepository grepo, PlayerRepository prepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Player player1 = Player.builder().name("joe").build();
				prepo.save(player1);
				Game game1 = Game.builder().name("mygame").build();
				game1.getPlayers().add(player1);
				grepo.save(game1);
			}
		};
	}
}
